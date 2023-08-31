package com.mcuneytozturk.saglikturizmi.util;
import com.mcuneytozturk.saglikturizmi.model.PageDTO;
import com.mcuneytozturk.saglikturizmi.util.dbUtil.BaseEntity;
import com.mcuneytozturk.saglikturizmi.util.dbUtil.BaseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public abstract class BaseController<
        Entity extends BaseEntity,
        DTO extends BaseDTO,
        Repository extends BaseRepository<Entity>,
        Mapper extends BaseMapper<DTO, Entity>,
        Service extends BaseService<Entity, DTO, Mapper, Repository>
        > {
    abstract protected Service getService();


    @GetMapping("/page-num/{pNum}/page-size/{pSize}")
    public ResponseEntity<PageDTO<DTO>> getAll(@PathVariable int pNum, @PathVariable int pSize){
        return new ResponseEntity<>(getService().getAll(1, 10), HttpStatus.OK);
    }

    @GetMapping("{uuid}")
    public ResponseEntity<DTO> getByUuid(@PathVariable UUID uuid){
        DTO dto = getService().getByUUID(uuid);

        if (dto != null){
            return new ResponseEntity<>(dto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public ResponseEntity<DTO> save(@RequestBody DTO dto){
        return new ResponseEntity<>(getService().save(dto), HttpStatus.CREATED);
    }


    @PutMapping("{uuid}")
    public ResponseEntity<DTO> update(@PathVariable UUID uuid, @RequestBody DTO dto){
        if(getService().update(uuid, dto) != null)
        {
            return new ResponseEntity<>(getService().update(uuid, dto), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{uuid}")
    @Secured({"ROLE_USER", "ROLE_PATIENT"}) // ROLE_USER ve ROLE_PATIENT olan kayıtlı kullanıcılar veri silemez (sadece admin'ler veri silebilir, appointment ve reservation gibi veriler için müşteri hizmetleri aranır admin rolüne sahip kullanıcı iptal gerçekleştirebilir)
    public ResponseEntity<Boolean> deleteByUuid(@PathVariable UUID uuid){
        Boolean isDeleted = getService().delete(uuid);
        if(isDeleted){
            return new ResponseEntity<>(isDeleted, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(isDeleted, HttpStatus.NOT_FOUND);
        }
    }
}

