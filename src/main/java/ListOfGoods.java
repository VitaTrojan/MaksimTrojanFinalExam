import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.junit.ComparisonFailure;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class ListOfGoods extends PagesHelper {
    @FindBy(xpath = "//ul[@class='nav navbar-nav']/li/a")
    private List<WebElement> navItems;
    @FindBy(xpath = "//ul[@class='nav navbar-nav']")
    private List<WebElement> nav;
    @FindBy(css = ".product-layout img")
    private List<WebElement> listOfProducts;
    @FindBy(xpath = "//li[contains(text(),'Availability:')]")
    private WebElement availabilityInformation;
    @FindBy(css = ".breadcrumb li:nth-child(2)")
    private WebElement tabName;

    public String getTabName() {
        return tabName.getText();
    }

    @FindBy(css = ".breadcrumb li:nth-child(3)")
    private WebElement productName;

    public String getproductName() {
        return productName.getText();
    }
    public ListOfGoods(WebDriver driver) {
        super(driver);
    }


    private String getAvailabilityInfoMessage() {
        return availabilityInformation.getText().replace("Availability: ", "");
    }

    void assertItemAvailability(String item, String expectedAvailabilityInfoMessage) {
        for (int i = 0; i < navItems.size(); i++) {
            if (item.equals(navItems.get(i).getText())) {
                navItems.get(i).click();
                int y = 0;
                while (y < listOfProducts.size()) {
                    listOfProducts.get(y).click();
                    // softly - po failo eina prie kito parametro
//                    SoftAssertions softly = new SoftAssertions();
//                    softly.assertThat(getAvailabilityInfoMessage())
//                            .as(getproductName() + " in " + getTabName() + ". Expected: " + expectedAvailabilityInfoMessage + ", but was: " + getAvailabilityInfoMessage())
//                            .isEqualTo(expectedAvailabilityInfoMessage);
//                    softly.assertAll();

                    // normal assert
                    Assert.assertEquals(getproductName() + " in " + getTabName() + ". Expected: " + expectedAvailabilityInfoMessage + ", but was: " + getAvailabilityInfoMessage()
                            , expectedAvailabilityInfoMessage, getAvailabilityInfoMessage());
                    driver.navigate().back();
                    y++;
                }
            }
        }
    }
}
/*
 nesugalvoju kaip metoda padaryti be asserto. Jei gaunu String List tada klaidos pranesimas negrazus, jei String tada tik viena gaunu.
 Nesigauna kad testas eitu toliau pagaves faila. po fail, ima kita parametra. Bandziau try/cach, expected=error.clasa, softly assert
 */
