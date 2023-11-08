package frc.robot.commands;

import java.util.concurrent.TimeUnit;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class DriveToDistanceCommand extends CommandBase {
    double distance;
    double speed;

    public DriveToDistanceCommand(double distance, double speed) {
        this.distance = distance;
        this.speed = speed;
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        Robot.driveSubsystem.stop();
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        Robot.driveSubsystem.drive(speed, 0);
        try{
            TimeUnit.SECONDS.wait((long)(distance/speed));
        }catch(Exception e){}
        Robot.driveSubsystem.stop();
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        Robot.driveSubsystem.stop();
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return isScheduled();
    }
}
