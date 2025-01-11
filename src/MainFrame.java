import Lab1.MainLab1;
import Lab2.MainLab2;
import Lab3.MainLab3;
import Lab4.MainLab4;
import Lab5.MainLab5;
import Lab6.MainLab6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame
{
    private static final String[] labNames = {"1", "2", "3", "4", "5", "6"};
    private final JComboBox labComboBox;
    private final JTextArea input;
    private final JTextArea output;
    public MainFrame()
    {
        super("lab 7");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add selector

        JPanel northPanel = new JPanel();

        JLabel labComboBoxLabel = new JLabel("Lab number");
        northPanel.add(labComboBoxLabel);

        labComboBox = new JComboBox<>(labNames);
        labComboBox.setSelectedIndex(0);
        labComboBox.addActionListener(this::labComboBoxAction);
        northPanel.add(labComboBox);

        add(northPanel, BorderLayout.PAGE_START);

        // Add input, output

        JPanel centerPanel = new JPanel();
        JPanel inputPanel = new JPanel();
        inputPanel.setBorder(BorderFactory.createTitledBorder("Input"));
        JPanel outputPanel = new JPanel();
        outputPanel.setBorder(BorderFactory.createTitledBorder("Output"));

        input = new JTextArea(30, 50);
        output = new JTextArea(30, 50);
        output.setEditable(false);

        inputPanel.add(new JScrollPane(input));
        outputPanel.add(new JScrollPane(output));
        centerPanel.add(inputPanel);
        centerPanel.add(outputPanel);

        add(centerPanel, BorderLayout.CENTER);

        // Add execute button and clear button

        JPanel southPanel = new JPanel();

        JButton executeButton = new JButton("Execute");
        executeButton.addActionListener(this::executeLab);
        southPanel.add(executeButton);

        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(this::clearTextAreas);
        southPanel.add(clearButton);

        add(southPanel, BorderLayout.PAGE_END);

        pack();
        setVisible(true);
    }

    private void labComboBoxAction(ActionEvent event)
    {
        int labelId = labComboBox.getSelectedIndex();
        if (labelId == 0)
        {
            input.setEditable(true);
            input.setBackground(new Color(255, 255, 255));
        }
        else
        {
            input.setEditable(false);
            input.setBackground(new Color(200, 200, 200));
        }
    }

    private void executeLab(ActionEvent e)
    {
        int labelId = labComboBox.getSelectedIndex();
        if (labelId == 0)
        {
            String inputText = input.getText();
            MainLab1.execute(inputText, output);
        }
        else if (labelId == 1)
        {
            MainLab2.execute(output);
        }
        else if (labelId == 2)
        {
            MainLab3.execute(output);
        }
        else if (labelId == 3)
        {
            MainLab4.execute(output);
        }
        else if (labelId == 4)
        {
            MainLab5.execute(output);
        }
        else if (labelId == 5)
        {
            MainLab6.execute(output);
        }
    }

    private void clearTextAreas(ActionEvent e)
    {
        input.setText("");
        output.setText("");
    }
}