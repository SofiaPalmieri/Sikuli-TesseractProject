package Pickled;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public abstract class TestCase {

private final List<RequiredParameter> requiredParameters = new ArrayList<>();
    abstract void setUp(Environment environment);

    abstract List<Result> execute(ParameterList parameters);

    abstract void tearDown();

    public List<RequiredParameter> getRequiredParameters(){
        return this.requiredParameters;
    }

    public Result step(String stepDescription, String expectedResult, Action action, String passMessage, String failMessage){
        ActionResult actionResult = action.run();
        BufferedImage image = new PickledRobot().getCurrentScreen();
        return new Result(actionResult.getActionResult(),stepDescription,expectedResult,passMessage,failMessage,actionResult.getExpectedImage(),image);
    }
}




