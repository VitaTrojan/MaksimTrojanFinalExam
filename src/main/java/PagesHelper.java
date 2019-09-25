import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class PagesHelper {
    protected WebDriver driver;

    public PagesHelper(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
