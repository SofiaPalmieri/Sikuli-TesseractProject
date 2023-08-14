package Pickled;

interface ClickAction {
    void performClick(PickledRobot robot);
}

public enum ClickType {
    CLICK((PickledRobot robot) -> {
        robot.click();
    }),
    RIGHT_CLICK((PickledRobot robot) -> {
        robot.rightClick();
    }),

    DOUBLE_CLICK((PickledRobot robot) -> {
        robot.click();
        robot.click();
    });

    ClickType(ClickAction action) {
        this.action = action;
    }

    private final ClickAction action;

    public void doClick(PickledRobot robot) {
        this.action.performClick(robot);
    }
}
