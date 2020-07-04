package com.myorg.ezdeal.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class StepsRejectedRequest {

    private WebDriver driverFirefox1;
    private WebDriver driverFirefox2;
    private String userAnnouncer = "cesar947";
    private String passAnnouncer = "3456789";
    private String userCustomer = "jair777";
    private String passCustomer = "135790";

    @Given("An announcer in his services view")
    public void an_announcer_in_his_schedule_view() throws Throwable{
        System.setProperty("webdriver.gecko.driver","D://7MO CICLO//DISEÑO_EXPERIMENTOS_SOFTWARE//GeckoDriver//geckodriver.exe");
        driverFirefox1 = new FirefoxDriver();
        driverFirefox1.manage().window().maximize();
        driverFirefox1.get("http://localhost:8080/login");
        driverFirefox1.findElement(By.name("usuario")).sendKeys(this.userAnnouncer);
        driverFirefox1.findElement(By.name("contraseña")).sendKeys(this.passAnnouncer);
        driverFirefox1.findElement(By.name("loginButton")).click();
        driverFirefox1.findElement(By.name("opcionMisServiciosNavBar")).click();



    }
    @And("He has a service with at least one request that is not convinient")
    public void he_has_a_service_with_at_least_one_request_that_is_not_convinient() throws Throwable{
        WebDriverWait wait = new WebDriverWait(driverFirefox1, 3);
        Actions action = new Actions(driverFirefox1);
        WebElement we = driverFirefox1.findElement(By.xpath("/html/body/div/div/main/div/div/div[2]/div/div/div[2]/div[1]/div[1]/p"));
        action.moveToElement(we).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("botonRechazarJair Orlando")));

    }
    @When("He selects the reject option")
    public void he_selects_the_reject_option() throws Throwable{
        driverFirefox1.findElement(By.name("botonRechazarJair Orlando")).click();
    }
    @Then("He will write and send a message with the reason of rejection")
    public void he_will_be_able_select_the_reject_option() throws Throwable{
        WebDriverWait wait = new WebDriverWait(driverFirefox1, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("contenidoMotivo")));
        driverFirefox1.findElement(By.name("contenidoMotivo")).sendKeys("Quisiera que establezca otra hora de pacto después de las 6 pm");
        driverFirefox1.findElement(By.name("enviarMotivoRechazo")).click();
    }

    @And("The client will see his message in his request view")
    public void the_client_will_see_his_meesage_in_his_request_view() throws Throwable{
        driverFirefox2 = new FirefoxDriver();
        driverFirefox2.manage().window().maximize();
        driverFirefox2.get("http://localhost:8080/login");
        driverFirefox2.findElement(By.name("usuario")).sendKeys(this.userCustomer);
        driverFirefox2.findElement(By.name("contraseña")).sendKeys(this.passCustomer);
        driverFirefox2.findElement(By.name("loginButton")).click();

        WebDriverWait wait1 = new WebDriverWait(driverFirefox2, 3);
        wait1.until(ExpectedConditions.elementToBeClickable(By.name("mis-solicitudes")));
        driverFirefox2.findElement(By.name("mis-solicitudes")).click();

        JavascriptExecutor jse = (JavascriptExecutor) driverFirefox2;
        jse.executeScript("window.scrollBy(0,500)", "");

    }

    @And("He will be able to make a request again")
    public void he_will_be_able_to_make_a_request_again(){
        WebDriverWait wait2 = new WebDriverWait(driverFirefox2, 2);
        wait2.until(ExpectedConditions.elementToBeClickable(By.name("volver-solicitar")));
        driverFirefox2.findElement(By.name("volver-solicitar")).click();

        driverFirefox2.findElement(By.name("horaPacto")).sendKeys("11:00");
        driverFirefox2.findElement(By.name("fechaPacto")).sendKeys("2020-07-11");
        driverFirefox2.findElement(By.name("mensaje")).sendKeys("Quiero que le enseñes a mi perro a ir al baño");
        driverFirefox2.findElement(By.name("solicitar")).click();
        driverFirefox1.close();
        driverFirefox2.close();

    }
    /*@But("It will be rejected by the announcer")
    public void it_will_be_rejected_by_the_announcer(){
        driverFirefox2.findElement(By.name("opcionMisServiciosNavBar")).click();
        WebDriverWait wait1 = new WebDriverWait(driverFirefox2, 3);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/main/div/div/div[2]/div/div/div[1]/div[1]/div[1]/img")));
        Actions action = new Actions(driverFirefox2);
        WebElement we = driverFirefox2.findElement(By.xpath("/html/body/div/div/main/div/div/div[2]/div/div/div[1]/div[1]/div[1]/img"));
        action.moveToElement(we).build().perform();
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.name("botonRechazar")));
        driverFirefox2.findElement(By.name("botonRechazar")).click();

    }

    @And("He will send the reason for rejection")
    public void he_will_send_the_reason_for_rejection(){
        WebDriverWait wait = new WebDriverWait(driverFirefox2, 2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("contenidoMotivo")));
        driverFirefox2.findElement(By.name("contenidoMotivo")).sendKeys("Quisiera que establezca otra hora de pacto después de las 6 pm" +
                " ,puesto que necesito tiempo para revisar el problema y tengo una cita a las 3 pm.");
        driverFirefox2.findElement(By.name("enviarMotivoRechazo")).click();

        driverFirefox2.close();

    }
*/
}
