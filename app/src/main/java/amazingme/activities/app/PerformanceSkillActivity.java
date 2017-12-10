package amazingme.activities.app;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.amazingme.activities.R;

import java.util.ArrayList;
import java.util.List;

import amazingme.app.EnumeratedActivity;
import amazingme.model.Milestone;
import amazingme.model.Skill;
import amazingme.util.AverageCalculator;

public class PerformanceSkillActivity extends NavigationBarActivity {
    public PerformanceSkillActivity() { super(R.layout.activity_performance_skill); }

    @Override
    public EnumeratedActivity activityName() {
        return EnumeratedActivity.PERFORMANCE_SKILL;
    }

    @Override
    public void bindToUserInterface() {
        final Skill skill = getSkillFromBundle();
        if (skill == null || skill.getCurrentlyMeasuredMilestonesRelatedToThisSkill().contains(Milestone.NONE)) {
            Log.e("PERFORMANCE SKILL", "Internal application error. Skill should not be null");
            return;
        }

        final List<Milestone> milestonesWithResults = new ArrayList<>();
        final List<String> milestonesWithResultsStrings = new ArrayList<>();
        for (Milestone milestone : skill.getCurrentlyMeasuredMilestonesRelatedToThisSkill()) {
            if (!Double.isNaN(AverageCalculator.calculateMilestoneAverageFor(this.getUserContext().currentChildUser(), milestone))) {
                milestonesWithResultsStrings.add(milestone.toString());
                milestonesWithResults.add(milestone);
            }
        }

        final TextView skillHeaderTextView = (TextView) findViewById(R.id.skill_header);
        skillHeaderTextView.setText(skill.toString());

        ListView listView = (ListView) findViewById(R.id.milestone_list);
        ArrayAdapter<String> milestonesAdapter =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, milestonesWithResultsStrings);
        listView.setAdapter(milestonesAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Bundle bundle = new Bundle();
                bundle.putSerializable(getResources().getString(R.string.key_milestone), milestonesWithResults.get(position));
                goTo(EnumeratedActivity.PERFORMANCE_DETAIL, bundle);
            }
        });

    }

    private Skill getSkillFromBundle() {
        try {
            return (Skill) getIntent().getSerializableExtra(getResources().getString(R.string.key_skill));
        } catch (ClassCastException e) {
            return null;
        }
    }
}
