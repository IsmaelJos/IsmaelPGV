package es.system.ismaeljos.springboot.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
public class User {

	private int id;
	private String name;
	private String password;
	@ManyToOne(fetch = FetchType.LAZY)
	private Rol rol;

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
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				", password='" + password + '\'' +
				", rol=" + rol +
				'}';
	}
}
