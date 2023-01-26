package com.anubhavpabby.blog.controllers;

import com.anubhavpabby.blog.dtos.ApiResponse;
import com.anubhavpabby.blog.dtos.UserDto;
import com.anubhavpabby.blog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    // Get Request: Get the list of all the users.
    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUser() {
        List<UserDto> userDtos = userService.getAllUsers();
        return ResponseEntity.ok(userDtos);
    }

    // Get Request: Get the data of the user by userId
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUser(@PathVariable("userId") Long userId) {
        UserDto userDto = this.userService.getUserById(userId);
        return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);
    }

    // Post Request: This requests creates a new user
    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        UserDto createdUserDto = this.userService.createUser(userDto);
        return new ResponseEntity<UserDto>(createdUserDto, HttpStatus.CREATED);
    }

    // Put Request: Update the data of the user by userId
    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("userId") Long uId, @RequestBody UserDto userDto) throws Exception {
        UserDto updatedUserDto = this.userService.updateUser(userDto, uId);
        return new ResponseEntity<UserDto>(updatedUserDto, HttpStatus.OK);
    }

    // Delete Request: Delete the data of the user by userId
    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Long uId) {
        this.userService.deleteUser(uId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("User with user id: " + uId + " is successfully deleted.", true), HttpStatus.OK);
    }
}
