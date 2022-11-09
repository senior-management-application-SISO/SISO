package siso.project.repository.vo;

import lombok.Builder;
import lombok.Data;

import java.sql.Date;
import java.time.LocalDateTime;

@Data
public class UserInfoStateVO {
    private Long id;
    private String userName;
    private Date dateOfBirth;
    private String address;
    private String phoneNumber;
    private Boolean alone;
    private Long teamId;
    private Long adminId;
    private Long usersLocationId;
    private Long villageHallId;
    private LocalDateTime date;
    private Boolean attendanceState;
    private Boolean hallState;

    @Builder
    public UserInfoStateVO(Long id, String userName, Date dateOfBirth, String address, String phoneNumber, Boolean alone, Long teamId, Long adminId, Long usersLocationId, Long villageHallId, LocalDateTime date, Boolean attendanceState, Boolean hallState) {
        this.id = id;
        this.userName = userName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.alone = alone;
        this.teamId = teamId;
        this.adminId = adminId;
        this.usersLocationId = usersLocationId;
        this.villageHallId = villageHallId;
        this.date = date;
        this.attendanceState = attendanceState;
        this.hallState = hallState;
    }
}
