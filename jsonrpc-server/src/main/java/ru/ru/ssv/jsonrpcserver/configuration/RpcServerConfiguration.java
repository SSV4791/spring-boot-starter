package ru.ru.ssv.jsonrpcserver.configuration;

import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImplExporter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RpcServerConfiguration {

    @Bean
    public AutoJsonRpcServiceImplExporter rpcServiceImplExporter() {
        return new AutoJsonRpcServiceImplExporter();
    }
}
