package com.tugasday12.tugasday12.controller;


import com.tugasday12.tugasday12.dto.CreateUserDto;
import com.tugasday12.tugasday12.dto.DeleteUserDto;
import com.tugasday12.tugasday12.dto.UpdateUserDto;
import com.tugasday12.tugasday12.service.UserService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @SneakyThrows(Exception.class)
    @PostMapping(path = "/user",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object>create(@RequestBody CreateUserDto dto){

        log.info("api api/v1/user fro POST is executed");
        return userService.create(dto);
    }

    @SneakyThrows(Exception.class)
    @PutMapping(path = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object>update(@RequestBody UpdateUserDto dto){

        log.info("api api/v1/user fro PUT is executed");
        return userService.update(dto);
    }

    @SneakyThrows(Exception.class)
    @DeleteMapping(path = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object>delete(@RequestBody DeleteUserDto dto){

        log.info("api api/v1/user Delete is executed");
        return userService.delete(dto);
    }

}