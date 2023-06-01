package regression.persontest;

import ManWoman.Man;
import ManWoman.Woman;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PersonGetterSetterOperationTests {
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
    @Test
    @Parameters({"ageManRetired"})
    public void testPersonGetAge(int ageManRetired){
        softAssert.assertEquals(manRetired.getAge(), ageManRetired, "Age get wrong");
        softAssert.assertAll();
    }

    @Test
    @Parameters({"setAge"})
    public void testPersonSetAge(int setAge){
        manSimple.setAge(setAge);
        softAssert.assertEquals(manSimple.getAge(), setAge, "Age set wrong");
        softAssert.assertAll();
    }

    @Test
    @Parameters({"firstNameWoman"})
    public void testPersonGetFirstName(String firstNameWoman){
        softAssert.assertEquals(womanSimple.getFirstName(), firstNameWoman, "FirstName get wrong");
        softAssert.assertAll();
    }

    @Test
    @Parameters({"lastNameWoman"})
    public void testPersonGetLastName(String lastNameWoman){
        softAssert.assertEquals(womanRetired.getLastName(), lastNameWoman, "LastName get wrong");
        softAssert.assertAll();
    }

    @Test
    @Parameters({"setLastName"})
    public void testPersonSetLastName(String setLastName){
        manSimple.setLastName(setLastName);
        softAssert.assertEquals(manSimple.getLastName(), setLastName, "LastName set wrong");
        softAssert.assertAll();
    }

    @Test
    @Parameters({"partner"})
    public void testPersonGetPartner(String partner){
        softAssert.assertEquals(manSimple.getPartner(), partner, "Partner get wrong");
        softAssert.assertAll();
    }

    @Test
    @Parameters({"testPartner"})
    public void testPersonSetPartner(String testPartner){
        manRetired.setPartner(testPartner);
        softAssert.assertEquals(manRetired.getPartner(), testPartner, "Partner set wrong");
        softAssert.assertAll();
    }

    @Test
    public void testPersonSetRetired(){
        softAssert.assertEquals(womanSimple.isRetired().booleanValue(), false, "Main logic isRetired method wrong");
        womanSimple.setRetired(true);
        softAssert.assertEquals(womanSimple.isRetired().booleanValue(), true, "Retired set wrong");
        softAssert.assertAll();
    }


    @Test
    @Parameters({"lastNameWoman"})
    public void testWomanGetMaidenName(String lastNameWoman){
        womanSimple.registerPartnership(manSimple);
        softAssert.assertEquals(womanSimple.getMaidenName(), lastNameWoman);
        softAssert.assertAll();
    }
}
