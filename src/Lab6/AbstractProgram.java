package Lab6;

import java.util.Random;
import javax.swing.*;

class AbstractProgram implements Runnable
{
    private ProgrammState state;
    private Thread daemonThread;
    private final StringBuffer outputText;
    private final JTextArea output;

    AbstractProgram(StringBuffer outputText, JTextArea output)
    {
        this.output = output;
        this.outputText = outputText;
        this.state = ProgrammState.UNKNOWN;
        this.daemonThread = new Thread(new StateChangeDaemon());
        this.daemonThread.setDaemon(true);
    }
    public ProgrammState getState()
    {
        return state;
    }

    @Override
    public void run()
    {
        start();
        this.daemonThread.start();

        while (state != ProgrammState.FATAL_ERROR)
        {
            outputText.append("State is " + state + '\n');
            output.setText(outputText.toString());
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
        }
    }
    void start()
    {
        if (state == ProgrammState.UNKNOWN || state == ProgrammState.STOPPING)
        {
            changeState(ProgrammState.RUNNING);
        }
    }
    public synchronized void changeState(ProgrammState newState)
    {
        state = newState;
        outputText.append("State changed to " + state + '\n');
        output.setText(outputText.toString());
        notifyAll();
    }
    public synchronized void waitForStateChange()
    {
        try
        {
            wait();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
    private class StateChangeDaemon implements Runnable
    {
        @Override
        public void run()
        {
            while (true)
            {
                try
                {
                    Thread.sleep(3000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                if (state != ProgrammState.STOPPING && state != ProgrammState.FATAL_ERROR)
                {
                    changeState(getRandomState());
                }
            }
        }
        private ProgrammState getRandomState()
        {
            Random random = new Random();
            int index = random.nextInt(ProgrammState.values().length - 1) + 1;
            return ProgrammState.values()[index];
        }
    }
}
