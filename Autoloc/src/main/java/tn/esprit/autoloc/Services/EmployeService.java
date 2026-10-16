package tn.esprit.autoloc.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.Entities.employe;
import tn.esprit.autoloc.Repositories.employeRepo;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class EmployeService implements IEmployeService {
    private final employeRepo employeRepo;

    @Override
    public employe ajouterEmploye(employe em) { return employeRepo.save(em); }
    @Override
    public void supprimerEmploye(long idEmploye) { employeRepo.deleteById(idEmploye); }
    @Override
    public List<employe> recupererEmployes() { return employeRepo.findAll(); }
    @Override
    public Set<employe> findEmployes() { return new HashSet<>(employeRepo.findAll()); }
    @Override
    public employe recupererEmployeByid(long idEmploye) { return employeRepo.findById(idEmploye).orElse(null); }
}