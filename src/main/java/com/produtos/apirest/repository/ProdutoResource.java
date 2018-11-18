package com.produtos.apirest.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.model.Produto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value="API REST Produtos")
@CrossOrigin(origins="*")
public class ProdutoResource {

	@Autowired
	ProdutoRepository produtoRepository;

	@GetMapping("/produtos")
	@ApiOperation(value="Retorna uma lista de produtos")
	public List<Produto> listaProduto() {
		return produtoRepository.findAll();

	}

	@GetMapping("/produto/{id}")
	@ApiOperation(value="Retorna um produto unico")
	public Produto listaProdutoPorId(@PathVariable(value = "id") long id) {
		return produtoRepository.findById(id);

	}

	@PostMapping("/produto")
	@ApiOperation(value="Salva um produto novo")
	public Produto salvaProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);

	}
	@DeleteMapping("/produto")
	@ApiOperation(value="Remove um produto")
	public void deletaProduto(@RequestBody Produto produto) {
		 produtoRepository.delete(produto);
	}
	
	@PutMapping("/produto")
	@ApiOperation(value="Atualiza um produto")
	public Produto atualizaProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
	

}
