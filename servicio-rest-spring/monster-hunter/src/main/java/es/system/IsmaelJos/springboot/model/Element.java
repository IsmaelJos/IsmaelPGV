package es.system.IsmaelJos.springboot.model;

import jakarta.persistence.*;

@Entity
@Table(name = "element")
public class Element {
    private int id;
    private String name;

    public Element() {
    }

    public Element(String name) {
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
        return "User [id=" + id + ", name=" + name + "]";
    }
}
