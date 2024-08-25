package core.callbacks;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class WriteToFileCallback implements AfterAllCallback, AfterTestExecutionCallback {
  private static final List<String> testResults = new ArrayList<>();

  @Override
  public void afterAll(ExtensionContext context) throws Exception {
    Path filePath = Path.of(System.getProperty("user.dir"), "/src/test/resources/TestResults.txt");
    String resultText = String.join("\n", testResults);
    Files.writeString(filePath, resultText);
  }

  @Override
  public void afterTestExecution(ExtensionContext context) throws Exception {
    String className = context.getRequiredTestClass().getName();
    String methodName = context.getRequiredTestMethod().getName();
    String displayedName = context.getDisplayName();
    String testResult = context.getExecutionException().isEmpty() ? "PASSED" : "FAILED";
    testResults.add("%s.%s() '%s' - %s".formatted(className, methodName, displayedName, testResult));
  }
}
