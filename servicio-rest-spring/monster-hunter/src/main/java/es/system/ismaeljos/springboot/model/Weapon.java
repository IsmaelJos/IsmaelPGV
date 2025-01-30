package es.system.ismaeljos.springboot.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "weapons")
public class Weapon implements Serializable {
    @Id
    private int id;
    private String name;
    private int power;

    private Set<Character> characters;
    private Element element;

    public Weapon() {
    }

    public Weapon(String name) {
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

    @Column(name = "power", nullable = false)
    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @ManyToMany(mappedBy = "weapons")
        @JsonBackReference
    public Set<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(Set<Character> character) {
        this.characters = character;
    }

    @ManyToOne
    @JoinColumn(name = "element", nullable = false)
        @JsonManagedReference
    public Element getElement() {return element;}

    public void setElement(Element element) {this.element = element;}

    @Override
    public String toString() {
        return "Weapon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", power=" + power +
                ", element=" + element +
                '}';
    }
}
