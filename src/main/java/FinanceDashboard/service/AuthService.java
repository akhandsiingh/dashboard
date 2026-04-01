package FinanceDashboard.service;

import FinanceDashboard.auth.JwtUtil;
import FinanceDashboard.dto.AuthResponseDTO;
import FinanceDashboard.dto.LoginRequestDTO;
import FinanceDashboard.dto.UserRequestDTO;
import FinanceDashboard.model.Role;
import FinanceDashboard.model.Status;
import FinanceDashboard.model.User;
import FinanceDashboard.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    public String register(UserRequestDTO request) {

        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword()) // plain for now
                .role(Role.VIEWER)
                .status(Status.ACTIVE)
                .build();

        userRepository.save(user);

        return "User registered successfully";
    }

    public AuthResponseDTO login(LoginRequestDTO request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!user.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        String token = jwtUtil.generateToken(user.getEmail());

        return new AuthResponseDTO(token);
    }
}