package amazingme.activities.app;

import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class GameMenuItemAdapter extends BaseAdapter {
    private Context mContext;
    private List<Integer> gameIconIds;
    private List<String> gameTitles;

    public GameMenuItemAdapter(Context c, List<Integer> gameIconIds, List<String> gameTitles) {
        mContext = c;
        this.gameIconIds = gameIconIds;
        this.gameTitles = gameTitles;
    }

    @Override
    public int getCount() {
        if (gameIconIds.size() != gameTitles.size()) {
            Log.e(GameMenuItemAdapter.class.getName(),
                    "Unexpected size difference error. GameIcons and GameTitles should have the same size");
        }
        return gameIconIds.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


    // create a new ImageView for each item referenced by the Adapter
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout viewGroup = createLinearLayout();
        ImageView imageView = createImageView(gameIconIds.get(position));
        TextView textView = createTextView(gameTitles.get(position));
        viewGroup.addView(imageView);
        viewGroup.addView(textView);

        return viewGroup;
    }


    private ImageView createImageView(int gameIconId) {
        int IMAGE_WIDTH = 400;
        int IMAGE_HEIGHT = 400;
        ImageView imageView;
        imageView = new ImageView(mContext);
        imageView.setLayoutParams(new GridView.LayoutParams(IMAGE_WIDTH, IMAGE_HEIGHT));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setPadding(2, 2, 2, 2);
        imageView.setImageResource(gameIconId);
        return imageView;
    }

    private TextView createTextView(String text) {
        int TEXT_SIZE = 30;
        TextView textView;
        textView = new TextView(mContext);
        textView.setText(text);
        textView.setTextSize(TEXT_SIZE);
        textView.setGravity(Gravity.CENTER);
        return textView;
    }

    private LinearLayout createLinearLayout() {
        LinearLayout viewGroup = new LinearLayout(mContext);
        viewGroup.setOrientation(LinearLayout.VERTICAL);
        viewGroup.setGravity(Gravity.CENTER);
        return viewGroup;
    }
}
