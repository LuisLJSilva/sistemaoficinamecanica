package br.edu.infnet.sistemaoficinamecanica.model.negocio;

import java.time.LocalDate;

public class Servico {
	
	
	private String tipoServico;
	private float valor;
	private int id;
	
	public Servico() {
		
	}
	
	public Servico(String tipoServico, float valor, int id) {
		this.tipoServico = tipoServico;
		this.valor = valor;
		this.id = id;
	}
	
	@Override
	public String toString() {
		return String.format("%s;%.2f;%d", tipoServico, valor, id);
	}

	public String getTipoServico() {
		return tipoServico;
	}

	public void setTipoServico(String tipoServico) {
		this.tipoServico = tipoServico;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

}
