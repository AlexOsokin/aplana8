package autotest.steps;

import autotest.util.Init;
import cucumber.api.java.After;
import cucumber.api.java.Before;


public class BaseSteps {

    @Before
    public void initDriver(){
        Init.initDriver();

    }
    @After
    public void closeDriver(){
        Init.closeDriver();

    }
}
