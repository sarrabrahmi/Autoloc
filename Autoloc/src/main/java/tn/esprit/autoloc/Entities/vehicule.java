package tn.esprit.autoloc.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class vehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVehicule;
    @Column(nullable = false, unique = true, length = 20)
    private String immatriculation;
    @Column(nullable = false, length = 50)
    private String marque;
    @Column(nullable = false, length = 50)
    private String modele;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private CategorieVehicule categorie;
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal tarifJournalier;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private StatutVehicule statut;

    // ManyToOne : plusieurs vehicules appartiennent a une agence
    @ManyToOne
    @JoinColumn(name = "idAgence")
    @ToString.Exclude
    private agence agence;

    // OneToMany : un vehicule a plusieurs reservations
    @OneToMany(mappedBy = "vehicule")
    @JsonIgnore
    @ToString.Exclude
    private Set<reservation> reservations = new HashSet<>();

    // OneToMany : un vehicule a plusieurs maintenances
    @OneToMany(mappedBy = "vehicule")
    @JsonIgnore
    @ToString.Exclude
    private Set<maintenance> maintenances = new HashSet<>();

    // ManyToMany : proprietaire de l'association (table vehicule_equipement)
    @ManyToMany
    @JoinTable(
            name = "vehicule_equipement",
            joinColumns = @JoinColumn(name = "idVehicule"),
            inverseJoinColumns = @JoinColumn(name = "idEquipement")
    )
    @ToString.Exclude
    private Set<equipement> equipements = new HashSet<>();
}