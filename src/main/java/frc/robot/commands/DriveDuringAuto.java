/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class DriveDuringAuto extends Command {
  private long runTime;
  private long startTime;
  private long endTime;
  private double forwardSpeed, lateralSpeed, rotationSpeed;
  public DriveDuringAuto(long time, double forwardSpeed, double lateralSpeed, double rotationSpeed) {
    // Use requires() here to declare subsystem dependencies
    runTime = time;
    this.forwardSpeed = forwardSpeed;
    this.lateralSpeed = lateralSpeed;
    this.rotationSpeed = rotationSpeed;

    requires(Robot.macanumDrive);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    System.out.println("Starting Auto");
    startTime = System.currentTimeMillis();
    endTime = startTime + runTime; //runTime is in milliseconds
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.macanumDrive.set(forwardSpeed, lateralSpeed, rotationSpeed);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if(System.currentTimeMillis() >= endTime)
      return true;
    else
      return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.macanumDrive.set(0, 0, 0);
    System.out.println("Auto Complete");
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
