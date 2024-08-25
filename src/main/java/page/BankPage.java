package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class BankPage {
  String optionDropdownUserSelect = "//option[normalize-space(.)='%s']";
  SelenideElement blockMessage = $x("//span[@ng-show='message']");
  SelenideElement buttonCustomerLogin = $x("//button[@ng-click='customer()']");
  SelenideElement buttonDeposit = $x("//button[@ng-click='deposit()']");
  SelenideElement buttonSubmit = $x("//button[@type='submit']");
  SelenideElement dropdownUserSelect = $x("//select[@id='userSelect']");
  SelenideElement fieldInputAmount = $x("//input[@ng-model='amount']");


  public BankPage() {
    Selenide.open("");
  }

  @Step
  public BankPage checkMessageContainsText(String expectedText) {
    blockMessage
        .scrollTo()
        .shouldHave(Condition.text(expectedText));
    return this;
  }

  @Step("Нажать кнопку 'Customer Login'.")
  public BankPage clickOnButtonCustomerLogin() {
    buttonCustomerLogin
        .scrollTo()
        .click();
    return this;
  }

  @Step("Нажать кнопку 'Deposit'.")
  public BankPage clickOnButtonDeposit() {
    buttonDeposit
        .scrollTo()
        .click();
    return this;
  }

  @Step("Нажать кнопку подтверждения.")
  public BankPage clickOnButtonSubmit() {
    buttonSubmit
        .scrollTo()
        .click();
    return this;
  }

  @Step("Кликнуть по выпадающему меню выбора пользователя.")
  public BankPage clickOnDropdownUserSelect() {
    dropdownUserSelect
        .scrollTo()
        .click();
    return this;
  }

  @Step("Заполнить поле 'Amount' значением '{0}'.")
  public BankPage fillFieldAmount(String value) {
    fieldInputAmount
        .scrollTo()
        .click();
    fieldInputAmount
        .sendKeys(value);
    return this;
  }

  @Step("Выбрать пользователя с именем '{0}' в выпадающем списке.")
  public BankPage selectInDropdownUserWithName(String name) {
    $x(optionDropdownUserSelect.formatted(name))
        .scrollTo()
        .click();
    return this;
  }
}
