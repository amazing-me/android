package amazingme.activities.app;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.amazingme.activities.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import amazingme.app.EnumeratedActivity;
import amazingme.controller.ActivityManager;
import amazingme.model.Milestone;
import amazingme.model.Skill;

public class PerformanceDetailActivity extends NavigationBarActivity {
    public PerformanceDetailActivity() { super(R.layout.activity_performance_detail); }

    @Override
    public EnumeratedActivity activityName() {
        return EnumeratedActivity.PERFORMANCE_DETAIL;
    }

    @Override
    public void bindToUserInterface() {
        final Milestone milestone = getMilestoneFromBundle();
        if (milestone == null) {
            Log.e("PERFORMANCE DETAIL", "Internal application error. Milestone should not be null");
        }

        final TextView milestoneHeaderTextView = (TextView) findViewById(R.id.milestone_header);
        milestoneHeaderTextView.setText(milestone.toString());
    }

    private Milestone getMilestoneFromBundle() {
        try {
            return (Milestone) getIntent().getSerializableExtra(getResources().getString(R.string.key_milestone));
        } catch (ClassCastException e) {
            return null;
        }
    }
}
