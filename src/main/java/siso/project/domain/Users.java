package siso.project.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Users {

    private Long id;

    private String userName;
    private String userId;
    private String password;
    private String address;
    private String phoneNumber;

    //외래키
    private Long groupId;
    private Long usersLocationId;
    private Long adminId;


    public Users(String userName, String userId, String password, String address, String phoneNumber) {
        this.userName = userName;
        this.userId = userId;
        this.password = password;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Users(String userName, String userId, String password, String address, String phoneNumber, Long groupId, Long usersLocationId, Long adminId) {
        this.userName = userName;
        this.userId = userId;
        this.password = password;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.groupId = groupId;
        this.usersLocationId = usersLocationId;
        this.adminId = adminId;
    }
}
