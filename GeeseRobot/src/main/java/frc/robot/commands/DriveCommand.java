// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class DriveCommand extends CommandBase {
  public DriveCommand(){
    
  }

  @Override
  public void initialize(){
    Robot.driveSubsystem.stop();
  }

  @Override
  public void execute(){
    Robot.driveSubsystem.driveJoystick(Robot.container.getDriverStick(), 1);
  }

  @Override
e    end(); 
  }

  @Override
  public boolean isFinished(){
    return false;
  }

  public void end(){
    Robot.driveSubsystem.stop();
  }
  
  public void interrupted(){
    end();
  }
}

