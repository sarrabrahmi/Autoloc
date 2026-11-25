package tn.esprit.autoloc.RestController;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.Entities.contrat;
import tn.esprit.autoloc.Services.IContratService;
import java.util.List;
import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/api/contrats")
public class ContratController {
    private final IContratService contratService;

    @PostMapping("/addcontrat")
    public ResponseEntity<contrat> ajouterContrat(@RequestBody contrat ct) {
        return ResponseEntity.status(HttpStatus.CREATED).body(contratService.ajouterContrat(ct));
    }

    @PutMapping("/modifcontrat/{id}")
    public ResponseEntity<contrat> modifierContrat(@PathVariable long id, @RequestBody contrat ct) {
        contrat existing = contratService.recupererContratByid(id);
        if (existing == null) return ResponseEntity.notFound().build();
        existing.setDateSignature(ct.getDateSignature());
        existing.setMontantTotal(ct.getMontantTotal());
        existing.setValide(ct.getValide());
        if (ct.getReservation() != null) existing.setReservation(ct.getReservation());
        // paiements untouched
        return ResponseEntity.ok(contratService.ajouterContrat(existing));
    }

    @DeleteMapping("/deletecontrat/{id}")
    public ResponseEntity<Void> supprimerContrat(@PathVariable long id) {
        if (contratService.recupererContratByid(id) == null) return ResponseEntity.notFound().build();
        contratService.supprimerContrat(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getcontrats")
    public ResponseEntity<List<contrat>> recupererContrats() {
        return ResponseEntity.ok(contratService.recupererContrats());
    }

    @GetMapping("/set")
    public ResponseEntity<Set<contrat>> findContrats() {
        return ResponseEntity.ok(contratService.findContrats());
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<contrat> recupererContratByid(@PathVariable long id) {
        contrat ct = contratService.recupererContratByid(id);
        return ct == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(ct);
    }
}