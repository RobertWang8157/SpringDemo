package com.example.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "member")
@ToString
public class Member {
	@Id

	private int id;
	private String name;
	private String pwd;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date birth;
	private String email2;


	public Member() {
	}

	public Member(String name, String pwd, int id, Date birth, String email2) {
		super();
		this.name = name;
		this.pwd = pwd;
		this.id = id;
		this.birth = birth;
		this.email2 = email2;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}	

	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", pwd=" + pwd + ", birth=" + birth + ", email=" + email2 + "]";
	}

}
