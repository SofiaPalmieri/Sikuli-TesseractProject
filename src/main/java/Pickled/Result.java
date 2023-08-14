package Pickled;


import java.awt.image.BufferedImage;

public class Result {

    private final Boolean pass;
    private final BufferedImage expectedImage;
    private final String stepDescription;
    private final String expectedResult;
    private final String passMessage;
    private final String failMessage;

    private final BufferedImage capturedImage;


    public Result(Boolean pass, String stepDescription, String expectedResult, String passMessage, String failMessage, BufferedImage expectedImage, BufferedImage capturedImage){
        this.pass = pass;
        this.stepDescription = stepDescription;
        this.expectedResult = expectedResult;
        this.passMessage = passMessage;
        this.failMessage = failMessage;
        this.expectedImage = expectedImage;
        this.capturedImage = capturedImage;
    }

    public BufferedImage getExpectedImage() {
        return expectedImage;
    }

    public String getFailMessage() {
        return failMessage;
    }

    public String getPassMessage() {
        return passMessage;
    }

    public String getExpectedResult() {
        return expectedResult;
    }

    public String getStepDescription() {
        return stepDescription;
    }

    public BufferedImage getCapturedImage(){return capturedImage;}

    public Boolean getPass() {
        return pass;
    }
}
