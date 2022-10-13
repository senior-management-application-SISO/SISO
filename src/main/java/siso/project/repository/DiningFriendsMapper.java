package siso.project.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import siso.project.domain.DiningFriends;
import siso.project.domain.Users;
import siso.project.repository.dto.DiningFriendsDto;

import java.util.List;
import java.util.Optional;

@Mapper
public interface DiningFriendsMapper {

    // 저장
    void save(DiningFriends diningFriends);

    // 수정
    void update(@Param("id") Long id, @Param("updateParam")DiningFriendsDto updateDto);

    // 삭제
    void delete(Long id);

    // 조회
    Optional<DiningFriends> findById(Long id);

    // 전체 조회
    List<DiningFriends> select(DiningFriendsDto diningFriendsDto);
}
