package stepDef;

import config.env_target;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

// method extends karena menambahkan code dari file lain
public class Login extends env_target {



        @Given("User is on login page")
        public void user_is_on_login_page() {
            // buat property untuk chrome driver
            System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");

            // penggunaan object driver == chrome driver
            driver = new ChromeDriver();

            // akses URL website
            driver.get(url);

            // mekanisme untuk menunggu pencarian element
            Duration duration = Duration.ofSeconds(10);
            WebDriverWait wait = new WebDriverWait(driver, duration);

            // menunggu element button login muncul
            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='submit']"))
            );
        }
        @When("User fill username and password")
        public void user_fill_username_and_password() {
            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.name("password")).sendKeys("secret_sauce");
        }
        @When("User click login button")
        public void user_click_login_button() {
            driver.findElement(By.xpath("//input[@type='submit']")).click();
        }
        @Then("User verify login result")
        public void user_verify_login_result() {
            // mekanisme untuk menunggu pencarian element
            Duration duration = Duration.ofSeconds(10);
            WebDriverWait wait = new WebDriverWait(driver, duration);
            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Products')]"))
            );
            driver.quit();
        }

    }
