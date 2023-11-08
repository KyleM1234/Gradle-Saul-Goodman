/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.Constants;
 
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Victor;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * Add your docs here.
 */
public class DriveSubsystem extends SubsystemBase {
   // Put methods for controlling this subsystem
    // here. Call these from Commands.

	// Victor speed controller instantiations
	//RobotMap has CANBus ports
	
	Victor frontRight = new Victor(Constants.frontRightChannel);
	Victor frontLeft = new Victor(Constants.frontLeftChannel);
	Victor backRight = new Victor(Constants.backRightChannel);
	Victor backLeft = new Victor(Constants.backLeftChannel);

	// Sample PWM motor instantiation
	
	PWM motor = new PWM(1);
	
	// Groups left and right speed controllers together for drivetrain

	MotorControllerGroup left = new MotorControllerGroup(frontLeft, backLeft);
	MotorControllerGroup right = new MotorControllerGroup(frontRight, backRight);

	//Encoder leftEnc = new Encoder(Constants.leftEnc1, Constants.leftEnc2, false, Encoder.EncodingType.k4X);
	//Encoder rightEnc = new Encoder(Constants.rightEnc1, Constants.rightEnc2, false, Encoder.EncodingType.k4X);

	// Initial instantiation of our drivetrain object 

	public DifferentialDrive drive;

	
	public DriveSubsystem() {

		// Setting inversions (flipped direction of motor)
		// of speed controllers
		
		frontRight.setInverted(false);
		frontLeft.setInverted(false);
		backRight.setInverted(false);
		backLeft.setInverted(false);

		// Finalising instantiation of the drivetrain object
		// after setting motor inversions
		
		drive = new DifferentialDrive(left, right);

		// Sample showing how to invert the counting direction
		// after instantiation of an encoder

		//rightEnc.setReverseDirection(true);
		
	}
	// Drives drivetrain based on joystick input and dampening value (speed)
	// from 0 to 1
	public void driveJoystick(Joystick joystick, double speed) {
		
		drive.arcadeDrive(joystick.getY()*speed, joystick.getX()*speed);
	}
	
	// Drives drivetrain based on given speed and roation values
	public void drive(double speed, double rotationSpeed) {
		drive.arcadeDrive(speed, rotationSpeed);
	}

	// Stops the motors on the drivetrain
	public void stop() {
		drive.stopMotor();
	}

	// Gets a Raw encoder value
	// Similarly, getCount will give you the number of 
	// "clicks" it has recorded
	/*
  	public double getLeftRaw(){
		return leftEnc.getRaw();
	}

	// Averages the raw values of the left and right encoders
	public double getRawAvg(){
		return (leftEnc.getRaw() + rightEnc.getRaw())/2; 
	}

	// Gets a distance based on a factor for units per
	// encoder value
	// Units used is up to the team
	public double getAvgDistance(){
		return getRawAvg() * 0.0008;
	}

	//Resets the encoders so that they read from 0 again
	public void encReset(){
		leftEnc.reset();
		rightEnc.reset();
	}
  */
}