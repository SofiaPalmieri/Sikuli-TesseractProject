package Pickled;

import PickledExceptions.PickledMissingFileException;
import PickledExceptions.PickledTimeOutException;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Match;
import org.sikuli.script.Screen;

import java.awt.*;


public class Image extends ScreenElement{

    private final String imageName;

    public Image(String imageName){
        this.imageName = imageName;
    }

    @Override
    public Rectangle find(double wait) throws PickledTimeOutException, PickledMissingFileException {

        Screen screen = new Screen();
        String imagePath = DependencyHandler.getInstance().getImage(this.imageName);

        long limit = this.getTimeoutLimit(wait);
        while (this.notTimedOut(limit)){
        try {
            Match m = screen.find(imagePath);
            return m.getRect();
        } catch (FindFailed ignored){

        }
        }
        throw new PickledTimeOutException();
    }




}
