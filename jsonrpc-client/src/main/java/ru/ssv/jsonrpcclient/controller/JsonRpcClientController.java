package ru.ssv.jsonrpcclient.controller;

import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import ru.ssv.jsonrpcclient.api.UserService;
import ru.ssv.jsonrpcclient.dto.JsonRpcRequest;
import ru.ssv.jsonrpcclient.dto.JsonRpcResponse;
import ru.ssv.jsonrpcclient.dto.UserResponseDto;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/jsonrpc/client")
public class JsonRpcClientController {

    private static final String URL_SERVER = "http://127.0.0.1:8080//jsonrpc/user";
    private static final String METHOD = "saveOrUpdateUser";

    private final RestTemplate restTemplate;
    private final JsonRpcHttpClient jsonRpcHttpClient;
    private final UserService userService;

    @GetMapping("/v1/user")
    public UserResponseDto saveOrUpdateUserV1(@RequestParam String name, @RequestParam int age){
        return UserResponseDto.builder()
                .name(name)
                .age(age)
                .build();
    }

    @GetMapping("/v2/user")
    public UserResponseDto saveOrUpdateUserV2(@RequestParam String name, @RequestParam int age) throws Throwable {
        var httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        var jsonRpcRequest = JsonRpcRequest.builder()
                .id(1)
                .method(METHOD)
                .params(List.of(name, age))
                .build();

        var jsonRpcResponse = restTemplate.exchange(
                URL_SERVER,
                HttpMethod.POST,
                new HttpEntity<>(jsonRpcRequest, httpHeaders),
                new ParameterizedTypeReference<JsonRpcResponse>() {}
        );
        return jsonRpcResponse.getBody().getResult();
    }

    @GetMapping("/v3/user")
    public UserResponseDto saveOrUpdateUserV3(@RequestParam String name, @RequestParam int age) throws Throwable {
        return jsonRpcHttpClient.invoke(
                METHOD, null,
//                Map.of("name", name, "age", age),
                UserResponseDto.class);
    }

    @GetMapping("/v4/user")
    public UserResponseDto saveOrUpdateUserV4(@RequestParam String name, @RequestParam int age) throws Throwable {
        return userService.saveOrUpdateUser(name, age);
    }
}
