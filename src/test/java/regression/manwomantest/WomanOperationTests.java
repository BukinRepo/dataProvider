package regression.manwomantest;

import ManWoman.Man;
import ManWoman.Woman;
import dataproviders.DataProviderTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class WomanOperationTests {
    // ManWoman.Woman class have ony isRetired, registerPartnership, deregisterPartnership unique setting logic. All common test will be covered in PersonTest.PersonOperationTests
    private Man manSimple;
    private Man manRetired;
    private Woman womanSimple;
    private Woman womanRetired;
    private SoftAssert softAssert = new SoftAssert();
    @BeforeMethod
    @Parameters({"firstNameMan", "lastNameMan", "ageManSimple", "ageManRetired", "firstNameWoman", "lastNameWoman", "ageWomanSimple", "ageWomanRetired", "partner"})
    private void createPeople(String firstNameMan, String lastNameMan, int ageMan, int ageManRetired, String firstNameWoman, String lastNameWoman, int ageWomanSimple, int ageWomanRetired, String partner) {
        manSimple = new Man(firstNameMan, lastNameMan, ageMan, partner);
        manRetired = new Man(firstNameMan, lastNameMan, ageManRetired, partner);
        womanSimple = new Woman(firstNameWoman,lastNameWoman, ageWomanSimple, partner);
        womanRetired = new Woman(firstNameWoman,lastNameWoman, ageWomanRetired, partner);
    }

//    @Test
    @Test(dataProvider = "womanTestData", dataProviderClass = DataProviderTest.class)
    public void testWomanIsRetired(String firstNameWoman, String lastNameWoman, int ageWomanSimple, int ageWomanRetired, String womanPartner){
        womanSimple = new Woman(firstNameWoman,lastNameWoman, ageWomanSimple, womanPartner);
        womanRetired = new Woman(firstNameWoman,lastNameWoman, ageWomanRetired, womanPartner);
        softAssert.assertTrue(womanRetired.isRetired(), "Please check retired age");
        softAssert.assertFalse(womanSimple.isRetired(), "Please check retired boundary age");
        softAssert.assertAll();
    }

    @Test
    public void testWomanRegisterPartnership(){
        womanRetired.registerPartnership(manRetired);
        //Check Last name set.
        softAssert.assertEquals(womanRetired.getLastName(),manRetired.getLastName(), "ManWoman.Woman last name wasn't set");
        //Check partners for woman attribute are correctly set.
        softAssert.assertEquals(manRetired.getFirstName() + " " + manRetired.getLastName(),womanRetired.getPartner(),"Partners for ManWoman.Woman set wrong");
        //Check partners for man attribute are correctly set.
        softAssert.assertEquals(womanRetired.getFirstName() + " " + womanRetired.getLastName(), manRetired.getPartner(),"Partners for ManWoman.Man set wrong");
        softAssert.assertAll();
    }

    @Test
    public void testWomanDeregisterPartnership(){
        womanSimple.registerPartnership(manSimple);
        womanSimple.deregisterPartnership(true, manSimple);
        softAssert.assertEquals(womanSimple.getMaidenName(), womanSimple.getLastName(),"ManWoman.Woman maiden name set wrong");
        softAssert.assertEquals(womanSimple.getPartner(), "Single", "After divorce ManWoman.Woman partner attribute set wrong");
        softAssert.assertEquals(manSimple.getPartner(), "Single", "After divorce ManWoman.Man partner attribute set wrong");
        softAssert.assertAll();
    }
}
