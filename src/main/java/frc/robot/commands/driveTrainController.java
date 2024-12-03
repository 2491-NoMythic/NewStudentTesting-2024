// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.driveTrainTest;
import edu.wpi.first.math.proto.Controller;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;

/** An example command that uses an example subsystem. */
public class driveTrainController extends Command {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final driveTrainTest trainDriveTest;
  private XboxController controller;
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public driveTrainController(driveTrainTest driveDrive, XboxController controller) {
    trainDriveTest = driveDrive;
    this.controller = controller;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(driveDrive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    trainDriveTest.driveTrainGo(controller.getRightY(), controller.getRightX());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
