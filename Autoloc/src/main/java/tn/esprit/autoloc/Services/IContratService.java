package tn.esprit.autoloc.Services;

import tn.esprit.autoloc.Entities.contrat;
import java.util.List;
import java.util.Set;

public interface IContratService {
    contrat ajouterContrat(contrat ct);
    void supprimerContrat(long idContrat);
    List<contrat> recupererContrats();
    Set<contrat> findContrats();
    contrat recupererContratByid(long idContrat);
}