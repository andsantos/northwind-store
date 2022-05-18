package br.com.andsantos.northwind.catalogo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.andsantos.northwind.catalogo.dto.ProdutoDTO;
import br.com.andsantos.northwind.catalogo.service.ProdutoService;
import br.com.andsantos.northwind.util.Pagina;
import br.com.andsantos.northwind.util.PaginationUtil;

@RestController
@RequestMapping("/api")
public class ProdutoController {
    private final Logger log = LoggerFactory.getLogger(ProdutoController.class);

    private ProdutoService service;

    public ProdutoController(ProdutoService produtoService) {
        this.service = produtoService;
    }

    @GetMapping("/produtos")
    public ResponseEntity<Pagina<ProdutoDTO>> listar(Pageable pageable,
            @RequestParam(required = false) String nome) {
        log.debug("Recuperando todos os produtos");
        Page<ProdutoDTO> page = service.listar(nome, pageable);
        return ResponseEntity.ok().body(PaginationUtil.paginar(page));
    }

    @GetMapping("/produtos/{id}")
    public ResponseEntity<ProdutoDTO> obter(@PathVariable Long id) {
        log.debug("Recuperando o produto com id {}", id);
        ProdutoDTO dto = service.obter(id);
        return ResponseEntity.ok().body(dto);
    }
}
