package tn.esprit.autoloc.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.Entities.agence;
import tn.esprit.autoloc.Services.IAgenceService;
import java.util.List;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnore;

@RestController
@Tag(name="gestion agnece")
@AllArgsConstructor
@RequestMapping("/api/agences")
public class AgenceController {
    private final IAgenceService agenceService;
@Operation(description = "ajouter une agence")
    @PostMapping("/addagence")
    public ResponseEntity<agence> ajouterAgence(@RequestBody agence ag) {
        return ResponseEntity.status(HttpStatus.CREATED).body(agenceService.ajouterAgence(ag));
    }

    @PutMapping("/modifagence/{id}")
    public ResponseEntity<agence> modifierAgence(@PathVariable long id, @RequestBody agence ag) {
        if (agenceService.recupererAgenceByid(id) == null) return ResponseEntity.notFound().build();
        ag.setIdAgence(id);
        return ResponseEntity.ok(agenceService.ajouterAgence(ag));
    }
@Operation(description = "supprimer une agence par id ")
    @DeleteMapping("/deleteagence/{id}")
    public ResponseEntity<Void> supprimerAgence(@PathVariable long id) {
        if (agenceService.recupererAgenceByid(id) == null) return ResponseEntity.notFound().build();
        agenceService.supprimerAgence(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/findallag")
    public ResponseEntity<List<agence>> recupererAgences() {
        return ResponseEntity.ok(agenceService.recupererAgences());
    }

    @GetMapping("/set")
    public ResponseEntity<Set<agence>> findAgences() {
        return ResponseEntity.ok(agenceService.findAgences());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<agence> recupererAgenceByid(@PathVariable long id) {
        agence ag = agenceService.recupererAgenceByid(id);
        return ag == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(ag);
    }
}