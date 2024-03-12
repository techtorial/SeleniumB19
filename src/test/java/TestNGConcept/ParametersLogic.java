package TestNGConcept;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersLogic {

    @Parameters("firstname")
    @Test
    public void practice(String username){
        System.out.println(username);
    }
    @Parameters({"firstName","lastName","zipCode"})
    @Test
    public void multiplePractice(String lastName,String firstName,String zipCode){
        System.out.println(firstName);
        System.out.println(lastName);
        System.out.println(zipCode);
    }
}
