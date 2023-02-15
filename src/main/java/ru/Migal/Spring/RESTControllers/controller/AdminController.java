package ru.Migal.Spring.RESTControllers.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/admin/page")
public class AdminController {

    @GetMapping
    public String getPage() {
        return "admin";
    }
}