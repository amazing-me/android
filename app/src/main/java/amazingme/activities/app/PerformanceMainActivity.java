package amazingme.activities.app;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.amazingme.activities.R;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.helper.DateAsXAxisLabelFormatter;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import amazingme.activities.util.Formatter;
import amazingme.app.EnumeratedActivity;
import amazingme.model.Skill;
import amazingme.util.AverageCalculator;
import amazingme.util.SeriesCalculator;

public class PerformanceMainActivity extends NavigationBarActivity {
    public PerformanceMainActivity() { super(R.layout.activity_performance_main); }

    @Override
    public EnumeratedActivity activityName() {
        return EnumeratedActivity.PERFORMANCE_MAIN;
    }

    @Override
    public void bindToUserInterface() {
        final List<Skill> skillsWithResults = new ArrayList<>();
        final List<String> skillsWithResultsStrings = new ArrayList<>();
        for (Skill skill : Skill.values()) {
            if (!Double.isNaN(AverageCalculator.calculateSkillAverageFor(this.getUserContext().currentChildUser(), skill))) {
                skillsWithResultsStrings.add(skill.toString());
                skillsWithResults.add(skill);
            }
        }

        ListView listView = (ListView) findViewById(R.id.performance_skill_list);
        ArrayAdapter<String> skillsArrayAdapter =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, skillsWithResultsStrings);
        listView.setAdapter(skillsArrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Bundle bundle = new Bundle();
                bundle.putSerializable(getResources().getString(R.string.key_skill), skillsWithResults.get(position));
                goTo(EnumeratedActivity.PERFORMANCE_SKILL, bundle);
            }
        });

        TextView overallScore = (TextView)findViewById(R.id.overall_score);
        double average = AverageCalculator.calculateSkillAverageFor(this.getUserContext().currentChildUser(), skillsWithResults);
        if (Double.isNaN(average)) {
            overallScore.setText(R.string.no_data_to_display);
        } else {
            overallScore.setText(Formatter.getStringFormatterForScoreDisplay().format(average));
        }

        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(SeriesCalculator.calculateSeriesFor(this.getUserContext().currentChildUser(), skillsWithResults));
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


}
