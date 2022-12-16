package ru.ssv.jsonrpcclient.api;

import com.googlecode.jsonrpc4j.JsonRpcParam;
import ru.ssv.jsonrpcclient.dto.UserRequestDto;
import ru.ssv.jsonrpcclient.dto.UserResponseDto;

public interface UserService {
    UserResponseDto saveOrUpdateUser(@JsonRpcParam("name") String name, @JsonRpcParam("age") int age);
    UserResponseDto saveOrUpdateUser(UserRequestDto user);
}
