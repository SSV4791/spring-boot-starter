package ru.ssv.jsonrpcclient.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserResponseDto {
    private String id;
    private String name;
    private int age;
}
