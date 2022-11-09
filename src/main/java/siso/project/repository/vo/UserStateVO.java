package siso.project.repository.vo;

import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
public class UserStateVO {
    private Long id;
    private String userName;
    private LocalDateTime dateOfBirth;
    private String address;
    private String phoneNumber;
    private Boolean alone;

    //@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime date;
    private Boolean attendanceState;
    private Boolean hallState;



    @Builder
    public UserStateVO(Long id, String userName, LocalDateTime dateOfBirth, String address, String phoneNumber, Boolean alone, LocalDateTime date, Boolean attendanceState, Boolean hallState) {
        this.id = id;
        this.userName = userName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.alone = alone;
        this.date = date;
        this.attendanceState = attendanceState;
        this.hallState = hallState;
    }
}
