package tn.esprit.autoloc.RestController;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.Entities.employe;
import tn.esprit.autoloc.Services.IEmployeService;
import java.util.List;
import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/api/employes")
public class EmployeController {
    private final IEmployeService employeService;

    @PostMapping("/addemp")
    public ResponseEntity<employe> ajouterEmploye(@RequestBody employe em) {
        return ResponseEntity.status(HttpStatus.CREATED).body(employeService.ajouterEmploye(em));
    }

    @PutMapping("/modifemp/{id}")
    public ResponseEntity<employe> modifierEmploye(@PathVariable long id, @RequestBody employe em) {
        if (employeService.recupererEmployeByid(id) == null) return ResponseEntity.notFound().build();
        em.setIdEmploye(id);
        return ResponseEntity.ok(employeService.ajouterEmploye(em));
    }

    @DeleteMapping("/deleteemp/{id}")
    public ResponseEntity<Void> supprimerEmploye(@PathVariable long id) {
        if (employeService.recupererEmployeByid(id) == null) return ResponseEntity.notFound().build();
        employeService.supprimerEmploye(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getallemp")
    public ResponseEntity<List<employe>> recupererEmployes() {
        return ResponseEntity.ok(employeService.recupererEmployes());
    }

    @GetMapping("/set")
    public ResponseEntity<Set<employe>> findEmployes() {
        return ResponseEntity.ok(employeService.findEmployes());
    }

    @GetMapping("/getemp/{id}")
    public ResponseEntity<employe> recupererEmployeByid(@PathVariable long id) {
        employe em = employeService.recupererEmployeByid(id);
        return em == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(em);
    }
    @PutMapping("/{idEmploye}/desaffecter")
    public ResponseEntity<employe> desaffecterEmploye(@PathVariable Long idEmploye) {
        return ResponseEntity.ok(employeService.desaffecterEmploye(idEmploye));
    }

    @PutMapping("/{idEmploye}/affecter/{idAgence}")
    public ResponseEntity<employe> affecterEmploye(@PathVariable Long idEmploye, @PathVariable Long idAgence) {
        return ResponseEntity.ok(employeService.affecterEmploye(idEmploye, idAgence));
    }
}