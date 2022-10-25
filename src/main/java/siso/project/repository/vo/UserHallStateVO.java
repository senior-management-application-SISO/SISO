package siso.project.repository.vo;


import lombok.Builder;
import lombok.Data;


import java.time.LocalDateTime;

@Data
public class UserHallStateVO {
    private String userName;
    private LocalDateTime dateOfBirth;
    private String phoneNumber;

    private String hallName;
    private String address;


    @Builder
    public UserHallStateVO(String userName, LocalDateTime dateOfBirth, String phoneNumber, String hallName, String address) {
        this.userName = userName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.hallName = hallName;
        this.address = address;
    }
}
