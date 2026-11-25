package tn.esprit.autoloc.RestController;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.Entities.reservation;
import tn.esprit.autoloc.Services.IReservationService;
import java.util.List;
import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/api/reservations")
public class ReservationController {
    private final IReservationService reservationService;

    @PostMapping
    public ResponseEntity<reservation> ajouterReservation(@RequestBody reservation re) {
        return ResponseEntity.status(HttpStatus.CREATED).body(reservationService.ajouterReservation(re));
    }

    @PutMapping("/{id}")
    public ResponseEntity<reservation> modifierReservation(@PathVariable long id, @RequestBody reservation re) {
        if (reservationService.recupererReservationByid(id) == null) return ResponseEntity.notFound().build();
        re.setIdReservation(id);
        return ResponseEntity.ok(reservationService.ajouterReservation(re));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerReservation(@PathVariable long id) {
        if (reservationService.recupererReservationByid(id) == null) return ResponseEntity.notFound().build();
        reservationService.supprimerReservation(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<reservation>> recupererReservations() {
        return ResponseEntity.ok(reservationService.recupererReservations());
    }

    @GetMapping("/set")
    public ResponseEntity<Set<reservation>> findReservations() {
        return ResponseEntity.ok(reservationService.findReservations());
    }

    @GetMapping("/{id}")
    public ResponseEntity<reservation> recupererReservationByid(@PathVariable long id) {
        reservation re = reservationService.recupererReservationByid(id);
        return re == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(re);
    }
}