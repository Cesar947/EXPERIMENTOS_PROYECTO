package com.myorg.ezdeal.steps;

import io.cucumber.java.en.*;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class StepsInvalidRequest {

    private String userCustomer = "jair777";
    private String passCustomer = "135790";

    private WebDriver driverFirefox1;

    @Given("A client in the detail of a service")
    public void a_client_in_the_detail_of_a_service() throws Throwable{
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

    @When("He fill the request form with an agreed time that belongs to range of hours of a scheduled request")
    public void he_fill_the_request_form_with_an_agreed_time_that_belongs_to_range_of_hours_of_a_scheduled_request() throws Throwable{
        driverFirefox1.findElement(By.name("horaPacto")).sendKeys("16:00");
        driverFirefox1.findElement(By.name("fechaPacto")).sendKeys("2020-07-11");
        driverFirefox1.findElement(By.name("mensaje")).sendKeys("Necesito que arregles el lavabo de mi cocina");
    }

    @And("He clicks in send request option")
    public void he_clicks_in_send_request_option() throws Throwable {
        driverFirefox1.findElement(By.name("solicitar")).click();
    }

    @Then("An alert will appear with a detailed message of error")
    public void an_alert_will_appear_with_a_detailed_message_of_error() throws Throwable{
        driverFirefox1.switchTo().alert().accept();
        driverFirefox1.close();
    }


}
