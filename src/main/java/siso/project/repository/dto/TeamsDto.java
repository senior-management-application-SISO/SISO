package siso.project.repository.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
public class TeamsDto {

    private String teamName;
    private String teamAddress;
    private Long adminId;

    @Builder
    public TeamsDto(String teamName, String teamAddress, Long adminId) {
        this.teamName = teamName;
        this.teamAddress = teamAddress;
        this.adminId = adminId;
    }
}
