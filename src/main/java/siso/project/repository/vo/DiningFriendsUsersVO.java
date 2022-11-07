package siso.project.repository.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DiningFriendsUsersVO {

    private Long id;
    private Integer memNumber;
    private Integer currentNumber;

    private LocalDateTime time;
    private String address;
    private String name;
    private String phoneNumber;
    private String memo;
    private Boolean state;

    private String userName;
}
