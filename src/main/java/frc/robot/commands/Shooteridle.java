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

public class Shooteridle extends Command {
  public Shooteridle() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.shooter);
  }

  Aim aim;
  Shoot shoot;

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    aim = new Aim();  
    shoot = new Shoot();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    if(Robot.m_oi.getAuxillaryRawAxis(RobotMap.LEFT_TRIGGER) > 0.1)
    {
      aim.start();
    }
    if(Robot.m_oi.getAuxillaryRawAxis(RobotMap.RIGHT_TRIGGER) > 0.1)
    {
      shoot.start();
    }

  }


  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
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