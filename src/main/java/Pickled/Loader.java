package Pickled;

import java.util.List;

public interface Loader {
    void loadResult(TestSuite suite, TestCase testCase, List<Result> testResult);
}
