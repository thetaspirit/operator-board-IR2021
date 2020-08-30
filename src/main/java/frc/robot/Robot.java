package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;

public class Robot extends TimedRobot {

  private final Joystick OperatorConsole = new Joystick(0);
  private boolean buttonPressed;
  private int buttonIndex;

  @Override
  public void teleopInit() {
    this.buttonPressed = true;
    this.buttonIndex = 1;
  }

  @Override
  public void teleopPeriodic() {
    if (buttonPressed) {
      OperatorConsole.setOutput(buttonIndex, true);
      buttonPressed = false;
    }

    if (OperatorConsole.getRawButton(buttonIndex)) {
      OperatorConsole.setOutput(buttonIndex, false);
      buttonPressed = true;
      buttonIndex++;
    }
  }
}
