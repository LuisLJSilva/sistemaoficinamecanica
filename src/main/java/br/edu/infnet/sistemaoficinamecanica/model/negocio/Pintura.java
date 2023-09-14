package br.edu.infnet.sistemaoficinamecanica.model.negocio;

public class Pintura extends Servico {
	
	private float intensidadeBrilho;
	private boolean tintaEcologica;
	private String cor;
	
	public Pintura() {
		
	}
	
	public Pintura(String tipoServico, float valor, int id, float intensidadeBrilho, boolean tintaEcologica, String cor) {
		super (tipoServico, valor, id);
		this.intensidadeBrilho = intensidadeBrilho;
		this.tintaEcologica = tintaEcologica;
		this.cor = cor;		
	}
	
	@Override
	public String toString() {
		return String.format("%s;%s;%2.f;%s",
				super.toString(),
				intensidadeBrilho,
				tintaEcologica,
				cor
				);
	}

	public float getIntensidadeBrilho() {
		return intensidadeBrilho;
	}

	public void setIntensidadeBrilho(float intensidadeBrilho) {
		this.intensidadeBrilho = intensidadeBrilho;
	}

	public boolean isTintaEcologica() {
		return tintaEcologica;
	}

	public void setTintaEcologica(boolean tintaEcologica) {
		this.tintaEcologica = tintaEcologica;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

}
