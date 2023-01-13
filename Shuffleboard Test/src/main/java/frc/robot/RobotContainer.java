package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.resetLEDColorCommand;
import frc.robot.commands.turnLEDBlueCommand;
import frc.robot.commands.turnLEDGreenCommand;
import frc.robot.commands.turnLEDRedCommand;
import frc.robot.shuffleboard.ShuffleboardConfig;
import frc.robot.subsystems.LEDSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // Shuffleboard
  ShuffleboardConfig shuffleboardConfig;
  // The robot's subsystems and commands are defined here...
  private final LEDSubsystem m_LEDSubsystem;

  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    shuffleboardConfig = new ShuffleboardConfig();
    m_LEDSubsystem = new LEDSubsystem();
    // Configure the trigger bindings
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
     // m_driverController.b().whileTrue(m_exampleSubsystem.exampleMethodCommand());

     m_driverController.x().onTrue(new turnLEDBlueCommand(m_LEDSubsystem));
     m_driverController.a().onTrue(new turnLEDGreenCommand(m_LEDSubsystem));
     m_driverController.b().onTrue(new turnLEDRedCommand(m_LEDSubsystem));
     m_driverController.y().onTrue(new resetLEDColorCommand(m_LEDSubsystem));

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    String autoCommandString = shuffleboardConfig.getAutoChooser().getSelected();
    switch(autoCommandString) {
      case "ledred":
        return Autos.turnRedAuto(m_LEDSubsystem);
      case "ledgreen":
        return Autos.turnGreenAuto(m_LEDSubsystem);
      case "ledblue":
        return Autos.turnBlueAuto(m_LEDSubsystem);
      default:
        return null;
    }
  }
}
