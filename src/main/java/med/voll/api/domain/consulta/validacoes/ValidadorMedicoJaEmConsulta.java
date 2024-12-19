package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.infra.exception.ValidacaoException;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoJaEmConsulta implements ValidadorAgendamentoConsultas {

    private final MedicoRepository medicoRepository;

    public ValidadorMedicoJaEmConsulta(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    public void validar(DadosAgendamentoConsulta dados) {
        if (dados.idMedico() == null || dados.data() == null) {
            return;
        }

        boolean medicoJaEmConsulta = medicoRepository.existsByMedicoIdAndDataAndMotivoCancelamentoIsNull(dados.idMedico(), dados.data());
        if (medicoJaEmConsulta) {
            throw new ValidacaoException("O médico já possui outra consulta marcada nesse mesmo horário.");
        }
    }
}