package ru.ssv.springbootstarter.propertyfile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PropertyFileApplication {

	public static void main(String[] args) {
		var applicationContext =  SpringApplication.run(PropertyFileApplication.class, args);
		var auditEventTypes = applicationContext.getBean(AuditEventTypeConfiguration.class);
		System.out.println(auditEventTypes);
	}

}
