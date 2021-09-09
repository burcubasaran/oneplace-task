package com.testautomation.task;

import com.testautomation.task.TestAutomationException;
import org.apache.maven.surefire.shared.lang3.SystemUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Objects;
import java.util.logging.Level;

public class Utils {

    public static WebDriver buildChromeDriver()  {
        URL resource;
        if(SystemUtils.IS_OS_WINDOWS) {
            resource = Thread.currentThread().getContextClassLoader().getResource("chromedriver/windows/chromedriver.exe");
        }
        else if(SystemUtils.IS_OS_LINUX) {
            resource = Thread.currentThread().getContextClassLoader().getResource("chromedriver/linux/chromedriver");
        }
        else {
            throw new IllegalStateException("The system is neither identified as windows nor as linux");
        }

        Objects.requireNonNull(resource, "The chromedriver resource could not be located");

        ChromeDriverService chromeDriverService;
        try {
            chromeDriverService = new ChromeDriverService.Builder().usingDriverExecutable(new File(resource.toURI())).build();
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException("Resource URL does not represent a valid URI", e);
        }

        return new ChromeDriver(chromeDriverService, getChromeOptions());
    }

    private static ChromeOptions getChromeOptions() throws TestAutomationException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setAcceptInsecureCerts(true);
        chromeOptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
        chromeOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);
        return chromeOptions;
    }
}

