package Pickled;

public class Environment {

    private String name;
    private OperatingSystem operatingSystem;
    private Client client;

    public Environment(String name, OperatingSystem operatingSystem, Client client){
        this.client = client;
        this.name = name;
        this.operatingSystem = operatingSystem;
    }

}
