package siso.project.repository.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UsersLocationDto {

    private String address;
    private double lat;
    private double lon;
    private LocalDateTime time;

    @Builder
    public UsersLocationDto(String address, double lat, double lon, LocalDateTime time) {
        this.address = address;
        this.lat = lat;
        this.lon = lon;
        this.time = time;
    }
}
