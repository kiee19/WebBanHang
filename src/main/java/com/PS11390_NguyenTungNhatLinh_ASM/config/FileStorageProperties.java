package com.PS11390_NguyenTungNhatLinh_ASM.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;
@ConfigurationProperties(prefix = "file")
@Data
public class FileStorageProperties {
	private String uploadDir;
}
