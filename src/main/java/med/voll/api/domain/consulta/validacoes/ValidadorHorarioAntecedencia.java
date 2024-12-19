package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.infra.exception.ValidacaoException;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component("validadorHorarioAntecedenciaAgendamento")
public class ValidadorHorarioAntecedencia implements ValidadorAgendamentoConsultas{

    public void validar (DadosAgendamentoConsulta dados) {
        var dataConsulta = dados.data();
        var agora = LocalDateTime.now();
        var diferencaEmMinutos = Duration.between(agora, dataConsulta).toMinutes();

        if (diferencaEmMinutos < 30) {
            throw new ValidacaoException("A consulta deve ser agendada com, no mínimo, 30 minutos de antecedência. Agradecemos pela compreensão.");
        }
    }
}
