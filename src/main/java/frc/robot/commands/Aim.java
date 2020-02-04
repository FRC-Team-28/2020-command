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

public class Aim extends Command {
  public Aim() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.shooter);
  }

  public static final double TARGET_HEIGHT = 59;

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    Robot.shooter.moveWheel(1);
    System.out.println(Robot.limelight.getY() + " , " + calcDistance());

  }

  public static double calcDistance()
  {
    return (TARGET_HEIGHT - RobotMap.CAMERA_HEIGHT) / Math.tan(Math.PI/180 * (RobotMap.CAMERA_ANGLE + Robot.limelight.getY()));
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if(Robot.m_oi.getAuxillaryRawAxis(RobotMap.LEFT_TRIGGER) > 0.1)
    {
      return false;
    }
    else
      return true;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
