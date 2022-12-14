package siso.project.repository.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class VillageHallDto {

    private String hallName;
    private double lat;
    private double lon;
    private String address;
    private Long adminId;

    @Builder
    public VillageHallDto(String hallName, double lat, double lon, String address, Long adminId) {
        this.hallName = hallName;
        this.lat = lat;
        this.lon = lon;
        this.address = address;
        this.adminId = adminId;
    }
}
