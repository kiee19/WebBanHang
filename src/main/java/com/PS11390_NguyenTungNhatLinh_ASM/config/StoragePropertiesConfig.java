package com.PS11390_NguyenTungNhatLinh_ASM.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@ConfigurationProperties("storage")
@Data
public class StoragePropertiesConfig {
	private String location;
}
