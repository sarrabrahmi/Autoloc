package tn.esprit.autoloc.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class contrat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContrat;
    @Column(nullable = false)
    private LocalDate dateSignature;
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal montantTotal;
    @Column(nullable = false)
    private Boolean valide;

    // OneToOne : proprietaire de l'association (FK idReservation unique)
    @OneToOne
    @JoinColumn(name = "idReservation", nullable = false, unique = true)
    @ToString.Exclude
    private reservation reservation;

    // Composition : les paiements dependent du contrat (supprimes avec lui)
    @OneToMany(mappedBy = "contrat", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private Set<paiement> paiements = new HashSet<>();
}