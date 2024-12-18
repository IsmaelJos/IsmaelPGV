package es.system.IsmaelJos.springboot.model;

import jakarta.persistence.*;

@Entity
@Table(name = "monster")
public class Monster {
    private int id;
    private String name;
    // private String element;
    private String description;

    public Monster() {
    }

    public Monster(String name, String description) {
        this.name = name;
        this.description = description;
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

    @Column(name = "description", nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", description=" + description + "]";
    }

}
