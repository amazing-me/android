package amazingme.model;

import amazingme.util.Constants;

public enum Milestone {

    //TODO -> not all milestones are included, only those thought to be measurable in amazingme :: https://www.cdc.gov/ncbddd/actearly/milestones/milestones-2mo.html

    //2 month milestones
    BEGINS_TO_SMILE_AT_PEOPLE("", Constants.TWO_MONTHS, Constants.SIX_YEARS),
    CAN_BRIEFLY_CALM,HERSELF ("", Constants.TWO_MONTHS, Constants.SIX_YEARS),
    TRIES_TO_LOOK_AT_PARENT("", Constants.TWO_MONTHS, Constants.SIX_YEARS),
    COOS_OR_MAKES_GURGLING_SOUNDS("", Constants.TWO_MONTHS, Constants.SIX_YEARS),
    TURNS_HEAD_TOWARD_SOUNDS("", Constants.TWO_MONTHS, Constants.SIX_YEARS),
    PAYS_ATTENTION_TO_FACES("", Constants.TWO_MONTHS, Constants.SIX_YEARS),
    BEGINS_TO_FOLLOW_THINGS_WITH_EYES("", Constants.TWO_MONTHS, Constants.SIX_YEARS),
    CRIES_AND_FUSSES_IF_ACTIVITY_DOESNT_CHANGE("", Constants.TWO_MONTHS, Constants.SIX_YEARS),
    CAN_HOLD_HEAD_UP_AND_BEGINS_TO_PUSH_UP_WHEN_LYING_ON_TUMMY("", Constants.TWO_MONTHS, Constants.SIX_YEARS),
    MAKES_SMOOTHER_MOVEMENTS_WITH_ARMS_AND_LEGS("", Constants.TWO_MONTHS, Constants.SIX_YEARS),

    UNDERSTANDS_WORDS_LIKE_IN_ON_OR_UNDER("", Constants.THREE_YEARS, Constants.SIX_YEARS);

    int appropriateAgeMinimum;
    int appropriateAgeMaximum;
    String descriptor;

    Milestone(String description, int minAge, int maxAge) {
        this.descriptor = description;
        this.appropriateAgeMinimum = minAge;
        this.appropriateAgeMaximum = maxAge;
    }

    Milestone() {
        this("no description available", 0, 0);
    }

}
