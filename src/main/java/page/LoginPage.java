package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import page.enums.InternalPages;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
  String link = "//a[@href='%s']";
  SelenideElement fieldInputUsername = $x("//input[@id='username']");
  SelenideElement fieldInputPassword = $x("//input[@id='password']");
  SelenideElement buttonLogin = $x("//button[@id='submit']");
  SelenideElement blockTextLoggedIn = $x("""
      //p[@id='logged-in' and normalize-space(.) = 'You are now logged in!']
      """);

  public LoginPage() {
    Selenide.open("");
  }

  @Step("Проверить, что пользователь залогинился.")
  public LoginPage checkUserIsLoggedIn() {
    blockTextLoggedIn.shouldBe(Condition.visible);
    return this;
  }

  @Step("Кликнуть по кнопке 'Login'.")
  public LoginPage clickOnButtonLogin() {
    buttonLogin
        .scrollTo()
        .click();
    return this;
  }

  @Step("Кликнуть по полю 'Username'.")
  public LoginPage clickOnFieldUsername() {
    fieldInputUsername
        .scrollTo()
        .click();
    return this;
  }

  @Step("Кликнуть по полю 'Password'.")
  public LoginPage clickOnFieldPassword() {
    fieldInputPassword
        .scrollTo()
        .click();
    return this;
  }

  @Step("Заполнить поле 'Username' текстом '{0}'.")
  public LoginPage fillFieldUsername(String text) {
    fieldInputUsername
        .scrollTo()
        .sendKeys(text);
    return this;
  }

  @Step("Заполнить поле 'Password' текстом '{0}'.")
  public LoginPage fillFieldPassword(String text) {
    fieldInputPassword
        .scrollTo()
        .sendKeys(text);
    return this;
  }

  @Step("Выбрать тестовую страницу '{0}'.")
  public LoginPage selectInternalPage(InternalPages page) {
    $x(link.formatted(page))
        .scrollTo()
        .click();
    return this;
  }
}
