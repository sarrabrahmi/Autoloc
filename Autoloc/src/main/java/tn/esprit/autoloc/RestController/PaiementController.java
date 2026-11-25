package tn.esprit.autoloc.RestController;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.Entities.paiement;
import tn.esprit.autoloc.Services.IPaiementService;
import java.util.List;
import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/api/paiements")
public class PaiementController {
    private final IPaiementService paiementService;

    @PostMapping
    public ResponseEntity<paiement> ajouterPaiement(@RequestBody paiement pa) {
        return ResponseEntity.status(HttpStatus.CREATED).body(paiementService.ajouterPaiement(pa));
    }

    @PutMapping("/{id}")
    public ResponseEntity<paiement> modifierPaiement(@PathVariable long id, @RequestBody paiement pa) {
        if (paiementService.recupererPaiementByid(id) == null) return ResponseEntity.notFound().build();
        pa.setIdPaiement(id);
        return ResponseEntity.ok(paiementService.ajouterPaiement(pa));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerPaiement(@PathVariable long id) {
        if (paiementService.recupererPaiementByid(id) == null) return ResponseEntity.notFound().build();
        paiementService.supprimerPaiement(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<paiement>> recupererPaiements() {
        return ResponseEntity.ok(paiementService.recupererPaiements());
    }

    @GetMapping("/set")
    public ResponseEntity<Set<paiement>> findPaiements() {
        return ResponseEntity.ok(paiementService.findPaiements());
    }

    @GetMapping("/{id}")
    public ResponseEntity<paiement> recupererPaiementByid(@PathVariable long id) {
        paiement pa = paiementService.recupererPaiementByid(id);
        return pa == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(pa);
    }
}