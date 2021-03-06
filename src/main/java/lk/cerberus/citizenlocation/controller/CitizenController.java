package lk.cerberus.citizenlocation.controller;

import lk.cerberus.citizenlocation.entity.Citizen;
import lk.cerberus.citizenlocation.service.CitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/citizens")
public class CitizenController {

    @Autowired
    private CitizenService citizenService;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<Citizen> getAllCitizen() {
        return citizenService.getAllCitizen();
    }

    @GetMapping(path = "/{nic}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Optional<Citizen> getCitizenByNIC(@PathVariable(value = "nic") String nic) {
        return citizenService.getCitizenByNIC(nic);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void addCitizen(@RequestBody Citizen citizen) {
        citizenService.addCitizen(citizen);
    }


    @PutMapping(path = "/{nic}", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void updateCitizen(@PathVariable(value = "nic") String nic, @RequestBody Citizen citizen) {
        citizenService.updateCitizen(nic, citizen);
    }

    @DeleteMapping(path = "/{nic}")
    public void deleteCitizen(@PathVariable(value = "nic") String nic) {
        citizenService.deleteCitizen(nic);
    }
}
