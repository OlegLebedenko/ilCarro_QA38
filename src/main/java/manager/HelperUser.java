package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperUser extends HelperBase{
    public HelperUser(WebDriver wd) {

        super(wd);
    }

    public void openLoginForm(){

        wd.findElement(By.xpath("//a[.=' Log in ']")).click();
    }
    public void openRegistrationForm(){

        wd.findElement(By.xpath("//a[.=' Sign up ']")).click();
    }

    public void fillLoginForm(String email, String password){
        type(By.xpath("//input[@id='email']"),email);
        type(By.xpath("//input[@id='password']"),password);

    }
    public void fillLoginForm(User user){
        type(By.xpath("//input[@id='email']"),user.getEmail());
        type(By.xpath("//input[@id='password']"),user.getPassword());

    }
    public void fillRegistrationForm(User user){
        type(By.xpath("//input[@id='name']"),user.getName());
        type(By.xpath("//input[@id='lastName']"),user.getLastName());
        type(By.xpath("//input[@id='email']"),user.getEmail());
        type(By.xpath("//input[@id='password']"),user.getPassword());
        click(By.cssSelector("label[for='terms-of-use']"));

    }


    public void submitButton(){

        click(By.xpath("//*[.=\"Y’alla!\"]"));
    }
    public void submitButtonType(){

        wd.findElement(By.xpath("//button[@type='submit']")).submit();
    }

    public void logout(){

        click(By.xpath("//a[.=' Logout ']"));
    }

    public boolean isLogged(){
        return isElementPresent(By.xpath("//a[.=' Logout ']"));

    }

    public void login(User user){
        openLoginForm();
        fillLoginForm(user);
        submitButton();
        click(By.xpath("//button[.='Ok']"));

    }




}
