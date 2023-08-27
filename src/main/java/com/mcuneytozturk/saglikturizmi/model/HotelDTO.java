package com.mcuneytozturk.saglikturizmi.model;

import com.mcuneytozturk.saglikturizmi.util.BaseDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class HotelDTO extends BaseDTO {
    private String name;
    private String city;
    private List<RoomDTO> rooms;
}
