package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.Button;

/**
 * A wrapper class for our custom-made operator board. Does not have a
 * constructor. Access statically. Access Buttons via public static state.
 * Access axis values via methods. Use methods to make buttons light up.
 */
public class OperatorBoard {

    private static Joystick HARDWARE;
    public OperatorBoardButton BUTTON_THREE;
    public OperatorBoardButton BUTTON_ONE;

    private static OperatorBoard instance;

    /**
     * The constructor is kept private so that I can make sure it is only run once,
     * and that there is only ever one instance of OperatorBoard in existence.
     */
    public static OperatorBoard getInstance() {
        if (instance == null) {
            instance = new OperatorBoard();
        }
        return instance;
    }

    /**
     * The constructor is kept private so that I can make sure it is only run once,
     * and that there is only ever one instance of OperatorBoard in existence.
     */
    private OperatorBoard() {
        HARDWARE = new Joystick(1);
        BUTTON_THREE = new OperatorBoardButton(3);
        BUTTON_ONE = new OperatorBoardButton(1);
    }

    public class OperatorBoardButton extends Button {
        private int m_buttonNumber;

        public OperatorBoardButton(int button) {
            m_buttonNumber = button;
        }

        @Override
        public boolean get() {
            return HARDWARE.getRawButton(m_buttonNumber);
        }

        public void turnLightOn() {
            HARDWARE.setOutput(m_buttonNumber, true);
        }

        public void turnLightOff() {
            HARDWARE.setOutput(m_buttonNumber, false);
        }
    }

}
