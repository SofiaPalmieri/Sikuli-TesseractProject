package Pickled;

import java.util.*;


public class ParameterList {

    Map<String,Object> parameters = new HashMap<>();

    public void addParameter(String name, Object param){
        this.parameters.put(name,param);
    }

    public <T> T getParameter(String paramName, Class<T> type){
        Object value = this.parameters.get(paramName);
        return type.cast(value);
    }

}
