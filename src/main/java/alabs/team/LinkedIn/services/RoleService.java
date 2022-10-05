package alabs.team.LinkedIn.services;

import alabs.team.LinkedIn.model.Role;

import java.util.List;

public interface RoleService {
    Role getRole(Long id);
    List<Role> getAllRoles();
}