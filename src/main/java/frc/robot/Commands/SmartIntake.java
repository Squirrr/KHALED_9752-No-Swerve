// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.IntakeSubsystem;
import frc.robot.Subsystems.TransferSubsystem;

public class SmartIntake extends Command {
  /** Creates a new SmartIntake. */
  IntakeSubsystem intake;
  TransferSubsystem transfer;
  // ShooterSubsystem shooter;
  public SmartIntake(IntakeSubsystem i, TransferSubsystem t/*, ShooterSubsystem s*/) {
    intake = i;
    transfer = t;
    // shooter = s;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(intake);
    addRequirements(transfer);
    // addRequirements(shooter);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    transfer.close();
    intake.setIntake(1);
    transfer.setTransfer(1);
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
