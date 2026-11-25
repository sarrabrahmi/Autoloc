package tn.esprit.autoloc.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservation;
    @Column(nullable = false)
    private LocalDate dateDebut;
    @Column(nullable = false)
    private LocalDate dateFin;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private StatutReservation statut;

    @ManyToOne
    @JoinColumn(name = "idVehicule", nullable = false)
    @ToString.Exclude
    private vehicule vehicule;

    @ManyToOne
    @JoinColumn(name = "idClient", nullable = false)
    @ToString.Exclude
    private client client;

    // OneToOne : cote inverse (la cle etrangere est dans contrat)
    @OneToOne(mappedBy = "reservation")
    @JsonIgnore
    @ToString.Exclude
    private contrat contrat;
}