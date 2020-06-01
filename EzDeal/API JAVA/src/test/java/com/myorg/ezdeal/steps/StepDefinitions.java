package com.myorg.ezdeal.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class StepDefinitions {

    WebDriver driver;

    @Given("^A client that wants to be part of our service$")
    public void a_client_that_wants_to_be_part_of_our_service() throws Throwable
    {
        System.setProperty("webdriver.gecko.driver","D://7MO CICLO//DISEÑO_EXPERIMENTOS_SOFTWARE//GeckoDriver//geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:8080/login");
    }

    @When("^He fills the sign in form$")
    public void he_fills_the_sign_in_form() throws Throwable
    {
        driver.findElement(By.name("usuario")).sendKeys("cesar947");
        driver.findElement(By.name("contraseña")).sendKeys("3456789");
    }

    @Then("^He clicks the log in button$")
    public void he_clicks_the_log_in_buttons() throws Throwable
    {
        driver.findElement(By.name("login")).click();
    }


}
