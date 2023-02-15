package ru.Migal.Spring.RESTControllers.service;


import ru.Migal.Spring.RESTControllers.model.Role;

import java.util.List;
import java.util.Set;

public interface RoleService {
    void addRole(Role role);

    void updateRole(Role role);

    void removeRoleById(Role role);

    Role getRoleByName(String role);

    List<Role> getAllRoles();

    Set<Role> checkRoles(String[] checkBoxRoles);
}