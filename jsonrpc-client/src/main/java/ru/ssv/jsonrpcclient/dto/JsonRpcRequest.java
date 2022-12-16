package ru.ssv.jsonrpcclient.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class JsonRpcRequest {
    private int id;
    private String method;
    private List<Object> params;
}
