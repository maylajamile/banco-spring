package br.com.banco.repositorio;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.banco.modelo.Transferencia;

@Repository
public interface RepositorioTransferencia extends JpaRepository<Transferencia, Long> {

	List<Transferencia> findAllByContaIdAndOperadorAndDataTransferenciaBetween(Long idConta, String operador,
			OffsetDateTime dataInicialOffset, OffsetDateTime dataFimOffset);

	List<Transferencia> findAllByContaIdAndDataTransferenciaBetween(Long idConta, OffsetDateTime dataInicialOffset,
			OffsetDateTime dataFimOffset);

	List<Transferencia> findAllByContaIdAndOperador(Long idConta, String operador);

	List<Transferencia> findAllByContaId(Long idConta);

}
