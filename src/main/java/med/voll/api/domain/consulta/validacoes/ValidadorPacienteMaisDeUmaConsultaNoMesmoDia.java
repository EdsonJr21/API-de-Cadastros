package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.paciente.PacienteRepository;
import med.voll.api.infra.exception.ValidacaoException;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteMaisDeUmaConsultaNoMesmoDia implements ValidadorAgendamentoConsultas {

    private final PacienteRepository pacienteRepository;

    public ValidadorPacienteMaisDeUmaConsultaNoMesmoDia(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public void validar (DadosAgendamentoConsulta dados) {
        if (dados.idPaciente() == null || dados.data() == null) {
            return;
        }

        boolean pacienteJaEmConsulta = pacienteRepository.existsByIdPacienteIdAndData(dados.idPaciente(), dados.data());
        if (pacienteJaEmConsulta) {
            throw new ValidacaoException("O paciente já possui uma consulta agendada na data informada.");
        }

    }
}
