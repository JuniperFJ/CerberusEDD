// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Spark;





public class DriveSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  private Spark m_MotorLeft1;
  private Spark m_MotorRight1;
  private Spark m_MotorLeft2 ;
  private Spark m_MotorRight2;
  private DifferentialDrive driveMotorGroup;
  private MotorControllerGroup RightMotors;
  private MotorControllerGroup LeftMotors;

  public DriveSubsystem() {
    m_MotorLeft1 = new Spark(Constants.Ports.LeftDrive1Port); 
      addChild("m_LeftDrive1",m_MotorLeft1);
      m_MotorLeft1.setInverted(Constants.Inverted.LeftDriveMotor1);

    m_MotorRight1 = new Spark(Constants.Ports.RightDrive1Port);
      addChild("m_RightDrive1",m_MotorRight1);
      m_MotorLeft1.setInverted(Constants.Inverted.RightDriveMotor1);
    
    m_MotorLeft2 = new Spark(Constants.Ports.LeftDrive2Port);
      addChild("m_LeftDrive2",m_MotorLeft2);
      m_MotorLeft2.setInverted(Constants.Inverted.LeftDriveMotor2);
  
    m_MotorRight2 = new Spark(Constants.Ports.RightDrive2Port);
      addChild("m_RightDrive2",m_MotorRight2);
      m_MotorRight2.setInverted(Constants.Inverted.RightDriveMotor2);


    RightMotors = new MotorControllerGroup(m_MotorRight1,m_MotorRight2);
    LeftMotors  = new MotorControllerGroup(m_MotorLeft1, m_MotorLeft2);

    driveMotorGroup = new DifferentialDrive(LeftMotors, RightMotors);
      addChild("DriveMotorGroup",driveMotorGroup);
    driveMotorGroup.setSafetyEnabled(true);
    driveMotorGroup.setExpiration(0.1);
    driveMotorGroup.setMaxOutput(1.0);
    
  }

  /**
   * Example command factory method.
   *
   * @return a command
   */
  public Command exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  public void tankDriveRaw(double leftSpeed, double rightSpeed){
    driveMotorGroup.tankDrive(Math.sqrt(Constants.DRIVE_SPEED) * leftSpeed, Math.sqrt(Constants.DRIVE_SPEED) * rightSpeed);
  }
}
