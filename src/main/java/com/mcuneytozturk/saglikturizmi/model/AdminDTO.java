package com.mcuneytozturk.saglikturizmi.model;

import com.mcuneytozturk.saglikturizmi.util.BaseDTO;
import lombok.Data;

@Data
public class AdminDTO extends BaseDTO {
    private String adminName;
    private String firstName;
    private String lastName;
    private String password;
    private String email;

}
