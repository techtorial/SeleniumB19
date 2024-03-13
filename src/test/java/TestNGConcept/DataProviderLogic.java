package TestNGConcept;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderLogic{

//    @DataProvider(name = "couples")
//    public Object[][] getData(){
//        return new Object[][]{
//                {"Alex","Tanya"},
//                {"Jay","Ashley"},
//                {"Inna","Alex"},
//                {"Olga","Igor"}
//        };
//    }

    @Test(dataProvider = "couples",dataProviderClass = AllData.class)
    public void couple1(String first,String second){
        System.out.println(first + second);
    }

//    @Test
//    public void couple2(){
//        System.out.println("Jay" + "Ashley");
//    }
//
//    @Test
//    public void couple3(){
//        System.out.println("Inna" + "Alex");
//    }
//
//    @Test
//    public void couple4(){
//        System.out.println("Olga" + "Igor");
//    }
}
