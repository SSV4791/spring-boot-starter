package ru.ssv.restserver.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserRequestDto {
    private String id;
    private String name;
    private int age;
    private OffsetDateTime birdDate;
}
