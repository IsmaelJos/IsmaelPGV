package es.system.ismaeljos.springboot.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "elements")
public class Element implements Serializable {
    @Id
    private int id;
    private String name;

    public Element() {
    }

    public Element(String name) {
        this.name = name;
    }
    @Id
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
        return "User [id=" + id + ", name=" + name + "]";
    }
}
