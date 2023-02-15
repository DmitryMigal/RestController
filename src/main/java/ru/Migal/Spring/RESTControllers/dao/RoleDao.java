package ru.Migal.Spring.RESTControllers.dao;


import ru.Migal.Spring.RESTControllers.model.Role;

import java.util.List;

public interface RoleDao {
    void addRole(Role role);

    void updateRole(Role role);

    void removeRoleById(Role role);

    Role getRoleByName(String role);

    List<Role> getAllRoles();
}