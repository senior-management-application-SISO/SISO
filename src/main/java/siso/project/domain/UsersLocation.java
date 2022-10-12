package siso.project.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UsersLocation {

    private Long id;

    private Integer lat;
    private Integer lon;
    private LocalDateTime time;
}
