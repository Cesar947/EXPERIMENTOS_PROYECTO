package com.myorg.ezdeal.steps;

import io.cucumber.java.en.*;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class StepsInvalidRequest {

    private String userCustomer = "jair777";
    private String passCustomer = "135790";
    private String userAnnouncer = "pepino";
    private String passAnnouncer = "1234567";

    private WebDriver driverFirefox1;
    private WebDriver driverFirefox2;

    @Given("A client who wants to request a service")
    public void a_client_who_wants_to_request_a_service() throws Throwable{
        System.setProperty("webdriver.gecko.driver","D://7MO CICLO//DISEÑO_EXPERIMENTOS_SOFTWARE//GeckoDriver//geckodriver.exe");
        driverFirefox1 = new FirefoxDriver();
        driverFirefox1.manage().window().maximize();
        driverFirefox1.get("http://localhost:8080/login");
        driverFirefox1.findElement(By.name("usuario")).sendKeys(this.userCustomer);
        driverFirefox1.findElement(By.name("contraseña")).sendKeys(this.passCustomer);
        driverFirefox1.findElement(By.name("loginButton")).click();

        WebDriverWait wait = new WebDriverWait(driverFirefox1, 3);
        wait.until(ExpectedConditions.elementToBeClickable(By.name("servicio2")));

        driverFirefox1.findElement(By.name("servicio2")).click();
    }

    @And("Fill the request form with an agreed time which affects the time of another job already scheduled by the announcer")
    public void fill_the_request_form_with_an_agreed_time_which_affects_the_time_of_another_job_already_scheduled_by_the_announcer() throws Throwable{
        driverFirefox1.findElement(By.name("horaPacto")).sendKeys("14:00");
        driverFirefox1.findElement(By.name("fechaPacto")).sendKeys("2020-07-11");
        driverFirefox1.findElement(By.name("mensaje")).sendKeys("Necesito que arregles el lavabo de mi cocina");
    }

    @When("He select the send option")
    public void he_select_the_send_option() throws Throwable{
        driverFirefox1.findElement(By.name("solicitar")).click();

    }

    @Then("The request will be sent to the announcer")
    public void the_request_will_be_sent_to_the_announcer(){

        WebDriverWait wait = new WebDriverWait(driverFirefox1, 2);
        wait.until(ExpectedConditions.elementToBeClickable(By.name("irAInicio")));
        driverFirefox1.findElement(By.name("irAInicio")).click();
        driverFirefox1.close();
        driverFirefox2 = new FirefoxDriver();
        driverFirefox2.manage().window().maximize();
        driverFirefox2.get("http://localhost:8080/login");
        driverFirefox2.findElement(By.name("usuario")).sendKeys(this.userAnnouncer);
        driverFirefox2.findElement(By.name("contraseña")).sendKeys(this.passAnnouncer);
        driverFirefox2.findElement(By.name("loginButton")).click();

    }

    @But("It will be rejected by the announcer")
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

}
