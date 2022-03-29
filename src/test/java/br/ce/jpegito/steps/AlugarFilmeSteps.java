package br.ce.jpegito.steps;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import com.sun.tools.javac.util.Name.Table;

import br.ce.jpegito.entidades.Filme;
import br.ce.jpegito.entidades.NotaAluguel;
import br.ce.jpegito.entidades.TipoAluguel;
import br.ce.jpegito.servicos.AluguelService;
import br.ce.jpegito.utils.DateUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;
import junit.framework.Assert;

public class AlugarFilmeSteps {
	
	private Filme filme;
	private AluguelService aluguel = new AluguelService();
	private NotaAluguel nota;
	private String erro;
	private TipoAluguel tipoAluguel;
	
	@Given("um filme com estoque de {int} unidades")
	public void umFilmeComEstoqueDeUnidades(Integer arg1) {
	     filme = new Filme();
	     filme.setEstoque(arg1);
	     
	}
	@Given("o preço do aluguel seja R$ {int}")
	public void oPreçoDoAluguelSejaR$(Integer arg1) {
	    filme.setAluguel(arg1);
	}
	
	@Given("um filme")
	public void umFilme(io.cucumber.datatable.DataTable dataTable) {
	    Map<String, String> map = dataTable.asMap(String.class, String.class);
	    filme = new Filme();
	    filme.setEstoque(Integer.parseInt(map.get("estoque")));
	    filme.setAluguel(Integer.parseInt(map.get("preco")));;
	    String tipo = map.get("tipo");
	    tipoAluguel = tipo.equals("semanal")? TipoAluguel.SEMANAL: tipo.equals("extendido")? TipoAluguel.EXTENDIDO: TipoAluguel.COMUM;

	}
	
	@When("alugar")
	public void alugar() {
		try {
			nota = aluguel.alugar(filme, tipoAluguel);
		} catch (RuntimeException e) {
			erro = e.getMessage();
		}
	     
	}
	@Then("o preço do aluguel será R$ {int}")
	public void oPreçoDoAluguelSeráR$(Integer arg1) {
	     Assert.assertEquals(arg1, nota.getPreco());
	}
//	@Then("a data de entrega será no dia seguinte")
//	public void aDataDeEntregaSeráNoDiaSeguinte() {
//	     Calendar cal = Calendar.getInstance();
//	     cal.add(Calendar.DAY_OF_MONTH, 1);
//	     
//	     Date dataRetorno = nota.getDataEntrega();
//	     Calendar calRetorno = Calendar.getInstance();
//	     calRetorno.setTime(dataRetorno);
//	     
//	     
//	     Assert.assertEquals(cal.get(Calendar.DAY_OF_MONTH), calRetorno.get(Calendar.DAY_OF_MONTH));
//	     Assert.assertEquals(cal.get(Calendar.MONTH), calRetorno.get(Calendar.MONTH));
//	     Assert.assertEquals(cal.get(Calendar.YEAR), calRetorno.get(Calendar.YEAR));
//	}
	@Then("o estoque do filme será de {int} unidade")
	public void oEstoqueDoFilmeSeráDeUnidade(Integer arg1) {
	     Assert.assertEquals(arg1, filme.getEstoque());
	}
	
	@Then("não será possível por falta de estoque")
	public void nãoSeráPossívelPorFaltaDeEstoque() {
	     Assert.assertEquals("Filme sem estoque",erro);
	}

	
	
	@Given("o tipo de aluguel é (.*)$")
	public void oTipoDeAluguelÉExtendido(String tipo) {
	     tipoAluguel = tipo.equals("semanal")? TipoAluguel.SEMANAL: tipo.equals("extendido")? TipoAluguel.EXTENDIDO: TipoAluguel.COMUM;
	}
	@Then("a data de entrega será em (\\d+) dias?$")
	public void aDataDeEntregaSeráEmDias(Integer int1) {
	     Date dataEsperada = DateUtils.obterDataDiferencaDias(int1);
	     Date dataReal = nota.getDataEntrega();
	     
	     DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	     
	     Assert.assertEquals(format.format(dataEsperada), format.format(dataReal));
	}
	@Then("a pontuação será de {int} pontos")
	public void aPontuaçãoSeráDePontos(Integer int1) {
	     Assert.assertEquals(int1, nota.getPontuacao());
	}


}
