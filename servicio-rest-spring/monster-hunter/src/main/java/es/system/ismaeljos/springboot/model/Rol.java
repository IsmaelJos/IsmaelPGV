package es.system.ismaeljos.springboot.model;

import jakarta.persistence.*;

@Entity
@Table(name = "rols")
public class Rol {

    private int id;
    private String name;
    public Rol() {
    }

    public Rol(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "Rol [id=" + id + ", name=" + name + "]";
    }

}
