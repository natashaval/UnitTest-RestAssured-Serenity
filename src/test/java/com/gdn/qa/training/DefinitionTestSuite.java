package com.gdn.qa.training;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        tags = "@DummyEmployee",
        features="src/test/resources/features/consult_dictionary/",
        junit = "--step-notifications"
)
public class DefinitionTestSuite {}
