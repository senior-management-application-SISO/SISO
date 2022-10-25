package siso.project.controller.team;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class TeamsForm {

    private Long id;
    @NotEmpty
    private String teamName;
    @NotEmpty
    private String teamAddress;

}
