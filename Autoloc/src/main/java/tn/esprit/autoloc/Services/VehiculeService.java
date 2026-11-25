package tn.esprit.autoloc.Services;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import tn.esprit.autoloc.Entities.agence;
import tn.esprit.autoloc.Entities.equipement;
import tn.esprit.autoloc.Entities.vehicule;
import tn.esprit.autoloc.Repositories.agenceRepo;
import tn.esprit.autoloc.Repositories.equipementRepo;
import tn.esprit.autoloc.Repositories.vehiculeRepo;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class VehiculeService implements IVehiculeService {
    private final vehiculeRepo vehiculeRepo;
    private final agenceRepo agenceRepo;
    private final equipementRepo equipementRepo;

    @Override
    public vehicule ajouterVehicule(vehicule ve) { return vehiculeRepo.save(ve); }
    @Override
    public void supprimerVehicule(long idVehicule) { vehiculeRepo.deleteById(idVehicule); }
    @Override
    public List<vehicule> recupererVehicules() { return vehiculeRepo.findAll(); }
    @Override
    public Set<vehicule> findVehicules() { return new HashSet<>(vehiculeRepo.findAll()); }
    @Override
    public vehicule recupererVehiculeByid(long idVehicule) { return vehiculeRepo.findById(idVehicule).orElse(null); }

    private vehicule getVehicule(Long idVehicule) {
        return vehiculeRepo.findById(idVehicule)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Vehicule introuvable : " + idVehicule));
    }

    // Scenario 2 : un vehicule neuf est rattache a une agence
    @Override
    @Transactional
    public vehicule affecterVehicule(Long idVehicule, Long idAgence) {
        vehicule ve = getVehicule(idVehicule);
        agence ag = agenceRepo.findById(idAgence)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Agence introuvable : " + idAgence));
        ve.setAgence(ag);
        return vehiculeRepo.save(ve);
    }

    // Scenario 3a : installer un equipement (siege bebe) sur le vehicule
    @Override
    @Transactional
    public vehicule affecterEquipement(Long idVehicule, Long idEquipement) {
        vehicule ve = getVehicule(idVehicule);
        equipement eq = equipementRepo.findById(idEquipement)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Equipement introuvable : " + idEquipement));
        boolean dejaInstalle = ve.getEquipements().stream()
                .anyMatch(e -> e.getIdEquipement().equals(idEquipement));
        if (dejaInstalle) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Equipement deja installe sur ce vehicule");
        }
        ve.getEquipements().add(eq);
        return vehiculeRepo.save(ve);
    }

    // Scenario 3b : retirer l'equipement au retour
    @Override
    @Transactional
    public vehicule desaffecterEquipement(Long idVehicule, Long idEquipement) {
        vehicule ve = getVehicule(idVehicule);
        boolean retire = ve.getEquipements().removeIf(e -> e.getIdEquipement().equals(idEquipement));
        if (!retire) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Cet equipement n'est pas installe sur ce vehicule");
        }
        return vehiculeRepo.save(ve);
    }
}