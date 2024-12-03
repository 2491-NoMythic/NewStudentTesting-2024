// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.ArmMovement;
import frc.robot.subsystems.driveTrainTest;

public class ArmAuto extends SequentialCommandGroup {
  /** Creates a new ArmAuto. */
  public ArmAuto(driveTrainTest driveTrain, ArmMovement armMove) {

    // Use addRequirements() here to declare subsystem dependencies.
    addCommands(
      new DriveCommand(driveTrain, 0.5, 2), 
      new ArmCommand(armMove, 0.4),
      new DriveCommand(driveTrain, -0.5, 2)
    );
  }
}
