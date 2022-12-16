# Реализация JSON-RPC SERVER 

Ресурс - https://www.programmersought.com/article/63415517083/

## Ключевые моменты рализации

1. Зависимости 

   implementation 'org.springframework.boot:spring-boot-starter'
   implementation 'org.springframework.boot:spring-boot-starter-web'

   implementation 'javax.jws:javax.jws-api:1.1'
   implementation 'com.fasterxml.jackson.core:jackson-databind:2.11.4'
   implementation 'com.github.briandilley.jsonrpc4j:jsonrpc4j:1.6'

2. Конфигурация 

   Бин AutoJsonRpcServiceImplExporter - BeanFactoryPostProcessor который ищет бины помеченные аннотацией @AutoJsonRpcServiceImpl 
   и интерфейсы аннотированные @JsonRpcService 