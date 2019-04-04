# Spyfall!
## Joseph Chang & Francis Adams

This repository has all of the files needed in Android Studio to run as a project. Simply open the main folder in Android Studio.

## Rules:
Spyfall is a fun game for 3 to infinite (preferably < 12) people. There are about *5 rounds* (more for bigger parties) that take about *5 minutes* (more for bigger parties) each. There is *one spy* per round that **tries to figure out the location** and everyone else **tries to figure out who the spy is**. Score is distributed at the end of the game like so:

- The spy earns 2 points if no one accuses him / her of being the spy
- The spy earns 4 points if a non-spy is accused of being a spy
- The spy earns 4 points if he / she guesses the location
- Non-spy who initiated a successful accusation of the spy earns 2 points
- Everyone else (after successful accusation) earns 1 point

### How work was split up:
Joseph:
- Java Class Code
- Markdown Readme
- Git Implementation

Francis:
- XML
- Resource data population
- Research on Timer class, multiple intents / activities, etc
- Concept Design

## Instructions:
On the first screen, you will be able to select the amount of players (default 3) and the amount of spies (though we recommend only 1). Press 'Start' to begin the game.

Pressing start will start a new screen that will assign roles to players. Drag your role out of the envelope and keep it hidden from other players; memorize the role and location. Press 'Got It' and pass the phone to the next person. Repeat until last player receives a role.

Once everyone receives a role, the location screen will now show up, allowing all players to see all possible locations. Press the start game button to start a timer for the round. You can exit the game at anytime using the 'Finish Game' button.
Have fun!
