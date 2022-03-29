package br.ce.jpegito.steps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.ParameterType;
import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class AprenderCucumberSteps {
	
	@Given("que criei o arquivo corretamente")
	public void queCrieiOArquivoCorretamente() {
	   
	}
	@When("executá-lo")
	public void executáLo() {
	 
	}
	@Then("a especificação deve finalizar com sucesso")
	public void aEspecificaçãoDeveFinalizarComSucesso() {
	    
	}
	
	private int contador = 0;
	
	@Given("que o valor do contador é {int}")
	public void queOValorDoContadorÉ(Integer arg1) {
	    contador = arg1;
	}
	@When("eu incrementar em {int}")
	public void euIncrementarEm(Integer arg1) {
	    contador = contador + arg1;
	}
	@Then("o valor incrementado será {int}")
	public void oValorIncrementadoSerá(Integer arg1) {
	    assertEquals((Integer) arg1,(Integer) contador);
	   
	}
	Date entrega = new Date();
	
	@ParameterType(".*")
	public Date dataTransform(String data) {
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date retorno = format.parse(data);
			return retorno;
		} catch (ParseException e) {
//			TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	@Given("que a entrega é dia {dataTransform}")
	public void queAEntregaÉDia(Date dataEntrega) {
		entrega = dataEntrega;
	}
	
	@When("a entrega atrasar em (\\d+) (dia|dias|mes|meses)$")
	public void aEntregaAtrasarEmDias(Integer arg1, String tempo) {
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(entrega);
	    if(tempo.equals("dias")) {
	    	cal.add(Calendar.DAY_OF_MONTH, arg1);
	    }
	    if(tempo.equals("meses")) {
	    	cal.add(Calendar.MONTH, arg1);
	    }
	    
	    entrega = cal.getTime();
	}
	
	@Then("a entrega será efetuada em {dataTransform}")
	public void aEntregaSeráEfetuadaEm(Date dataEntrega) {
	     DateFormat format = new SimpleDateFormat ("dd/MM/yyyy");
	     assertEquals(dataEntrega, entrega);
	}


	
	@Given("que o ticket( especial)? é (A.\\d{3})$")
	public void queOTicketÉ(String tipo, String arg1) {
	    
	}
	@Given("que o valor da passagem é R$ {double}")
	public void queOValorDaPassagemÉR$(Double double1) {
	    
	}
	@Given("que o nome do passageiro é \"(.{5,20})\"$")
	public void queONomeDoPassageiroÉ(String string) {
	    
	}
	@Given("que o telefone do passageiro é (9\\d{3}-\\d{4})$")
	public void queOTelefoneDoPassageiroÉ(String telefone) {
	    
	}
	@When("criar os steps")
	public void criarOsSteps() {
	    
	}
	@Then("o teste vai funcionar")
	public void oTesteVaiFuncionar() {
	    
	}

}
