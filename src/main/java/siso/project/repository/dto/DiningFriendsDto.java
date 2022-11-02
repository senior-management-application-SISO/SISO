package siso.project.repository.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
public class DiningFriendsDto {

    private Integer memNumber;
    private Integer currentNumber;
    private LocalDateTime time;
    private String address;
    private String name;
    private String phoneNumber;
    private String memo;
    private Boolean state;

    //외래키
    private Long teamId;
    private Long usersId;

    @Builder
    public DiningFriendsDto(Integer memNumber, Integer currentNumber, LocalDateTime time, String address, String name, String phoneNumber, String memo, Boolean state, Long teamId, Long usersId) {
        this.memNumber = memNumber;
        this.currentNumber = currentNumber;
        this.time = time;
        this.address = address;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.memo = memo;
        this.state = state;
        this.teamId = teamId;
        this.usersId = usersId;
    }
}
