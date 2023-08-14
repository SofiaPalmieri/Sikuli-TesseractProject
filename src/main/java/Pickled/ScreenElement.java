package Pickled;

import PickledExceptions.PickledSUTException;
import PickledExceptions.PickledTimeOutException;

import java.awt.*;

public abstract class ScreenElement {

    public void click(double timeout,ClickType type) throws PickledSUTException, PickledTimeOutException {
        Rectangle rect = this.find(timeout);
        PickledRobot robot = new PickledRobot();
        robot.moveTo(rect);
        type.doClick(robot);
    }

    public void move(double timeout) throws PickledSUTException, PickledTimeOutException {
        Rectangle rect = this.find(timeout);
        new PickledRobot().moveTo(rect);
    }

    public boolean found(double timeout) throws PickledSUTException{
        try {
            Rectangle rect = this.find(timeout);
            return true;
        } catch (PickledTimeOutException p) {
            return false;
        }
    }

    public void dragTo(ScreenElement scr){

    }

    public long getTimeoutLimit(double wait){
        long t= System.currentTimeMillis();
        long MILLISECONDS_IN_SECOND = 1000;
        return (long) (t+wait * MILLISECONDS_IN_SECOND);
    }

    public boolean notTimedOut(long limit){
        return System.currentTimeMillis() < limit;
    }

    public abstract Rectangle find(double timeout) throws PickledTimeOutException;

}
