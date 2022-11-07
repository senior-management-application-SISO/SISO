package siso.project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import siso.project.domain.DiningFriends;
import siso.project.domain.DiningFriendsUsers;
import siso.project.repository.DiningFriendsMapper;
import siso.project.repository.DiningFriendsUsersMapper;
import siso.project.repository.dto.DiningFriendsDto;
import siso.project.repository.vo.DiningFriendsUsersVO;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DiningFriendsService {

    private final DiningFriendsMapper diningFriendsMapper;
    private final DiningFriendsUsersMapper diningFriendsUsersMapper;

    //파티 생성
    public void create(DiningFriends diningFriends) {
        diningFriends.setCurrentNumber();
        diningFriendsMapper.save(diningFriends);
    }

    //파티 조회
    public List<DiningFriends> select(Long teamId) {
        DiningFriendsDto diningFriendsDto = DiningFriendsDto.builder()
                .teamId(teamId)
                .build();

        return diningFriendsMapper.select(diningFriendsDto);
    }

    public void delete(DiningFriends diningFriends) {
        diningFriendsMapper.delete(diningFriends.getId());
    }

    //파티 상세 조회
    public List<DiningFriendsUsersVO> detailSelect(Long diningFriendId) {
        return diningFriendsUsersMapper.selectDiningFriendsUsers(diningFriendId);
    }

    //파티 참가
    public void saveDiningFriendsUsers(DiningFriendsUsers diningFriendsUsers) {
        diningFriendsUsersMapper.save(diningFriendsUsers);
        diningFriendsMapper.currentNumberPlusUpdate(diningFriendsUsers.getDiningFriendsId());
    }

    //파티 탈퇴
    public void deleteDiningFriendsUsers(DiningFriendsUsers diningFriendsUsers) {
        diningFriendsUsersMapper.selectedDelete(diningFriendsUsers);
        diningFriendsMapper.currentNumberMinusUpdate(diningFriendsUsers.getDiningFriendsId());
    }

}
