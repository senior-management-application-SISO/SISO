package siso.project.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import siso.project.domain.Admin;
import siso.project.domain.Teams;
import siso.project.repository.dto.TeamsDto;

@SpringBootTest
@Transactional
public class TeamsMapperTest {

    @Autowired
    TeamsMapper teamsMapper;
    @Autowired
    AdminMapper adminMapper;

    @Test
    void saveWithoutAdminId() {
        String teamName = "teamA";
        String teamAddress = "teamAddress";
        Teams team = Teams.builder()
                .teamName(teamName)
                .teamAddress(teamAddress)
                .build();

        teamsMapper.save(team);
    }

    @Test
    void saveWithAdminId() {
        // admin 등록
        Admin admin = Admin.builder()
                .adminName("admin")
                .adminId("adminId")
                .adminPassword("adminPassword")
                .adminPhoneNumber("010-1111-1111")
                .countyOfficeId(null)
                .build();

        adminMapper.save(admin);

        // 등록된 admin id
        Long adminId = admin.getId();

        // Team 등록 with admin
        Teams team = Teams.builder()
                .teamName("teamA")
                .teamAddress("teamAddress")
                .adminId(adminId)
                .build();

        teamsMapper.save(team);
    }

    @Test
    void updateWithoutAdmin() {
        // Team 등록
        String teamName = "teamA";
        String teamAddress = "teamAddress";
        Teams team = Teams.builder()
                .teamName(teamName)
                .teamAddress(teamAddress)
                .build();

        teamsMapper.save(team);

        // Get teamId
        Long teamId = team.getId();

        // Dto Construct
        String updatedTeamName = "updatedTeamA";
        String updatedTeamAddress = "updatedTeamAddress";
        TeamsDto teamsUpdateDto = TeamsDto.builder()
                .teamName(updatedTeamName)
                .teamAddress(updatedTeamAddress)
                .build();

        // team update without admin
        teamsMapper.update(teamId, teamsUpdateDto);
    }

    @Test
    void updateWithAdmin() {
        //Admin 등록
        Admin admin1 = Admin.builder()
                .id(null)
                .adminName("adminName1")
                .adminId("adminId1")
                .adminPassword("adminPw1")
                .adminPhoneNumber("010-11")
                .countyOfficeId(null)
                .build();
        adminMapper.save(admin1);
        Admin admin2 = Admin.builder()
                .id(null)
                .adminName("adminName2")
                .adminId("adminId2")
                .adminPassword("adminPw2")
                .adminPhoneNumber("010-22")
                .countyOfficeId(null)
                .build();
        adminMapper.save(admin2);

        // Admin1 id 조회
        Long admin1Id = admin1.getId();
        Long admin2Id = admin2.getId();

        // Team 등록
        Teams team = Teams.builder()
                .teamName("teamA")
                .teamAddress("teamAddress")
                .adminId(admin1Id)
                .build();

        teamsMapper.save(team);

        // TeamUpdateDto 생성
        // 1. (teamName, teamAddress, null)
        TeamsDto teamsUpdateDto = TeamsDto.builder()
                .teamName("updatedTeamName")
                .teamAddress("updatedTeamAddress")
                .adminId(admin2Id)
                .build();
        // 2. (null, null, adminId)
//        TeamsDto teamsUpdateDto = TeamsDto.builder()
//                .adminId(admin2Id)
//                .build();

        // team update with admin
        teamsMapper.update(team.getId(), teamsUpdateDto);
    }

    @Test
    void delete() {
        // Team 저장
        Teams team = Teams.builder()
                .teamName("teamA")
                .teamAddress("teamAddress")
                .build();

        teamsMapper.save(team);

        // team 삭제
        teamsMapper.delete(team.getId());
    }
}
