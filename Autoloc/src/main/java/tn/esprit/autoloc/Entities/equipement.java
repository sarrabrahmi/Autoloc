package tn.esprit.autoloc.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class equipement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEquipement;
    @Column(nullable = false, length = 50)
    private String libelle;

    // ManyToMany : cote inverse (proprietaire = vehicule)
    @ManyToMany(mappedBy = "equipements")
    @JsonIgnore
    @ToString.Exclude
    private Set<vehicule> vehicules = new HashSet<>();
}