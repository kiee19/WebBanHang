package com.PS11390_NguyenTungNhatLinh_ASM.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDTO extends AbtractDTO<CategoryDTO>{
	
	private String name;
	private String code;
	private Boolean isDeleted;
	
}
