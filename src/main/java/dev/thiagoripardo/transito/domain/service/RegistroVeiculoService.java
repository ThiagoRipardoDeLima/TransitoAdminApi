package dev.thiagoripardo.transito.domain.service;

import dev.thiagoripardo.transito.domain.exception.NegocioException;
import dev.thiagoripardo.transito.domain.model.Proprietario;
import dev.thiagoripardo.transito.domain.model.StatusVeiculo;
import dev.thiagoripardo.transito.domain.model.Veiculo;
import dev.thiagoripardo.transito.domain.repository.ProprietarioRepository;
import dev.thiagoripardo.transito.domain.repository.VeiculoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@AllArgsConstructor
@Service
public class RegistroVeiculoService {

    private final VeiculoRepository rep;
    private final RegistroProprietarioService regProp;

    public Veiculo buscar(Long id){
        return rep.findById(id)
                .orElseThrow(() -> new NegocioException("Veiculo não encontrado"));
    }

    @Transactional
    public Veiculo cadastrar(Veiculo veiculo){

        if(veiculo.getId() != null){
            throw new NegocioException("Veiculo a ser cadastrado não deve ter um codigo");
        }

        boolean placaEmUso = rep.findByPlaca(veiculo.getPlaca())
                        .filter(p -> !p.equals(veiculo))
                        .isPresent();

        if(placaEmUso){
            throw new NegocioException("Já existe um veiculo cadastrado com esta placa");
        }

        Proprietario proprietario = regProp.buscar(veiculo.getProprietario().getId());

        veiculo.setProprietario(proprietario);
        veiculo.setStatus(StatusVeiculo.REGULAR);
        veiculo.setDataCadastro(OffsetDateTime.now());

        return rep.save(veiculo);
    }
}
