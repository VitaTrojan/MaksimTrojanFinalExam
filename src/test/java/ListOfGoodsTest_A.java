import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.IOException;
import java.util.List;

import static Data.DataGetter.getTestData;


@RunWith(Parameterized.class)
public class ListOfGoodsTest_A extends TestsHelper {
    private String item;
    private ListOfGoods listOfGoods = new ListOfGoods(driver);

    public ListOfGoodsTest_A(String item) {
        this.item = item;
    }

    @Parameterized.Parameters
    public static List<String> getA() throws IOException {
        return getTestData("src/main/resources/listOfGoods_A.txt");
    }

    @Test
    public void assertItemAvailability_A() {
        listOfGoods.assertItemAvailability(item, "In Stock");
    }
}

