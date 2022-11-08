package siso.project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import siso.project.domain.Users;
import siso.project.domain.UsersLocation;
import siso.project.repository.UsersLocationMapper;
import siso.project.repository.UsersMapper;
import siso.project.repository.dto.UsersDto;
import siso.project.repository.dto.UsersLocationDto;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersLocationService {
    private final UsersLocationMapper usersLocationMapper;
    private final UsersMapper usersMapper;

    public void saveUserLocation(long userId, UsersLocation usersLocation) {

        usersLocation.setTime(LocalDateTime.now());

        usersLocationMapper.save(usersLocation);

        UsersDto usersDto = UsersDto.builder()
                .usersLocationId(usersLocation.getId()).build();

        usersMapper.update(userId, usersDto);
    }

    public UsersLocation selectUserLocationByUsersLocationId(long id) {
        return usersLocationMapper.selectUserLocationByLocationId(id).get();
    }

    public UsersLocation selectUserLocationByUsersId(long userId) {
        Users user = usersMapper.findById(userId).get();

        return usersLocationMapper.selectUserLocationByLocationId(user.getUsersLocationId()).get();
    }

    public void updateUsersLocationByUsersId(long userId, UsersLocationDto usersLocationDto) {
        Users user = usersMapper.findById(userId).get();

        usersLocationMapper.update(user.getUsersLocationId(), usersLocationDto);
    }

    public void updateUsersLocationByUsersLocationId(long id, UsersLocationDto usersLocationDto) {
        usersLocationMapper.update(id, usersLocationDto);
    }

}
