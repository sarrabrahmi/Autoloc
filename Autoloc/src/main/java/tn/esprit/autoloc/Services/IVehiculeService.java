package tn.esprit.autoloc.Services;

import tn.esprit.autoloc.Entities.vehicule;
import java.util.List;
import java.util.Set;

public interface IVehiculeService {
    vehicule ajouterVehicule(vehicule ve);
    void supprimerVehicule(long idVehicule);
    List<vehicule> recupererVehicules();
    Set<vehicule> findVehicules();
    vehicule recupererVehiculeByid(long idVehicule);

    vehicule affecterVehicule(Long idVehicule, Long idAgence);
    vehicule affecterEquipement(Long idVehicule, Long idEquipement);
    vehicule desaffecterEquipement(Long idVehicule, Long idEquipement);
}