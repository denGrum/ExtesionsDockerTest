package core.callbacks;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class LoginBeforeCallback implements BeforeAllCallback {

  @Override
  public void beforeAll(ExtensionContext context) throws Exception {
    WebDriverManager.chromedriver().setup();
    Configuration.timeout = 5000;
    Configuration.browserSize = "1920x1080";
    Configuration.headless = false;
    Configuration.baseUrl = "https://crossbrowsertesting.github.io";
  }
}
