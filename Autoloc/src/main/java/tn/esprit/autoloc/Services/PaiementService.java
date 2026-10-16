package tn.esprit.autoloc.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.Entities.paiement;
import tn.esprit.autoloc.Repositories.paiementRepo;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class PaiementService implements IPaiementService {
    private final paiementRepo paiementRepo;

    @Override
    public paiement ajouterPaiement(paiement pa) { return paiementRepo.save(pa); }
    @Override
    public void supprimerPaiement(long idPaiement) { paiementRepo.deleteById(idPaiement); }
    @Override
    public List<paiement> recupererPaiements() { return paiementRepo.findAll(); }
    @Override
    public Set<paiement> findPaiements() { return new HashSet<>(paiementRepo.findAll()); }
    @Override
    public paiement recupererPaiementByid(long idPaiement) { return paiementRepo.findById(idPaiement).orElse(null); }
}