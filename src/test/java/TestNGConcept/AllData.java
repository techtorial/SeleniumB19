package TestNGConcept;

import org.testng.annotations.DataProvider;

public class AllData {

    @DataProvider(name = "couples")
    public Object[][] getData(){
        return new Object[][]{
                {"Alex","Tanya"},
                {"Jay","Ashley"},
                {"Inna","Alex"},
                {"Olga","Igor"}
        };
    }
}
