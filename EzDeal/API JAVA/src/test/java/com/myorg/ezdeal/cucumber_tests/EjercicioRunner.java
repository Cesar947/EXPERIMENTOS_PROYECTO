package com.myorg.ezdeal.cucumber_tests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features/Ejercicio.feature",glue="com.myorg.ezdeal.cucumber_tests", strict = true)
public class EjercicioRunner {
}
