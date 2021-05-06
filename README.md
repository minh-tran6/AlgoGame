# AlgoGame
This android app is aimed to help understand various data structures and algorithms.
The 3 three games we have should help visualize how each of this structures work and hopefully inspire people to research them and apply it in their lives


---

## HOMESCREEN
   - Once the application is launched, it will go to the "get user's name" screen where the user can decide to play. 
   - Once user presses start, a dialog edit text will pop up to ask user for their name and prompt them to the game options or homescreen.
   - Homescreen will consist user's name, buttons directory to games, and exit button.

## STACK GAME
   - When the user chooses stack game from the main screen, a tutorial screen will appear, describing how to play the game.
   - Users can choose to play the game by pressing the "Start" button on the tutorial screen.
   - The gameplay screen consists of the timer, prompt, scrambled letters, the stack, push, pop, and submit button. The main objective is to push/pop in a certain sequence so that the scrambled letter matches the prompt.
   - Once the game is over, a pop up will appear and bring the user back to the main screen.

## QUEUE GAME
   - When the user chooses the queue game from the main screen, a tutorial screen will appear, describing how to play the game.
   - User can choose to play the game by pressing the "Start" button on the tutorial screen.
   - The gameplay screen consists of the timer, prompt, scrambled letters, the stack, the robot, left, right, down button. Main objective is to pick left, right, down direction in such a way that the robot will pick up the letters to make a word that matches the prompt. The direction of the orders will behave like a queue (FIFO).
   - Once the game is over, a pop up will appear and bring the user back to the main screen.

## SORT GAME
   - Once the button for the game is pressed, a tutorial screen should appear.
   - After reading it tap start to begin the game.
   - A random layout will be displayed each representing 3 sorting algorithms follow the instructions on screen once again to play the game.
   - Based on the position of the number the appropriate toast message will pop up informing you of your choice 
   - When dragging the number please ensure that the drag shadow is in a position where the tile would be if it was part of the array, like in the question
   - The tile will only move if in the drop point of which there are two for each sort:
   -     For insertion sort it is in the empty spot within the array and to the left of the array
   -     For the other sorts it is on the left and right side of the array.
   - Once complete you can return to the homes creen anytime using the standard android UI.


### Notes
1. We could not optimize the app to look nice on higher resolutions due to time constraints. Please use the default resolution and portrait only
2. Sort game challenges: Due to time constraints the position of the dropped tile will be off a bit

