package Lab6;

import java.lang.Thread;
import javax.swing.*;

class Supervisor extends Thread
{
    private AbstractProgram abstractProgram;
    private StringBuffer outputText;
    private JTextArea output;

    Supervisor(AbstractProgram abstractProgram, StringBuffer outputText, JTextArea output)
    {
        this.abstractProgram = abstractProgram;
        this.outputText = outputText;
        this.output = output;
    }

    @Override
    public void run()
    {
        while (true)
        {
            if (abstractProgram.getState() == ProgrammState.FATAL_ERROR)
            {
                outputText.append("State of Abstract Program is FATAL_ERROR. Power off.\n");
                output.setText(outputText.toString());
                break;
            }
            else if (abstractProgram.getState() == ProgrammState.STOPPING)
            {
                outputText.append("State of Abstract Program is STOPPING. Rerun.\n");
                output.setText(outputText.toString());
                abstractProgram.start();
            }
            abstractProgram.waitForStateChange();
        }
    }
}
