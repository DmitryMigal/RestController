package ru.Migal.Spring.RESTControllers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.Migal.Spring.RESTControllers.dao.RoleDao;
import ru.Migal.Spring.RESTControllers.model.Role;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class RoleServiceImpl implements RoleService {

    private final RoleDao roleDao;

    @Autowired
    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public void addRole(Role role) {
        roleDao.addRole(role);
    }

    @Override
    public void updateRole(Role role) {
        roleDao.updateRole(role);
    }

    @Override
    public void removeRoleById(Role role) {
        roleDao.removeRoleById(role);
    }

    @Override
    public Role getRoleByName(String role) {
        return roleDao.getRoleByName(role);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleDao.getAllRoles();
    }

    @Override
    public Set<Role> checkRoles(String[] checkBoxRoles) {
        if (checkBoxRoles == null) {
            checkBoxRoles = new String[]{"ROLE_USER"};
        }

        Set<Role> rolesSet = new HashSet<>();
        for (String roles : checkBoxRoles) {
            rolesSet.add(roleDao.getRoleByName(roles));
        }
        return rolesSet;
    }
}
