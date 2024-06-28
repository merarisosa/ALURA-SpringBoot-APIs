package med.voll.api.services;

import med.voll.api.dto.*;
import med.voll.api.models.Medico;
import med.voll.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicoService {

    @Autowired
    MedicoRepository medicoRepository;

    public void registarMedicos(MedicoDTO medico){
        medicoRepository.save(new Medico(medico));
    }

    public List<MedicoDTO> obtenerListadoMedicos(){
        List<Medico> medicos = medicoRepository.findAll();
        List<MedicoDTO> medicosDTO = medicos.stream()
                .map(medico -> {
                    DireccionDTO direccionDTO = new DireccionDTO(
                            medico.getDireccion().getCalle(),
                            medico.getDireccion().getNumero(),
                            medico.getDireccion().getComplemento(),
                            medico.getDireccion().getDistrito(),
                            medico.getDireccion().getCiudad()
                    );
                    return new MedicoDTO(
                            medico.getId(),
                            medico.getNombre(),
                            medico.getEmail(),
                            medico.getTelefono(),
                            medico.getDocumento(),
                            medico.getEspecialidad(),
                            direccionDTO
                    );
                })
                .collect(Collectors.toList());
        return medicosDTO;
    }

    public List<MedicoInfoDTO> obtenerMedicoInfoBasica(){
       return medicoRepository.findByIsActivoTrue().stream()
                .map(MedicoInfoDTO::new).toList();
    }

    public Page<MedicoInfoDTO> obtenerMedicoInfoPaginada(@PageableDefault(size = 5) Pageable paginacion) {
        return medicoRepository.findAll(paginacion).map(MedicoInfoDTO::new);
    }

    public void actualizarMedico(ActualizarMedicoDTO actualizarMedicoDTO){
        Medico medico = medicoRepository.getReferenceById(actualizarMedicoDTO.id());
        medico.actualizarDatos(actualizarMedicoDTO);
    }

    public void eliminarMedico(Long id){
        Medico medico = medicoRepository.getReferenceById(id);
        //medicoRepository.delete(medico);
        medico.desactivarMedico();
    }

    public MedicoDTO retornarMedico(Long id) {
        Medico medico = medicoRepository.getReferenceById(id);
        MedicoDTO medicoDTO = new MedicoDTO(
                medico.getId(),
                medico.getNombre(),
                medico.getEmail(),
                medico.getTelefono(),
                medico.getDocumento(),
                medico.getEspecialidad(),
                new DireccionDTO(medico.getDireccion().getCalle(),
                        medico.getDireccion().getDistrito(),
                        medico.getDireccion().getCiudad(),
                        medico.getDireccion().getNumero(),
                        medico.getDireccion().getComplemento()
                ));
        return medicoDTO;
    }
}

