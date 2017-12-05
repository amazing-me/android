package amazingme.util;


import android.util.Log;

import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.DataPointInterface;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.Series;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
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
        List<GameResult> gameResults = child.getGameResultsCorrespondingTo(milestone);
        if (gameResults == null) {
            return Arrays.copyOf(dataPoints.toArray(), dataPoints.size(), DataPoint[].class);
        }
        GameResult[] gameResultsAsArray = new GameResult[gameResults.size()];
        for (int i = 0; i < gameResultsAsArray.length; i++) {
            gameResultsAsArray[i] = gameResults.get(i);
        }
        Arrays.sort(gameResultsAsArray, new Comparator<GameResult>() {
            @Override
            public int compare(GameResult o1, GameResult o2) {
                return o1.getTimestamp() < o2.getTimestamp() ? -1 : o1.getTimestamp() == o2.getTimestamp() ? 0 : 1;
            }
        });
        for (int i = 0; i < gameResultsAsArray.length; i++) {
            if (gameResultsAsArray[i] != null) {
                double totalOfScoresUpToAndIncludingGameResult = 0;
                int numOfScoresUpToAndIncludingGameResult = 0;
                for (int j = 0; j <= i; j++) {
                    if (gameResultsAsArray[j] != null) {
                        totalOfScoresUpToAndIncludingGameResult += gameResultsAsArray[j].getScore();
                        numOfScoresUpToAndIncludingGameResult++;
                    }
                }
                Log.e("datapoints", "adding " + gameResultsAsArray[i].getTimestamp() + " and " + totalOfScoresUpToAndIncludingGameResult / numOfScoresUpToAndIncludingGameResult);
                long timestamp = gameResultsAsArray[i].getTimestamp();
                Date date = new Date(timestamp);

                dataPoints.add(new DataPoint(date, totalOfScoresUpToAndIncludingGameResult / numOfScoresUpToAndIncludingGameResult));
            }
        }
        return Arrays.copyOf(dataPoints.toArray(), dataPoints.size(), DataPoint[].class);
    }

}
