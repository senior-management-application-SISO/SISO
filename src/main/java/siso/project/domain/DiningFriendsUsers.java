package siso.project.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DiningFriendsUsers {

    private Long id;

    //외래키
    private Long usersId;
    private Long diningFriendsId;

    @Builder
    public DiningFriendsUsers(Long id, Long usersId, Long diningFriendsId) {
        this.id = id;
        this.usersId = usersId;
        this.diningFriendsId = diningFriendsId;
    }
}
