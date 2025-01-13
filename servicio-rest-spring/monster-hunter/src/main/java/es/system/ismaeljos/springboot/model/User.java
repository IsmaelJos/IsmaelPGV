package es.system.ismaeljos.springboot.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

	private int id;
	private String name;
	private String password;
	
	public User() {	
	}

	public User(String name, String password) {
		this.name = name;
		this.password = password;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "password", nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}
	
}
