package amazingme.activities.app;

import android.util.Log;
import android.widget.TextView;

import com.amazingme.activities.R;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.helper.DateAsXAxisLabelFormatter;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import amazingme.activities.util.Formatter;
import amazingme.app.EnumeratedActivity;
import amazingme.model.Milestone;
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

        TextView milestoneScore = (TextView)findViewById(R.id.milestone_score);
        double average = AverageCalculator.calculateMilestoneAverageFor(this.getUserContext().currentChildUser(), milestone);
        if (Double.isNaN(average)) {
            milestoneScore.setText(R.string.no_data_to_display);
        } else {
            milestoneScore.setText(Formatter.getStringFormatterForScoreDisplay().format(average));
        }

        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(SeriesCalculator.calculateSeriesFor(this.getUserContext().currentChildUser(), milestone));
        series.setThickness(8);
        series.setDataPointsRadius(12);

        GraphView graph = (GraphView) findViewById(R.id.milestone_performance_graph);
        graph.addSeries(series);
        graph.getGridLabelRenderer().setNumHorizontalLabels(3);
        graph.getGridLabelRenderer().setLabelFormatter(new DateAsXAxisLabelFormatter(this));
        graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setMaxY(100);
        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setMinX(series.getLowestValueX());
        graph.getViewport().setMaxX(series.getHighestValueX());
        graph.getGridLabelRenderer().setHumanRounding(false);
    }

    private Milestone getMilestoneFromBundle() {
        try {
            return (Milestone) getIntent().getSerializableExtra(getResources().getString(R.string.key_milestone));
        } catch (ClassCastException e) {
            return null;
        }
    }
}
