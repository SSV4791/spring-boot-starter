package ru.ru.ssv.jsonrpcserver.service;

import com.googlecode.jsonrpc4j.JsonRpcParam;
import com.googlecode.jsonrpc4j.JsonRpcService;
import ru.ru.ssv.jsonrpcserver.dto.UserRequestDto;
import ru.ru.ssv.jsonrpcserver.dto.UserResponseDto;

@JsonRpcService("/jsonrpc/user")
public interface UserService {
    UserResponseDto saveOrUpdateUser(@JsonRpcParam("name") String name, @JsonRpcParam("age") int age);
    UserResponseDto saveOrUpdateUser(UserRequestDto user);
}
