package siso.project.controller.villagehall;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class VillageHallForm {

    private Long id;
    @NotEmpty
    private String hallName;
    private Integer lat;
    private Integer lon;
    @NotEmpty
    private String address;
}
