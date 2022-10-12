package siso.project.repository.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UsersQrStateDto {

    private LocalDateTime date;
    private Boolean attendanceState;
    private Boolean hallState;

    //외래키
    private Long usersId;

    @Builder
    public UsersQrStateDto(LocalDateTime date, Boolean attendanceState, Boolean hallState, Long usersId) {
        this.date = date;
        this.attendanceState = attendanceState;
        this.hallState = hallState;
        this.usersId = usersId;
    }
}
