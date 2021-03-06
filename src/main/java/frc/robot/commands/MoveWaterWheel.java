/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class MoveWaterWheel extends Command {
  public MoveWaterWheel() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.waterWheel);
  }

  boolean notYetMoved;

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    notYetMoved = true;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(!Robot.waterWheel.getMagneticSensor())
      notYetMoved = false;

    if(!notYetMoved && Robot.waterWheel.getMagneticSensor())
      Robot.waterWheel.setSpeed(0);
    else
      Robot.waterWheel.setSpeed(0.1);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if(Robot.waterWheel.getMagneticSensor() && !notYetMoved)
      return true;
    else
      return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.waterWheel.setSpeed(0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
