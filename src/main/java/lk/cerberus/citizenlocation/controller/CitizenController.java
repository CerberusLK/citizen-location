package lk.cerberus.citizenlocation.controller;

import lk.cerberus.citizenlocation.entity.Citizen;
import lk.cerberus.citizenlocation.repository.CitizenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/citizens")
public class CitizenController {

    @Autowired
    private CitizenRepository citizenRepository;

    @GetMapping
    public List<Citizen> getAllCitizens() {
        return this.citizenRepository.findAll();
    }

    @PostMapping
    public Citizen createCitizen(@RequestBody Citizen citizen){
        return this.citizenRepository.save(citizen);
    }



}
