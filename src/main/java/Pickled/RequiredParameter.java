package Pickled;

public record RequiredParameter(String name, Type type) {
}

enum Type {
    INTEGER,
    DATE,
    FLOAT,
    STRING
}
