package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.infra.exception.ValidacaoException;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class ValidadorHorarioFuncionamentoDaClinica implements ValidadorAgendamentoConsultas{

    public void validar (DadosAgendamentoConsulta dados) {
        var dadoContulta = dados.data();

        var domingo = dadoContulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesDaAbertura = dadoContulta.getHour() < 7;
        var depoisDaAbertura = dadoContulta.getHour() > 18;
        if (domingo || antesDaAbertura || depoisDaAbertura) {
            throw new ValidacaoException("Informamos que esta solicitação foi recebida fora do horário de funcionamento da clínica.");
        }
    }
}
