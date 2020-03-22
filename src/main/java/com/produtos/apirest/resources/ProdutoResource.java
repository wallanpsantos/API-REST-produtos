package com.produtos.apirest.resources;

import com.produtos.apirest.model.Produto;
import com.produtos.apirest.repository.ProdutoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Produtos")
@CrossOrigin(origins="*") // Libera todos os dominios para acessar a API ou especifico @CrossOrigin(origins="https://dominio")
public class ProdutoResource {

	@Autowired
	ProdutoRepository produtoRepository;

	@GetMapping("/produtos")
	@ApiOperation(value="Retorna uma lista de Produtos")
	public List<Produto> listaProdutos() {
		return produtoRepository.findAll();
	}

	@GetMapping("/produtos/{id}")
	@ApiOperation(value="Retorna um único produto pelo ID")
	public Produto produtoUnico(@PathVariable(value = "id") long id) {
		return produtoRepository.findById(id);
	}

	@PostMapping("/produto")
	@ApiOperation(value="Adiciona um novo produto")
	public Produto salvaProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}

	@DeleteMapping("/produto")
	@ApiOperation(value="Deleta um produto pelo ID")
	public void deleteProduto(@RequestBody Produto produto) {
		produtoRepository.delete(produto);
	}

	@PutMapping("/produto")
	@ApiOperation(value="Atualiza um produto")
	public Produto atualizarProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
}