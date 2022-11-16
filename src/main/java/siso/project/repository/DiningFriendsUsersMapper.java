package siso.project.repository;

import org.apache.ibatis.annotations.Mapper;
import siso.project.domain.DiningFriends;
import siso.project.domain.DiningFriendsUsers;
import siso.project.repository.dto.DiningFriendsUsersDto;
import siso.project.repository.vo.DiningFriendsUsersVO;

import java.util.List;
import java.util.Optional;


@Mapper
public interface DiningFriendsUsersMapper {
    // 저장
    void save(DiningFriendsUsers diningFriendsUsers);

    // 삭제
    void delete(Long id);

    // 삭제
    void selectedDelete(DiningFriendsUsers diningFriendsUsers);

    // 특정 파티에 참가하는 참가자 정보 조회
    List<DiningFriendsUsersVO> selectDiningFriendsUsers(Long diningFriendsId);

    // user id로 파티 조회
    Optional<DiningFriendsUsersVO> selectByUserId(Long userId);

}
