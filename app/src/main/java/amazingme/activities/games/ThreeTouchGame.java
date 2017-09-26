package amazingme.activities.games;

import android.view.View;
import android.widget.Button;

import com.amazingme.activities.R;

import amazingme.activities.util.GameTitle;
import amazingme.activities.util.Icon;
import amazingme.app.EnumeratedActivity;
import amazingme.controller.ActivityManager;
import amazingme.model.AmazingMeGame;
import amazingme.model.GameResult;
import amazingme.model.Milestone;


//touch the screen three times within a minute to complete this.
@Icon(R.drawable.amazingbackground)
@GameTitle("Three Touch Game")
public class ThreeTouchGame extends AmazingMeGame {

    public ThreeTouchGame() {
        super(R.layout.activity_game_three_touch);
        this.relatedMilestones = new Milestone[] {Milestone.UNDERSTANDS_WORDS_LIKE_IN_ON_OR_UNDER};
    }

    @Override
    public GameResult gameResults() {
        return null;
    }

    @Override
    public EnumeratedActivity activityName() {
        return EnumeratedActivity.THREE_TOUCH_GAME;
    }

    @Override
    public void bindToUserInterface() {
        Button backBtn = (Button) findViewById(R.id.game_three_touch_back);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityManager.getInstance().goTo(ThreeTouchGame.this, EnumeratedActivity.GAME_MENU);
            }
        });
    }
}
