package TestNGConcept;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersLogic {

    @Parameters("firstname")
    @Test
    public void practice(String username){
        System.out.println(username);
    }
}
