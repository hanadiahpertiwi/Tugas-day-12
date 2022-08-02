package com.tugasday12.tugasday12.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserDto {

    private long id;
    private String username;
    private String phone;
    private String address;
}

