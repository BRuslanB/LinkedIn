package alabs.team.linkedin.repository;

import alabs.team.linkedin.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT c FROM User c JOIN c.roles b WHERE b.role LIKE '%ROLE_USER%'")
    List<User> findAllByOrderByIdAsc();

    User findAllByEmail(String username);

    @Query("SELECT c FROM User c WHERE c.company.id = :company_id")
    List<User> findByAllCompany(Long company_id);

    @Query("SELECT c FROM User c WHERE c.speciality.id = :speciality_id")
    List<User> findByAllSpeciality(Long speciality_id);

    @Query("SELECT c FROM User c JOIN c.roles b WHERE c.company.id = :company_id AND c.speciality.id = :speciality_id " +
            "AND b.role LIKE '%ROLE_USER%'")
    List<User> findByAllCompanyAndSpeciality(Long company_id, Long speciality_id);

    @Query("SELECT c FROM User c JOIN c.roles b WHERE (c.company.id = :company_id OR c.speciality.id = :speciality_id) " +
            "AND b.role LIKE '%ROLE_USER%'")
    List<User> findByAllCompanyORSpeciality(Long company_id, Long speciality_id);
}