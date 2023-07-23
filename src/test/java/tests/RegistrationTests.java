package tests;

import manager.ProviderData;
import manager.TestNgListener;
import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import tests.TestBase;


@Listeners(TestNgListener.class)

public class RegistrationTests extends TestBase {

    @BeforeMethod(alwaysRun = true)
    public void precondition() {
        if (app.getUser().isLogged()) {
            app.getUser().logout();
        }
    }

    @Test(priority = 1)
    public void registrationPositive(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        User user = new User()
                .withName("Vova")
                .withLastName("Volkov")
                .withEmail("vova" + i + "@mail.com")
                .withPassword("Volk1234$");

        app.getUser().openRegistrationForm();
        logger.info("openRegistrationForm invoked");
        app.getUser().fillRegistrationForm(user);
        logger.info("fillRegistrationForm invoked");
        app.getUser().submitButton();
        logger.info("submitButton invoked");
        logger.info("registrationPositive starts with credentials : " + user.getEmail()
        + " " + user.getPassword());
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//h2[contains(text(),'success')]")));

    }

    @Test(priority = 2)
    public void registrationNegativeNameBlank(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        User user = new User()
                .withName("    ")
                .withLastName("Volkov")
                .withEmail("vova" + i + "@mail.com")
                .withPassword("Volk1234$");

        app.getUser().openRegistrationForm();
        app.getUser().fillRegistrationForm(user);
        app.getUser().submitButton();
     //   Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//h1[contains(text(),'failed')]")));
    }

    @Test(priority = 3)
    public void registrationNegativeLastNameBlank(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        User user = new User()
                .withName("Vova")
                .withLastName("     ")
                .withEmail("vova" + i + "@mail.com")
                .withPassword("Volk1234$");

        app.getUser().openRegistrationForm();
        app.getUser().fillRegistrationForm(user);
        app.getUser().submitButton();
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//h1[contains(text(),'failed')]")));
    }

    @Test(priority = 4)
    public void registrationNegativeWrongEmail(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        User user = new User()
                .withName("Rita")
                .withLastName("Miller")
                .withEmail("рита" + i + "@мейл.ру")
                .withPassword("Volk1234$");

        app.getUser().openRegistrationForm();
        app.getUser().fillRegistrationForm(user);
        app.getUser().submitButton();


 //      Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//div[.='Wrong email format']")));

    }

    @Test
    public void registrationNegativeWrongPassword() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        User user = new User()
                .withName("Rita")
                .withLastName("Miller")
                .withEmail("rita" + i + "@mail.com")
                .withPassword("Volk1234");

        app.getUser().openRegistrationForm();
        app.getUser().fillRegistrationForm(user);
        app.getUser().submitButton();

    }

    @Test(dataProvider = "userDtoCsv", dataProviderClass = ProviderData.class)
    public void registrationPositiveDTO(User user){
//        int i = (int)(System.currentTimeMillis()/1000)%3600;
//        User user = new User()
//                .withName("Vova")
//                .withLastName("Volkov")
//                .withEmail("vova" + i + "@mail.com")
//                .withPassword("Volk1234$");

        app.getUser().openRegistrationForm();
        logger.info("openRegistrationForm invoked");
        app.getUser().fillRegistrationForm(user);
        logger.info("fillRegistrationForm invoked");
        app.getUser().submitButton();
        logger.info("submitButton invoked");
        logger.info("registrationPositive starts with credentials : " + user.getEmail()
                + " " + user.getPassword());
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//h2[contains(text(),'success')]")));

    }
        @AfterMethod(alwaysRun = true)
    public void postcondition(){
        if(app.getUser().isElementPresent(By.xpath("//button[.='Ok']"))) {
            app.getUser().click(By.xpath("//button[.='Ok']"));
         //      app.getUser().click(By.xpath("//button[@type='button']"));
        }

   }
}
