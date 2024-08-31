package dev.thiagoripardo.transito.domain.service;

import dev.thiagoripardo.transito.domain.exception.NegocioException;
import dev.thiagoripardo.transito.domain.model.Proprietario;
import dev.thiagoripardo.transito.domain.model.Veiculo;
import dev.thiagoripardo.transito.domain.repository.ProprietarioRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RegistroProprietarioService {

    private final ProprietarioRepository r;

    public Proprietario buscar(Long proprietarioId){
        return r.findById(proprietarioId)
                .orElseThrow(()->new NegocioException("Proprietário não encontrado"));
    }

    @Transactional
    public Proprietario salvar(Proprietario proprietario){
        boolean emailEmUso = r.findByEmail(proprietario.getEmail())
                .filter(p -> !p.equals(proprietario))
                .isPresent();

        if(emailEmUso){
            throw new NegocioException("Email já cadastrado");
        }

        return r.save(proprietario);
    }

    @Transactional
    public void excluir(Long id){
        r.deleteById(id);
    }
}
