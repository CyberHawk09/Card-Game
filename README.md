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