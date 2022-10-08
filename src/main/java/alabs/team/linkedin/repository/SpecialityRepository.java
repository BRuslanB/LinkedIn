package alabs.team.linkedin.repository;

import alabs.team.linkedin.model.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpecialityRepository extends JpaRepository<Speciality, Long> {
    List<Speciality> findAllByOrderByIdAsc();
}