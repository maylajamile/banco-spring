package br.com.banco.controlador;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.modelo.Transferencia;
import br.com.banco.repositorio.RepositorioTransferencia;

@RestController
@RequestMapping("/transferencias")
public class ControladorTransferencia {

	@Autowired
	private RepositorioTransferencia repositorioTransferencia;

	@GetMapping
	public List<Transferencia> listar(
			@RequestParam(value = "idConta", required = true) Long idConta,
			@RequestParam(value = "operador", required = false) String operador,
			@RequestParam(value = "dataInicio", required = false) String dataInicio,
			@RequestParam(value = "dataFinal", required = false) String dataFinal) {

		if (dataInicio != null && dataFinal != null && operador != null) {
			return buscarTransferencias(idConta, operador, dataInicio, dataFinal);
		} else if (dataInicio != null && dataFinal != null) {
			return buscarTransferencias(idConta, null, dataInicio, dataFinal);
		} else if (operador != null) {
			return repositorioTransferencia.findAllByContaIdAndOperador(idConta, operador);
		} else {
			return repositorioTransferencia.findAllByContaId(idConta);
		}
	}

	private List<Transferencia> buscarTransferencias(Long idConta, String operador, String dataInicio,
			String dataFinal) {
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
}
