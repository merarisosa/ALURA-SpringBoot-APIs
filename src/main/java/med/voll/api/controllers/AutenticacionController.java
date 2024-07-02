package med.voll.api.controllers;

import jakarta.validation.Valid;
import med.voll.api.dto.UsuarioDTO;
import med.voll.api.services.AutenticacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacionController {

    @Autowired
    AutenticacionService autenticacionService;

    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody @Valid UsuarioDTO usuarioDTO){
        return autenticacionService.autenticarUsuario(usuarioDTO);
    }
}
