package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot extends TimedRobot {

  @Override
  public void robotInit() {
    OperatorBoard.getInstance().BUTTON_ONE
        .toggleWhenPressed(new LightUpCommand(OperatorBoard.getInstance().BUTTON_ONE));
    OperatorBoard.getInstance().BUTTON_THREE.whileHeld(new LightUpCommand(OperatorBoard.getInstance().BUTTON_THREE));
  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();

  }

}
