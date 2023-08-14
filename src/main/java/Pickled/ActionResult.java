package Pickled;

import java.awt.image.BufferedImage;

public class ActionResult {
    BufferedImage image;
    Boolean actionResult;

    public ActionResult(BufferedImage image, Boolean actionResult){
        this.image = image;
        this.actionResult = actionResult;
    }

    public BufferedImage getExpectedImage() {
        return this.image;
    }

    public Boolean getActionResult(){
        return this.actionResult;
    }

}
