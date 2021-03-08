package lk.cerberus.citizenlocation.service;

import lk.cerberus.citizenlocation.entity.Citizen;
import lk.cerberus.citizenlocation.repository.CitizenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CitizenService {

    @Autowired
    public CitizenRepository citizenRepository;

    //Todo: add a service to update only selected fields only in a record -> examine the JPA Connection controller

    public List<Citizen> getAllCitizen() {
        List<Citizen> citizens = new ArrayList<>();
        citizenRepository.findAll().forEach(citizens::add);
        return citizens;
    }

    public void addCitizen(Citizen citizen) {
        citizenRepository.save(citizen);
    }

    public Optional<Citizen> getCitizenByNIC(String nic) {
        return citizenRepository.findById(nic);
    }

    public void updateCitizen(String nic, Citizen citizen) {
        citizenRepository.save(citizen);
    }

    public void deleteCitizen(String nic) {
        citizenRepository.deleteById(nic);
    }

}
