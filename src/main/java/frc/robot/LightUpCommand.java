// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.OperatorBoard.OperatorBoardButton;

/**
 * Simple command that turns button's light on when command initialized, and off
 * when command ended.
 */
public class LightUpCommand extends CommandBase {
  OperatorBoardButton m_button;

  public LightUpCommand(OperatorBoardButton button) {
    m_button = button;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_button.turnLightOn();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_button.turnLightOff();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
