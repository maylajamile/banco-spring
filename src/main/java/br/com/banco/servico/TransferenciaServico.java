package br.com.banco.servico;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.banco.modelo.Transferencia;
import br.com.banco.repositorio.RepositorioTransferencia;

@Service
public class TransferenciaServico {

	@Autowired
	private RepositorioTransferencia repositorioTransferencia;

	public List<Transferencia> buscarTransferencias(Long idConta, String operador, String dataInicio, String dataFinal) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate dataInicial = LocalDate.parse(dataInicio, formatter);
		LocalDate dataFim = LocalDate.parse(dataFinal, formatter);
		OffsetDateTime dataInicialOffset = dataInicial.atStartOfDay().atOffset(ZoneOffset.UTC);
		OffsetDateTime dataFimOffset = dataFim.atStartOfDay().atOffset(ZoneOffset.UTC);

		if (operador != null) {
			return repositorioTransferencia.findAllByContaIdAndOperadorAndDataTransferenciaBetween(idConta, operador,
					dataInicialOffset, dataFimOffset);
		} else {
			return repositorioTransferencia.findAllByContaIdAndDataTransferenciaBetween(idConta, dataInicialOffset,
					dataFimOffset);
		}
	}

	public List<Transferencia> buscarTransferenciasPorOperador(Long idConta, String operador) {
		return repositorioTransferencia.findAllByContaIdAndOperador(idConta, operador);
	}

	public List<Transferencia> buscarTransferenciasPorContaId(Long idConta) {
		return repositorioTransferencia.findAllByContaId(idConta);
	}

}
