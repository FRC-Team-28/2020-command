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
 * Add your docs here.
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

  public void set(double forwardInput, double lateralInput, double rotation){
    setFrontLeft(forwardInput, lateralInput, rotation);
    setFrontRight(forwardInput, lateralInput, rotation);
    setBackLeft(forwardInput, lateralInput, rotation);
    setBackRight(forwardInput, lateralInput, rotation);
  }

  public void setFrontLeft(double forwardInput, double lateralInput, double rotation)
  {
      fL.set(-1 * (forwardInput - lateralInput - rotation));
  }

  public void setFrontRight(double forwardInput, double lateralInput, double rotation)
  {
      fR.set(forwardInput + lateralInput + rotation);
  }

  public void setBackLeft(double forwardInput, double lateralInput, double rotation)
  {
      bL.set(-1 * (forwardInput + lateralInput - rotation));
  }

  public void setBackRight(double forwardInput, double lateralInput, double rotation)
  {
      bR.set(forwardInput - lateralInput + rotation);
  }

}
