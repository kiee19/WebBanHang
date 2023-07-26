package com.PS11390_NguyenTungNhatLinh_ASM.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class UserEntity extends BaseEntity {

	@NotNull
	@Column(name = "username")
	private String username;
	
	@NotNull
	@Column(name = "hashpassword")
	private String hashPassword;
	
	@NotNull
	@Column(name = "fullname")
	private String fullname;

	@Column(name = "email")
	private String email;

	@Column(name = "imgurl")
	private String imgUrl;
	
	@NotNull
	@Column(name = "isdeleted")
	private Boolean isDeleted;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "roleid")
	private RoleEntity roleId;

	@OneToMany(mappedBy = "userid")
	private List<OrderEntity> orders = new ArrayList<>();

}
