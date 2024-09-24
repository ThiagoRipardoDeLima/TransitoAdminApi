package dev.thiagoripardo.transito.api.assembler;

import dev.thiagoripardo.transito.api.model.VeiculoModel;
import dev.thiagoripardo.transito.domain.model.Veiculo;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class VeiculoAssembler {

    private ModelMapper mapper;

    public VeiculoModel toModel(Veiculo veiculo){
        return mapper.map(veiculo, VeiculoModel.class);
    }

    public List<VeiculoModel> toCollectionModel(List<Veiculo> veiculos){
        return veiculos.stream()
                .map(this::toModel)
                .toList();
    }
}
