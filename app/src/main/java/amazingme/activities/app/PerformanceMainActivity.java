package amazingme.activities.app;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.amazingme.activities.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import amazingme.app.EnumeratedActivity;
import amazingme.controller.ActivityManager;
import amazingme.model.Skill;

public class PerformanceMainActivity extends NavigationBarActivity {
    public PerformanceMainActivity() { super(R.layout.activity_performance_main); }

    @Override
    public EnumeratedActivity activityName() {
        return EnumeratedActivity.PERFORMANCE_MAIN;
    }

    @Override
    public void bindToUserInterface() {
        final List<Skill> allSkills = new ArrayList<>(Arrays.asList(Skill.values()));
        final List<String> allSkillsString = new ArrayList<>();
        for (Skill skill : allSkills) {
            allSkillsString.add(skill.toString());
        }

        ListView listView = (ListView) findViewById(R.id.performance_skill_list);
        ArrayAdapter<String> skillsArrayAdapter =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, allSkillsString);
        listView.setAdapter(skillsArrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Bundle bundle = new Bundle();
                bundle.putSerializable(getResources().getString(R.string.key_skill), allSkills.get(position));
                goTo(EnumeratedActivity.PERFORMANCE_SKILL, bundle);
            }
        });

    }


}
