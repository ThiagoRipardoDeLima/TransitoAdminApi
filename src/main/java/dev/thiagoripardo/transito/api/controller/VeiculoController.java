package dev.thiagoripardo.transito.api.controller;

import dev.thiagoripardo.transito.api.assembler.VeiculoAssembler;
import dev.thiagoripardo.transito.api.model.VeiculoModel;
import dev.thiagoripardo.transito.api.model.input.VeiculoInput;
import dev.thiagoripardo.transito.domain.exception.NegocioException;
import dev.thiagoripardo.transito.domain.model.Veiculo;
import dev.thiagoripardo.transito.domain.repository.VeiculoRepository;
import dev.thiagoripardo.transito.domain.service.RegistroVeiculoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    private final VeiculoRepository repository;
    private final RegistroVeiculoService service;
    private final VeiculoAssembler veiculoAssembler;

    @GetMapping
    public List<VeiculoModel> listar(){
        return veiculoAssembler.toCollectionModel(repository.findAll());
    }

    @GetMapping("/{veiculoId}")
    public ResponseEntity<VeiculoModel> buscar(@PathVariable Long veiculoId){
        return repository.findById(veiculoId)
                .map(veiculoAssembler::toModel)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VeiculoModel cadastrar(@Valid @RequestBody VeiculoInput veiculoInput){
        Veiculo veiculo = veiculoAssembler.toEntity(veiculoInput);
        Veiculo veiculoCadastrado = service.cadastrar(veiculo);

        return veiculoAssembler.toModel(veiculoCadastrado);
    }

}
