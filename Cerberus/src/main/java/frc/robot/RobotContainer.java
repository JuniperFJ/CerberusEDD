// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import frc.robot.commands.TeleopCommand;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.WaitCommand;



public class RobotContainer {
 
  private static RobotContainer m_RobotContainer = new RobotContainer();



  // Driver Controller
  private final DriveSubsystem m_DriveSubsystem = new DriveSubsystem();

  private final XboxController m_driverController = new XboxController(0);

  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  }


  

  private void configureBindings() {
    
  }

  

  public static RobotContainer getInstance(){
    return m_RobotContainer;

  }

  public XboxController getControllerInput(){
    return m_driverController;

  }

    public Command getAutonomousCommand() {
    // The selected command will be run in autonomous
    return new WaitCommand(1);
  }

    public Command getTeleopCommand(){
      return new TeleopCommand(m_DriveSubsystem);

    }

}
