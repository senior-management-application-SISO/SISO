package siso.project.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UsersLocation {

    private Long id;

    private Integer lat;
    private Integer lon;
    private LocalDateTime time;

    @Builder
    public UsersLocation(Long id, Integer lat, Integer lon, LocalDateTime time) {
        this.id = id;
        this.lat = lat;
        this.lon = lon;
        this.time = time;
    }


}
