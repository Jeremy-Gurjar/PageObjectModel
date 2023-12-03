package org.example;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BrowserManager extends Utils{
    LoadProp loadProp = new LoadProp();
    URL url = null;

//    String browserName = "firefox";
//    String browserName = loadProp.getProperty("browser");
//    String browserName = System.getProperty("browser");
        String browserName = System.getProperty("browser");


//    boolean sauce=false;
    boolean sauce = Boolean.parseBoolean(System.getProperty("sauce"));
//    boolean sauce = System.getProperty("browser");



    public  void openBrowser()
    {
        if (sauce)
        {
            System.out.println("running in sauce lab............................");
            if (browserName.equalsIgnoreCase("Chrome")) {
                ChromeOptions browserOptions = new ChromeOptions();
                browserOptions.setPlatformName("windows 10");
                browserOptions.setBrowserVersion("latest");
                Map<String, Object> sauceOptions = new HashMap<>();
                sauceOptions.put("username", loadProp.getProperty("sauceUserName"));
                sauceOptions.put("accessKey", loadProp.getProperty("saucePassword"));
                sauceOptions.put("build", "<your build id>");
                sauceOptions.put("name", "<your test name>");
                browserOptions.setCapability("sauce:options", sauceOptions);

                try {
                    url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                driver = new RemoteWebDriver(url, browserOptions);

            } else if (browserName.equalsIgnoreCase("Firefox")) {
                FirefoxOptions browserOptions = new FirefoxOptions();
                browserOptions.setPlatformName("Windows 11");
                browserOptions.setBrowserVersion("latest");
                Map<String, Object> sauceOptions = new HashMap<>();
                sauceOptions.put("username", "oauth-uniquetesting54-69237");
                sauceOptions.put("accessKey", "0b7ebc58-373e-4733-b703-de2051dc060a");
                sauceOptions.put("build", "<your build id>");
                sauceOptions.put("name", "<your test name>");
                browserOptions.setCapability("sauce:options", sauceOptions);

                try {
                    url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                driver = new RemoteWebDriver(url, browserOptions);

            } else if (browserName.equalsIgnoreCase("safari")) {
                SafariOptions browserOptions = new SafariOptions();
                browserOptions.setPlatformName("macOS 10.15");
                browserOptions.setBrowserVersion("latest");
                Map<String, Object> sauceOptions = new HashMap<>();
                sauceOptions.put("username", "oauth-uniquetesting54-69237");
                sauceOptions.put("accessKey", "0b7ebc58-373e-4733-b703-de2051dc060a");
                sauceOptions.put("build", "<your build id>");
                sauceOptions.put("name", "<your test name>");
                browserOptions.setCapability("sauce:options", sauceOptions);

                try {
                    url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                driver = new RemoteWebDriver(url, browserOptions);

            } else {
                System.out.println("Your browse name is wrong or does not match :" + browserName);
            }

        }else
            {

                System.out.println("running in Local............................");

                if (browserName.equalsIgnoreCase("Chrome")) {
                    System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
                    driver = new ChromeDriver();
                } else if (browserName.equalsIgnoreCase("Firefox")) {
                    System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
                    driver = new FirefoxDriver();

                } else if (browserName.equalsIgnoreCase("Edge")) {
                    System.setProperty("webdriver.edge.driver", "src/test/resources/drivers/msedgedriver.exe");
                    driver = new EdgeDriver();

                } else {
                    System.out.println("Your browse name is wrong or does not match :" + browserName);
                }
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.nopcommerce.com/");
    }

    public  void closeBrowser() {

        driver.close();  //closes the currently focused window/
    }


}
