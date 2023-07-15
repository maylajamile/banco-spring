package br.com.banco.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.modelo.Transferencia;
import br.com.banco.repositorio.RepositorioTransferencia;

@RestController
@RequestMapping("/transferencias")
public class ControladorTransferencia {
	
	@Autowired
	private RepositorioTransferencia repositorioTransferencia;
	
	@GetMapping
	public List<Transferencia> listar() {
		return repositorioTransferencia.findAll();
	}

}
