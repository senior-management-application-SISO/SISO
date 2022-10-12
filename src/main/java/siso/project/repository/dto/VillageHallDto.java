package siso.project.repository.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VillageHallDto {

    private String hallName;
    private Integer lat;
    private Integer lon;
    private String address;

}
