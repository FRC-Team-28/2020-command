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
 * The subsystem for the waterwheel
 */
public class WaterWheel extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  TalonSRX waterWheel = new TalonSRX(RobotMap.WATER_WHEEL);
  DigitalInput magneticSensor = new DigitalInput(RobotMap.MAGNETIC_SENSOR);
  DigitalInput springSensor[] = {new DigitalInput(RobotMap.SPRING_SENSOR1),new DigitalInput(RobotMap.SPRING_SENSOR2),new DigitalInput(RobotMap.SPRING_SENSOR3),
                                 new DigitalInput(RobotMap.SPRING_SENSOR4),new DigitalInput(RobotMap.SPRING_SENSOR5),new DigitalInput(RobotMap.SPRING_SENSOR6)};


  /**
   * directly sets the speed of the waterwheel. You probably don't want to use this. Use the MoveWaterWheel command instead.
   * @param speed the speed of the water wheel. range -1 to 1.
   */
  public void setSpeed(double speed)
  {
    //UNCOMMENT WHEN PART READY
    //waterWheel.set(ControlMode.PercentOutput, speed);
  }

  /**
   * gets the number of balls currently in the shhoter. calculated by counting the number of ball sensors that are on.
   * @return the number of balls in the shooter
   */
  public int ballCounter()
  {
    int count = 0;
    for(int i = 0; i < springSensor.length; i++)
    {
      if(springSensor[i].get())
        count++;
    }
    return count;
  }

  /**
   * gets the value from the magnetic sensor on the waterwheel
   * @return the value straight from the magnetic sensor on the waterwheel. True when magnet is present
   */
  public boolean getMagneticSensor()
  {
    return magneticSensor.get();
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    //setDefaultCommand(new MoveWaterWheel());
  }
}
