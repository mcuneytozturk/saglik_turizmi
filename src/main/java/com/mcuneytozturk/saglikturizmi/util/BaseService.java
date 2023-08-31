package com.mcuneytozturk.saglikturizmi.util;
import com.mcuneytozturk.saglikturizmi.model.PageDTO;
import com.mcuneytozturk.saglikturizmi.util.dbUtil.BaseEntity;
import com.mcuneytozturk.saglikturizmi.util.dbUtil.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.UUID;



public abstract class BaseService<
        Entity extends BaseEntity,
        DTO extends BaseDTO,
        Mapper extends BaseMapper<DTO, Entity>,
        Repository extends BaseRepository<Entity>
        > {

    protected abstract Mapper getMapper();

    protected abstract Repository getRepository();

    public PageDTO<DTO> getAll(int pageNum, int size){
        Pageable pageable = PageRequest.of(1, 10, Sort.by("id").descending());

        Page<Entity> entityPage = getRepository().findAll(pageable);

        return getMapper().pageEntityToPageDTO(entityPage);
    }

    public DTO save(DTO dto) {
        Entity entity = getMapper().dtoToEntity(dto);
        getRepository().save(entity);
        return getMapper().entityToDTO(entity);
    }


    public DTO update(UUID uuid, DTO dto) {
        Entity entity = getRepository().findByUuid(uuid).orElse(null);
        if (entity != null) {
            entity = getMapper().dtoToExistEntity(entity, dto);
            getRepository().save(entity);
            return getMapper().entityToDTO(entity);
        } else {
            return null;
        }
    }

    public DTO getByUUID(UUID uuid) {
        Entity entity = getRepository().findByUuid(uuid).orElse(null);
        if (entity != null) {
            return getMapper().entityToDTO(entity);
        } else {
            return null;
        }
    }

    public Boolean delete(UUID uuid) {
        Entity entity = getRepository().findByUuid(uuid).orElse(null);
        if (entity != null) {
            getRepository().delete(entity);
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }


}
