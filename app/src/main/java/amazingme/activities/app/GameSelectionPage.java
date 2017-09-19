package amazingme.activities.app;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.amazingme.activities.R;

import amazingme.app.EnumeratedActivity;
import amazingme.model.AmazingMeAppCompatActivity;

public class GameSelectionPage extends AmazingMeAppCompatActivity {

    private Button backBtn;
    private ImageButton ThreeTouchBtn;

    public GameSelectionPage() { super(R.layout.activity_game_selection_page); }

    @Override
    public EnumeratedActivity activityName() {
        return EnumeratedActivity.GAME_SELECTION_PAGE;
    }

    @Override
    public void bindToUserInterface() {
        backBtn = (Button) findViewById(R.id.game_selection_page_back_button);
        ThreeTouchBtn = (ImageButton) findViewById(R.id.game_selection_page_three_touch_button);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goTo(EnumeratedActivity.LOGIN);
            }
        });

        ThreeTouchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goTo(EnumeratedActivity.THREE_TOUCH_GAME);
            }
        });

    }

}
