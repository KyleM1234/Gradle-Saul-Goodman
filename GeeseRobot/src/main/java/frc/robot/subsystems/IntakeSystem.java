// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import frc.robot.Constants;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Victor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.Joystick;

public class IntakeSystem extends SubsystemBase {
  Ultrasonic sonic = new Ultrasonic(Constants.ping, Constants.echo);
  Victor intakeRight = new Victor(Constants.intake1);
  Victor intakeLeft = new Victor(Constants.intake2);

  MotorControllerGroup intake = new MotorControllerGroup(intakeRight, intakeLeft);

  /** Creates a new IntakeSys tem. */
  public IntakeSystem() {
    //sonic.setAutomaticMode(true);
  }

  public void intake(boolean direction, double speed){
    speed = Math.abs(speed);
    if(direction){
      intakeLeft.set(speed);
    }else{
      intakeLeft.set(-speed);
    }
  }

  public void joystickIntake(Joystick joystick, double damper){
    intake.set(joystick.getY()*damper);
  }

  public void stop(){
    intake.stopMotor();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void automaticMode(boolean mode){
    //sonic.setAutomaticMode(mode);
  }

  public void pingSonic(){
    sonic.ping();
  }

  public double getDistanceCM(){
    return sonic.getRangeMM() / 10;
  }

  public double getDistanceInches(){
    return sonic.getRangeInches();
  }

  public boolean hasSomething(double maxDistance){
    return getDistanceCM() < maxDistance;
  }
}
// bye yall