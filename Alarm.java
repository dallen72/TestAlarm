import javax.swing.*;
import java.awt.*;
import java.text.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Alarm implements Runnable{
  JFrame f;
  Thread t=null;
  JButton b;

  int secsPerQuestion;
  int secsRemaining;

  Alarm(int secs){
    secsPerQuestion = secs;
    secsRemaining = secsPerQuestion;

    f=new JFrame();


    b=new JButton();
    b.setBounds(100,100,100,50);
    b.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        secsRemaining += secsPerQuestion;
      }
    });

    f.add(b);
    f.setSize(300,400);
    f.setLayout(null);
    f.setVisible(true);


    t = new Thread(this);
    t.start();
  }

  public void run() {
    try {
      while (true) {
        if (secsRemaining == 0 || secsRemaining <= (-1*secsPerQuestion)) {
          Beepable.beep();
        }
        String secs = Integer.toString(secsRemaining);
        printTime(secs);
        t.sleep(1000);
        secsRemaining = secsRemaining - 1;
      }

    }catch (InterruptedException e) {
      e.printStackTrace();
    }
  }


  public void printTime(String secs){
    b.setText(secs);
  }
}
