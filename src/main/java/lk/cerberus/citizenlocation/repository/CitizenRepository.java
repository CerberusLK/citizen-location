package lk.cerberus.citizenlocation.repository;

import lk.cerberus.citizenlocation.entity.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CitizenRepository extends CrudRepository<Citizen, String>, JpaRepository<Citizen, String> {

}
