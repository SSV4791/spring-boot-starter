package ru.ssv.jsonrpcclient.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class JsonRpcResponse {
    private String jsonrpc;
    private String id;
    private UserResponseDto result;
}
