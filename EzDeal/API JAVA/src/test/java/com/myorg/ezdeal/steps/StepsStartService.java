package com.myorg.ezdeal.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class StepsStartService {

/*Given An announcer with username <username> and password <password>
    When He clicks on My Schedule option
    And He clicks on his first appointment
    Then He will see the start time of that service*/

    private WebDriver driver;

    @Given("^An announcer logged in with username (.*) and password (.*)$")
    public void an_announcer_with_username_and_password(String username, String password) throws Throwable{
        System.setProperty("webdriver.gecko.driver","D://7MO CICLO//DISEÑO_EXPERIMENTOS_SOFTWARE//GeckoDriver//geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:8080/login");
        driver.findElement(By.name("usuario")).sendKeys(username);
        driver.findElement(By.name("contraseña")).sendKeys(password);
        driver.findElement(By.name("loginButton")).click();
    }

    @When("^He clicks on My Schedule option$")
    public void he_clicks_on_my_schedule_option() throws Throwable{
        driver.findElement(By.name("agendaLink")).click();
    }

    @And("^He clicks on his first appointment's start button$")
    public void he_clicks_on_his_first_appointment_start_button() throws Throwable{
        driver.findElement(By.name("cita 10")).click();
        driver.switchTo().alert().accept();
    }

    @Then("^He will see the start time of that service$")
    public void he_will_see_the_start_time_of_that_service() throws Throwable{
        driver.navigate().refresh();
    }
}
