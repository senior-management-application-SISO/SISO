package siso.project.repository.vo;

import lombok.Builder;
import lombok.Data;

import java.sql.Date;
import java.time.LocalDateTime;

@Data
public class UserDetailInfoVO {
    private Long id;
    private String userId;
    private String userName;
    private Date dateOfBirth;
    private String address;
    private String phoneNumber;
    private Boolean alone;
    private Long teamId;
    private String teamName;
    private String teamAddress;
    private Long usersLocationId;
    private Long villageHallId;
    private LocalDateTime userStateDate;
    private Boolean attendanceState;
    private Boolean hallState;
    private String locationAddress;
    private Double locationLat;
    private Double locationLon;
    private Date locationTime;
    private String villageHallName;
    private Double villageHallLat;
    private Double villageHallLon;
    private String villageHallAddress;

    @Builder
    public UserDetailInfoVO(Long id, String userId, String userName, Date dateOfBirth, String address, String phoneNumber, Boolean alone, Long teamId, String teamName, String teamAddress, Long usersLocationId, Long villageHallId, LocalDateTime userStateDate, Boolean attendanceState, Boolean hallState, String locationAddress, Double locationLat, Double locationLon, Date locationTime, String villageHallName, Double villageHallLat, Double villageHallLon, String villageHallAddress) {
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.alone = alone;
        this.teamId = teamId;
        this.teamName = teamName;
        this.teamAddress = teamAddress;
        this.usersLocationId = usersLocationId;
        this.villageHallId = villageHallId;
        this.userStateDate = userStateDate;
        this.attendanceState = attendanceState;
        this.hallState = hallState;
        this.locationAddress = locationAddress;
        this.locationLat = locationLat;
        this.locationLon = locationLon;
        this.locationTime = locationTime;
        this.villageHallName = villageHallName;
        this.villageHallLat = villageHallLat;
        this.villageHallLon = villageHallLon;
        this.villageHallAddress = villageHallAddress;
    }
}
