# Amazing Me

Interactive Book Game is a game that is intended to help parents of very young kids (2-5 years old) to measure their children's progress in terms of their brain development. This game is also based on the "Amazing Me" book, which can be found on the CDC website.


# Release Notes for Amazing Me v0.1
## New Features
* "Game Selection Page" that dynamically loads games as they are added to the codebase
* "Performance Page" with breakdown of performance for each skill and each milestone 
* Google Firebase integration and design of database schema
* Login/Registration/Forgot password implementations (you can have an account now!)
* Navigation bar to move quickly and easily throughout the application  

## Bug Fixes
* Fixed problem where navigation bar was unclickable
* Fixed display on performance graphs to show correct dates
* Fixed problem where some accounts were not loaded correctly
* Fixed problem where some games were not loaded and caused the app to crash

## Known Bugs
* Finishing a game can throw an exception and cause the app to crash
* Older accounts can have problems loading and can cause the app to crash


# Installation Guide
## Pre-requisites
* The device must be an Android device running version 5.1.1 or later 
* Preferrably run on an Android tablet 

## Download Instructions
* Currently the APK is available by request from the development team or Dr. Rosa Arriaga
* When the app is ready for public consumption, it will be available on the Google Play Store

## Installation
* Download the APK and click install (like any other non-default application on the phone)

## Running the app
* Click on the icon for the game after it has finished installing, and have fun!




# Amazing Me Game Integration

Integrating existing game activities is simple when using the Amazing Me framework. The step-by-step instructions to do so are below! The instructions assume you are starting from scratch, but the necessary steps should follow closely even if you have already started designing your Activity class. 


## 1
Add a new layout resource file to the "R.layout" folder. This is where your main UI components are more than likely going to be defined. The current naming convention starts with the words "activity" and "game", followed by the name of the game. Each word should be separated by underscore and each would should be lowercase. Each component in the xml should start with the name following "activity" (as shown in the example below). 

Ex. "activity_game_my_new_game.xml" has a component with an id "game_my_new_game_end_button"


## 2
Add a class to the package "amazingme.activities.game". The class should follow normal Java naming conventions, and will have a name similar to the layout file you just created. For instance, if our game is "My New Game", the layout file should be named as above and the .java file should be name "MyNewGame". Don't forget to add the package statement at the top of the file. Your class should extend the "AmazingMeGame" class, and the constructor for the game class can simply call the super constructor, passing in the unique layout for the game ("super(R.layout.activity_game_my_new_game.xml))". 


## 3
In the app/src/main folder, you'll find an XML file labeled "AndroidManifest.xml". Under the "application" tag, add an activity, following the conventions already in the file. Roughly
```
  <activity android:name="amazingme.activities.games.MyNewGame"/>
```

## 3b
Now, go back to your layout file in the R.layout folder and add your newly created class as the context for the layout. You might have to import some other things, but it will roughly read
```
  tools:context="amazingme.activities.game.MyNewGame"
```
within the top-level tag of the XML.


## 3c
Go to the EnumeratedActivity class (amazingme.app package) and add an entry for your new game. The value is up to your choice but typically follows the name of the activity ("MyNewGame" would have a value of "MY_NEW_GAME"), and the constructor takes in the class ("MyNewGame.class"), followed by two booleans. The first indicates if the activity is a game (so put "true"). The second, "isActive", also takes a boolean and indicates whether or not to include a game in a build. For testing, put "true". If you're building a game but haven't finished yet (and don't want to trash your work), put false. 


## 3d (this is the only part that is annoying... sorry there's so many parts!)
Now, back in the class you made implement the activityName() method. This should simply return the EnumeratedActivity value you just enumerated. 

## 4
Next, import the following classes (they are all required for setup)::
```
import com.amazingme.activities.R;
import amazingme.activities.util.GameInfo;
import amazingme.activities.util.Icon;
import amazingme.app.EnumeratedActivity;
import amazingme.app.AmazingMeGame;
import amazingme.model.GameResult;
import amazingme.model.Milestone;
import amazingme.model.Problem;
```

## 5
Add the two necessary annotations just above the name of the class. The first, @Icon, is a reference to the preview the framework will use for displaying your game. It should reference a "drawable" in the R.drawable package (something like "R.drawable.mynewgamebackground"). 

The second, @GameInfo, is some information the framework uses in populating the game page and processing the information from the game. The "value" field should be the name desired for a preview of the game (in the Game Selection Page). The "instruction" field should be filled with a String with simple instrucitons on how to play the game. Finally, the "milestone" field should be an array of the Milestone Enum values that specify the milestones the game will measure. 

Check out the package "amazingme.model.Milestone" for a full list of milestones that can be measured. *NOTE* - only values that have the value of "true" for the "isMeasured" field of the Milestone are available to be measured. Please check you have not included milestones that are not supported as being measured. 


## 6
Now, let's use some of those import statements and fill out the class a bit more. First, implement the void method initGame(). This method is where you can very easily add listeners to the user interface, initialize services, and get instances of the interface (such as Buttons or TextViews). 


## 7
One of the last things we need to do is fill out the updateGameResults() method. This method updates the app and let's the parents know better how the child performs. It does not return a value, but instead updates a list of GameResult objects. You should instantiate a GameResult object for each Milestone you are measuring in the game. 

For each GameResult object you create, set the related milestone using setRelatedMilestone(), passing in the milestone this result should reflect. If needed, add a Problem enumerated type using the addProblem() method. A list of currently available problem values is in the amazingme.model.Problem class. Feel free to add to this class to reflect problem areas, but make sure the values are unique and useful. 

Finally, set the score for the GameResult objects using setScore(), passing in an integer between 0 and 100 (inclusive), and add the objects to the "gameResults" object (it's provided in the parent class for you). 


## 8
When you have decided the user is done playing the game (whether they have finished their time or have completed the game or anything else), call the resign() method. This method takes a boolean indicating if the user has finished the game or not. If they have finished the game ("resign(true)"), it will use your updateGameResults() method to update the user's results. Otherwise, it sends control back to the Amazing Me framework and the user can continue as they please. 


The rest is up to you! Feel free to add to the issues page and let us know what's left to do and what you would like available to you. If you have idea for common services that should be available to games, feel free to suggest them. 

We hope to make the game development process as easy as possible and to provide developers with a comprehensive resource bundle to allow them to focus on game design and performance evaluation. If you have ideas on how to make that process better, let us know! 

!HAPPY CODING!



- The Amazing Me Team 
