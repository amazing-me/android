package amazingme.activities.app;

import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.amazingme.activities.R;

import java.util.LinkedList;
import java.util.List;

import amazingme.activities.util.GameTitle;
import amazingme.activities.util.Icon;
import amazingme.app.EnumeratedActivity;
import amazingme.model.AmazingMeAppCompatActivity;
import amazingme.model.AmazingMeGame;

public class GameMenuActivity extends AmazingMeAppCompatActivity {
    private final String DEFAULT_GAME_TITLE = "Unnamed Game";
    private final int DEFAULT_GAME_ICON_ID = R.drawable.amazingmelogo;

    private List<Integer> gameIcons = new LinkedList<>();
    private List<String> gameTitles = new LinkedList<>();
    private List<EnumeratedActivity> gamesClasses;

    public GameMenuActivity() { super(R.layout.activity_game_menu); }

    @Override
    public EnumeratedActivity activityName() {
        return EnumeratedActivity.GAME_MENU;
    }

    @Override
    public void bindToUserInterface() {
        gamesClasses = getAppContext().getGames();
        populateGameItems();

        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new GameMenuItemAdapter(this, gameIcons, gameTitles));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                goTo(gamesClasses.get(position));
            }
        });
    }

    private void populateGameItems() {
        int gameIconId;
        String gameTitle;
        for (EnumeratedActivity activity : gamesClasses) {
            Class<? extends AmazingMeGame> gameClass = activity.getAppCompatGame();
            gameIconId = gameClass.isAnnotationPresent(Icon.class) ?
                    gameClass.getAnnotation(Icon.class).value() :
                    DEFAULT_GAME_ICON_ID;
            gameTitle = gameClass.isAnnotationPresent(GameTitle.class) ?
                    gameClass.getAnnotation(GameTitle.class).value() :
                    DEFAULT_GAME_TITLE;

            gameIcons.add(gameIconId);
            gameTitles.add(gameTitle);
        }
    }


}
