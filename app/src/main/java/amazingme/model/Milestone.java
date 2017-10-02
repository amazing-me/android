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

    //4 month milestones
    SMILES_SPONTANEOUSLY_ESPECIALLY_AT_PEOPLE("", Constants.FOUR_MONTHS, Constants.SIX_YEARS),
    LIKES_TO_PLAY_WITH_PEOPLE_AND_MIGHT_CRY_WHEN_PLAYING_STOPS("", Constants.FOUR_MONTHS, Constants.SIX_YEARS),
    COPIES_SOME_MOVEMENTS_AND_FACIAL_EXPRESSIONS_LIKE_SMILING_OR_FROWNING("", Constants.FOUR_MONTHS, Constants.SIX_YEARS),
    BEGINS_TO_BABBLE("", Constants.FOUR_MONTHS, Constants.SIX_YEARS),
    BABBLES_WITH_EXPRESSION_AND_COPIES_SOUNDS_HE_HEARS("", Constants.FOUR_MONTHS, Constants.SIX_YEARS),
    CRIES_IN_DIFFERENT_WAYS_TO_SHOW_HUNGER_PAIN_OR_BEING_TIRED("", Constants.FOUR_MONTHS, Constants.SIX_YEARS),
    LETS_YOU_KNOW_IF_HE_IS_HAPPY_OR_SAD("", Constants.FOUR_MONTHS, Constants.SIX_YEARS),
    RESPONDS_TO_AFFECTION("", Constants.FOUR_MONTHS, Constants.SIX_YEARS),
    REACHES_FOR_TOY_WITH_ONE_HAND("", Constants.FOUR_MONTHS, Constants.SIX_YEARS),
    USES_HANDS_AND_EYES_TOGETHER_SUCH_AS_SEEING_A_TOY_AND_REACHING_FOR_IT("", Constants.FOUR_MONTHS, Constants.SIX_YEARS),
    FOLLOWS_MOVING_THINGS_WITH_EYES_FROM_SIDE_TO_SIDE("", Constants.FOUR_MONTHS, Constants.SIX_YEARS),
    WATCHES_FACES_CLOSELY("", Constants.FOUR_MONTHS, Constants.SIX_YEARS),
    RECOGNIZES_FAMILIAR_PEOPLE_AND_THINGS_AT_A_DISTANCE("", Constants.FOUR_MONTHS, Constants.SIX_YEARS),
    HOLDS_HEAD_STEADY_UNSUPPORTED("", Constants.FOUR_MONTHS, Constants.SIX_YEARS),
    PUSHES_DOWN_ON_LEGS_WHEN_FEET_ARE_ON_A_HARD_SURFACE("", Constants.FOUR_MONTHS, Constants.SIX_YEARS),
    MAY_BE_ABLE_TO_ROLL_OVER_FROM_TUMMY_TO_BACK("", Constants.FOUR_MONTHS, Constants.SIX_YEARS),
    CAN_HOLD_A_TOY_AND_SHAKE_IT_AND_SWING_AT_DANGLING_TOYS("", Constants.FOUR_MONTHS, Constants.SIX_YEARS),
    BRINGS_HANDS_TO_MOUTH("", Constants.FOUR_MONTHS, Constants.SIX_YEARS),
    WHEN_LYING_ON_STOMACH_PUSHES_UP_TO_ELBOWS("", Constants.FOUR_MONTHS, Constants.SIX_YEARS),

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
