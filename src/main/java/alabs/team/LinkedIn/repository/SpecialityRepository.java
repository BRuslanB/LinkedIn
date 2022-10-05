package alabs.team.LinkedIn.repository;

import alabs.team.LinkedIn.model.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpecialityRepository extends JpaRepository<Speciality, Long> {
    List<Speciality> findAllByOrderByIdAsc();
}
