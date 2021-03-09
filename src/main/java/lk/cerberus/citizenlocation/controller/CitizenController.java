package lk.cerberus.citizenlocation.controller;

import lk.cerberus.citizenlocation.entity.Citizen;
import lk.cerberus.citizenlocation.exception.ResourceNotFoundException;
import lk.cerberus.citizenlocation.repository.CitizenRepository;
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

    @Autowired
    private CitizenRepository citizenRepository;

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

    @RequestMapping(value = "/update/location/{nic}", method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void updateLocation(@PathVariable(value = "nic") String nic, @RequestBody Citizen citizen) {
        Citizen currentData = this.citizenRepository.findById(nic)
                .orElseThrow(() -> new ResourceNotFoundException("Selected citizen of " + nic + " Not found"));
        currentData.setLatitude(citizen.getLatitude());
        currentData.setLongitude(citizen.getLongitude());
        citizenRepository.save(currentData);
    }

    @RequestMapping(value = "/update/status/{nic}", method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void updateHealthStatus(@PathVariable(value = "nic") String nic, @RequestBody Citizen citizen) {
        Citizen currentData = this.citizenRepository.findById(nic)
                .orElseThrow(() -> new ResourceNotFoundException("Selected citizen of " + nic + " Not found"));
        currentData.setHealth_status(citizen.getHealth_status());
        citizenRepository.save(currentData);
    }
}
