package ru.ru.ssv.jsonrpcserver.service;

import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.ru.ssv.jsonrpcserver.dto.UserRequestDto;
import ru.ru.ssv.jsonrpcserver.dto.UserResponseDto;

import java.util.UUID;

import static java.lang.String.format;

@Slf4j
@AutoJsonRpcServiceImpl
@Service
public class UserServiceImpl implements UserService{

    @Override
    public UserResponseDto saveOrUpdateUser(String name, int age) {

        log.info(format("name: %s, age: %s", name, age));

        return UserResponseDto.builder()
                .id(UUID.randomUUID().toString())
                .name(name)
                .age(age)
                .build();
    }

    @Override
    public UserResponseDto saveOrUpdateUser(UserRequestDto user) {

        log.info("");

        return saveOrUpdateUser(user.getName(), user.getAge());
    }
}
