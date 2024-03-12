package TestNGConcept;

import org.testng.annotations.*;

public class TestNGAnnotations {
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("I am a beforeSuite Annotation");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("I am a beforeTest annotation");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("I am a beforeCLass annotation"); //clearing cache
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("I am a beforeMethod annotation");
    }
    @Test
    public void test1(){
        System.out.println("I am a test 1 annotation");
    }
    @Test
    public void test2(){
        System.out.println("I am a test 2 annotation");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("I am an afterMethod annotation");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("I am an afterclass annotation");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("I am an afterTest Annotation");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("I am an afterSuite annotation");
    }
}
