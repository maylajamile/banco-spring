package br.com.banco.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.banco.modelo.Transferencia;

@Repository
public interface RepositorioTransferencia extends JpaRepository<Transferencia, Long>{

}
