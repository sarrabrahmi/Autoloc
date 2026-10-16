package tn.esprit.autoloc.Entities;

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
public class agence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAgence;
    @Column(nullable = false, length = 100)
    private String nom;
    @Column(nullable = false, length = 50)
    private String ville;
    @Column(nullable = false, length = 100)
    private String adresse;
    @Column(nullable = false, length = 20)
    private String telephone;

    // OneToMany : une agence a plusieurs employes
    @OneToMany(mappedBy = "agence", cascade = CascadeType.ALL)
    @ToString.Exclude
    private Set<employe> employes = new HashSet<>();

    // OneToMany : une agence possede plusieurs vehicules
    @OneToMany(mappedBy = "agence", cascade = CascadeType.ALL)
    @ToString.Exclude
    private Set<vehicule> vehicules = new HashSet<>();
}