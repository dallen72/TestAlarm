
import java.io.IOException;

interface Beepable {
 String[] cmdScript = new String[]{"/bin/bash", "./playSound.sh"};

 static public void beep() {
   try {
     Process procScript = Runtime.getRuntime().exec(cmdScript);
   } catch(IOException e) {
     e.printStackTrace();
   }
 }
}
