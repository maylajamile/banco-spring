package br.com.banco.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.banco.modelo.Conta;

@Repository
public interface RepositorioConta extends JpaRepository<Conta, Long>{
		
}
