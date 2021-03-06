package lk.cerberus.citizenlocation.repository;

import lk.cerberus.citizenlocation.entity.Citizen;
import org.springframework.data.repository.CrudRepository;

public interface CitizenRepository extends CrudRepository<Citizen, String> {

//    Citizen findByNIC(String nic);
//
//    List<Citizen> findAll();
}
