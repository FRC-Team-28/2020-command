/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Elevator extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  TalonSRX elevatorMotorLeft = new TalonSRX(RobotMap.ELEVATOR_LEFT);
  TalonSRX elevatorMotorRight = new TalonSRX(RobotMap.ELEVATOR_RIGHT);

  public void moveMotors(double speed)
  {
    //TODO figure out which one must be negated
    elevatorMotorLeft.set(ControlMode.PercentOutput, speed);
    elevatorMotorRight.set(ControlMode.PercentOutput, speed);

  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new Hang());
  }
}
