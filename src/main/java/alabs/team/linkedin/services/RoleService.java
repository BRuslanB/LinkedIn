package alabs.team.linkedin.services;

import alabs.team.linkedin.model.Role;

import java.util.List;

public interface RoleService {
    Role getRole(Long id);
    List<Role> getAllRoles();
}