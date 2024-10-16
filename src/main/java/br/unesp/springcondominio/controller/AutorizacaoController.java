package br.unesp.springcondominio.controller;

import br.unesp.springcondominio.entity.Autorizacao;
import br.unesp.springcondominio.service.AutorizacaoService;
import lombok.RequiredArgsConstructor; // Importa a anotação Lombok
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 *
 * @author rahon
 */
@RestController
@RequestMapping("/autorizacoes/v1")
@RequiredArgsConstructor // Gera o construtor com os parâmetros necessários
public class AutorizacaoController {

    private final AutorizacaoService autorizacaoService; // Usando final para injeção de dependência

    @GetMapping
    public List<Autorizacao> listarAutorizacoes() {
        return autorizacaoService.listarAutorizacoes();
    }

    @PostMapping
    public Autorizacao salvarAutorizacao(@RequestBody Autorizacao autorizacao) {
        return autorizacaoService.salvarAutorizacao(autorizacao);
    }

    @DeleteMapping("/{id}")
    public void deletarAutorizacao(@PathVariable long id) {
        autorizacaoService.deletarAutorizacao(id);
    }
}
