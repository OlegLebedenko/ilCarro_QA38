package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchTests extends TestBase{




    @Test(groups = {"positive"})
    public void searchPositiveTest(){

      app.getSearch().fillSearchForm("Haifa", "07/26/2023", "03/23/2024");
      app.getSearch().pause(3000);
      app.getUser().submitButtonType();

        Assert.assertTrue(app.getSearch().isElementPresent(By.xpath("//div[@class='car-card']")));
    }
}
