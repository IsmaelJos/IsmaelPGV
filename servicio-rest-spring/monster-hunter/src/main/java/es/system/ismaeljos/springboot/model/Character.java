package es.system.ismaeljos.springboot.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "characters")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Character {

    @Id
    private int id;
    private String name;
    private Set<Weapon> weapons;
    private Set<Armor> armors;

    public Character() {
    }

    public Character(String name) {
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

    @Column(name = "name", nullable = false, unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "character_weapon",
            joinColumns = @JoinColumn(name = "character_id"),
            inverseJoinColumns = @JoinColumn(name = "weapon_id")
    )
    @JsonManagedReference
    public Set<Weapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(Set<Weapon> weapons) {
        this.weapons = weapons;
    }

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "character_armor",
            joinColumns = @JoinColumn(name = "character_id"),
            inverseJoinColumns = @JoinColumn(name = "armor_id")
    )
    @JsonManagedReference
    public Set<Armor> getArmors() {
        return armors;
    }

    public void setArmors(Set<Armor> armors) {
        this.armors = armors;
    }

    @Override
    public String toString() {
        return "Character{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weapons=" + weapons +
                ", armors=" + armors +
                '}';
    }
}
