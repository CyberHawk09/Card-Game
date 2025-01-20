# Card-Game
## Changelogs Diary
### December 4
> Created java files (Card.java, Character.java, Ability.java, Main.java)

### December 5
> Made encapsulation methods for the instance variables<br>
> Made all constructors

### December 6
> Added health & MAX_HEALTH instance variables to Character class<br>
> Added abilityIndex() in Character file<br>
> Ran some tests in Main.java and debugged

### December 8
> Added Player.java to contain all cards a player has in their deck, hand, etc.<br>
> Changed Character.java to Person.java because Character is already a built-in object<br>
> Removed Card.java's image and position attributes (replaced position with Player.java's ArrayLists)<br>
> Removed Ability.java's description because it was unnecessary<br>
> Added moveCost and attackCost attributes to Person.java

### December 12
> Moved attackCost attribute to Ability.java instead of Person.java

### December 21
> Added UserInterface.java to control the user interface (currently Scanner, but might change to JFrame later)<br>
> Began working on game logic (runGame, runTurn, etc.)

### December 26
> Began working on JFrame and JButton tests

### December 29
> Added getHand methods

### January 6
> Added some JButtons

### January 7
> Finished adding all JButtons

### January 8
> Completed all game logic

### January 9
> Added actionListeners to buttons<br>
> Figured out how to add images to buttons

### January 10
> Added arrays to store JButtons rather than individual variables<br>
> Discovered the use of HTML strings for multi-line text in a JButton/Label

### January 11
> Began setting up the images and text for each JButton (Discovered that I would need a separate JLabel for each JButton in order to display text AND an image)

### January 12
> Fixed JLabel + JButton setup so only one JButton should be necessary<br>
> Fixed Player.java constructor, getActive, setActive, and deckDraw methods<br>
> Added deckReset method to Player.java<br>
> Added update methods to UserInterface.java<br>
> Added getMaxHealth method to Person.java<br>
> Tested layouts for GUI

### January 13
> Added update(p1, p2) content<br>
> Began connecting game logic to GUI

### January 14
> Some quick changes in Main.java code<br>
> Continued connecting game logic to GUI<br>
> Reworked deckReset method

### January 15
> Made deckDraw method less repetitive<br>
> Modified ability display for person cards<br>
> Added compareTo for Ability.java

### January 16
> Continued testing GUI + game logic

### January 17
> Added more test cases in Main.java<br>
> Fixed Ability.java compareTo method<br>
> Fixed some Player.java deckDraw

### January 18
> Fixed game logic to work properly<br>
> Completely connected GUI with game logic<br>
> Added some Person and Ability presets for cards<br>
> Added copy() method for Person.java<br>
> Made person cards look like they move to the active position<br>
> Fixed some attack logic<br>
> Added File IO to save records<br>
> Added end screen to display records, winner, amount of turns it took, etc.

### January 19
> Added javadoc comments<br>
> Added sorting algorithms and recursion<br>
> Added Copyable interface<br>
> Added a walkthrough JLabel in the top-right corner<br>
> Added colours to all JButtons<br>
> Removed images