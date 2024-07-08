// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import com.ctre.phoenix6.configs.MotionMagicConfigs;
import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.PositionVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.GravityTypeValue;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.ArmPIDConstants;

public class ArmSubsystem extends SubsystemBase {
  /** Creates a new ArmSubsystem. */
  final TalonFX armMotor = new TalonFX(Constants.kArmMotorPort, "static");

  TalonFXConfiguration armConfigs = new TalonFXConfiguration();
  Slot0Configs slot0Configs = armConfigs.Slot0;
  MotionMagicConfigs motionMagicConfigs = armConfigs.MotionMagic;
  PositionVoltage request = new PositionVoltage(0).withSlot(0);

  public ArmSubsystem() {
    slot0Configs.GravityType = GravityTypeValue.Arm_Cosine;
    slot0Configs.kG = ArmPIDConstants.kG;
    slot0Configs.kP = ArmPIDConstants.kP; 
    slot0Configs.kI = ArmPIDConstants.kI; 
    slot0Configs.kD = ArmPIDConstants.kD;

    motionMagicConfigs.MotionMagicCruiseVelocity = 80;
    motionMagicConfigs.MotionMagicAcceleration = 100;
    motionMagicConfigs.MotionMagicJerk = 1600;
  
    armMotor.getConfigurator().apply(armConfigs);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setArmAngle(double angleSetPoint) {
    armMotor.setControl(request.withPosition(angleSetPoint));
  }
}
