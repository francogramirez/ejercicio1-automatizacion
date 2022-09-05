package com.EjercicioAutomatizacion;

import static org.testng.AssertJUnit.assertEquals;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ejercicio_Automatizacion {
private WebDriver driver;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.consultoriaglobal.com.ar/cgweb/");
		System.out.println("Se abrió la página de Consultoría Global");
	}
	
	@Test
	public void testGooglePage() throws InterruptedException  {
		
	    WebElement contactos = driver.findElement(By.linkText("Contáctenos"));
	    contactos.click();
		System.out.println("Se ingresó a la sección 'Contáctenos'");
		
		WebElement nombre = driver.findElement(By.name("your-name"));
		nombre.clear();
		nombre.sendKeys("Franco");
		System.out.println("Se ingresó el nombre");
		
		WebElement email = driver.findElement(By.name("your-email"));
		email.clear();
		email.sendKeys("francoramirez");
		System.out.println("Se ingresó el mail");
		
		WebElement asunto = driver.findElement(By.name("your-subject"));
		asunto.clear();
		asunto.sendKeys("probando ejercicio de testing");
		System.out.println("Se ingresó el asunto");
		
		WebElement mensaje = driver.findElement(By.name("your-message"));
		mensaje.clear();
		mensaje.sendKeys("redactando mensaje");
		System.out.println("Se ingresó el mensaje");
		
		WebElement boton = driver.findElement(By.cssSelector("button, input[type=\"button\"], input[type=\"reset\"], input[type=\"submit\"]"));
		boton.click();
		System.out.println("Se hizo click en enviar");
		
		Thread.sleep(2000);
        List<WebElement> span = driver.findElements(By.tagName("span"));
        assertEquals("La dirección e-mail parece inválida.",span.get(2).getText());
        System.out.println(span.get(2).getText());
        
        assertEquals("https://www.consultoriaglobal.com.ar/cgweb/?page_id=370", driver.getCurrentUrl());
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
