package amazingme.util;

import android.util.Log;

import java.util.List;

import amazingme.model.Child;
import amazingme.model.GameResult;
import amazingme.model.Milestone;
import amazingme.model.Skill;

public class AverageCalculator {

    public AverageCalculator() {}

    public static double calculateSkillAverageFor(Child child, Skill skill) {
        double total = 0;
        int numberOfItems = 0;
        for (Milestone milestone : skill.getCurrentlyMeasuredMilestonesRelatedToThisSkill()) {
            List<GameResult> gameResultsForMilestone = child.getGameResultsCorrespondingTo(milestone);
            if (gameResultsForMilestone != null) {
                for (GameResult gameResult : gameResultsForMilestone) {
                    //if (gameResult != null) {
                        total += gameResult.getScore();
                        numberOfItems++;
                    //}
                }
            }
        }
        return numberOfItems == 0 ? Double.NaN : total / numberOfItems;
    }

    public static double calculateSkillAverageFor(Child child, List<Skill> skills) {
        double total = 0;
        int numberOfItems = 0;
        for (Skill skill : skills) {
            for (Milestone milestone : skill.getCurrentlyMeasuredMilestonesRelatedToThisSkill()) {
                List<GameResult> gameResultsForMilestone = child.getGameResultsCorrespondingTo(milestone);
                if (gameResultsForMilestone != null) {
                    for (GameResult gameResult : gameResultsForMilestone) {
                        //if (gameResult != null) {
                            total += gameResult.getScore();
                            numberOfItems++;
                        //}
                    }
                }
            }
        }
        return numberOfItems == 0 ? Double.NaN : total / numberOfItems;
    }

    public static double calculateMilestoneAverageFor(Child child, Milestone milestone) {
        double total = 0;
        int numberOfItems = 0;
        List<GameResult> gameResults = child.getGameResultsCorrespondingTo(milestone);
        if (gameResults != null) {
            for (GameResult gameResult : gameResults) {
                //if (gameResult != null) {
                    total += gameResult.getScore();
                    numberOfItems++;
                //}
            }
        }
        return numberOfItems == 0 ? Double.NaN : total / numberOfItems;
    }

}
