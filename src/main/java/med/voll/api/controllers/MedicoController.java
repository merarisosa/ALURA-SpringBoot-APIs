package med.voll.api.controllers;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.dto.ActualizarMedicoDTO;
import med.voll.api.dto.EliminarMedicoDTO;
import med.voll.api.dto.MedicoDTO;
import med.voll.api.dto.MedicoInfoDTO;
import med.voll.api.services.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.URL;
import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    MedicoService medicoService;

    @PostMapping
    public ResponseEntity<MedicoDTO> registarMedicos(@RequestBody  @Valid MedicoDTO medico, UriComponentsBuilder uriComponentsBuilder) {
        medicoService.registarMedicos(medico);

        URI url = uriComponentsBuilder.path("/medicos/{id}").buildAndExpand(medico.id()).toUri();
        return ResponseEntity.created(url).body(medico);
    }

    @GetMapping("/{id}")
    public ResponseEntity retornarMedico(@PathVariable @Valid Long id){
        var medico = medicoService.retornarMedico(id);
        return ResponseEntity.ok(medico);
    }

    @GetMapping
    public List<MedicoDTO> obtenerListadoMedicos(){
        return medicoService.obtenerListadoMedicos();
    }

    @GetMapping("/informacion")
    public List<MedicoInfoDTO> obtenerMedicoInfoBasica(){
        return medicoService.obtenerMedicoInfoBasica();
    }

    @GetMapping("/paginationData")
    public Page<MedicoInfoDTO> obtenerMedicoInfoPaginada(Pageable paginacion){
        return medicoService.obtenerMedicoInfoPaginada(paginacion);
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarMedico(@RequestBody @Valid ActualizarMedicoDTO actualizarMedicoDTO){
         medicoService.actualizarMedico(actualizarMedicoDTO);
         return ResponseEntity.ok(actualizarMedicoDTO);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarMedico(@PathVariable @Valid  Long id){
        medicoService.eliminarMedico(id);
        return ResponseEntity.noContent().build();
    }
}
