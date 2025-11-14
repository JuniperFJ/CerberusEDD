// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.DriveSubsystem;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj2.command.Command;



/** An example command that uses an example subsystem. */
public class TeleopCommand extends Command {

  private final DriveSubsystem m_driveSubsystem;

  public TeleopCommand(DriveSubsystem DriveSystem) {

    m_driveSubsystem = DriveSystem;
    addRequirements(m_driveSubsystem);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double Speed = 1;
    if(RobotContainer.getInstance().getControllerInput().getBButton()){
     Speed = 2; 
    }

    m_driveSubsystem.tankDriveRaw(RobotContainer.getInstance().getControllerInput().getLeftY()*Speed, RobotContainer.getInstance().getControllerInput().getRightY()*Speed);


  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }

  @Override
  public boolean runsWhenDisabled() {
      return false;
  }
}
