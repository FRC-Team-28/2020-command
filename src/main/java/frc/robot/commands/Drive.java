/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class Drive extends Command {
  public Drive() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.macanumDrive);

  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() 
  {
    double leftStickY = Robot.m_oi.getDriverRawAxis(RobotMap.LEFT_STICK_Y);
    double leftStickX = Robot.m_oi.getDriverRawAxis(RobotMap.LEFT_STICK_X);
    double triggerValue = Robot.m_oi.getDriverRawAxis(RobotMap.RIGHT_TRIGGER) - Robot.m_oi.getDriverRawAxis(RobotMap.LEFT_TRIGGER);

    Robot.macanumDrive.setFrontLeft(leftStickY, leftStickX, triggerValue);
    Robot.macanumDrive.setFrontRight(leftStickY, leftStickX, triggerValue);
    Robot.macanumDrive.setBackLeft(leftStickY, leftStickX, triggerValue);
    Robot.macanumDrive.setBackRight(leftStickY, leftStickX, triggerValue);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() 
  {
    Robot.macanumDrive.setFrontLeft(0,0,0);
    Robot.macanumDrive.setFrontRight(0,0,0);
    Robot.macanumDrive.setBackLeft(0,0,0);
    Robot.macanumDrive.setBackRight(0,0,0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() 
  {
    this.end();
  }
}
