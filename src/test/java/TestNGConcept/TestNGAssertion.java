package TestNGConcept;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGAssertion {

    public int multiplication(int number,int number2){
        return number*number2;
    }

    @Test
    public void validateMultiplication(){
        int actualResult=multiplication(3,4);
        int expectedResult=12;
        System.out.println(actualResult==expectedResult ? "Passed" : "Failed");
        Assert.assertEquals(actualResult,expectedResult,"Check the multiplication");
    }

    @Test
    public void validateZeroLogic(){
        int actualResult=multiplication(999999,0);
        int expectedResult=0;
        Assert.assertEquals(actualResult,expectedResult);
        Assert.assertTrue(actualResult==expectedResult);
    }
}
