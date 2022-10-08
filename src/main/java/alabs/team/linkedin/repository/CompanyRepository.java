package alabs.team.linkedin.repository;

import alabs.team.linkedin.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    List<Company> findAllByOrderByIdAsc();
}