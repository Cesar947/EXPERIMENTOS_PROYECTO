package com.myorg.ezdeal.runners;

import com.myorg.ezdeal.Application;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(Cucumber.class)
@SpringBootTest(classes = Application.class)
@CucumberOptions(features="src/test/resources/features/DoubleRequest.feature",glue="com.myorg.ezdeal.steps", strict = true)
public class StartServiceRunner {

}
