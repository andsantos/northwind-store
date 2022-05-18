package br.com.andsantos.northwind.catalogo.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.andsantos.northwind.catalogo.dto.ProdutoDTO;
import br.com.andsantos.northwind.catalogo.repository.ProdutoRepository;
import br.com.andsantos.northwind.catalogo.service.ProdutoService;
import br.com.andsantos.northwind.catalogo.service.mapper.ProdutoMapper;
import br.com.andsantos.northwind.exception.NotFoundException;

@Service
@Transactional
public class ProdutoServiceImpl implements ProdutoService {
    private static final String PRODUTO_NOT_FOUND = "Produto não encontrado.";

    private final Logger log = LoggerFactory.getLogger(ProdutoServiceImpl.class);

    private final ProdutoRepository repository;

    private final ProdutoMapper mapper;

    public ProdutoServiceImpl(ProdutoRepository produtoRepository, ProdutoMapper produtoMapper) {
        this.repository = produtoRepository;
        this.mapper = produtoMapper;
    }

    @Override
    public ProdutoDTO obter(Long id) {
        log.debug("Recuperando a Produto com id {}", id);
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new NotFoundException(PRODUTO_NOT_FOUND));
    }

    @Override
    public Page<ProdutoDTO> listar(String nomeProduto, Pageable pageable) {
        log.debug("Recuperando todas as Produtos contendo {}", nomeProduto);
        return repository.findAllByNomeProdutoContaining(nomeProduto, pageable)
                .map(mapper::toDto);
    }
}
