package med.voll.api.services;

import med.voll.api.dto.AgendarConsultaDTO;
import med.voll.api.dto.DetalleConsultaDTO;
import med.voll.api.models.Consulta;
import med.voll.api.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ConsultasService {
    @Autowired
    ConsultaRepository consultaRepository;

    public ResponseEntity agendarConsulta(AgendarConsultaDTO agendarConsultaDTO) {
        DetalleConsultaDTO detalleConsultaDTO = new DetalleConsultaDTO(
                agendarConsultaDTO.id(),
                agendarConsultaDTO.idPaciente(),
                agendarConsultaDTO.idMedico(),
                agendarConsultaDTO.fecha()
        );
        return ResponseEntity.ok(detalleConsultaDTO);
    }
}
