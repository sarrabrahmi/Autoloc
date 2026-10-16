package tn.esprit.autoloc.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.Entities.equipement;
import tn.esprit.autoloc.Repositories.equipementRepo;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class EquipementService implements IEquipementService {
    private final equipementRepo equipementRepo;

    @Override
    public equipement ajouterEquipement(equipement eq) { return equipementRepo.save(eq); }
    @Override
    public void supprimerEquipement(long idEquipement) { equipementRepo.deleteById(idEquipement); }
    @Override
    public List<equipement> recupererEquipements() { return equipementRepo.findAll(); }
    @Override
    public Set<equipement> findEquipements() { return new HashSet<>(equipementRepo.findAll()); }
    @Override
    public equipement recupererEquipementByid(long idEquipement) { return equipementRepo.findById(idEquipement).orElse(null); }
}