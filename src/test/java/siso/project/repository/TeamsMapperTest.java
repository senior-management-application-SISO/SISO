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
        Teams teams = new Teams(teamName, teamAddress);

        teamsMapper.save(teams);
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
        Teams team = new Teams(teamName, teamAddress);
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
        Admin admin1 = new Admin(null, "adminName1", "adminId1", "adminPw1", "010-11", null);
        adminMapper.save(admin1);
        Admin admin2 = new Admin(null, "adminName2", "adminId2", "adminPw2", "010-22", null);
        adminMapper.save(admin2);

        // Admin1 id 조회
        Long admin1Id = admin1.getId();
        Long admin2Id = admin2.getId();

        // Team 등록
        Teams team = new Teams(null, "teamA", "teamAddress", admin1Id);
        teamsMapper.save(team);

        // TeamUpdateDto 생성
        // 1. (teamName, teamAddress, null)
        TeamsDto teamsUpdateDto = new TeamsDto("updatedTeamName", "updatedTeamAddress", admin2Id);
        // 2. (null, null, adminId)
//        TeamsDto teamsUpdateDto = new TeamsDto(admin2Id);

        // team update with admin
        teamsMapper.update(team.getId(), teamsUpdateDto);
    }

    @Test
    void delete() {
        // Team 저장
        Teams team = new Teams("teamA", "teamAddress");
        teamsMapper.save(team);

        // team 삭제
        teamsMapper.delete(team.getId());
    }
}
