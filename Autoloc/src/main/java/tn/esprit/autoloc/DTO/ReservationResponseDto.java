package tn.esprit.autoloc.DTO;

import lombok.*;
import java.time.LocalDate;
import tn.esprit.autoloc.Entities.StatutReservation;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationResponseDto {

    private Long id;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private StatutReservation statut;

    private String nomClient;
    private String prenomClient;

    private String marque;
    private String modele;
    private String immatriculation;
}