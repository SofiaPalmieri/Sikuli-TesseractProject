package Pickled;


import java.util.ArrayList;
import java.util.List;

public class Client {

    private String name;
    private final List<Environment> environments = new ArrayList<Environment>();
    private final List<TestSuite> testSuites = new ArrayList<TestSuite>();

    public Client (String name){
        this.name = name;
    }

    public void addEnvironment(Environment environment){
        this.environments.add(environment);
    }

    public void addSuite(TestSuite suite){
        this.testSuites.add(suite);
    }


}
