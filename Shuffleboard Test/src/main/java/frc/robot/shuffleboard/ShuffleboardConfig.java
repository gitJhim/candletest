package frc.robot.shuffleboard;

import java.util.Map;

import edu.wpi.first.util.sendable.Sendable;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

public class ShuffleboardConfig {

    // Tabs
    ShuffleboardTab swissCheeseTab = Shuffleboard.getTab("Swiss Cheese");
    // Choosers
    SendableChooser<String> autoChooserSendable = new SendableChooser<>();

    public ShuffleboardConfig() {
        addWidgets();
    }
    
    public void addWidgets() {
        autoChooserSendable.setDefaultOption("Turn LED Red", "ledred");
        autoChooserSendable.addOption("Turn LED Green", "ledgreen");
        autoChooserSendable.addOption("Turn LED Blue", "ledblue");
        swissCheeseTab.add(autoChooserSendable);
    }

    public ShuffleboardTab getShuffleboardTab() {
        return this.swissCheeseTab;
    }

    public SendableChooser<String> getAutoChooser() {
        return this.autoChooserSendable;
    }


}