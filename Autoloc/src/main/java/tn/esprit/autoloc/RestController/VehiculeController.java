package tn.esprit.autoloc.RestController;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.Entities.vehicule;
import tn.esprit.autoloc.Services.IVehiculeService;
import java.util.List;
import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/api/vehicules")
public class VehiculeController {
    private final IVehiculeService vehiculeService;

    @PostMapping
    public ResponseEntity<vehicule> ajouterVehicule(@RequestBody vehicule ve) {
        return ResponseEntity.status(HttpStatus.CREATED).body(vehiculeService.ajouterVehicule(ve));
    }

    @PutMapping("/{id}")
    public ResponseEntity<vehicule> modifierVehicule(@PathVariable long id, @RequestBody vehicule ve) {
        vehicule existing = vehiculeService.recupererVehiculeByid(id);
        if (existing == null) return ResponseEntity.notFound().build();
        existing.setImmatriculation(ve.getImmatriculation());
        existing.setMarque(ve.getMarque());
        existing.setModele(ve.getModele());
        existing.setCategorie(ve.getCategorie());
        existing.setTarifJournalier(ve.getTarifJournalier());
        existing.setStatut(ve.getStatut());
        if (ve.getAgence() != null) existing.setAgence(ve.getAgence());
        if (ve.getEquipements() != null && !ve.getEquipements().isEmpty())
            existing.setEquipements(ve.getEquipements());
        return ResponseEntity.ok(vehiculeService.ajouterVehicule(existing));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerVehicule(@PathVariable long id) {
        if (vehiculeService.recupererVehiculeByid(id) == null) return ResponseEntity.notFound().build();
        vehiculeService.supprimerVehicule(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<vehicule>> recupererVehicules() {
        return ResponseEntity.ok(vehiculeService.recupererVehicules());
    }

    @GetMapping("/set")
    public ResponseEntity<Set<vehicule>> findVehicules() {
        return ResponseEntity.ok(vehiculeService.findVehicules());
    }

    @GetMapping("/{id}")
    public ResponseEntity<vehicule> recupererVehiculeByid(@PathVariable long id) {
        vehicule ve = vehiculeService.recupererVehiculeByid(id);
        return ve == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(ve);
    }
    @PutMapping("/{idVehicule}/affecter/{idAgence}")
    public ResponseEntity<vehicule> affecterVehicule(@PathVariable Long idVehicule, @PathVariable Long idAgence) {
        return ResponseEntity.ok(vehiculeService.affecterVehicule(idVehicule, idAgence));
    }

    @PutMapping("/{idVehicule}/equipements/{idEquipement}/affecter")
    public ResponseEntity<vehicule> affecterEquipement(@PathVariable Long idVehicule, @PathVariable Long idEquipement) {
        return ResponseEntity.ok(vehiculeService.affecterEquipement(idVehicule, idEquipement));
    }

    @PutMapping("/{idVehicule}/equipements/{idEquipement}/desaffecter")
    public ResponseEntity<vehicule> desaffecterEquipement(@PathVariable Long idVehicule, @PathVariable Long idEquipement) {
        return ResponseEntity.ok(vehiculeService.desaffecterEquipement(idVehicule, idEquipement));
    }
}