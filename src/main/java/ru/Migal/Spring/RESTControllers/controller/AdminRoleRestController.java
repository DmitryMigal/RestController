package ru.Migal.Spring.RESTControllers.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.Migal.Spring.RESTControllers.model.Role;
import ru.Migal.Spring.RESTControllers.service.RoleService;

import java.util.List;

@RestController
@RequestMapping("/admin/role")
public class AdminRoleRestController {
    private final RoleService roleService;

    public AdminRoleRestController(RoleService roleService) {

        this.roleService = roleService;
    }

    @GetMapping
    public ResponseEntity<List<Role>> getAllRoles() {
        return new ResponseEntity<>(roleService.getAllRoles(), HttpStatus.OK);
    }

}
