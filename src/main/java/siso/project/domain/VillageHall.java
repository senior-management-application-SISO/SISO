package siso.project.domain;

import lombok.Data;

@Data
public class VillageHall {

    private Long id;

    private String hallName;
    private Integer lat;
    private Integer lon;
    private String address;

    public VillageHall() {
    }

    public VillageHall(String hallName, Integer lat, Integer lon, String address) {
        this.hallName = hallName;
        this.lat = lat;
        this.lon = lon;
        this.address = address;
    }
}
