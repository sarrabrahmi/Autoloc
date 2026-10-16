package tn.esprit.autoloc.Services;

import tn.esprit.autoloc.Entities.maintenance;
import java.util.List;
import java.util.Set;

public interface IMaintenanceService {
    maintenance ajouterMaintenance(maintenance mt);
    void supprimerMaintenance(long idMaintenance);
    List<maintenance> recupererMaintenances();
    Set<maintenance> findMaintenances();
    maintenance recupererMaintenanceByid(long idMaintenance);
}