package siso.project.repository.vo;

import lombok.Builder;
import lombok.Data;

import java.sql.Date;
import java.time.LocalDateTime;

@Data
public class UserInfoVO {
    private Long id;
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
    private double locationLat;
    private double locationLon;
    private Date locationTime;
    private String villageHallName;
    private double villageHallLat;
    private double villageHallLon;
    private String villageHallAddress;

    @Builder
    public UserInfoVO(Long id, String userName, Date dateOfBirth, String address, String phoneNumber, Boolean alone, Long teamId, String teamName, String teamAddress, Long usersLocationId, Long villageHallId, LocalDateTime userStateDate, Boolean attendanceState, Boolean hallState, String locationAddress, double locationLat, double locationLon, Date locationTime, String villageHallName, double villageHallLat, double villageHallLon, String villageHallAddress) {
        this.id = id;
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
