package tn.esprit.autoloc.Services;

import tn.esprit.autoloc.DTO.ReservationResponseDto;
import tn.esprit.autoloc.Entities.reservation;
import java.util.List;
import java.util.Set;

public interface IReservationService {

    reservation ajouterReservation(reservation re);

    void supprimerReservation(long idReservation);

    List<reservation> recupererReservations();

    Set<reservation> findReservations();

    reservation recupererReservationByid(long idReservation);

    List<ReservationResponseDto> consulterReservations();

    List<ReservationResponseDto> consulterReservationsParClient(Long idClient);
}