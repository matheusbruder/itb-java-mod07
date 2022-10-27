package com.example.demo.repository;

import com.example.demo.model.Funcionario;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends ElasticsearchRepository<Funcionario, String> {


}


