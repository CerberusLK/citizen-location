package lk.cerberus.citizenlocation.repository;

import lk.cerberus.citizenlocation.entity.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitizenRepository extends JpaRepository<Citizen, String> {
}
