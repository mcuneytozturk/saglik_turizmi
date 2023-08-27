package com.mcuneytozturk.saglikturizmi.util;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class BaseDTO {


    private Long id;
    private UUID uuid;
    @JsonIgnore
    private LocalDateTime creationDate;
    @JsonIgnore
    private LocalDateTime updatedDate;


}