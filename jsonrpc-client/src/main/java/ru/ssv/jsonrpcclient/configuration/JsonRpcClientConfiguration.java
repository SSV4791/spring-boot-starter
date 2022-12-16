package ru.ssv.jsonrpcclient.configuration;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import com.googlecode.jsonrpc4j.ProxyUtil;
import lombok.SneakyThrows;
import org.springframework.boot.web.client.ClientHttpRequestFactorySupplier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;
import ru.ssv.jsonrpcclient.api.UserService;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpHeaders.ACCEPT;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;

@Configuration
public class JsonRpcClientConfiguration {

    @SneakyThrows
    @Bean
    JsonRpcHttpClient jsonRpcHttpClient() {
        Map<String, String> map = new HashMap<>();
        var client = new JsonRpcHttpClient(
                objectMapper(),
                new URL("http://127.0.0.1:8080//jsonrpc/user"),
                map
        );
        return client;
    }

    @Bean
    ObjectMapper objectMapper() {
        var mapper = new ObjectMapper();
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"));
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.isEnabled(MapperFeature.DEFAULT_VIEW_INCLUSION);
        return mapper;
    }

    @Bean
    MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        var converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(objectMapper());
        converter.setSupportedMediaTypes(List.of(MediaType.ALL));
        return converter;
    }

    @Bean
    RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder
                .messageConverters(mappingJackson2HttpMessageConverter())
                .requestFactory(new ClientHttpRequestFactorySupplier())
                .uriTemplateHandler(
                        new DefaultUriBuilderFactory("http://127.0.0.1:8080//jsonrpc/user")
                )
                .build();
    }

    @Bean
    public UserService userServiceAPI(JsonRpcHttpClient jsonRpcHttpClient) {
        return ProxyUtil.createClientProxy(getClass().getClassLoader(), UserService.class, jsonRpcHttpClient);
    }
}
