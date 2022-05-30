package com.brandon.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SendMailDto {
    private String emailAddress;
    private String subject;
    private String message;
}
