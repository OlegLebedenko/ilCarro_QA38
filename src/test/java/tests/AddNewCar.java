package tests;

import models.Car;
import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class AddNewCar extends TestBase {

    @BeforeMethod(alwaysRun = true)
    public void precondition(){
        if(app.getUser().isLogged() == false)
            app.getUser().login(
                    new User().withEmail("roman@gmail.com").withPassword("Roma1234$"));

    }

    @Test(groups = {"regress", "positive"})
    public void addNewCarPositive(){

      int i = (int) (System.currentTimeMillis()/1000)%3600;
      Car car = Car.builder()
              .location("Tel Aviv")
              .make("KIA")
              .model("Sportage")
              .year("2023")
              .fuel("Petrol")
              .seats("5")
              .carClass("Sedan")
              .carRegNumber("100-200-" + i)
              .price("120")
              .about("This is a test car")
              .build();

      app.getCar().openCarForm();
      app.getCar().fillCarForm(car);
      app.getUser().submitButtonType();
        Assert.assertTrue(app.getCar().isElementPresent(By.xpath("//h1[.='Car added']")));


    }

    @AfterMethod(alwaysRun = true)
    public void postcondition(){
        app.getCar().click(By.xpath("//button[@type='button']"));
        app.getUser().logout();

    }

}
