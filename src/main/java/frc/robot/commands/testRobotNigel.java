// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.testNigelRobo;

public class testRobotNigel extends Command {
  /** Creates a new testRobotNigel. */
public testRobotNigel setDefaultCommand;
  private testNigelRobo motor;
  private XboxController controller;
  private Timer timer;
  CANSparkMax intake1;

  public testRobotNigel(testNigelRobo motor, XboxController controller) {
    this.motor = motor;
    this.controller = controller;
    addRequirements(motor);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timer = new Timer();
    timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // if (controller.getAButton()) {
    //   motor.function(controller.getRawAxis(5));
    // }
    // else {
    //   motor.function(0);
    // }
    // if (timer.hasElapsed(4)) {
    //   motor.function(0.2); 
    // }
    // else{
    //   motor.function(0);
    // }
    // System.out.println(timer.get());
    // if (timer.hasElapsed(5)) {
    //   timer.restart();
    // }
    double speed=SmartDashboard.getNumber("Speed", 0);
  motor.setMotorSpeed(speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  motor.function(0);
  }
  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
