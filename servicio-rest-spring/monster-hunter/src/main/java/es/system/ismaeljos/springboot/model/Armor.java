package es.system.ismaeljos.springboot.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "armors")
public class Armor implements Serializable {
    @Id
    private int id;
    private String name;
    private int defense;
    @JsonIgnoreProperties
    private Set<Character> characters;

    public Armor() {
    }

    public Armor(String name) {
        this.name = name;
    }
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {this.id = id;}

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

    @ManyToMany(mappedBy = "armors")
    @JsonBackReference
    public Set<Character> getCharacters() {return characters;}

    public void setCharacters(Set<Character> characters) {this.characters = characters;}

    @Override
    public String toString() {
        return "Armor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", defense=" + defense +
                '}';
    }
}
