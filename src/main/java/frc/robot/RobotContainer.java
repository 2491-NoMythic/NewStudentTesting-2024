// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.driveTrainController;
import frc.robot.commands.testRobotNigel;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.driveTrainTest;
import frc.robot.subsystems.testNigelRobo;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands.
   * 
   */
  private testNigelRobo motorSubSys;
  private testRobotNigel myCommand;
  private XboxController controller;
  private int motorTurns = 2;
  private driveTrainTest driveTest;
  private driveTrainController driveContoller;
  public RobotContainer() {
    controller = new XboxController(0);
  motorInst();
   // Configure the trigger bindings
   configureBindings();
   SmartDashboard.putNumber("Motor Turns",motorTurns);
   SmartDashboard.putNumber("Speed", 0);
  }
  
  private void motorInst(){
   motorSubSys = new testNigelRobo();
  myCommand = new testRobotNigel(motorSubSys, controller);
   motorSubSys.setDefaultCommand(myCommand);
  driveTest = new driveTrainTest();
  driveContoller = new driveTrainController(driveTest, controller);
  driveTest.setDefaultCommand(driveContoller);
  }
  private void autoInst(){

  }
  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    //new Trigger(m_exampleSubsystem::exampleCondition)
     //   .onTrue(new driveTrainController(m_exampleSubsystem));

    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.
    m_driverController.b().whileTrue(m_exampleSubsystem.exampleMethodCommand());
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return myCommand;
  }
}
