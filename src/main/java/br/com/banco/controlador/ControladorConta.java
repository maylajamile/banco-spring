package br.com.banco.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.modelo.Conta;
import br.com.banco.repositorio.RepositorioConta;

@RestController
@RequestMapping("/contas")
public class ControladorConta {
	
	@Autowired
	private RepositorioConta repositorioConta;
	
	@GetMapping
	public List<Conta> listar() {
		return repositorioConta.findAll();
	}

}
