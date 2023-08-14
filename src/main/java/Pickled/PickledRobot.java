package Pickled;

import PickledExceptions.PickledSUTException;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;

public class PickledRobot {

    private final Robot robot;

    public PickledRobot (){
        try {
            this.robot = new Robot();
        } catch (AWTException awtException) {
            throw new PickledSUTException();
        }
    }

    public BufferedImage getCurrentScreen(){
            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage originalCapture = this.robot.createScreenCapture(screenRect);
            BufferedImage capture = new BufferedImage(originalCapture.getWidth(), originalCapture.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
            capture.getGraphics().drawImage(originalCapture, 0, 0, null);
            return originalCapture;
    }

    public BufferedImage getCroppedScreen(Rectangle rectangle){
        return this.getCurrentScreen().getSubimage(rectangle.x,rectangle.y,rectangle.width,rectangle.height);
    }

    public Robot getRobot(){
        return this.robot;
    }

    public void moveTo(Rectangle rect) {
        this.robot.mouseMove(rect.x + rect.width/2, rect.y + rect.height/2);
    }

    public void click(){
        this.robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        this.robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }

    public void rightClick(){
        this.robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
        this.robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
    }


}
