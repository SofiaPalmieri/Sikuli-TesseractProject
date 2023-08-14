package Pickled;

import PickledExceptions.PickledException;

import java.util.*;

public class TestSuite {

    private final Environment environment;
    private List<TestCase> testCases = new ArrayList<TestCase>();
    private final Map<TestCase, ParameterList> parameters = new HashMap<>();

    private final Loader loader;


    public TestSuite(Environment environment, List<TestCase> testCase, Loader loader){
        this.environment = environment;
        this.testCases = testCase;
        this.loader = loader;
    }

    public void runSuite(){
        for (TestCase testCase : testCases) {
            testCase.setUp(this.environment);
            List<Result> result = testCase.execute(this.getParametersFor(testCase));
            testCase.tearDown();
            this.loader.loadResult(this,testCase,result);
        }
    }

    private ParameterList getParametersFor(TestCase testCase) {
        return this.parameters.get(testCase);
    }

    public void setParametersFor(TestCase testCase, ParameterList parameters){
        this.parameters.put(testCase,parameters);
    }

    public void addTestCase(TestCase testCase){
        this.testCases.add(testCase);
    }

    public void removeTestCase(TestCase testCase){
        this.testCases.remove(testCase);
    }





}
