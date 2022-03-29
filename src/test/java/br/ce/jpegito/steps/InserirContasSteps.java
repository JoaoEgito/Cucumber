package br.ce.jpegito.steps;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class InserirContasSteps {
	
	private WebDriver driver;
	
	@Given("que desejo adicionar uma conta")
	public void queDesejoAdicionarUmaConta() {
		System.setProperty("webdriver.chrome.driver","/Users/joaoegito/Projects/selenium-drivers/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://seubarriga.wcaquino.me/");
		driver.findElement(By.id("email")).sendKeys("a1@a1.com");
	    driver.findElement(By.id("senha")).sendKeys("12345");     
	    driver.findElement(By.tagName("button")).click();
	    driver.findElement(By.linkText("Contas")).click();
	    driver.findElement(By.linkText("Adicionar")).click();

		
	}
	
//	@Given("que estou acessando a aplicação")
//	public void queEstouAcessandoAAplicação() {
//		System.setProperty("webdriver.chrome.driver","/Users/joaoegito/Projects/selenium-drivers/chromedriver");
//		driver = new ChromeDriver();
//		driver.get("https://seubarriga.wcaquino.me/");
//	}
//	
//	@When("informo o usuário {string}")
//	public void informoOUsuário(String email) {
//	     driver.findElement(By.id("email")).sendKeys(email);	     
//	}
//	
//	@When("a senha {string}")
//	public void aSenha(String senha) {
//	     driver.findElement(By.id("senha")).sendKeys(senha);     
//	}
//	
//	@When("seleciono entrar")
//	public void selecionoEntrar() {
//	     driver.findElement(By.tagName("button")).click();
//	}
	
//	@Then("visualizo a página inicial")
//	public void visualizoAPáginaInicial() {
//	     String texto = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
//	     Assert.assertEquals("Bem vindo, A!", texto);   
//	}
//	
//	@When("seleciono Contas")
//	public void selecionoContas() {
//	     driver.findElement(By.linkText("Contas")).click();
//	}
//	
//	@When("seleciono Adicionar")
//	public void selecionoAdicionar() {
//	     driver.findElement(By.linkText("Adicionar")).click();
//
//	}
	
//	@When("informo a conta {string}")
//	public void informoAConta(String conta) {
//	     driver.findElement(By.id("nome")).sendKeys(conta);
//	     
//	}
	
	@When("informo a conta {string}")
	public void informoAConta(String conta) {
	     driver.findElement(By.id("nome")).sendKeys(conta);
	     driver.findElement(By.tagName("button")).click();
	     
	}
	
//	@When("seleciono Salvar")
//	public void selecionoSalvar() {
//	     driver.findElement(By.tagName("button")).click();
//
//	}
	
//	@Then("a conta é inserida com sucesso")
//	public void aContaÉInseridaComSucesso() {
//		String texto = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
//	     Assert.assertEquals("Conta adicionada com sucesso!", texto);   
//	}
//	
//	@Then("sou notificado que o nome da conta é obrigatório")
//	public void souNotificadoQueONomeDaContaÉObrigatório() {
//		String texto = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
//	     Assert.assertEquals("Informe o nome da conta", texto); 
//	}
	
//	@Then("sou notificado que já existe uma conta com esse nome")
//	public void souNotificadoQueJáExisteUmaContaComEsseNome() {
//		String texto = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
//	     Assert.assertEquals("Já existe uma conta com esse nome!", texto); 
//	}
	
	@Then("recebo a mensagem {string}")
	public void receboAMensagem(String mensagem) {
		String texto = driver.findElement(By.xpath("//div[starts-with(@class, 'alert alert-')]")).getText();
	     Assert.assertEquals(mensagem, texto);
	}
	
	@Before
	public void inicio() {
		System.out.println("Iniciando o Teste");
	}
	
	@After(order = 1, value = "@tag")
	public void screenshot(Scenario feature) {
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("target/screenshot/"+feature.getId()+".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@After(order = 0, value = "@tag")
	public void fecharBrowser() {
		driver.quit();
		System.out.println("Terminando o Teste");
	}
	
}
