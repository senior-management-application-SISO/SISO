package siso.project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import siso.project.domain.DiningFriends;
import siso.project.repository.DiningFriendsMapper;
import siso.project.repository.dto.DiningFriendsDto;

@Service
@RequiredArgsConstructor
public class DiningFriendsService {

    private final DiningFriendsMapper diningFriendsMapper;

    //파티 생성
    public void create(DiningFriends diningFriends) {
        diningFriendsMapper.save(diningFriends);
    }


}
