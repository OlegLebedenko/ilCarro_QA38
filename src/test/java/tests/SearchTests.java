package tests;

import org.testng.annotations.Test;

public class SearchTests extends TestBase{


    @Test
    public void searchPositiveTest(){

      app.getSearch().fillSearchForm("Haifa", "07/18/2023", "03/23/2024");
      app.getSearch().pause(3000);
      app.getUser().submitButtonType();
    }
}
