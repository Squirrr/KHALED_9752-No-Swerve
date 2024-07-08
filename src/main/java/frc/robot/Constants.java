// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/** Add your docs here. */
public class Constants {

    public static final int kIntakeMotorPort = 15;
    public static final int kTransferMotorPort = 20; 
    public static final int kLeftShooterMotorPort = 20; //SparkMAX Controller 
    public static final int kRightShooterMotorPort = 21; //SparkMAX Controller
    public static final int kArmMotorPort = 16;
    public static final int kServoPort = 9;


    public class ShooterPIDConstants {
        public static final double kFF = 0.002;
        public static final double kP = 0.002;
        public static final double kI = 0.0;
        public static final double kD = 0.001;
    }
    public class ArmPIDConstants {
        public static final double kG = 0.255;
        public static final double kP = 0.8;
        public static final double kI = 0;
        public static final double kD = 0.1;
        public static final double ampPos = 65;
    }
    public static double degreesToRotations(double degrees, double gearRatio) {
        return degrees/(360 / (gearRatio * 2048)); //Returns rotations
    }


}
