package siso.project.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class VillageHall {

    private Long id;

    private String hallName;
    private Integer lat;
    private Integer lon;
    private String address;

    @Builder
    public VillageHall(Long id, String hallName, Integer lat, Integer lon, String address) {
        this.id = id;
        this.hallName = hallName;
        this.lat = lat;
        this.lon = lon;
        this.address = address;
    }
}
