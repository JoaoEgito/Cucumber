package br.ce.jpegito.entidades;

public class Filme {
	private int estoque;
	private int aluguel;
	
	public void setEstoque(Integer arg1) {
		this.estoque = arg1;
	}

	public void setAluguel(Integer arg1) {
		this.aluguel = arg1;		
	}

	public Integer getAluguel() {
		 return aluguel;
	}

	public Integer getEstoque() {
		 return estoque;
	}

}
