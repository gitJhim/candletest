// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.LEDSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.WaitCommand;

public final class Autos {

  public static CommandBase turnRedAuto(LEDSubsystem subsystem) {
    return Commands.sequence(new turnLEDRedCommand(subsystem));
  }
  
  public static CommandBase turnGreenAuto(LEDSubsystem subsystem) {
    return Commands.sequence(new turnLEDGreenCommand(subsystem), new WaitCommand(3.25), new resetLEDColorCommand(subsystem));
  }

  public static CommandBase turnBlueAuto(LEDSubsystem subsystem) {
    return Commands.sequence(new turnLEDBlueCommand(subsystem));
  }

  private Autos() {
    throw new UnsupportedOperationException("This is a utility class!");
  }
}
