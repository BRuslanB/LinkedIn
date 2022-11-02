package alabs.team.linkedin.repository;

import alabs.team.linkedin.model.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface SpecialityRepository extends JpaRepository<Speciality, Long> {
    List<Speciality> findAllByOrderByIdAsc();
}