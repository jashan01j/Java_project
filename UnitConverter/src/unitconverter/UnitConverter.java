package unitconverter;
import javax.swing.*;
import java.awt.event.*;

public class UnitConverter {
    private JFrame frame;
    private JLabel inputLabel, outputLabel;
    private JTextField input;
    private JTextField output;
    private JComboBox fromUnit;
    private JComboBox toUnit;
    private JButton convertButton;

    public UnitConverter() {
        initComponents();
    }

    protected void initComponents() {
        frame = new JFrame("Unit Converter");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        inputLabel = new JLabel("Input: ");
        input = new JTextField();
        outputLabel = new JLabel("Output: ");
        output = new JTextField();
        output.setEditable(false);
        String []unit1={"Meters", "Feet", "Inches", "Centimeters"};
        fromUnit = new JComboBox(unit1);
        String []unit2={"Meters", "Feet", "Inches", "Centimeters"};
        toUnit = new JComboBox(unit2);
        convertButton = new JButton("Convert");

        inputLabel.setBounds(20, 50, 100, 20);
        input.setBounds(150, 50, 100, 20);
        fromUnit.setBounds(270, 50, 100, 20);
        outputLabel.setBounds(20, 80, 100, 20);
        output.setBounds(150, 80, 100, 20);
        toUnit.setBounds(270, 80, 100, 20);
        convertButton.setBounds(150, 120, 100, 20);

        convertButton.addActionListener(new ConvertButtonListener());

        frame.add(inputLabel);
        frame.add(input);
        frame.add(fromUnit);
        frame.add(output);
        frame.add(outputLabel);
        frame.add(toUnit);
        frame.add(convertButton);

        frame.setVisible(true);
    }

    private class ConvertButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String fromUnitType = fromUnit.getSelectedItem().toString();
            String toUnitType = toUnit.getSelectedItem().toString();

            try {
                double inputValue = Double.parseDouble(input.getText());
                double outputValue = 0.0;

                if (fromUnitType.equals("Meters")) {
                    if (toUnitType.equals("Meters")) {
                        outputValue = metersToMeters(inputValue);
                    } else if (toUnitType.equals("Feet")) {
                        outputValue = metersToFeet(inputValue);
                    } else if (toUnitType.equals("Inches")) {
                        outputValue = metersToInches(inputValue);
                    } else if (toUnitType.equals("Centimeters")) {
                        outputValue = metersToCentimeters(inputValue);
                    }
                } else if (fromUnitType.equals("Feet")) {
                    if (toUnitType.equals("Meters")) {
                        outputValue = feetToMeters(inputValue);
                    } else if (toUnitType.equals("Feet")) {
                        outputValue = feetToFeet(inputValue);
                    } else if (toUnitType.equals("Inches")) {
                        outputValue = feetToInches(inputValue);
                    } else if (toUnitType.equals("Centimeters")) {
                        outputValue = feetToCentimeters(inputValue);
                    }
                } else if (fromUnitType.equals("Inches")) {
                    if (toUnitType.equals("Meters")) {
                        outputValue = inchesToMeters(inputValue);
                    } else if (toUnitType.equals("Feet")) {
                        outputValue = inchesToFeet(inputValue);
                    } else if (toUnitType.equals("Inches")) {
                        outputValue = inchesToInches(inputValue);
                    } else if (toUnitType.equals("Centimeters")) {
                        outputValue = inchesToCentimeters(inputValue);
                    }
                } else if (fromUnitType.equals("Centimeters")) {
                    if (toUnitType.equals("Meters")) {
                        outputValue = centimetersToMeters(inputValue);
                    } else if (toUnitType.equals("Feet")) {
                        outputValue = centimetersToFeet(inputValue);
                    } else if (toUnitType.equals("Inches")) {
                        outputValue = centimetersToInches(inputValue);
                    } else if (toUnitType.equals("Centimeters")) {
                        outputValue = centimetersToCentimeters(inputValue);
                    }
                }

                output.setText(String.valueOf(outputValue));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid input. Please enter a valid number.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static double metersToMeters(double inputValue) {
        return inputValue;
    }

    public static double metersToCentimeters(double inputValue) {
        return inputValue * 100;
    }

    public static double metersToFeet(double inputValue) {
        return inputValue * 3.28084;
    }

    public static double metersToInches(double inputValue) {
        return inputValue * 3.28084 * 12;
    }

    public static double feetToMeters(double inputValue) {
        return inputValue / 3.28084;
    }

    public static double feetToCentimeters(double inputValue) {
        return inputValue * 30.48;
    }

    public static double feetToFeet(double inputValue) {
        return inputValue;
    }

    public static double feetToInches(double inputValue) {
        return inputValue * 12;
    }

    public static double inchesToMeters(double inputValue) {
        return inputValue / 39.3700787;
    }

    public static double inchesToCentimeters(double inputValue) {
        return inputValue * 2.54;
    }

    public static double inchesToInches(double inputValue) {
        return inputValue;
    }

    public static double inchesToFeet(double inputValue) {
        return inputValue / 12;
    }

    public static double centimetersToMeters(double inputValue) {
        return inputValue / 100;
    }

    public static double centimetersToCentimeters(double inputValue) {
        return inputValue;
    }

    public static double centimetersToFeet(double inputValue) {
        return inputValue / 30.48;
    }

    public static double centimetersToInches(double inputValue) {
        return inputValue / 2.54;
    }

    public static void main(String[] args) {
        new UnitConverter();
    }
}