package com.prosutos.apirest.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prosutos.apirest.models.Produto;
import com.prosutos.apirest.repository.ProdutoRepository;



@RestController
@RequestMapping(value="/api")
public class ProdutoResource {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@GetMapping("/produtos")
	public List<Produto> listarProdutos(){
		return produtoRepository.findAll();
	}
	
	@GetMapping("/produto/{id}")
	public Produto buscarProduto(@PathVariable(value="id") Long id){
		Optional<Produto> optionalProduto = produtoRepository.findById(id);
		if(optionalProduto.isPresent()) {
			return optionalProduto.get();			
		}	
		
		return null;
	}
	
	@PostMapping("/produto")
	public Produto salvar(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
	
}
