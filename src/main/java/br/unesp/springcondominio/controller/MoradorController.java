package br.unesp.springcondominio.controller;
import br.unesp.springcondominio.entity.Morador;
import br.unesp.springcondominio.service.MoradorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author rahon
 */
@RestController
@RequestMapping("/moradores/v1")
@RequiredArgsConstructor
public class MoradorController {

    private final MoradorService moradorService; // Usando final para injeção de dependência

    // 1. GET - Listar todos os moradores
    @GetMapping
    public ResponseEntity<List<Morador>> listarMoradores() {
        List<Morador> moradores = moradorService.listarMoradores();
        return new ResponseEntity<>(moradores, HttpStatus.OK);
    }

    // 2. GET - Buscar morador por ID
    @GetMapping("/{id}")
    public ResponseEntity<Morador> buscarPorId(@PathVariable Long id) {
        Optional<Morador> morador = moradorService.buscarPorId(id);
        return morador.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                      .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // 3. POST - Criar um novo morador
    @PostMapping
    public ResponseEntity<Morador> salvar(@RequestBody Morador morador) {
        Morador novoMorador = moradorService.salvar(morador);
        return new ResponseEntity<>(novoMorador, HttpStatus.CREATED);
    }

    // 4. PUT - Atualizar um morador existente
    @PutMapping("/{id}")
    public ResponseEntity<Morador> atualizar(@PathVariable Long id, @RequestBody Morador moradorAtualizado) {
        Optional<Morador> moradorExistente = moradorService.buscarPorId(id);
        if (moradorExistente.isPresent()) {
            Morador morador = moradorExistente.get();
            morador.setNome(moradorAtualizado.getNome()); // Exemplos de atualização de dados
            morador.setDataNascimento(moradorAtualizado.getDataNascimento());
            //morador.setMoradorTipo(moradorAtualizado.getMoradorTipo());
            morador.setTipoMorador(moradorAtualizado.getTipoMorador());
            Morador moradorAtual = moradorService.salvar(morador);
            return new ResponseEntity<>(moradorAtual, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // 5. DELETE - Deletar um morador por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        Optional<Morador> moradorExistente = moradorService.buscarPorId(id);
        if (moradorExistente.isPresent()) {
            moradorService.deletar(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
