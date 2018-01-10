# TestAlarm
Alarm for training for timed tests. Only tested on Ubuntu 16.

## Description
This was designed to help a student pace oneself on a timed test, expecially for tests which only allowed a short amount of time per question.

## Dependencies
* aplay installed in environment
* swing (java)

## Compilation
	$ chmod +x playSound.sh
	$ javac Alarm.java Beepable.java Main.java

## Usage
	$ java Main [SECS_PER_QUESTION]

The program window will pop up showing a button with a countdown time, starting with SECS_PER_QUESTION.

Clicking the button (or pressing the spacebar) will increment the time remaining by SECS_PER_QUESTION. This signifies a question has been completed.

When the timer gets to zero seconds, a beep will sound, notifying that the user should be completed with the question they are working on. When the timer gets to negative SECS_PER_QUESTION, the timer will repeatedly beep, notifying that the user is behind schedule by more than one question.
