package com.PS11390_NguyenTungNhatLinh_ASM.dto;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;

import lombok.Data;
@Data
public abstract class AbtractDTO<T> {
	private Long id;
	private Date createdDate;
	private Date modifiedDate;
	private List<T> listResult = new ArrayList<>();
}
