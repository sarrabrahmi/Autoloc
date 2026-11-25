package tn.esprit.autoloc.RestController;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.Entities.maintenance;
import tn.esprit.autoloc.Services.IMaintenanceService;
import java.util.List;
import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/api/maintenances")
public class MaintenanceController {
    private final IMaintenanceService maintenanceService;

    @PostMapping
    public ResponseEntity<maintenance> ajouterMaintenance(@RequestBody maintenance mt) {
        return ResponseEntity.status(HttpStatus.CREATED).body(maintenanceService.ajouterMaintenance(mt));
    }

    @PutMapping("/{id}")
    public ResponseEntity<maintenance> modifierMaintenance(@PathVariable long id, @RequestBody maintenance mt) {
        if (maintenanceService.recupererMaintenanceByid(id) == null) return ResponseEntity.notFound().build();
        mt.setIdMaintenance(id);
        return ResponseEntity.ok(maintenanceService.ajouterMaintenance(mt));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerMaintenance(@PathVariable long id) {
        if (maintenanceService.recupererMaintenanceByid(id) == null) return ResponseEntity.notFound().build();
        maintenanceService.supprimerMaintenance(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<maintenance>> recupererMaintenances() {
        return ResponseEntity.ok(maintenanceService.recupererMaintenances());
    }

    @GetMapping("/set")
    public ResponseEntity<Set<maintenance>> findMaintenances() {
        return ResponseEntity.ok(maintenanceService.findMaintenances());
    }

    @GetMapping("/{id}")
    public ResponseEntity<maintenance> recupererMaintenanceByid(@PathVariable long id) {
        maintenance mt = maintenanceService.recupererMaintenanceByid(id);
        return mt == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(mt);
    }
}