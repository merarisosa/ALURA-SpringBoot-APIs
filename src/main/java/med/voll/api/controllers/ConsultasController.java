package med.voll.api.controllers;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.dto.AgendarConsultaDTO;
import med.voll.api.dto.DetalleConsultaDTO;
import med.voll.api.services.ConsultasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping("/consultas")
public class ConsultasController {

    @Autowired
    ConsultasService consultasService;

    @PostMapping
    @Transactional
    public ResponseEntity agendarConsulta(@RequestBody @Valid AgendarConsultaDTO agendarConsultaDTO, UriComponentsBuilder uriComponentsBuilder){
        /*
        URI url = uriComponentsBuilder.path("consultas/{id}").buildAndExpand(agendarConsultaDTO.id()).toUri();
        return ResponseEntity.created(url).body(agendarConsultaDTO);
         */
        return ResponseEntity.ok(consultasService.agendarConsulta(agendarConsultaDTO));
    }
}
