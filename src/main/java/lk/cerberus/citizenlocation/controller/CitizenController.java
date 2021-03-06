package lk.cerberus.citizenlocation.controller;

import lk.cerberus.citizenlocation.entity.Citizen;
import lk.cerberus.citizenlocation.service.CitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/citizens")
public class CitizenController {

    @Autowired
    private CitizenService citizenService;

    @GetMapping
    public List<Citizen> getAllCitizen() {
        return citizenService.getAllCitizen();
    }

    @GetMapping("/{nic}")
    public Optional<Citizen> getCitizenByNIC(@PathVariable(value = "nic") String nic) {
        return citizenService.getCitizenByNIC(nic);
    }

    @PostMapping
    public void addCitizen(@RequestBody Citizen citizen) {
        citizenService.addCitizen(citizen);
    }


    @PutMapping("/{nic}")
    public void updateCitizen(@PathVariable(value = "nic") String nic, @RequestBody Citizen citizen) {
        citizenService.updateCitizen(nic, citizen);
    }

    @DeleteMapping("/{nic}")
    public void deleteCitizen(@PathVariable(value = "nic") String nic) {
        citizenService.deleteCitizen(nic);
    }
}
