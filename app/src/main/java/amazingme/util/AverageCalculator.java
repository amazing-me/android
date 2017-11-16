package amazingme.util;

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
            for (GameResult gameResult : child.getGameResults().get(milestone.toString())) {
                total += gameResult.getScore();
                numberOfItems++;
            }
        }
        return numberOfItems == 0 ? Double.NaN : total / numberOfItems;
    }

    public static double calculateSkillAverageFor(Child child, List<Skill> skills) {
        double total = 0;
        int numberOfItems = 0;
        for (Skill skill : skills) {
            for (Milestone milestone : skill.getCurrentlyMeasuredMilestonesRelatedToThisSkill()) {
                if (child.getGameResults().get(milestone.toString()) != null) {
                    for (GameResult gameResult : child.getGameResults().get(milestone.toString())) {
                        total += gameResult.getScore();
                        numberOfItems++;
                    }
                }
            }
        }
        return numberOfItems == 0 ? Double.NaN : total / numberOfItems;
    }

    public static double calculateMilestoneAverageFor(Child child, Milestone milestone) {
        double total = 0;
        int numberOfItems = 0;
        if (child.getGameResults().get(milestone.toString()) != null) {
            for (GameResult gameResult : child.getGameResults().get(milestone.toString())) {
                total += gameResult.getScore();
                numberOfItems++;
            }
        }
        return numberOfItems == 0 ? Double.NaN : total / numberOfItems;
    }

}
