// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Robot;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class IntakeCommand extends CommandBase {
  boolean direction = false;
  double speed = 0;

  public IntakeCommand(boolean direction, double speed){
    this.direction = direction;
    this.speed = speed;
  }

  @Override
  public void initialize(){
    Robot.intakeSystem.stop();
  }

  @Override
  public void execute(){
    Robot.intakeSystem.intake(direction, speed);
  }

  @Override
  public void end(boolean interrupted){
    end();
  }

  @Override
  public boolean isFinished(){
    return false;
  }

  public void end(){
    Robot.intakeSystem.stop();
  }
}
