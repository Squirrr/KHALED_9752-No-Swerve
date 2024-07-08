// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandPS5Controller;
import frc.robot.Commands.ArmCommand;
import frc.robot.Commands.SimpleShoot;
import frc.robot.Commands.SmartIntake;
import frc.robot.Commands.SmartOuttake;
import frc.robot.Constants.ArmPIDConstants;
import frc.robot.Subsystems.ArmSubsystem;
import frc.robot.Subsystems.IntakeSubsystem;
import frc.robot.Subsystems.ShooterSubsystem;
import frc.robot.Subsystems.TransferSubsystem;

public class RobotContainer {

  public CommandPS5Controller base = new CommandPS5Controller(0);
  public TransferSubsystem transfer = new TransferSubsystem();
  public IntakeSubsystem intake = new IntakeSubsystem();
  public ShooterSubsystem shooter = new ShooterSubsystem();
  public ArmSubsystem arm = new ArmSubsystem();

  public RobotContainer() {

    intake.setDefaultCommand(intake.DefaultCommand());
    transfer.setDefaultCommand(transfer.DefaultCommand());
    shooter.setDefaultCommand(shooter.DefaultCommand());

    configureBindings();
  }

  private void configureBindings() {

    base.R1().whileTrue(new ArmCommand(arm, 0));
    base.R1().whileTrue(new SmartIntake(intake, transfer));
    base.L1().whileTrue(new SmartOuttake(intake, transfer));
    base.R2().whileTrue(/*new TransferCommand(transfer, -0.2).withTimeout(0.5)
    .andThen*/(new SimpleShoot(transfer, shooter)));
    base.triangle().whileTrue(new ArmCommand(arm, ArmPIDConstants.ampPos));
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
