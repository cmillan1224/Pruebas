import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class PruebaTest {
    private WebDriver chromeDriver;

    @BeforeTest
    public void abrirDriver(){
        //borrar
        //Encontrar archivo .exe de chromedriver
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");

        //Creamos opciones sobre nuestro driver
        ChromeOptions options = new ChromeOptions();
        options.setCapability("marionette", true);

        //Nueva instancia de chromedriver
        chromeDriver = new ChromeDriver(options);

        //Definimos un tiempo de espera hasta que aceptamos un timeout
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void hacer_una_busqueda() {

        //Abrimos una URL
        chromeDriver.get("https://www.google.com/");

        //Encontrar e interactuar con elementos
        chromeDriver.findElement(By.xpath("//body/div[1]/div[3]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/input[1]")).sendKeys("Cuantos paises tiene america");
        chromeDriver.findElement(By.xpath("//body/div[1]/div[3]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/input[1]")).sendKeys(Keys.ENTER);
        chromeDriver.findElement(By.xpath("//h3[contains(text(),'América - Wikipedia, la enciclopedia libre')]")).click();

        //Creamos un elemento web para hacer acciones mas avanzadas
         WebElement wordFind = chromeDriver.findElement(By.xpath("//a[contains(text(),'35 países')]"));

         //Verificamos que la cantidad de paises en el elemento web contenga a 35
        Assert.assertTrue(wordFind.getText().contains("35"));

    }
    @AfterTest
    public void cerrarDriver(){
        //cerrar ventana apagar driver
        chromeDriver.close();
    }
}
