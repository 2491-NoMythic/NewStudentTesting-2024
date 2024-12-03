// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkLimitSwitch;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArmMovement extends SubsystemBase {
  public CANSparkMax armMotor;
  public SparkLimitSwitch limitSwitch1;
  /** Creates a new ExampleSubsystem. */
  public ArmMovement() {
    armMotor = new CANSparkMax(0,MotorType.kBrushless);
    limitSwitch1 = armMotor.getForwardLimitSwitch(SparkLimitSwitch.Type.kNormallyClosed);


  }
  public void armMove(double armSpeed){
    armMotor.set(armSpeed);

  }
  public boolean armLimitSwitch(){
    return limitSwitch1.isPressed();

  }
  
  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
