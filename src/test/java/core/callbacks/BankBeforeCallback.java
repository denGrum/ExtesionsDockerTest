package core.callbacks;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class BankBeforeCallback implements BeforeAllCallback {

  @Override
  public void beforeAll(ExtensionContext context) throws Exception {
    Configuration.timeout = 4000;
    Configuration.browserSize = "1600x900";
    Configuration.headless = true;
    Configuration.baseUrl = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login";
  }
}
