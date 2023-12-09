package com.noxtec.noxtec.repository;

import java.util.List;

//import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.noxtec.noxtec.model.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Integer> {

    List<Contato> findByContatoNomeContaining(String contatoNome);

    List<Contato> findByContatoTelefoneContaining(String contatoTelefoneContaining);

    List<Contato> findByContatoEmailContaining(String contatoEmailContaining);

    List<Contato> findByContatoCelularContaining(String contatoCelular);

}
