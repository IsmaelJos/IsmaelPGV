package es.system.ismaeljos.springboot.model;


import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private int id;
	private String name;
	private String password;
	@ManyToOne//(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
	@JoinColumn(name = "roll", nullable = true)
	private Roll roll;

	public User() {	
	}

	public User(String name, String password, Roll roll) {
		this.name = name;
		this.password = password;
		this.roll = roll;
	}

	@Id
	@Column(name = "id", nullable = false)
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

	@Column(name = "roll", nullable = true)
	public Roll getRol() {
		return roll;
	}

	public void setRol(Roll roll) {
		this.roll = roll;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				", password='" + password + '\'' +
				", roll=" + roll.getName() +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		User user = (User) o;
		return id == user.id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
