package siso.project.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UsersQrState {

    private Long id;

    private LocalDateTime date;
    private Boolean attendanceState;
    private Boolean hallState;

    //외래키
    private Long usersId;
}
