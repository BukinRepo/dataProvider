package dataproviders;

import models.ManModel;
import models.WomanModel;
import org.testng.annotations.DataProvider;

import static utils.CsvReader.getListAgesFromCsv;

public class DataProviderTest {

    private static final String MANPATH = "src\\test\\resources\\managestestdata.csv";
    private static final String WOMANPATH = "src\\test\\resources\\womanagestestdata.csv";

    @DataProvider(name = "manTestData")
    public static Object[][] manTestData(){
//        List<ManModel> manTestData = getListAgesFromCsv(MANPATH);
//        Object[][] objects = new Object[manTestData.size()][5];
//        for (int i = 0; i < manTestData.size(); i++) {
//            objects[i][0] = manTestData.get(i).getFirstNameMan();
//            objects[i][1] = manTestData.get(i).getLastNameMan();
//            objects[i][2] = manTestData.get(i).getSimpleMan();
//            objects[i][3] = manTestData.get(i).getRetiredMan();
//            objects[i][4] = manTestData.get(i).getPartner();
//        }
        return getListAgesFromCsv(MANPATH, ManModel.class).
                stream().map(value -> new Object[]{value.getFirstNameMan(),value.getLastNameMan(), value.getSimpleMan(), value.getRetiredMan(), value.getManPartner()})
                .toArray(Object[][]::new);
    }

    @DataProvider(name = "womanTestData")
    public static Object[][] womanTestData(){
        return getListAgesFromCsv(WOMANPATH, WomanModel.class).
                stream().map(value -> new Object[]{value.getFirstNameWoman(),value.getLastNameWoman(), value.getAgeWomanSimple(), value.getAgeWomanRetired(), value.getWomanPartner()})
                .toArray(Object[][]::new);
    }
}
