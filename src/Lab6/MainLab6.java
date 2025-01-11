package Lab6;

import javax.swing.*;
public class MainLab6
{
    public static void execute(JTextArea output)
    {
        StringBuffer outputText = new StringBuffer();
        AbstractProgram abstractProgram = new AbstractProgram(outputText, output);
        Supervisor supervisor = new Supervisor(abstractProgram, outputText, output);

        supervisor.start();
        Thread abstractProgramThread = new Thread(abstractProgram::run);
        abstractProgramThread.start();
    }
}
