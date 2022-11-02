package alabs.team.linkedin.repository;

import alabs.team.linkedin.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface CompanyRepository extends JpaRepository<Company, Long> {
    List<Company> findAllByOrderByIdAsc();
}