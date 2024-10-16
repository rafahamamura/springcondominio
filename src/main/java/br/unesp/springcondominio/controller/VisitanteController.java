package br.unesp.springcondominio.controller;

import br.unesp.springcondominio.entity.Visitante;
import br.unesp.springcondominio.service.VisitanteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controlador REST para gerenciamento de visitantes
 * 
 * @author rahon
 */
@RestController
@RequestMapping("/visitantes")
@RequiredArgsConstructor 
public class VisitanteController {

    private final VisitanteService visitanteService;

    @GetMapping
    public ResponseEntity<List<Visitante>> listarVisitantes() {
        List<Visitante> visitantes = visitanteService.listarVisitantes();
        return new ResponseEntity<>(visitantes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Visitante> buscarPorId(@PathVariable Long id) {
        Optional<Visitante> visitante = visitanteService.buscarPorId(id);
        return visitante.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                        .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Visitante> salvar(@RequestBody Visitante visitante) {
        Visitante novoVisitante = visitanteService.salvar(visitante);
        return new ResponseEntity<>(novoVisitante, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Visitante> atualizar(@PathVariable Long id, @RequestBody Visitante visitanteAtualizado) {
        Optional<Visitante> visitanteExistente = visitanteService.buscarPorId(id);
        if (visitanteExistente.isPresent()) {
            Visitante visitante = visitanteExistente.get();
            visitante.setNome(visitanteAtualizado.getNome());
            visitante.setDataNascimento(visitanteAtualizado.getDataNascimento());
            visitante.setTipoVisitante(visitanteAtualizado.getTipoVisitante());
            Visitante visitanteAtual = visitanteService.salvar(visitante);
            return new ResponseEntity<>(visitanteAtual, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        Optional<Visitante> visitanteExistente = visitanteService.buscarPorId(id);
        if (visitanteExistente.isPresent()) {
            visitanteService.deletar(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
