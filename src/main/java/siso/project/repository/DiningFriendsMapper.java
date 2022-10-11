package siso.project.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import siso.project.domain.DiningFriends;
import siso.project.repository.dto.DiningFriendsDto;

@Mapper
public interface DiningFriendsMapper {

    // 저장
    void save(DiningFriends diningFriends);

    // 수정
    void update(@Param("id") Long id, @Param("updateParam")DiningFriendsDto updateDto);

    // 삭제
    void delete(Long id);
}
