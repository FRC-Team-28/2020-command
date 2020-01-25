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
import frc.robot.commands.Limelightidle;
import frc.robot.commands.UseLimelight;

/**
 * Add your docs here.
 */
public class Limelight extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  
  NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");

  public double getNetworkTableEntry(String entry)
  {
    return table.getEntry(entry).getDouble(0.0);
  }

  public double getY()
  {
    return table.getEntry("ty").getDouble(0.0);
  }

  public double getX()
  {
    return table.getEntry("tx").getDouble(0.0);
  }

  public double getA()
  {
    return table.getEntry("ta").getDouble(0.0);
  }


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new Limelightidle());
  }
}
