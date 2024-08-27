package les20Retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
    private int countRetry = 0;
    private int maxRetry = 3;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (countRetry < maxRetry) {
            countRetry++;
            return true;
        }
        return false;
    }
}
