// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.TransferSubsystem;

public class TransferCommand extends Command {
  TransferSubsystem transfer;
  public static double speed;
  /** Creates a new TransferCommand. */
  public TransferCommand(TransferSubsystem t, double tSpeed) {
    transfer = t;
    speed = tSpeed;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(transfer);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    transfer.setTransfer(speed);
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
