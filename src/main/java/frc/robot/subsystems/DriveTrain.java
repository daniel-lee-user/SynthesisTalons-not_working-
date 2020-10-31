/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.arcadeDrive;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;;


/**
 * Add your docs here.
 */
public class DriveTrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public TalonSRX leftMaster = new TalonSRX(RobotMap.leftMasterPort);

  public TalonSRX rightMaster = new TalonSRX(RobotMap.rightMasterPort);
  
  public DriveTrain() {

  }
  public void manualDrive(double move, double turn) {
    leftMaster.set(ControlMode.PercentOutput, move);
    rightMaster.set(ControlMode.PercentOutput, move);
  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new arcadeDrive());
  }
  @Override
  public void periodic() {
    super.periodic();
    manualDrive(1, 1);
  }
}
