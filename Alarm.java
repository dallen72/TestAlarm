import javax.swing.*;
import java.awt.*;
import java.text.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Alarm implements Runnable{
  JFrame jframe;
  Thread thread = null;
  JButton button;

  int secsPerQuestion;
  int secsRemaining;

  Alarm(int secs){
    secsPerQuestion = secs;
    secsRemaining = secsPerQuestion;

    jframe = new JFrame();


    button=new JButton();
    button.setBounds(100,100,100,50);
    button.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        secsRemaining += secsPerQuestion;
      }
    });

    jframe.add(button);
    jframe.setSize(300,400);
    jframe.setLayout(null);
    jframe.setVisible(true);


    thread = new Thread(this);
    thread.start();
  }

  public void run() {
    try {
      while (true) {
        if (secsRemaining == 0 || secsRemaining <= (-1*secsPerQuestion)) {
          Beepable.beep();
        }
        String secs = Integer.toString(secsRemaining);
        printTime(secs);
        thread.sleep(1000);
        secsRemaining = secsRemaining - 1;
      }

    }catch (InterruptedException e) {
      e.printStackTrace();
    }
  }


  public void printTime(String secs){
    button.setText(secs);
  }
}
