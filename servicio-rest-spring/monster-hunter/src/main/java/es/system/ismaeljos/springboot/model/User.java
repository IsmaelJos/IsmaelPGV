package es.system.ismaeljos.springboot.model;

import jakarta.persistence.*;
import lombok.Setter;

@Entity
@Table(name = "users")
public class User {

	@Setter
	private int id;
	@Setter
	private String name;
	@Setter
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

	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}

	@Column(name = "password", nullable = false)
	public String getPassword() {
		return password;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}
	
}
