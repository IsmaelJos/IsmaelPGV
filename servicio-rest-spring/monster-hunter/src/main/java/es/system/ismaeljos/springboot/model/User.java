package es.system.ismaeljos.springboot.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "users")
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String password;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rol",nullable = true)
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

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}

	@Column(name = "password", nullable = false)
	public String getPassword() {
		return password;
	}

	@Column(name = "rol", nullable = true)
	public Rol getRol() {
		return rol;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				", password='" + password + '\'' +
				", rol=" + rol+
				'}';
	}
}
