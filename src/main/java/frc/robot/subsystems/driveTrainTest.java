// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class driveTrainTest extends SubsystemBase {
  /** Creates a new driveTrainTest. */

 CANSparkMax leftMotor1;
 CANSparkMax leftMotor2;
 CANSparkMax rightMotor1;
 CANSparkMax rightMotor2;
 DifferentialDrive testDrive;
 private final XboxController controller = new XboxController(0);

  public driveTrainTest() {
  leftMotor1 = new CANSparkMax(0,MotorType.kBrushless);
  leftMotor2 = new CANSparkMax(0,MotorType.kBrushless);
  rightMotor1 = new CANSparkMax(0,MotorType.kBrushless);
  rightMotor2 = new CANSparkMax(0,MotorType.kBrushless);
  rightMotor1.setInverted(true);
  rightMotor2.setInverted(true);
  testDrive = new DifferentialDrive(leftMotor1::set, rightMotor1::set);
  rightMotor2.follow(rightMotor1);
  leftMotor2.follow(leftMotor1);
  }
  public void driveTrainGo(double yAxis, double xAxis) {
    
    testDrive.arcadeDrive(xAxis, yAxis);
  }

  public double getDistance(){
    return leftMotor1.getEncoder().getPosition();
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
