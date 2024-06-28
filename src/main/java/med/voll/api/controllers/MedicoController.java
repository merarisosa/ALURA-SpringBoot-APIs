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
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    MedicoService medicoService;

    @PostMapping
    public void registarMedicos(@RequestBody  @Valid MedicoDTO medico) {
        medicoService.registarMedicos(medico);
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
    public void actualizarMedico(@RequestBody @Valid ActualizarMedicoDTO actualizarMedicoDTO){
         medicoService.actualizarMedico(actualizarMedicoDTO);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void eliminarMedico(@PathVariable @Valid  Long id){
        medicoService.eliminarMedico(id);
    }
}
