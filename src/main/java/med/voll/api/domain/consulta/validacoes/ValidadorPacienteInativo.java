package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.paciente.Paciente;
import med.voll.api.domain.paciente.PacienteRepository;
import med.voll.api.infra.exception.ValidacaoException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ValidadorPacienteInativo implements ValidadorAgendamentoConsultas{

    private final PacienteRepository pacienteRepository;

    public ValidadorPacienteInativo(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public void validar(DadosAgendamentoConsulta dados) {
        if (dados.idPaciente() == null) {
            return;
        }

        Optional<Paciente> pacienteOptional = pacienteRepository.findById(dados.idPaciente());
        if (pacienteOptional.isEmpty()) {
            throw new ValidacaoException("Paciente não encontrado");
        }

        Paciente paciente = pacienteOptional.get();
        if (!paciente.isAtivo()) {
            throw new ValidacaoException("Paciente inativo");
        }
    }
}
