package tn.esprit.autoloc.Services;

import tn.esprit.autoloc.Entities.paiement;
import java.util.List;
import java.util.Set;

public interface IPaiementService {
    paiement ajouterPaiement(paiement pa);
    void supprimerPaiement(long idPaiement);
    List<paiement> recupererPaiements();
    Set<paiement> findPaiements();
    paiement recupererPaiementByid(long idPaiement);
}