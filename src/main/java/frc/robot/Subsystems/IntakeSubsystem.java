// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSubsystem extends SubsystemBase {
  /** Creates a new IntakeSubsystem. */
  final TalonFX intakeMotor = new TalonFX(Constants.kIntakeMotorPort, "static");
  public IntakeSubsystem() {}

  public void setIntake(double speed) {
    intakeMotor.set(speed);
  }

  public Command DefaultCommand() {
    return run(
      () -> {
        intakeMotor.stopMotor();
      });
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
