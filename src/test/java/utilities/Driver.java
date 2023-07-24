package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Driver {
    private Driver() {
        /*
       Driver class'indan obje olusturmanin onunce gecebilmek icin
       default constructor'i private yaparak bunu engellemis oluruz. Bu kaliba da Singleton patter denir */

    }

    /*
                    POM(Page Object Model)
       Test seneryolarının daha az kod ile yazılmasına ve bakımının daha kolay yapılmasına
   olanak sağlayan yazılım test yöntemidir. TestNG ve Cucumber frameworklerinde POM kalıbı kullanılır.
 */
    /*
                Driver'i her çağırdığımızda yeni bir pencere açılmasının önüne geçmek için
        if bloğu içinde Eğer driver'a değer ATANMAMIŞSA değer ata, eğer değer atanmışsa
        driver'i aynı sayfada return et
                 */
    static WebDriver driver;
        /*
              .properties dosyasına key olarak browser ve değerini aşağıda oluşturduğumuz switch case lerden birini seçeriz
        ve sectiğimiz driver çalışır
         */

    public static WebDriver getDriver() {
        if (driver == null) {//Driver a deger atanmamissa
            switch (ConfigReader.getProperty("browser")) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver = new ChromeDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        return driver;


        }

        public static void closeDriver () {
            if (driver != null) {//-->Driver a deger atanmissa,bos degilse
                driver.close();
                driver = null;//--> DRiver Ii kapattıktan sonra bosalt
            }


        }

        public static void quitDriver () {
            if (driver != null) {//-->Driver a deger atanmissa,bos degilse
                driver.quit();
                driver = null;//--> Driver i kapattıktan sonra bosalt
            }

        }
    }
