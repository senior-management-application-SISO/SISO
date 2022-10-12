package siso.project.domain;

import lombok.Data;

import java.time.LocalTime;

@Data
public class DiningFriends {

    private Long id;

    private Integer memNumber;
    private LocalTime time;
    private String address;
    private String name;
    private String phoneNumber;
    private String members;
    private Boolean state;
    private String memo;

    //외래키
    private Long teamId;
    private Long usersId;

}
