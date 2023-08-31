package com.mcuneytozturk.saglikturizmi.model;

import com.mcuneytozturk.saglikturizmi.util.BaseDTO;
import lombok.Data;
import org.springframework.data.domain.Sort;

import java.util.List;

@Data
public class PageDTO<DTO extends BaseDTO> {
    private int number;
    private int totalPages;
    private long totalElements;
    private int size;
    private int numberOfElements;
    private List<DTO> content;
    private Sort sort;
}
