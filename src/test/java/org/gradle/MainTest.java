package org.gradle;

import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class MainTest {
    @Test
    public void appHasAGreeting() {
        MainApp classUnderTest = new MainApp();
        assertNotNull("app should have a greeting", classUnderTest.getGreeting());
        }
    }
