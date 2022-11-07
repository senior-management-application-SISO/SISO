package siso.project.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@NoArgsConstructor
public class DiningFriends {

    private Long id;
    private Integer memNumber;
    private Integer currentNumber;

    //@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime time;
    private String address;
    private String name;
    private String phoneNumber;
    private String memo;
    private Boolean state;

    //외래키
    private Long teamId;
    private Long usersId;

    public void setCurrentNumber() {
        this.currentNumber = 1;
    }

    @Builder
    public DiningFriends(Long id, Integer memNumber, Integer currentNumber, LocalDateTime time, String address, String name, String phoneNumber, String memo, Boolean state, Long teamId, Long usersId) {
        this.id = id;
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
