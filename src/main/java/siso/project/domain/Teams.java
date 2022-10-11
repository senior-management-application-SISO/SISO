package siso.project.domain;

import lombok.Builder;
import lombok.Data;

@Data
public class Teams {

    private Long id;

    private String teamName;
    private String teamAddress;

    //외래키
    private Long adminId;

    @Builder
    public Teams(Long id, String teamName, String teamAddress, Long adminId) {
        this.id = id;
        this.teamName = teamName;
        this.teamAddress = teamAddress;
        this.adminId = adminId;
    }

    public Teams(String teamName, String teamAddress) {
        this.teamName = teamName;
        this.teamAddress = teamAddress;
    }
}
