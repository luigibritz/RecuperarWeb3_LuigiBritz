package com.qi.livraria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.qi.livraria.model.Livro;;

public interface LivroRepository extends JpaRepository<Livro, Long>{

}
