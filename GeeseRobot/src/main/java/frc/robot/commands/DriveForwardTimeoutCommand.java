// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class DriveForwardTimeoutCommand extends CommandBase {
  /** Creates a new DriveTimeoutCommand. */
  public DriveForwardTimeoutCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize(){
    Robot.driveSubsystem.stop();
    withTimeout(3);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute(){
    Robot.driveSubsystem.drive(1,0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted){
    Robot.driveSubsystem.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return isScheduled();
  }
}
