// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrainTest extends SubsystemBase {
  /** Creates a new driveTrainTest. */

  private CANSparkMax leftMotor1;
  private CANSparkMax leftMotor2;
  private CANSparkMax rightMotor1;
  private CANSparkMax rightMotor2;
  private DifferentialDrive differentialDrive;
 

  public DriveTrainTest() {
    leftMotor1 = new CANSparkMax(0,MotorType.kBrushless);
    leftMotor2 = new CANSparkMax(0,MotorType.kBrushless);
    rightMotor1 = new CANSparkMax(0,MotorType.kBrushless);
    rightMotor2 = new CANSparkMax(0,MotorType.kBrushless);

    SmartDashboard.putNumber("Drive P", 0);
    SmartDashboard.putNumber("Drive I", 0);
    SmartDashboard.putNumber("Drive D", 0);
    SmartDashboard.putNumber("Drive FF", 0);
    SmartDashboard.putNumber("Drive Izone", 0);

    leftMotor2.follow(leftMotor1);
    rightMotor2.follow(rightMotor1);

    differentialDrive = new DifferentialDrive(leftMotor1::set, rightMotor1::set);
  
    rightMotor2.setInverted(true);
    rightMotor1.setInverted(true);
  }
  public void setDriveTrain(double y_Axis, double x_Axis) {
   differentialDrive.arcadeDrive(y_Axis, x_Axis);
  }
  public void drivePID(double leftSpeed, double rightSpeed) {
    leftMotor1.getPIDController().setReference(leftSpeed, CANSparkBase.ControlType.kVelocity);
    rightMotor1.getPIDController().setReference(rightSpeed,CANSparkBase.ControlType.kVelocity);
  }
  public void setDriveTrainPID() {
    double p = SmartDashboard.getNumber("Drive P", 0);
    double i = SmartDashboard.getNumber("Drive I", 0);
    double d = SmartDashboard.getNumber("Drive D", 0);
    double ff = SmartDashboard.getNumber("Drive FF", 0);
    double iZ = SmartDashboard.getNumber("Drive Izone", 0);

    leftMotor1.getPIDController().setFF(ff);
  
    leftMotor1.getPIDController().setP(p);

    leftMotor1.getPIDController().setI(i);

    leftMotor1.getPIDController().setD(d);

    leftMotor1.getPIDController().setIZone(iZ);


    rightMotor1.getPIDController().setFF(ff);

    rightMotor1.getPIDController().setP(p);

    rightMotor1.getPIDController().setI(i);

    rightMotor1.getPIDController().setD(d);

    rightMotor1.getPIDController().setIZone(iZ);
  }
  public void stopMotors(){
    leftMotor1.set(0);
    rightMotor1.set(0);
  }

  @Override
  public void periodic() {
    setDriveTrainPID();
    // This method will be called once per scheduler run
  }
}
