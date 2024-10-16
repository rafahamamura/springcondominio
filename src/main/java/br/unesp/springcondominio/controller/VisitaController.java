package br.unesp.springcondominio.controller;

import br.unesp.springcondominio.entity.Visita;
import br.unesp.springcondominio.service.VisitaService;
import lombok.RequiredArgsConstructor; // Importa a anotação Lombok
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
  * 
 * @author rahon
 */
@RestController
@RequestMapping("/visitas/v1")
@RequiredArgsConstructor 
public class VisitaController {

    private final VisitaService visitaService; // Usando final para injeção de dependência

    @GetMapping
    public List<Visita> listarVisitas() {
        return visitaService.listarVisitas();
    }

    @PostMapping
    public Visita salvarVisita(@RequestBody Visita visita) {
        return visitaService.salvarVisita(visita);
    }

    @DeleteMapping("/{id}")
    public void deletarVisita(@PathVariable long id) {
        visitaService.deletarVisita(id);
    }
}
