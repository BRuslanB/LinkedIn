package alabs.team.linkedin.services.impl;

import alabs.team.linkedin.model.Role;
import alabs.team.linkedin.repository.RoleRepository;
import alabs.team.linkedin.services.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public Role getRole(Long id){
        return roleRepository.findById(id).orElse(null);
    }

    public List<Role> getAllRoles(){
        return roleRepository.findAllByOrderByIdAsc();
    }
}