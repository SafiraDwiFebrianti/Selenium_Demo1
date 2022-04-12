package config;

import org.openqa.selenium.WebDriver;

public class env_target {

    // menggunakan method protected karena variable hendak digunakan di class lain
    // membuat object webdriver
    protected WebDriver driver;
    // deklarasi variable url dengan value
    protected String url = "https://www.saucedemo.com/";

}
