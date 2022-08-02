package com.tugasday12.tugasday12.service;


import com.tugasday12.tugasday12.dto.CreateUserDto;
import com.tugasday12.tugasday12.dto.DeleteUserDto;
import com.tugasday12.tugasday12.dto.UpdateUserDto;
import com.tugasday12.tugasday12.errorresponse.ErrorResponse;
import com.tugasday12.tugasday12.model.User;
import com.tugasday12.tugasday12.repository.UserRepository;
import lombok.SneakyThrows;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional(rollbackOn = Exception.class  )

public class UserService {

    @Autowired
    private UserRepository userRepository;

    @SneakyThrows(Exception.class)
    public ResponseEntity<Object>create(CreateUserDto dto){

        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String,Object> res = new HashMap<String, Object>();

        User user = new User();

        user.setUsername(dto.getUsername().trim());
        user.setPhone(dto.getPhone().trim());
        user.setAddress(dto.getAddress().trim());


        userRepository.save(user);

        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).build();

    }

    public ResponseEntity<Object>update(UpdateUserDto dto) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> res = new HashMap<String, Object>();

        User user = userRepository.findById(dto.getId()).orElse(null);
        if (Optional.ofNullable(user).isPresent()) {

            user.setUsername(dto.getUsername().trim());
            user.setPhone(dto.getPhone().trim());
            user.setAddress(dto.getAddress().trim());
            userRepository.save(user);
        } else {
            ErrorResponse err = new ErrorResponse("999", "Data Not Found");
            return ResponseEntity.status(HttpStatus.OK).headers(headers).body(err);
        }
        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).build();
    }

        public ResponseEntity<Object> delete(DeleteUserDto dto) {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);


            User user = userRepository.findById(dto.getId()).orElse(null);
            if (Optional.ofNullable(user).isPresent()) {

                user.setUsername(dto.getUsername().trim());
                user.setPhone(dto.getPhone().trim());
                user.setAddress(dto.getAddress().trim());
                userRepository.delete(user);
            } else {
                ErrorResponse err = new ErrorResponse("999", "Data Not Found");
                return ResponseEntity.status(HttpStatus.OK).headers(headers).body(err);
            }
            return ResponseEntity.status(HttpStatus.CREATED).headers(headers).build();
        }
    }




