package tn.esprit.autoloc.Services;

import tn.esprit.autoloc.Entities.equipement;
import java.util.List;
import java.util.Set;

public interface IEquipementService {
    equipement ajouterEquipement(equipement eq);
    void supprimerEquipement(long idEquipement);
    List<equipement> recupererEquipements();
    Set<equipement> findEquipements();
    equipement recupererEquipementByid(long idEquipement);
}