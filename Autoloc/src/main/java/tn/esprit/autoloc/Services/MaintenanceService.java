package tn.esprit.autoloc.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.Entities.maintenance;
import tn.esprit.autoloc.Repositories.maintenanceRepo;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class MaintenanceService implements IMaintenanceService {
    private final maintenanceRepo maintenanceRepo;

    @Override
    public maintenance ajouterMaintenance(maintenance mt) { return maintenanceRepo.save(mt); }
    @Override
    public void supprimerMaintenance(long idMaintenance) { maintenanceRepo.deleteById(idMaintenance); }
    @Override
    public List<maintenance> recupererMaintenances() { return maintenanceRepo.findAll(); }
    @Override
    public Set<maintenance> findMaintenances() { return new HashSet<>(maintenanceRepo.findAll()); }
    @Override
    public maintenance recupererMaintenanceByid(long idMaintenance) { return maintenanceRepo.findById(idMaintenance).orElse(null); }
}