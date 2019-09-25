import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.io.IOException;
import java.util.List;
import static Data.DataGetter.getTestData;


@RunWith(Parameterized.class)
public class ListOfGoodsTest_B extends TestsHelper {
    private String item;
    private ListOfGoods listOfGoods = new ListOfGoods(driver);

    public ListOfGoodsTest_B(String item) {
        this.item = item;
    }

    @Parameterized.Parameters
    public static List<String> getB() throws IOException {
        return getTestData("src/main/resources/listOfGoods_B.txt");
    }

    @Test
    public void assertItemAvailability_B()  {
        listOfGoods.assertItemAvailability(item, "In Stock");
    }
}
