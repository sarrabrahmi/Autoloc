package tn.esprit.autoloc.Entities;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
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

    @ManyToMany(mappedBy = "equipements")
    @ToString.Exclude
    private Set<vehicule> vehicules = new HashSet<>();
}
