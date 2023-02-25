// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.LED;

import edu.wpi.first.wpilibj2.command.InstantCommand;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class InitializeLED extends InstantCommand {
  private final LED m_led = new LED(); //Set controller address

  public InitializeLED(LED led) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_led);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_led.clearLED(); //Turn off LED strip at start

    m_led.setLED(1,1); //Set strip 1 to function 1
  }
}
