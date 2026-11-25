package tn.esprit.autoloc.RestController;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.Entities.equipement;
import tn.esprit.autoloc.Services.IEquipementService;
import java.util.List;
import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/api/equipements")
public class EquipementController {
    private final IEquipementService equipementService;

    @PostMapping
    public ResponseEntity<equipement> ajouterEquipement(@RequestBody equipement eq) {
        return ResponseEntity.status(HttpStatus.CREATED).body(equipementService.ajouterEquipement(eq));
    }

    @PutMapping("/{id}")
    public ResponseEntity<equipement> modifierEquipement(@PathVariable long id, @RequestBody equipement eq) {
        if (equipementService.recupererEquipementByid(id) == null) return ResponseEntity.notFound().build();
        eq.setIdEquipement(id);
        return ResponseEntity.ok(equipementService.ajouterEquipement(eq));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerEquipement(@PathVariable long id) {
        if (equipementService.recupererEquipementByid(id) == null) return ResponseEntity.notFound().build();
        equipementService.supprimerEquipement(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<equipement>> recupererEquipements() {
        return ResponseEntity.ok(equipementService.recupererEquipements());
    }

    @GetMapping("/set")
    public ResponseEntity<Set<equipement>> findEquipements() {
        return ResponseEntity.ok(equipementService.findEquipements());
    }

    @GetMapping("/{id}")
    public ResponseEntity<equipement> recupererEquipementByid(@PathVariable long id) {
        equipement eq = equipementService.recupererEquipementByid(id);
        return eq == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(eq);
    }
}