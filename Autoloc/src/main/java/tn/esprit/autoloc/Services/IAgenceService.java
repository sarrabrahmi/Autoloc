package tn.esprit.autoloc.Services;

import tn.esprit.autoloc.Entities.agence;
import java.util.List;
import java.util.Set;

public interface IAgenceService {
    agence ajouterAgence(agence ag);
    void supprimerAgence(long idAgence);
    List<agence> recupererAgences();
    Set<agence> findAgences();
    agence recupererAgenceByid(long idAgence);
}