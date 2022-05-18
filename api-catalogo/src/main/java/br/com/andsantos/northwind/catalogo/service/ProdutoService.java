package br.com.andsantos.northwind.catalogo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.andsantos.northwind.catalogo.dto.ProdutoDTO;

public interface ProdutoService {

    ProdutoDTO obter(Long id);

    Page<ProdutoDTO> listar(String nomeProduto, Pageable pageable);

}