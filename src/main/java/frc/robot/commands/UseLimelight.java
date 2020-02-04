/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.PID;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class UseLimelight extends Command {
  public UseLimelight() {
    // Use requires() here to declare subsystem dependentestcies
    requires(Robot.limelight);
  }

  PID pid;

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    //pid = new PID(.05,0.05,.12,0);
    pid = new PID(.05,0,0,0);

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    double x = Robot.limelight.getNetworkTableEntry("tx");
    Robot.macanumDrive.set(Robot.m_oi.getDriverRawAxis(RobotMap.LEFT_STICK_Y),Robot.m_oi.getDriverRawAxis(RobotMap.LEFT_STICK_X),-pid.update(x));
    

    System.out.println(x);


  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if(Robot.m_oi.getDriverButton(RobotMap.A_BUTTON))
      return false;
    else
      return true;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    System.out.println("OFF");
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
