// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class testNigelRobo extends SubsystemBase {
  /** Creates a new testNigelRobo. */
  CANSparkMax intake1;
  DigitalInput limitSwitch = new DigitalInput(9);
  public testNigelRobo() {
    intake1 = new CANSparkMax (22,MotorType.kBrushless);
    intake1.setSmartCurrentLimit(20);
    intake1.burnFlash();
  }
  
  

public void setMotorSpeed(double speed) {
  if (limitSwitch.get()) {
   // We are going up and top limit is tripped so stop
   intake1.set(0);
 } else {
   // We are going up but top limit is not tripped so go at commanded speed
   intake1.set(speed);
 }
}
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  
  }
  public void function(double variable){
    intake1.set(variable);
  }
}
