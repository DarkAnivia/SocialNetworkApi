package com.socialNetwork.restservice;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {

    private @Id @GeneratedValue Long id;
	private String name;
	private String pwd;

	User() {}

	User (User user){
		this.name = user.getName();
		this.pwd = user.getPwd();
	}

	User(String name, String pwd) {

		this.name = name;
		this.pwd = pwd;
	}

	public Long getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public boolean equals(Object o) {

		if (this == o)
			return true;
		if (!(o instanceof User))
			return false;
		User user = (User) o;
		return Objects.equals(this.id, user.id) && Objects.equals(this.name, user.name)
				&& Objects.equals(this.pwd, user.pwd);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.id, this.name, this.pwd);
	}

	@Override
	public String toString() {
		return "User{" + "id=" + this.id + ", name='" + this.name + '\'' + ", pwd='" + this.pwd + '\'' + '}';
	}
    
}