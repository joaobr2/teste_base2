import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DSL {

private WebDriver driver;
	
	public DSL(WebDriver driver) {
		this.driver = driver;
	}
	// Login 
	
	public void logindosistema(String login,String senha) {
		escrever("/html/body/div[3]/form/table/tbody/tr[2]/td[2]/input",login);
		escrever("/html/body/div[3]/form/table/tbody/tr[3]/td[2]/input", senha);
		clicarBotao("/html/body/div[3]/form/table/tbody/tr[6]/td/input");
	}
	
	
	
	
	
	// Texto e Obter texto  
	
	public void escrever(String id_campo, String texto) {
		driver.findElement(By.xpath(id_campo)).sendKeys(texto);
	}
	
	public String obterValorCampo(String id_campo) {
		return driver.findElement(By.xpath(id_campo)).getAttribute("value");
	}
	
	
	//Combo
	
	public void selecionarCombo(String path, String valor) {
		WebElement element = driver.findElement(By.xpath(path));
		Select combo = new Select(element);
		combo.selectByVisibleText(valor);
	}
	
	public void deselecionarCombo(String path, String valor) {
		WebElement element = driver.findElement(By.xpath(path));
		Select combo = new Select(element);
		combo.deselectByVisibleText(valor);
	}
	
	public String obterValorCombo(String path) {
		WebElement element = driver.findElement(By.xpath(path));
		Select combo = new Select(element);
		return combo.getFirstSelectedOption().getText();
	}
	
	//Botao
	
	public void clicarBotao(String path) {
		driver.findElement(By.xpath(path)).click();
	}
	
	//Texto
	
	public String obterTexto(String path) {
		return driver.findElement(By.xpath(path)).getText();
	}
	
	
}
