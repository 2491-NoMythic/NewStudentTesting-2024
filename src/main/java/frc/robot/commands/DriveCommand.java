// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.driveTrainTest;

public class DriveCommand extends Command {
  private final driveTrainTest subsystem;
  private final double power;
  private final double distance;
  private double startPosition;
  /** Creates a new DriveCommand. */
  public DriveCommand(driveTrainTest subsystem, double power, double distance) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.subsystem = subsystem;
    this.power = power;
    this.distance = distance;

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    subsystem.driveTrainGo(power, 0);
    startPosition = subsystem.getDistance();
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    subsystem.driveTrainGo(0,0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    double currentPosition = subsystem.getDistance();
    double distance = currentPosition - startPosition; 
    return distance > this.distance;
  }
}
