package amazingme.activities.app;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.amazingme.activities.R;

import amazingme.app.EnumeratedActivity;

import amazingme.model.AmazingMeAppCompatActivity;

public class EndGameActivity extends AmazingMeAppCompatActivity {
    private Button exitBtn, replayBtn, continueBtn;
    private int score;
    private EditText scoreField;
    private TextView scoreLabel;

    public EndGameActivity() { super(R.layout.activity_end_game); }

    @Override
    public EnumeratedActivity activityName() {
        return EnumeratedActivity.END_GAME;
    }

    @Override
    public void bindToUserInterface() {
        exitBtn = (Button) findViewById(R.id.end_game_activity_exit_button);
        replayBtn = (Button) findViewById(R.id.end_game_activity_replay_button);
        continueBtn = (Button) findViewById(R.id.end_game_activity_continue_button);
        scoreField = (EditText) findViewById(R.id.end_game_activity_display_edittext);

        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goTo(EnumeratedActivity.GAME_MENU);
            }
        });
        replayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goTo(EnumeratedActivity.REGISTRATION); //go back to game enum
            }
        });
        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goTo(EnumeratedActivity.REGISTRATION); //go to next game enum
            }
        });
    }
}

