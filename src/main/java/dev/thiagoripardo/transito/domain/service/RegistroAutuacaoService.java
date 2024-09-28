package dev.thiagoripardo.transito.domain.service;

import dev.thiagoripardo.transito.domain.model.Autuacao;
import dev.thiagoripardo.transito.domain.model.Veiculo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegistroAutuacaoService {

    private RegistroVeiculoService veiculoService;

    @Transactional
    public Autuacao registrar(Long veiculoId, Autuacao novaAutuacao){
        Veiculo veiculo = veiculoService.buscar(veiculoId);
        return veiculo.adicionarAutuacao(novaAutuacao);
    }
}
