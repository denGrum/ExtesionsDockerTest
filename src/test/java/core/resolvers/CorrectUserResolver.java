package core.resolvers;

import core.annotations.CorrectUser;
import models.User;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

public class CorrectUserResolver implements ParameterResolver {
  private static final String USERNAME = "tester@crossbrowsertesting.com";
  private static final String PASSWORD = "test123";

  @Override
  public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
    return parameterContext.isAnnotated(CorrectUser.class);
  }

  @Override
  public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
    Class<?> type = parameterContext.getParameter().getType();
    if (User.class.equals(type)) {
      return new User()
          .setUsername(USERNAME)
          .setPassword(PASSWORD);
    }
    throw new ParameterResolutionException("Неверный тип данных параметра метода!");
  }
}
