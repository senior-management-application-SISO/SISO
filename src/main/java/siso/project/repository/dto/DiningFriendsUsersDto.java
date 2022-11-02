package siso.project.repository.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class DiningFriendsUsersDto {

    private Long usersId;
    private Long diningFriendsId;

    @Builder
    public DiningFriendsUsersDto(Long usersId, Long diningFriendsId) {
        this.usersId = usersId;
        this.diningFriendsId = diningFriendsId;
    }
}
