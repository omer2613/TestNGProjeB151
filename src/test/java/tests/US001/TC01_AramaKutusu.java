package tests.US001;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC01_AramaKutusu {
    @Test
    public void test01() {
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        ReusableMethods.bekle(1);
        Page page = new Page();
        page.aramaKutusu.sendKeys("iphone", Keys.ENTER);
        Driver.closeDriver();
}
}