/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.UseLimelight;

/**
 * Limelight subsystem. includes all the methods to get the raw limelight values
 */
public class Limelight extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  
  NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");

  public double getNetworkTableEntry(String entry)
  {
    return table.getEntry(entry).getDouble(0.0);
  }

  /**
   * gets the y value from the limelight, which represents the angle between the center of the camera and the center of the target in the y direction
   * @return the angle in degrees of the between the center of the camera and the center of the target in the vertical direction
   */
  public double getY()
  {
    return table.getEntry("ty").getDouble(0.0);
  }

  /**
   * gets the y value from the limelight, which represents the angle between the center of the camera and the center of the target in the x direction
   * @return the angle in degrees of the between the center of the camera and the center of the target in the horizontal direction
   */
  public double getX()
  {
    return table.getEntry("tx").getDouble(0.0);
  }

  /**
   * gets the "area" of the target.
   * @return The "area" of the target in percent of total image. Values range from 0 for no target to 100 for the target occupying all of the camera space.
   */
  public double getA()
  {
    return table.getEntry("ta").getDouble(0.0);
  }


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new Limelightidle());
  }
}
