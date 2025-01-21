package es.system.ismaeljos.springboot.model;

import jakarta.persistence.*;

@Entity
@Table(name = "armors")
public class Armor {
    @Id
    private int id;
    private String name;
    private int defense;

    public Armor() {
    }

    public Armor(String name) {
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

    @Column(name = "defense", nullable = false)
    public int getDefence() {
        return defense;
    }

    public void setDefence(int defence) {
        this.defense = defence;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + "]";
    }
}
