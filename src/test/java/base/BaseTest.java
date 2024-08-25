package base;

import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

  @BeforeAll
  static void prepareWebDriver() {
    WebDriverManager.chromedriver().setup();
  }

  @AfterEach
  void closeWebDriver() {
    Selenide.closeWebDriver();
  }
}
