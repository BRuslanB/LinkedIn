package alabs.team.linkedin.repository;

import alabs.team.linkedin.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface RoleRepository extends JpaRepository<Role, Long> {
    List<Role> findAllByOrderByIdAsc();

    Role findByRole(String role_user);
}