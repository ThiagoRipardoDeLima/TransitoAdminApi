package dev.thiagoripardo.transito.api.assembler;

import dev.thiagoripardo.transito.api.model.AutuacaoModel;
import dev.thiagoripardo.transito.api.model.input.AutuacaoInput;
import dev.thiagoripardo.transito.domain.model.Autuacao;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class AutuacaoAssembler {

    private final ModelMapper mapper;

    public Autuacao toEntity(AutuacaoInput autuacaoInput){
        return mapper.map(autuacaoInput, Autuacao.class);
    }

    public AutuacaoModel toModel(Autuacao autuacao){
        return mapper.map(autuacao, AutuacaoModel.class);
    }

    public List<AutuacaoModel> toCollectionModel(List<Autuacao> autuacoes){
        return autuacoes.stream()
                .map(this::toModel)
                .toList();
    }
}
