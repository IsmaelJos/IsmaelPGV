package es.system.ismaeljos.springboot.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "users")
public class User implements Serializable {

	private int id;
	@Setter
	private String name;
	@Setter
	private String password;
	@Setter
	@ManyToOne
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
