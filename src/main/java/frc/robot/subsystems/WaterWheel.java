/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.RobotMap;
import frc.robot.commands.MoveWaterWheel;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class WaterWheel extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  TalonSRX waterWheel = new TalonSRX(RobotMap.WATER_WHEEL);
  DigitalInput magneticSensor = new DigitalInput(RobotMap.MAGNETIC_SENSOR);

  public void setSpeed(double speed)
  {
    //UNCOMMENT WHEN PART READY
    //waterWheel.set(ControlMode.PercentOutput, speed);
  }

  public boolean getSensor()
  {
    return magneticSensor.get();
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new MoveWaterWheel());
  }
}
