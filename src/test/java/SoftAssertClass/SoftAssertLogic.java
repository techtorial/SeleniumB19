package SoftAssertClass;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertLogic {

    public int getSum(int number1,int number2){
        return number1+number2;
    }

    @Test
    public void hardAssert(){
        Assert.assertEquals(getSum(1,3),4);
        System.out.println("test1");
        Assert.assertEquals(getSum(3,8),10);
        System.out.println("test2");
        Assert.assertEquals(getSum(7,0),7);
        System.out.println("test3");
    }

    @Test
    public void softAssert(){
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(getSum(1,3),4);
        System.out.println("test1");
        softAssert.assertEquals(getSum(3,8),10);
        System.out.println("test2");
        softAssert.assertEquals(getSum(7,0),7);
        System.out.println("test3");
        softAssert.assertAll();
    }

}
