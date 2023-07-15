package br.com.banco.modelo;

import java.time.OffsetDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "transferencia")
public class Transferencia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private OffsetDateTime dataTransferencia;
	private Double valor;
	private String tipo;
	private String opedador;
	@ManyToOne
	@JoinColumn(name = "conta_id")
	private Conta idConta;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public OffsetDateTime getDataTransferencia() {
		return dataTransferencia;
	}
	
	public void setDataTransferencia(OffsetDateTime dataTransferencia) {
		this.dataTransferencia = dataTransferencia;
	}
	
	public Double getValor() {
		return valor;
	}
	
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getOpedador() {
		return opedador;
	}
	
	public void setOpedador(String opedador) {
		this.opedador = opedador;
	}
	
	public Conta getIdConta() {
		return idConta;
	}
	
	public void setIdConta(Conta idConta) {
		this.idConta = idConta;
	}
	
}
