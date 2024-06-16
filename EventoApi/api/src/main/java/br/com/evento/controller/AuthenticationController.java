package br.com.evento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.evento.model.AuthenticationDTO;
import br.com.evento.model.LoginResponseDTO;
import br.com.evento.model.RegisterDTO;
import br.com.evento.model.Usuario;
import br.com.evento.repository.UsuarioRepository;
import br.com.evento.security.TokenService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        try{
            var auth = this.authenticationManager.authenticate(usernamePassword);
            var token = tokenService.generatedToken((Usuario)auth.getPrincipal());

            return ResponseEntity.ok(new LoginResponseDTO(token));
        }catch(Exception ex){
            System.out.println("Erro:   ");
            System.out.println(ex);
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data){
        if (this.usuarioRepository.findByLogin(data.login()) != null)
            return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        System.out.println(data.login());
        System.out.println(encryptedPassword);
        System.out.println(data.role());

        Usuario newUser = new Usuario(data.login(), encryptedPassword, data.role());

        this.usuarioRepository.save(newUser);

        return ResponseEntity.ok().build();
    }
}
