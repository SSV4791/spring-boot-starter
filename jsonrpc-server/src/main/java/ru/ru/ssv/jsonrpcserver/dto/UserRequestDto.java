package ru.ru.ssv.jsonrpcserver.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRequestDto {
    private String name;
    private int age;
}
