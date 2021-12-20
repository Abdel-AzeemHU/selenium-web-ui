package com.qabot;


import org.testng.annotations.*;
import java.io.IOException;


public class MasterTest extends MasterPage{

    @Test
    public void basePageNavigation() throws IOException {
        driver = initializeDriver();
        driver.get("http://the-internet.herokuapp.com/");

    }

}
