package com.myorg.ezdeal.steps;

import com.myorg.ezdeal.models.Solicitud;
import com.myorg.ezdeal.repository.SolicitudRepository;
import com.myorg.ezdeal.service.SolicitudService;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
public class StepDefinitionDoubleRequest {

    private WebDriver driver;
    @Autowired
    private SolicitudRepository solicitudRepository;
    private List<Solicitud> solicitudes;
    private Long serviceId;
    private String nombreUsuario;
    private String contraseña;

    @Before
    public void abrirPantallaLogIn(){
        this.serviceId = new Long(10);
        this.nombreUsuario = "Slayz08";
        this.contraseña = "7777777";
        this.solicitudes = new ArrayList<>();
        System.setProperty("webdriver.gecko.driver","D://7MO CICLO//DISEÑO_EXPERIMENTOS_SOFTWARE//GeckoDriver//geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:8080/login");
    }


    @Given("an announcer located in My Services page")
    public void an_announcer_located_in_my_services_page(){
        driver.findElement(By.name("usuario")).sendKeys(this.nombreUsuario);
        driver.findElement(By.name("contraseña")).sendKeys(this.contraseña);
        driver.findElement(By.name("loginButton")).click();
        try{
            Thread.sleep(5000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        driver.findElement(By.name("opcionMisServiciosNavBar")).click();

    }

    @And("has a service with two requests with the same hour and date")
    public void has_a_service_with_two_requests_with_the_same_hour_and_date(){
        //this.solicitudes = solicitudRepository.listarPorServicio(serviceId);
    }

    @When("he hovers the mouse to see the requests of the service")
    public void he_hovers_the_mouse_to_see_the_requests_of_the_service(){

        try{
            Thread.sleep(2000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.name("iconoSolicitud" + this.serviceId.intValue()))).perform();

        try{
            Thread.sleep(3000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    @Then("He will accept the request of who sent it first")
    public void he_will_accept_the_request_of_who_sent_it_first(){

        driver.findElement(By.name("botonAceptar8")).click();
    }
    @And("Define the end time of the service")
    public void define_the_end_time_of_the_service(){
        driver.findElement(By.name("hora-de-fin")).sendKeys("18:00");
        driver.findElement(By.name("enviarAceptacion")).click();
    }

    @But("He will reject the other request")
    public void he_will_reject_the_other_request()
    {
        try{
            Thread.sleep(3000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.name("iconoSolicitud" + this.serviceId.intValue()))).perform();

        try{
            Thread.sleep(4000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        driver.findElement(By.name("botonRechazar9")).click();
        try{
            Thread.sleep(3000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    @And("Write the message with the reasons of the rejection")
    public void write_the_message_with_the_reasons_of_the_rejection(){
        driver.findElement(By.name("contenidoMotivo")).sendKeys("18:00");
        driver.findElement(By.name("enviarMotivoRechazo")).click();

    }


}
