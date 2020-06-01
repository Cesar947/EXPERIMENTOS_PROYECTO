package com.myorg.ezdeal.steps;

import com.myorg.ezdeal.models.Solicitud;
import com.myorg.ezdeal.repository.SolicitudRepository;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RunWith(SpringRunner.class)
public class StepDefinitionDoubleRequest {

    private WebDriver driver;

    @Autowired
    private SolicitudRepository solicitudRepository;
    private List<Solicitud> solicitudesRealizadas;
    private Solicitud solicitudNueva;


    @Given("An unscheduled request with the date {string} and the time {string} to the service {int}")
    public void getAnScheduledRequest(String date, String time, int serviceId) throws Throwable{
        Long serviceIdLong = new Long(serviceId);
        LocalTime nuevaHora1 = LocalTime.parse(time);
        DateTimeFormatter dtfTime = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
        LocalTime nuevaHora = LocalTime.parse(nuevaHora1.format(dtfTime));
        LocalDate nuevaFecha = LocalDate.parse(date);
        solicitudesRealizadas = solicitudRepository.listarPorFechaYHoraYServicio(nuevaFecha, nuevaHora, serviceIdLong);
    }

    @When("Another client with username {string} and password {string} log in in the application")
    public void clientLogIn(String username, String password){
        System.setProperty("webdriver.gecko.driver","D://7MO CICLO//DISEÑO_EXPERIMENTOS_SOFTWARE//GeckoDriver/geckodriver.exe");
        driver= new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:8080/login");
        driver.findElement(By.name("usuario")).sendKeys(username);
        driver.findElement(By.name("contraseña")).sendKeys(password);
        driver.findElement(By.name("login")).click();
    }

    @Then("Send a new request with the same date {string} and time {string} and message {string} to the service {int}")
    public void makeNewRequest(String date, String time, String content, int serviceId){

        LocalDate fecha1 = LocalDate.parse(date);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/mm/yyyy");
        LocalDate fecha2 = LocalDate.parse(fecha1.format(dtf));
        String fecha3 = fecha2.toString();

        driver.findElement(By.name("servicio" + serviceId)).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/main/div/div/div[2]/div[2]/div[6]/div[1]/div[1]/input")).sendKeys(time);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/main/div/div/div[2]/div[2]/div[6]/div[1]/div[2]/div/input")).sendKeys(fecha3);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/main/div/div/div[2]/div[2]/div[6]/div[2]/textarea")).sendKeys(content);

        driver.findElement(By.xpath("//*[@id=\"app\"]/div/main/div/div/div[2]/div[2]/div[6]/div[3]/button"));
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/main/div/div/div[2]/button"));
    }



}
