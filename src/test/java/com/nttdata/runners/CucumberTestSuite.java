package com.nttdata.runners;

import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import net.serenitybdd.cucumber.CucumberWithSerenity;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/features",
        glue = "com.nttdata.stepsdefinition",
        tags = "  @Principal"
)

public class CucumberTestSuite {
}
