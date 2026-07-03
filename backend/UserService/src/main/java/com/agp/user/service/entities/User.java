package com.agp.user.service.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="micro_users")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
	
	@Id
	@Column(name = "id")
	private String userId;
	
	@Column(name="firstname", length = 20)
	private String firstName;
	
	@Column(name="lastname", length = 20)
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="about")
	private String  about;
	
	@Column(name="username")
	private String  userName;
	
	@Column(name="password")
	private String  password;
	
	@Column(name="roles")
	private String  roles;
	
	@Transient
	private List<Rating> ratings = new ArrayList<>();

}
