package com.anubhavpabby.blog.serviceimpl;

import com.anubhavpabby.blog.dtos.UserDto;
import com.anubhavpabby.blog.exceptions.ResourceNotFoundException;
import com.anubhavpabby.blog.models.User;
import com.anubhavpabby.blog.repositories.UserRepo;
import com.anubhavpabby.blog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDto getUserById(Long userId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
        return this.userObjToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = this.userRepo.findAll();
        List<UserDto> userDtos = users.stream().map((User user) -> {
            return userObjToUserDto(user);
        }).collect(Collectors.toList());

        return userDtos;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = this.userDtoToUserObj(userDto);
        User savedUser = this.userRepo.save(user);
        return this.userObjToUserDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Long userId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));

        user.setName(userDto.getName());
        user.setDob(userDto.getDob());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setBio(userDto.getBio());

        User updatedUser = this.userRepo.save(user);
        return this.userObjToUserDto(updatedUser);
    }

    @Override
    public void deleteUser(Long userId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
        this.userRepo.delete(user);
    }

    private User userDtoToUserObj(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setDob(userDto.getDob());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setBio(userDto.getBio());
        return user;
    }

    private UserDto userObjToUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setDob(user.getDob());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setBio(user.getBio());
        return userDto;
    }
}
