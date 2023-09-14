package br.edu.infnet.sistemaoficinamecanica.model.negocio;

public class Manutencao extends Servico {
	
	private boolean necessitaPeca;
	private float custoEstimado;
	private String tipoManutencao;
	
	public Manutencao() {
		
	}
	
	public Manutencao(String tipoServico, float valor, int id, boolean necessitaPeca, float custoEstimado, String tipoManutencao) {
		super (tipoServico, valor, id);
		this.necessitaPeca = necessitaPeca;
		this.custoEstimado = custoEstimado;
		this.tipoManutencao = tipoManutencao;		
	}
	
	@Override
	public String toString() {
		return String.format("%s;%s;%2.f;%s",
				super.toString(),
				necessitaPeca,
				custoEstimado,
				tipoManutencao
				);
	}

	public boolean isNecessitaPeca() {
		return necessitaPeca;
	}

	public void setNecessitaPeca(boolean necessitaPeca) {
		this.necessitaPeca = necessitaPeca;
	}

	public float getCustoEstimado() {
		return custoEstimado;
	}

	public void setCustoEstimado(float custoEstimado) {
		this.custoEstimado = custoEstimado;
	}

	public String getTipoManutencao() {
		return tipoManutencao;
	}

	public void setTipoManutencao(String tipoManutencao) {
		this.tipoManutencao = tipoManutencao;
	}

}
