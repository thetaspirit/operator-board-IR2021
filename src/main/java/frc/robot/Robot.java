package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends TimedRobot {

  private final Joystick OperatorConsole = new Joystick(0);
  private boolean buttonPressed;
  private int buttonIndex;
  private int lastButtonPressed;

  @Override
  public void robotInit() {
    for(int i=1; i<=19; i++){ // turn off all lights
      OperatorConsole.setOutput(i, false); 
    }
  }

  @Override
  public void teleopInit() {
    this.buttonPressed = true;
    this.buttonIndex = 1;
    this.lastButtonPressed = 0; // intialize with no button pressed
    for(int i=1; i<=19; i++){ // turn off all lights
      OperatorConsole.setOutput(i, false); 
    }
  }

  @Override
  public void teleopPeriodic() {
    for(int i=1; i<=19; i++){ // check all the buttons and keep the highest that is pressed
      if (OperatorConsole.getRawButton(i)){
        this.lastButtonPressed = i;
      }  
    }
    SmartDashboard.putNumber("lastButtonPressed", this.lastButtonPressed);
    for(int i=1; i<=19; i++){
      if (i == this.lastButtonPressed){ 
        OperatorConsole.setOutput(i, true); // turn on the pressed button
      } else {
        OperatorConsole.setOutput(i, false); // turn off all others
      }
    }

 
//    if (buttonPressed) {
//      OperatorConsole.setOutput(buttonIndex, true);
//      buttonPressed = false;
//    }
//
//    if (OperatorConsole.getRawButton(buttonIndex)) {
//      OperatorConsole.setOutput(buttonIndex, false);
//     buttonPressed = true;
//      buttonIndex++;
//    }
  }
}
