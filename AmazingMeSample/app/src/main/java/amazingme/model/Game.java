package amazingme.model;

import android.support.v7.app.AppCompatActivity;

public interface Game /*extends AppCompatActivity implements some kind of view, i believe*/ {

    void takeover(); // should allow the game to take-over control... basically another activity

    GameResult resign(); // should return control to the main activity (or the last activity to have been active)

    int score(); //should have a good way to score each interaction

    Problem[] problemAreas(); //should implement finding problem areas that decreased score in each interaction

    Milestone[] relatedMilestones();

}
