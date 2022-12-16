package ru.ssv.restserver.controller;

import org.springframework.web.bind.annotation.*;
import ru.ssv.restserver.dto.UserRequestDto;
import ru.ssv.restserver.dto.UserResponseDto;

import java.time.OffsetDateTime;
import java.util.Random;
import java.util.UUID;

@RestController
@RequestMapping("/rest-server/v1")
public class RestServerController {

    @GetMapping(path = "users/{id}")
    UserResponseDto getUser(@PathVariable("id") String userId) {
        return UserResponseDto.builder()
                .id(userId)
                .name(UUID.randomUUID().toString())
                .age(new Random().nextInt(100))
                .birdDate(OffsetDateTime.now())
                .build();
    }

    @PostMapping(path = "users")
    UserResponseDto getUser(@RequestBody UserRequestDto user) {
        return UserResponseDto.builder()
                .id(user.getId())
                .name(user.getName())
                .age(user.getAge())
                .birdDate(user.getBirdDate())
                .build();
    }
}
