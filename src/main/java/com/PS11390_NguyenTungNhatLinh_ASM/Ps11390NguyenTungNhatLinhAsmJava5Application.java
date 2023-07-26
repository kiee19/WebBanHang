package com.PS11390_NguyenTungNhatLinh_ASM;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.PS11390_NguyenTungNhatLinh_ASM.config.FileStorageProperties;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@EnableConfigurationProperties(FileStorageProperties.class)
public class Ps11390NguyenTungNhatLinhAsmJava5Application {

	public static void main(String[] args) {
		SpringApplication.run(Ps11390NguyenTungNhatLinhAsmJava5Application.class, args);
	}

}
