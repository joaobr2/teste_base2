import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.junit.Assert;

public class TesteUnitario {

	private WebDriver driver;
	private DSL dsl;
	
	@Before
	public void inicializa() {
		System.setProperty("webdriver.gecko.driver","C:\\Users\\isacf\\Driver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://mantis-prova.base2.com.br/login_page.php");
		dsl = new DSL(driver);
		
	}
	
	@After
	public void finaliza() {
		driver.quit();
	}
	
	@Test
	public void TesteLogincomSucesso() {
		dsl.logindosistema("joao.lucas", "Joaolucas223");
		Assert.assertEquals("joao.lucas",dsl.obterTexto("/html/body/table[1]/tbody/tr/td[1]/span[1]")); 
	}
	
	@Test
	public void TesteSairdoSistemacomSucesso() {
		dsl.logindosistema("joao.lucas", "Joaolucas223");
		Assert.assertEquals("joao.lucas",dsl.obterTexto("/html/body/table[1]/tbody/tr/td[1]/span[1]"));
		dsl.clicarBotao("/html/body/table[2]/tbody/tr/td[1]/a[7]");
		Assert.assertEquals("Username",dsl.obterTexto("/html/body/div[3]/form/table/tbody/tr[2]/td[1]"));
		
		
	}
	
	@Test
	public void TesteLoginsemSucesso() {
		dsl.logindosistema("joao.lucas", "Joao");
		Assert.assertEquals("Your account may be disabled or blocked or the username/password you entered is incorrect.",dsl.obterTexto("/html/body/div[2]/font"));
	}
	
		
	
	@Test
	public void TesteRelatarCasocomSucesso() {
		
		dsl.logindosistema("joao.lucas", "Joaolucas223");
		dsl.clicarBotao("/html/body/table[2]/tbody/tr/td[1]/a[3]");
		dsl.selecionarCombo("/html/body/div[3]/form/table/tbody/tr[2]/td[2]/select", "[Todos os Projetos] Teste");
		dsl.selecionarCombo("/html/body/div[3]/form/table/tbody/tr[3]/td[2]/select","sempre");
		dsl.selecionarCombo("/html/body/div[3]/form/table/tbody/tr[4]/td[2]/select", "grande");
		dsl.selecionarCombo("/html/body/div[3]/form/table/tbody/tr[5]/td[2]/select","urgente");	
		dsl.escrever("/html/body/div[3]/form/table/tbody/tr[8]/td[2]/input", "Teste 1 ralatar caso");
		dsl.escrever("/html/body/div[3]/form/table/tbody/tr[9]/td[2]/textarea", "Teste utilizando o selenium pelo caminho feliz");
		dsl.clicarBotao("/html/body/div[3]/form/table/tbody/tr[15]/td[2]/input");
		
	}
	
	@Test 
	public void TesteRelatarCasosemSucesso() {
		dsl.logindosistema("joao.lucas", "Joaolucas223");
		dsl.clicarBotao("/html/body/table[2]/tbody/tr/td[1]/a[3]");
		dsl.selecionarCombo("/html/body/div[3]/form/table/tbody/tr[2]/td[2]/select", "[Todos os Projetos] Teste");
		dsl.escrever("/html/body/div[3]/form/table/tbody/tr[9]/td[2]/textarea", "Teste utilizando o selenium pelo caminho feliz");
		dsl.clicarBotao("/html/body/div[3]/form/table/tbody/tr[15]/td[2]/input");
		Assert.assertEquals("APPLICATION ERROR #11",dsl.obterTexto("/html/body/div[2]/table/tbody/tr[1]/td"));
		
	}
	
	
}
