package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.infra.exception.ValidacaoException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ValidadorMedicoInativo implements ValidadorAgendamentoConsultas{

    private final MedicoRepository repository;

    public ValidadorMedicoInativo(MedicoRepository medicoRepository) {
        this.repository = medicoRepository;
    }

    public void validar (DadosAgendamentoConsulta dados) {
        if (dados.idMedico() == null) {
            return;
        }

        Optional<Medico> medicoOptional = repository.findById(dados.idMedico());
        if (medicoOptional.isEmpty()) {
            throw new ValidacaoException("Médico não encontrado");
        }

        Medico medico = medicoOptional.get();
        if (!medico.isAtivo()) {
            throw new ValidacaoException("Médico está inativo");
        }
    }
}
