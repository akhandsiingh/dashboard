package FinanceDashboard.controller;

import FinanceDashboard.dto.AuthResponseDTO;
import FinanceDashboard.dto.LoginRequestDTO;
import FinanceDashboard.dto.UserRequestDTO;
import FinanceDashboard.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public String register(@RequestBody UserRequestDTO request) {
        return authService.register(request);
    }

    @PostMapping("/login")
    public AuthResponseDTO login(@RequestBody LoginRequestDTO request) {
        return authService.login(request);
    }
}