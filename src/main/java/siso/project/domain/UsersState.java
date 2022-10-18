package siso.project.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UsersState {

    private Long id;

    private LocalDateTime date;
    private Boolean attendanceState;
    private Boolean hallState;

    //외래키
    private Long usersId;

    @Builder
    public UsersState(Long id, LocalDateTime date, Boolean attendanceState, Boolean hallState, Long usersId) {
        this.id = id;
        this.date = date;
        this.attendanceState = attendanceState;
        this.hallState = hallState;
        this.usersId = usersId;
    }
}
