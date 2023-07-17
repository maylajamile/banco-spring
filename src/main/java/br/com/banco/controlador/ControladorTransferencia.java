package br.com.banco.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.modelo.Transferencia;
import br.com.banco.servico.TransferenciaServico;

@RestController
@RequestMapping("/transferencias/{idConta}")
public class ControladorTransferencia {

	@Autowired
	private TransferenciaServico servico;
	
	@GetMapping
	public List<Transferencia> listar(
			@PathVariable("idConta") Long idConta,
			@RequestParam(value = "operador", required = false) String operador,
			@RequestParam(value = "dataInicio", required = false) String dataInicio,
			@RequestParam(value = "dataFinal", required = false) String dataFinal) {

		if (dataInicio != null && dataFinal != null && operador != null) {
			return servico.buscarTransferencias(idConta, operador, dataInicio, dataFinal);
		} else if (dataInicio != null && dataFinal != null) {
			return servico.buscarTransferencias(idConta, operador, dataInicio, dataFinal);
		} else if (operador != null) {
			return servico.buscarTransferenciasPorOperador(idConta, operador);
		} else {
			return servico.buscarTransferenciasPorContaId(idConta);
		}
	}

}
