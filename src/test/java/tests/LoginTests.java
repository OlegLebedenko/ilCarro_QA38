package tests;

import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @BeforeMethod
    public void precondition(){
        if(app.getUser().isLogged()){
            app.getUser().logout();
        }

    }

    @Test
    public void loginPositiveTest() {
        String email = "roman@gmail.com", password = "Roma1234$";
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(email, password);
        app.getUser().submitButton();
        app.getUser().pause(5000);
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//h2[.='Logged in success']")));

    }
    @Test
    public void loginPositiveTestTwo() {
  //     User user = new User();
        User user = new User()
                .withEmail("rtr1@mail.com")
                .withPassword("Rtr1234#");
    //    user.setEmail("");
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(user.getEmail(), user.getPassword());
        app.getUser().submitButton();
        app.getUser().pause(5000);
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//h2[.='Logged in success']")));

    } @Test
    public void loginPositiveTestThree() {
  //     User user = new User();
        User user = new User()
                .withEmail("fot!@co.il")
                .withPassword("Fotin1234&");
    //    user.setEmail("");
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(user);
        app.getUser().submitButton();
        app.getUser().pause(5000);
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//h2[.='Logged in success']")));

    }

    @AfterMethod
    public void postcondition(){
        app.getUser().click(By.xpath("//button[.='Ok']"));

    }


}
