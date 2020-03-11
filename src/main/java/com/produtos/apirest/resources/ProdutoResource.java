package com.produtos.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.produtos.apirest.repository.ProdutoRepository;
import com.produtos.apirest.model.Produto;

@RestController
@RequestMapping(value = "/api")
public class ProdutoResource {

	@Autowired
	ProdutoRepository produtoRepository;

	@GetMapping("/produtos")
	public List<Produto> listaProdutos() {
		return produtoRepository.findAll();
	}

	@GetMapping("/produtos/{id}")
	public Produto produtoUnico(@PathVariable(value = "id") long id) {
		return produtoRepository.findById(id);
	}

	@PostMapping("/produto")
	public Produto salvaProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}

	@DeleteMapping("/produto")
	public void deleteProduto(@RequestBody Produto produto) {
		produtoRepository.delete(produto);
	}

	@PutMapping("/produto")
	public Produto atualizarProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
}