package siso.project.repository.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalTime;

@Data
public class DiningFriendsDto {

    private Integer memNumber;
    private LocalTime time;
    private String address;
    private String name;
    private String phoneNumber;
    private String members;
    private String memo;
    private Boolean state;

    //외래키
    private Long teamId;
    private Long usersId;

    @Builder
    public DiningFriendsDto(Integer memNumber, LocalTime time, String address, String name, String phoneNumber, String members, String memo, Boolean state, Long teamId, Long usersId) {
        this.memNumber = memNumber;
        this.time = time;
        this.address = address;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.members = members;
        this.memo = memo;
        this.state = state;
        this.teamId = teamId;
        this.usersId = usersId;
    }
}
