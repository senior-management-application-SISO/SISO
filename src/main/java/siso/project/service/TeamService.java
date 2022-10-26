package siso.project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import siso.project.domain.DiningFriends;
import siso.project.domain.Teams;
import siso.project.repository.DiningFriendsMapper;
import siso.project.repository.TeamsMapper;
import siso.project.repository.dto.DiningFriendsDto;
import siso.project.repository.dto.TeamsDto;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final TeamsMapper teamsMapper;
    private final DiningFriendsMapper diningFriendsMapper;

    public List<Teams> teamSelect(Long loginAdminId, TeamsDto cond) {
        List<Teams> teams = teamsMapper.select(loginAdminId, cond);
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

    public Teams findById(Long teamId) {
        return teamsMapper.findById(teamId).get();
    }

    public void teamUpdate(Long teamId, TeamsDto teamsDto) {
        teamsMapper.update(teamId, teamsDto);
    }

    public void teamDelete(Long teamId) {
        DiningFriendsDto friendsDto = DiningFriendsDto.builder()
                .teamId(teamId)
                .build();
        List<DiningFriends> foundDiningFriends = diningFriendsMapper.select(friendsDto);

        for (DiningFriends foundDiningFriend : foundDiningFriends) {
            diningFriendsMapper.updateTeamId(foundDiningFriend.getId(), null);
        }

        teamsMapper.delete(teamId);
    }
}
