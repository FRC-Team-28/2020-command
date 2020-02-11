/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.TalonFXSensorCollection;


import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.PID;
import frc.robot.Robot;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Shooter extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  
  PID pid = new PID(0,0,0,0);

  TalonFX shootControllerLeft = new TalonFX(RobotMap.SHOOTER_WHEEL_LEFT);
  TalonFX shootControllerRight = new TalonFX(RobotMap.SHOOTER_WHEEL_RIGHT);

  TalonFXSensorCollection sensorLeft = new TalonFXSensorCollection(shootControllerLeft);
  TalonFXSensorCollection sensorRight = new TalonFXSensorCollection(shootControllerRight);


  //TODO: rewrite this to reflect the fact that we have two wheels
  //also maybe write it so that the PID is in this class, not in Aim.java
  public void moveWheel(double leftSpeed, double rightSpeed)
  {
    shootControllerLeft.set(ControlMode.PercentOutput, leftSpeed);
    shootControllerRight.set(ControlMode.PercentOutput, rightSpeed);
  }

  public double[] getEncoderValues()
  {
    TalonFXSensorCollection sensorLeft = new TalonFXSensorCollection(shootControllerLeft);
    TalonFXSensorCollection sensorRight = new TalonFXSensorCollection(shootControllerRight);
    double [] output = {sensorLeft.getIntegratedSensorVelocity(), sensorRight.getIntegratedSensorVelocity()};
    return output;
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    //  setDefaultCommand(new Shooteridle());
 
 
  }
}
