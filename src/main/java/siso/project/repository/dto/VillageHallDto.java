package siso.project.repository.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class VillageHallDto {

    private String hallName;
    private Integer lat;
    private Integer lon;
    private String address;

    @Builder
    public VillageHallDto(String hallName, Integer lat, Integer lon, String address) {
        this.hallName = hallName;
        this.lat = lat;
        this.lon = lon;
        this.address = address;
    }
}
