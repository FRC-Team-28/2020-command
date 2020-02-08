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
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Shooter extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  PID pid = new PID(0,0,0,0);
  //TalonSRX shooterWheel = new TalonSRX(RobotMap.SHOOTER_WHEEL);
  TalonFX shootController1 = new TalonFX(RobotMap.SHOOTER_WHEEL);
  TalonFX shootController2 = new TalonFX(8);


  public void moveWheel(double speed)
  {
    //UNCOMMENT WHEN PART READY
    //shooterWheel.set(ControlMode.PercentOutput, pid.update(speed));
    shootController1.set(ControlMode.PercentOutput, speed);
    shootController2.set(ControlMode.PercentOutput, speed);
  }

  public double[] getEncoderValues()
  {
    TalonFXSensorCollection sensor1 = new TalonFXSensorCollection(shootController1);
    TalonFXSensorCollection sensor2 = new TalonFXSensorCollection(shootController2);
    double [] output = {sensor1.getIntegratedSensorVelocity(), sensor2.getIntegratedSensorVelocity()};
    return output;
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    //  setDefaultCommand(new Shooteridle());
 
 
  }
}
