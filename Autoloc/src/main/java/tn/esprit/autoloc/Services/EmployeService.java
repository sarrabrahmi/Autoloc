package tn.esprit.autoloc.Services;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import tn.esprit.autoloc.Entities.agence;
import tn.esprit.autoloc.Entities.employe;
import tn.esprit.autoloc.Repositories.agenceRepo;
import tn.esprit.autoloc.Repositories.employeRepo;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class EmployeService implements IEmployeService {
    private final employeRepo employeRepo;
    private final agenceRepo agenceRepo;

    @Override
    public employe ajouterEmploye(employe em) { return employeRepo.save(em); }
    @Override
    public void supprimerEmploye(long idEmploye) { employeRepo.deleteById(idEmploye); }
    @Override
    public List<employe> recupererEmployes() { return employeRepo.findAll(); }
    @Override
    public Set<employe> findEmployes() { return new HashSet<>(employeRepo.findAll()); }
    @Override
    public employe recupererEmployeByid(long idEmploye) { return employeRepo.findById(idEmploye).orElse(null); }

    // Scenario 1a : l'employe quitte son agence
    @Override
    @Transactional
    public employe desaffecterEmploye(Long idEmploye) {
        employe em = employeRepo.findById(idEmploye)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employe introuvable : " + idEmploye));
        if (em.getAgence() == null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Cet employe n'est affecte a aucune agence");
        }
        em.setAgence(null);
        return employeRepo.save(em);
    }

    // Scenario 1b : l'employe rejoint une agence (seulement s'il n'en a pas deja une)
    @Override
    @Transactional
    public employe affecterEmploye(Long idEmploye, Long idAgence) {
        employe em = employeRepo.findById(idEmploye)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employe introuvable : " + idEmploye));
        agence ag = agenceRepo.findById(idAgence)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Agence introuvable : " + idAgence));
        if (em.getAgence() != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "Employe deja affecte a l'agence " + em.getAgence().getIdAgence() + " : desaffecter d'abord");
        }
        em.setAgence(ag);
        return employeRepo.save(em);
    }
}