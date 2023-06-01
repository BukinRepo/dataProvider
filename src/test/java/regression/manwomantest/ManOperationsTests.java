package regression.manwomantest;

import ManWoman.Man;
import dataproviders.DataProviderTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ManOperationsTests {
    // ManWoman.Man class have ony isRetired unique setting logic. All common test will be covered in PersonTest.PersonOperationTests
    private Man manSimple;
    private Man manRetired;
    private SoftAssert softAssert = new SoftAssert();

//    @BeforeMethod
//    @Parameters({"firstNameMan", "lastNameMan", "ageManSimple", "ageManRetired", "partner"})
//    private void createPeople(String firstNameMan, String lastNameMan, int ageManSimple, int ageManRetired, String partner) {
//        manSimple = new Man(firstNameMan, lastNameMan, ageManSimple, partner);
//        manRetired = new Man(firstNameMan, lastNameMan, ageManRetired, partner);
//    }
//    @Test
    @Test(dataProvider = "manTestData", dataProviderClass = DataProviderTest.class)
//    @Parameters({"firstNameMan", "lastNameMan", "partner"})
    public void testManIsRetired(String firstNameMan, String lastNameMan, int ageManSimple, int ageManRetired, String manPartner){
        manSimple = new Man(firstNameMan, lastNameMan, ageManSimple, manPartner);
        manRetired = new Man(firstNameMan, lastNameMan, ageManRetired, manPartner);
        softAssert.assertTrue(manRetired.isRetired(), "Please check retired age");
        softAssert.assertFalse(manSimple.isRetired(), "Please check retired boundary age");
        softAssert.assertAll();
    }
}
