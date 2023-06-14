You can run the whole code by running thw main java file which is Main.java. 


I have created 2 modules one for controller and one for models.

The models module includes,
Game.java - which contains the logic of the whole game and required entites.
GameInitialisation.java - This class helps in intialisation of game by taking input from the user.
and other classes.


I have designed the game in this way what this game will do is it will first take input from console for no. of players
and player information and it will distribut 5 cards to each of them. Next a random card is drawn from the draw pile
at the start of the game and players decide which card to play based on that topcard. Since when action card comes and
it cannot be the top card to play, so there what I have done is the top card of the draw pile will be the card that 
will become the next topcard. A player can select his card based on top card from console in case the player does not
have top card the game will automatically pick from draw pile and assign it to the player. 