package tn.esprit.autoloc.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.DTO.ReservationResponseDto;
import tn.esprit.autoloc.Entities.reservation;
import tn.esprit.autoloc.Mappers.ReservationMapper;
import tn.esprit.autoloc.Repositories.reservationRepo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class ReservationService implements IReservationService {

    private final reservationRepo reservationRepo;
    private final ReservationMapper reservationMapper;

    @Override
    public reservation ajouterReservation(reservation re) {
        return reservationRepo.save(re);
    }

    @Override
    public void supprimerReservation(long idReservation) {
        reservationRepo.deleteById(idReservation);
    }

    @Override
    public List<reservation> recupererReservations() {
        return reservationRepo.findAll();
    }

    @Override
    public Set<reservation> findReservations() {
        return new HashSet<>(reservationRepo.findAll());
    }

    @Override
    public reservation recupererReservationByid(long idReservation) {
        return reservationRepo.findById(idReservation).orElse(null);
    }

    @Override
    public List<ReservationResponseDto> consulterReservations() {
        return reservationRepo.findAll()
                .stream()
                .map(reservationMapper::toResponseDto)
                .toList();
    }

    @Override
    public List<ReservationResponseDto> consulterReservationsParClient(Long idClient) {
        return reservationRepo.findByClient_IdClient(idClient)
                .stream()
                .map(reservationMapper::toResponseDto)
                .toList();
    }
}