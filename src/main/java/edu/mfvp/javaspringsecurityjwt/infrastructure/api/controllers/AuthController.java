package edu.mfvp.javaspringsecurityjwt.infrastructure.api.controllers;

import edu.mfvp.javaspringsecurityjwt.application.usecases.user.CreateUserUseCase;
import edu.mfvp.javaspringsecurityjwt.infrastructure.api.dtos.request.UserRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final CreateUserUseCase createUserUseCase;

    public AuthController(CreateUserUseCase createUserUseCase) {
        this.createUserUseCase = createUserUseCase;
    }

    @PostMapping("/signup")
    public ResponseEntity<Void> signUp(@RequestBody UserRequest request, UriComponentsBuilder uriComponentsBuilder) {
        createUserUseCase.execute(request.toUser());
        return ResponseEntity.ok().build();
    }
}
