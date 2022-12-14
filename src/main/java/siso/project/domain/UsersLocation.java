package siso.project.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UsersLocation {

    private Long id;

    private String address;
    private double lat;
    private double lon;
    private LocalDateTime time;

    @Builder
    public UsersLocation(Long id, String address, double lat, double lon, LocalDateTime time) {
        this.id = id;
        this.address = address;
        this.lat = lat;
        this.lon = lon;
        this.time = time;
    }


}
