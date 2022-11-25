package ru.ssv.springbootstarter.propertyfile;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "audit")
@Data
public class AuditEventTypeConfiguration {
    Map<String, EventType> eventTypes;

    @Data
    public static class EventType {
        private String description;
        private List<String> params;
    }
}
