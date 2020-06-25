package com.myorg.ezdeal.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class StepsGoldMembreship {

    WebDriver driver1;
    WebDriver driver2;

    @Given("^An announcer with username (.*) and password (.*)$")
    public void an_announcer_with_username_and_password(String username, String password) throws Throwable{
        System.setProperty("webdriver.gecko.driver","D://7MO CICLO//DISEÑO_EXPERIMENTOS_SOFTWARE//GeckoDriver//geckodriver.exe");
        driver1 = new FirefoxDriver();
        driver1.manage().window().maximize();
        driver1.get("http://localhost:8081/login");
        driver1.findElement(By.name("usuario")).sendKeys(username);
        driver1.findElement(By.name("contraseña")).sendKeys(password);
        driver1.findElement(By.name("loginButton")).click();
    }

    @And("^A client with username (.*) and password(.*)$")
    public void a_client_with_username_and_password(String username, String password) throws Throwable{
        System.setProperty("webdriver.gecko.driver","D://7MO CICLO//DISEÑO_EXPERIMENTOS_SOFTWARE//GeckoDriver//geckodriver.exe");
        driver2 = new FirefoxDriver();
        driver2.manage().window().maximize();
        driver2.get("http://localhost:8081/login");
        driver2.findElement(By.name("usuario")).sendKeys(username);
        driver2.findElement(By.name("contraseña")).sendKeys(password);
        driver2.findElement(By.name("loginButton")).click();
    }

    @When("^The announcer clicks on I wanna be Gold button$")
    public void the_announcer_clicks_on_i_wanna_be_gold_button() throws Throwable{
        driver1.findElement(By.name("goldButton")).click();
    }
    @And("^He send the payment form filled$")
    public void he_send_the_payment_form_filled() throws Throwable{
        driver1.findElement(By.name("numTarjeta")).sendKeys("123456789012");
        driver1.findElement(By.name("ccv")).sendKeys("123");
        driver1.findElement(By.name("fechaV")).sendKeys("07/22");
        driver1.findElement(By.name("quieroGold")).click();
    }

    @Then("^The client will see the services of this announcer in the Home View$")
    public void the_client_will_see_the_services_of_this_announcer_in_the_home_view() throws Throwable{
        driver2.navigate().refresh();
        driver1.close();
        driver2.close();
 ;
    }
}
