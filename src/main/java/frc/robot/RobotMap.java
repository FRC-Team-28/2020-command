/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

      //SHOOTING STUFF
      public static final double
      CAMERA_ANGLE = 3,
      CAMERA_HEIGHT = 32;


      //ANALOG
      public static final int
      GYRO_PIN = 1, 
      ARM_POT = 2, 
      ELEVATOR_SWITCH = 3;
      
      //TALONS
      public static final int
      SHOOTER_WHEEL = 0,
      WATER_WHEEL = 0;


      //SPARK/PWM 
      public static final int 
      FL_MOTOR = 3, 
      FR_MOTOR = 2, 
      BR_MOTOR = 0, 
      BL_MOTOR = 1;

      //DIO  Wryyyy
      public static final int 
      MAGNETIC_SENSOR = 0,
      SPRING_SENSOR1 = 1,
      SPRING_SENSOR2 = 1,
      SPRING_SENSOR3 = 1,
      SPRING_SENSOR4 = 1,
      SPRING_SENSOR5 = 1,
      SPRING_SENSOR6 = 1;



  public static final int LEFT_STICK_X = 0;
	public static final int LEFT_STICK_Y = 1;
	public static final int LEFT_TRIGGER = 2;
  public static final int RIGHT_TRIGGER = 3;
  public static final int RIGHT_STICK_X = 4;
  public static final int RIGHT_STICK_Y = 5;
  public static final int A_BUTTON = 1;
  public static final int B_BUTTON = 2;
  public static final int X_BUTTON = 3;
  public static final int Y_BUTTON = 4;
  public static final int LB_BUTTON = 5;
  public static final int RB_BUTTON = 6;
  public static final int SEL_BUTTON = 7;
  public static final int START_BUTTON = 8;
  public static final int LS_BUTTON = 9;
  public static final int RS_BUTTON = 10;




  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;


}
