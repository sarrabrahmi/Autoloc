package tn.esprit.autoloc.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClient;
    @Column(nullable = false, length = 50)
    private String nom;
    @Column(nullable = false, length = 50)
    private String prenom;
    // facultatif (plusieurs NULL autorisés malgré unique)
    @Column(unique = true, length = 100)
    private String email;
    // facultatif
    @Column(length = 20)
    private String telephone;
    // non fourni via ClientRequestDto -> facultatif à la création
    @Column(unique = true, length = 20)
    private String numPermis;
    @Column(nullable = false)
    private LocalDate dateInscription;

    // OneToMany : un client a plusieurs reservations
    @OneToMany(mappedBy = "client")
    @JsonIgnore
    @ToString.Exclude
    private Set<reservation> reservations = new HashSet<>();
}