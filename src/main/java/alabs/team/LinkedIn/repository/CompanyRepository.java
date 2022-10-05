package alabs.team.LinkedIn.repository;

import alabs.team.LinkedIn.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    List<Company> findAllByOrderByIdAsc();
}
