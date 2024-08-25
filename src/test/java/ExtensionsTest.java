import base.BaseTest;
import core.annotations.CorrectUser;
import core.annotations.IncorrectUser;
import core.callbacks.BankBeforeCallback;
import core.callbacks.LoginBeforeCallback;
import core.callbacks.WriteToFileCallback;
import core.resolvers.CorrectUserResolver;
import core.resolvers.IncorrectUserResolver;
import models.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import page.BankPage;
import page.LoginPage;
import page.enums.InternalPages;

@ExtendWith(WriteToFileCallback.class)
public class ExtensionsTest extends BaseTest {
  private static void checkUserLoggedIn(User user) {
    new LoginPage()
        .selectInternalPage(InternalPages.LOGIN_FORM)
        .clickOnFieldUsername()
        .fillFieldUsername(user.getUsername())
        .clickOnFieldPassword()
        .fillFieldPassword(user.getPassword())
        .clickOnButtonLogin()
        .checkUserIsLoggedIn();
  }

  @Nested
  @ExtendWith({CorrectUserResolver.class, IncorrectUserResolver.class, LoginBeforeCallback.class})
  class LoginClass {
    @BeforeAll
    static void prepareTestData() {
      System.out.println("Отработал коробочный колбэк.");
    }

    @Test
    @DisplayName("Пользователь должен успешно авторизоваться.")
    void correctTest(@CorrectUser User correctUser) {
      checkUserLoggedIn(correctUser);
    }

    @Test
    @DisplayName("Пользователь не должен авторизоваться.")
    void incorrectTest(@IncorrectUser User incorrectUser) {
      checkUserLoggedIn(incorrectUser);
    }
  }

  @Nested
  @ExtendWith(BankBeforeCallback.class)
  class BankClass {
    @Test
    @DisplayName("Пополнить счет.")
    void depositToAccount() {
      String userName = "Ron Weasly";
      String depositAmount = "150";
      String messageText = "Deposit Successful";

      new BankPage()
          .clickOnButtonCustomerLogin()
          .clickOnDropdownUserSelect()
          .selectInDropdownUserWithName(userName)
          .clickOnButtonSubmit()
          .clickOnButtonDeposit()
          .fillFieldAmount(depositAmount)
          .clickOnButtonSubmit()
          .checkMessageContainsText(messageText);
    }
  }
}
