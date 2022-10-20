package siso.project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import siso.project.domain.Teams;
import siso.project.repository.TeamsMapper;
import siso.project.repository.dto.TeamsDto;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final TeamsMapper teamsMapper;

    public List<Teams> teamSelect(Long loginAdminId, TeamsDto teamsDto) {
        List<Teams> teams = teamsMapper.select(loginAdminId, teamsDto);
        return teams;
    }

    public void teamSave(Long loginAdminId, Teams teams) {
        Teams saveTeams = Teams.builder()
                .teamName(teams.getTeamName())
                .teamAddress(teams.getTeamAddress())
                .adminId(loginAdminId)
                .build();

        teamsMapper.save(saveTeams);
    }

}
