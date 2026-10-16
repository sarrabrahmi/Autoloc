package tn.esprit.autoloc.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.Entities.vehicule;
import tn.esprit.autoloc.Repositories.vehiculeRepo;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class VehiculeService implements IVehiculeService {
    private final vehiculeRepo vehiculeRepo;

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
}