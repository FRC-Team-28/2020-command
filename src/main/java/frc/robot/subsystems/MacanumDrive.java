/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.Drive;

/**
 * Scottish mecanum drive subsystem
 */
public class MacanumDrive extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.


  //TODO - Change this to TalonFX objects
  private Spark bL = new Spark(RobotMap.BL_MOTOR);
	private Spark bR = new Spark(RobotMap.BR_MOTOR);
	private Spark fL = new Spark(RobotMap.FL_MOTOR);
  private Spark fR = new Spark(RobotMap.FR_MOTOR);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new Drive());
  }

  /**
   * sets all the motor speeds, drives the robot
   * @param forwardInput range from -1 to 1, positive is forwards
   * @param lateralInput range from -1 to 1, positive is right
   * @param rotation range from -1 to 1, positive is clockwise (right)
   */
  public void set(double forwardInput, double lateralInput, double rotation){
    setFrontLeft(forwardInput, lateralInput, rotation);
    setFrontRight(forwardInput, lateralInput, rotation);
    setBackLeft(forwardInput, lateralInput, rotation);
    setBackRight(forwardInput, lateralInput, rotation);
  }

  private void setFrontLeft(double forwardInput, double lateralInput, double rotation)
  {
      fL.set(-1 * (forwardInput - lateralInput - rotation));
  }

  private void setFrontRight(double forwardInput, double lateralInput, double rotation)
  {
      fR.set(forwardInput + lateralInput + rotation);
  }

  private void setBackLeft(double forwardInput, double lateralInput, double rotation)
  {
      bL.set(-1 * (forwardInput + lateralInput - rotation));
  }

  private void setBackRight(double forwardInput, double lateralInput, double rotation)
  {
      bR.set(forwardInput - lateralInput + rotation);
  }

}
