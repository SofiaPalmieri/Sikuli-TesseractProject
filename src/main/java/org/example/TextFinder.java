package org.example;


import Pickled.*;
import PickledExceptions.PickledTimeOutException;

public class TextFinder {


    public static void main(String[] args) throws PickledTimeOutException {
        DependencyHandler.getInstance().loadDependencies();
        new Text("Learning").click(5,ClickType.CLICK);
    }
}
