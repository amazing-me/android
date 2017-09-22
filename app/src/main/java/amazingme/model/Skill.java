package amazingme.model;


import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public enum Skill {

    SOCIAL_AND_EMOTIONAL(Milestone.BEGINS_TO_SMILE_AT_PEOPLE, Milestone.TRIES_TO_LOOK_AT_PARENT),
    LANGUAGE_AND_COMMUNICATION(Milestone.COOS_OR_MAKES_GURGLING_SOUNDS, Milestone.TURNS_HEAD_TOWARD_SOUNDS,
            Milestone.UNDERSTANDS_WORDS_LIKE_IN_ON_OR_UNDER),
    COGNITIVE(Milestone.BEGINS_TO_FOLLOW_THINGS_WITH_EYES, Milestone.CRIES_AND_FUSSES_IF_ACTIVITY_DOESNT_CHANGE),
    MOVEMENT_AND_PHYSICAL_DEVELOPMENT;

    Set<Milestone> relatedMilestones;

    Skill(Milestone... milestones) {
        this.relatedMilestones = new HashSet<>();
        Collections.addAll(relatedMilestones, milestones);
    }

}
