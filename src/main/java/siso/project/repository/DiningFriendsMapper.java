package siso.project.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import siso.project.domain.DiningFriends;
import siso.project.domain.DiningFriendsUsers;
import siso.project.domain.Users;
import siso.project.repository.dto.DiningFriendsDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Mapper
public interface DiningFriendsMapper {

    // 저장
    void save(DiningFriends diningFriends);

    // 수정
    void update(@Param("id") Long id, @Param("updateParam")DiningFriendsDto updateDto);

    void updateTeamId(@Param("id") Long id, @Param("teamId") Long teamId);

    // 삭제
    void delete(Long id);

    // 조회
    Optional<DiningFriends> findById(Long id);

    // 전체 조회
    List<DiningFriends> select(DiningFriendsDto diningFriendsDto);


    // 자신이 소속된 소속의 파티 조회
    Optional<DiningFriends> selectDiningFriends(@Param("teamId") Long teamId, @Param("dateTime") LocalDateTime dateTime);

    //참가 인원 증가
    void currentNumberPlusUpdate(Long id);

    //참가 인원 감소
    void currentNumberMinusUpdate(Long id);
}
