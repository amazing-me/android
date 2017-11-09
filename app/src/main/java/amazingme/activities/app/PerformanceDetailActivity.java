package amazingme.activities.app;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.amazingme.activities.R;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.DataPointInterface;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.Series;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import amazingme.activities.util.Formatter;
import amazingme.app.EnumeratedActivity;
import amazingme.controller.ActivityManager;
import amazingme.model.Milestone;
import amazingme.model.Skill;
import amazingme.util.AverageCalculator;
import amazingme.util.SeriesCalculator;

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

        // TODO -> look for NaN and replace with useful text
        TextView milestoneScore = (TextView)findViewById(R.id.milestone_score);
        milestoneScore.setText(Formatter.getStringFormatterForScoreDisplay()
                .format(AverageCalculator.calculateMilestoneAverageFor(this.getUserContext().currentChildUser(), milestone)));

        GraphView graph = (GraphView) findViewById(R.id.milestone_performance_graph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(SeriesCalculator.calculateSeriesFor(this.getUserContext().currentChildUser(), milestone));
        new LineGraphSeries<>();
        graph.addSeries(series);

    }

    private Milestone getMilestoneFromBundle() {
        try {
            return (Milestone) getIntent().getSerializableExtra(getResources().getString(R.string.key_milestone));
        } catch (ClassCastException e) {
            return null;
        }
    }
}
