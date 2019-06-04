package com.prosutos.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prosutos.apirest.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>  {
	
	

}
