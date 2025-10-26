CBL Java Game 

This project is a small Java Swing game on the model of the game Undertale. After downloading and extracting the folder, open it in VS Code and run MainGame.java. VS Code should detect the main class automatically; if it asks for a JDK, select Java 17. The game opens in a window and starts from a simple start screen that switches to the gameplay screen when you press the start control. No external libraries are required beyond the standard Java runtime and the Java extensions in VS Code.

The gameplay is straightforward. You control the player character on a 2D screen and can move around the world using the arrow keys. Pressing space performs a basic attack that creates a short‑lived hitbox. The attack has different timing or damage to show the contrast with the basic strike. Collisions stop the player at walls and other solid tiles so you cannot walk through scenery. When your attack’s hitbox overlaps an enemy, the enemy loses health and can be defeated. When the enemy or the boss touches or attacks you, your health decreases.

The boss demonstrates a small finite state machine. It idles, then chases, then performs an attack, then recovers before resuming. Its attacks are telegraphed so the player has a small window to react.

For assessment, follow a simple flow. Start the program and switch from the start screen to gameplay. Move in several directions and test that the camera or viewport remains stable and that you cannot leave the play area. Walk into walls to confirm collision blocking. Trigger a basic attack and strike an enemy while also attempting to swing into empty space to show that damage only occurs on overlap. Take damage from an enemy to verify that the health display updates and that the death condition leads to game over. Spawn the boss and narrate how the behavior changes as it switches between idle, chase, and attack.

These notes are written to help you run and judge the current build quickly. They describe the expected controls, the observable features, and the simplest path to demonstrate correctness of movement, collision, combat, health, boss behavior, and pause handling.
