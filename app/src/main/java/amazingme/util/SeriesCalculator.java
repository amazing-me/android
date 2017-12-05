package amazingme.util;


import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.DataPointInterface;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.Series;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import amazingme.model.Child;
import amazingme.model.GameResult;
import amazingme.model.Milestone;
import amazingme.model.Skill;

public class SeriesCalculator {

    public SeriesCalculator() {}

    public static DataPoint[] calculateSeriesFor(Child child, List<Skill> skills) {
        List<DataPoint> dataPoints = new LinkedList<>();
        for (Skill skill : skills) {
            dataPoints.addAll(Arrays.asList(calculateSeriesFor(child, skill)));
        }
        return Arrays.copyOf(dataPoints.toArray(), dataPoints.size(), DataPoint[].class);
    }

    public static DataPoint[] calculateSeriesFor(Child child, Skill skill) {
        List<DataPoint> dataPoints = new LinkedList<>();
        for (Milestone milestone : skill.getCurrentlyMeasuredMilestonesRelatedToThisSkill()) {
            dataPoints.addAll(Arrays.asList(calculateSeriesFor(child, milestone)));
        }
        return Arrays.copyOf(dataPoints.toArray(), dataPoints.size(), DataPoint[].class);
    }

    public static DataPoint[] calculateSeriesFor(Child child, Milestone milestone) {
        List<DataPoint> dataPoints = new LinkedList<>();
        if (child.getGameResults().get(milestone.toString()) != null) {
            for (GameResult gameResult : child.getGameResults().get(milestone.toString())) {
                if (gameResult != null) {
                    long timestamp = gameResult.getTimestamp();
                    Date date = new Date(timestamp);
                    dataPoints.add(new DataPoint(date, gameResult.getScore()));
                }
            }
        }
        return Arrays.copyOf(dataPoints.toArray(), dataPoints.size(), DataPoint[].class);
    }

}
