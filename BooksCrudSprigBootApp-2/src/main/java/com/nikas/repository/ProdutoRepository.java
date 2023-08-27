package com.nikas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nikas.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
