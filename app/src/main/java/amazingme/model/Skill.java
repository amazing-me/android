package amazingme.model;


import java.util.HashSet;
import java.util.Set;

public enum Skill {
    SOCIAL_AND_EMOTIONAL("Social and Emotional",
            Milestone.BEGINS_TO_SMILE_AT_PEOPLE,
            Milestone.TRIES_TO_LOOK_AT_PARENT,
            Milestone.CAN_BRIEFLY_CALM,
            Milestone.SMILES_SPONTANEOUSLY_ESPECIALLY_AT_PEOPLE,
            Milestone.LIKES_TO_PLAY_WITH_PEOPLE_AND_MIGHT_CRY_WHEN_PLAYING_STOPS,
            Milestone.COPIES_SOME_MOVEMENTS_AND_FACIAL_EXPRESSIONS_LIKE_SMILING_OR_FROWNING,
            Milestone.KNOWS_FAMILIAR_FACES_AND_BEGINS_TO_KNOW_IF_SOMEONE_IS_A_STRANGER,
            Milestone.LIKES_TO_PLAY_WITH_OTHERS_ESPECIALLY_PARENTS,
            Milestone.RESPONDS_TO_OTHER_PEOPLES_EMOTIONS_AND_OFTEN_SEEMS_HAPPY,
            Milestone.LIKES_TO_LOOK_AT_SELF_IN_A_MIRROR,
            Milestone.MAY_BE_AFRAID_OF_STRANGERS,
            Milestone.MAY_BE_CLINGY_WITH_FAMILIAR_ADULTS,
            Milestone.HAS_FAVORITE_TOYS,
            Milestone.IS_SHY_OR_NERVOUS_WITH_STRANGERS,
            Milestone.CRIES_WHEN_MOM_OR_DAD_LEAVES,
            Milestone.HAS_FAVORITE_THINGS_AND_PEOPLE,
            Milestone.SHOWS_FEAR_IN_SOME_SITUATIONS,
            Milestone.HANDS_YOU_A_BOOK_WHEN_HE_WANTS_TO_HEAR_A_STORY,
            Milestone.REPEATS_SOUNDS_OR_ACTIONS_TO_GET_ATTENTION,
            Milestone.PUTS_OUT_ARM_OR_LEG_TO_HELP_WITH_DRESSING,
            Milestone.PLAYS_GAMES_SUCH_AS_PEEK_A_BOO_AND_PAT_A_CAKE,
            Milestone.LIKES_TO_HAND_THINGS_TO_OTHERS_AS_PLAY,
            Milestone.MAY_HAVE_TEMPER_TANTRUMS,
            Milestone.MAY_BE_AFRAID_OF_STRANGERS_TWO,
            Milestone.SHOWS_AFFECTION_TO_FAMILIAR_PEOPLE,
            Milestone.PLAYS_SIMPLE_PRETEND_SUCH_AS_FEEDING_A_DOLL,
            Milestone.MAY_CLING_TO_CAREGIVERS_IN_NEW_SITUATIONS,
            Milestone.POINTS_TO_SHOW_OTHERS_SOMETHING_INTERESTING,
            Milestone.EXPLORES_ALONE_BUT_WITH_PARENT_CLOSE_BY,
            Milestone.COPIES_OTHERS_ESPECIALLY_ADULTS_AND_OLDER_CHILDREN,
            Milestone.GETS_EXCITED_WHEN_WITH_OTHER_CHILDREN,
            Milestone.SHOWS_MORE_AND_MORE_INDEPENDENCE,
            Milestone.SHOWS_DEFIANT_BEHAVIOR_DOING_WHAT_HE_HAS_BEEN_TOLD_NOT_TO,
            Milestone.PLAYS_MAINLY_BESIDE_OTHER_CHILDREN_BUT_IS_BEGINNING_TO_INCLUDE_OTHER_CHILDREN_SUCH_AS_IN_CHASE_GAMES,
            Milestone.COPIES_ADULTS_AND_FRIENDS,
            Milestone.SHOWS_AFFECTION_FOR_FRIENDS_WITHOUT_PROMPTING,
            Milestone.TAKES_TURNS_IN_GAMES,
            Milestone.SHOWS_CONCERN_FOR_CRYING_FRIEND,
            Milestone.UNDERSTANDS_THE_IDEA_OF_MINE_AND_HIS_OR_HERS,
            Milestone.SHOWS_WIDE_RANGE_OF_EMOTIONS,
            Milestone.SEPARATES_EASILY_FROM_MOM_AND_DAD,
            Milestone.MAY_GET_UPSET_WITH_MAJOR_CHANGES_IN_ROUTINE,
            Milestone.DRESSES_AND_UNDRESSES_SELF,
            Milestone.ENJOYS_DOING_NEW_THINGS,
            Milestone.PLAYS_MOM_AND_DAD,
            Milestone.IS_MORE_AND_MORE_CREATIVE_WITH_MAKE_BELIEVE_PLAY,
            Milestone.WOULD_RATHER_PLAY_WITH_OTHER_CHILDREN_THAN_BY_HIMSELF,
            Milestone.COOPERATES_WITH_OTHER_CHILDREN,
            Milestone.OFTEN_CANT_TELL_WHATS_REAL_AND_WHATS_MAKE_BELIEVE,
            Milestone.TALKS_ABOUT_WHAT_SHE_LIKES_AND_WHAT_SHE_IS_INTERESTED_IN,
            Milestone.WANTS_TO_PLEASE_FRIENDS,
            Milestone.WANTS_TO_BE_LIKE_FRIENDS,
            Milestone.MORE_LIKELY_TO_AGREE_WITH_RULES,
            Milestone.LIKES_TO_SING_DANCE_AND_ACT,
            Milestone.IS_AWARE_OF_GENDER,
            Milestone.CAN_TELL_WHATS_REAL_AND_WHATS_MAKE_BELIEVE,
            Milestone.SHOWS_MORE_INDEPENDENCE_FOR_EXAMPLE_MAY_VISIT_A_NEXT_DOOR_NEIGHBOR_BY_HIMSELF_ADULT_SUPERVISION_STILL_NEEDED,
            Milestone.IS_SOMETIMES_DEMANDING_AND_SOMETIMES_VERY_COOPERATIVE
    ),

    LANGUAGE_AND_COMMUNICATION("Language and Communication",
            Milestone.COOS_OR_MAKES_GURGLING_SOUNDS, Milestone.TURNS_HEAD_TOWARD_SOUNDS,
            Milestone.UNDERSTANDS_WORDS_LIKE_IN_ON_AND_UNDER,
            Milestone.BEGINS_TO_BABBLE,
            Milestone.BABBLES_WITH_EXPRESSION_AND_COPIES_SOUNDS_HE_HEARS,
            Milestone.CRIES_IN_DIFFERENT_WAYS_TO_SHOW_HUNGER_PAIN_OR_BEING_TIRED,
            Milestone.RESPONDS_TO_SOUNDS_BY_MAKING_SOUNDS,
            Milestone.STRINGS_VOWELS_TOGETHER_WHEN_BABBLING_AH_EH_OH_AND_LIKES_TAKING_TURNS_WITH_PARENT_WHILE_MAKING_SOUNDS,
            Milestone.RESPONDS_TO_OWN_NAME,
            Milestone.MAKES_SOUNDS_TO_SHOW_JOY_AND_DISPLEASURE,
            Milestone.BEGINS_TO_SAY_CONSONANT_SOUNDS_JABBERING_WITH_M_B,
            Milestone.UNDERSTANDS_NO,
            Milestone.MAKES_A_LOT_OF_DIFFERENT_SOUNDS_LIKE_MAMAMAMA_AND_BABABABABA,
            Milestone.COPIES_SOUNDS_AND_GESTURES_OF_OTHERS,
            Milestone.USES_FINGERS_TO_POINT_AT_THINGS,
            Milestone.RESPONDS_TO_SIMPLE_SPOKEN_REQUESTS,
            Milestone.USES_SIMPLE_GESTURES_LIKE_SHAKING_HEAD_NO_OR_WAVING_BYE_BYE,
            Milestone.MAKES_SOUNDS_WITH_CHANGES_IN_TONE_SOUNDS_MORE_LIKE_SPEECH,
            Milestone.SAYS_MAMA_AND_DADA_AND_EXCLAMATIONS_LIKE_UH_OH,
            Milestone.TRIES_TO_SAY_WORDS_YOU_SAY,
            Milestone.SAYS_SEVERAL_SINGLE_WORDS,
            Milestone.SAYS_AND_SHAKES_HEAD_NO,
            Milestone.POINTS_TO_SHOW_SOMEONE_WHAT_HE_WANTS,
            Milestone.POINTS_TO_THINGS_OR_PICTURES_WHEN_THEY_ARE_NAMED,
            Milestone.KNOWS_NAMES_OF_FAMILIAR_PEOPLE_AND_BODY_PARTS,
            Milestone.SAYS_SENTENCES_WITH_TWO_TO_FOUR_WORDS,
            Milestone.FOLLOWS_SIMPLE_INSTRUCTIONS,
            Milestone.REPEATS_WORDS_OVERHEARD_IN_CONVERSATION,
            Milestone.POINTS_TO_THINGS_IN_A_BOOK,
            Milestone.FOLLOWS_INSTRUCTIONS_WITH_TWO_OR_THREE_STEPS,
            Milestone.CAN_NAME_MOST_FAMILIAR_THINGS,
            Milestone.UNDERSTANDS_WORDS_LIKE_IN_ON_AND_UNDER,
            Milestone.SAYS_FIRST_NAME_AGE_AND_SEX,
            Milestone.NAMES_A_FRIEND,
            Milestone.SAYS_WORDS_LIKE_I_ME_WE_AND_YOU_AND_SOME_PLURALS_CARS_DOGS_CATS,
            Milestone.TALKS_WELL_ENOUGH_FOR_STRANGERS_TO_UNDERSTAND_MOST_OF_THE_TIME,
            Milestone.CARRIES_ON_A_CONVERSATION_USING_TWO_TO_THREE_SENTENCES,
            Milestone.KNOWS_SOME_BASIC_RULES_OF_GRAMMAR_SUCH_AS_CORRECTLY_USING_HE_AND_SHE,
            Milestone.SINGS_A_SONG_OR_SAYS_A_POEM_FROM_MEMORY_SUCH_AS_THE_ITSY_BITSY_SPIDER_OR_THE_WHEELS_ON_THE_BUS,
            Milestone.TELLS_STORIES,
            Milestone.CAN_SAY_FIRST_AND_LAST_NAME,
            Milestone.SPEAKS_VERY_CLEARLY,
            Milestone.TELLS_A_SIMPLE_STORY_USING_FULL_SENTENCES,
            Milestone.USES_FUTURE_TENSE_FOR_EXAMPLE_GRANDMA_WILL_BE_HERE,
            Milestone.SAYS_NAME_AND_ADDRESS
    ),

    COGNITIVE("Cognitive",
            Milestone.BEGINS_TO_FOLLOW_THINGS_WITH_EYES,
            Milestone.CRIES_AND_FUSSES_IF_ACTIVITY_DOESNT_CHANGE,
            Milestone.PAYS_ATTENTION_TO_FACES,
            Milestone.LETS_YOU_KNOW_IF_HE_IS_HAPPY_OR_SAD,
            Milestone.RESPONDS_TO_AFFECTION,
            Milestone.REACHES_FOR_TOY_WITH_ONE_HAND,
            Milestone.USES_HANDS_AND_EYES_TOGETHER_SUCH_AS_SEEING_A_TOY_AND_REACHING_FOR_IT,
            Milestone.FOLLOWS_MOVING_THINGS_WITH_EYES_FROM_SIDE_TO_SIDE,
            Milestone.WATCHES_FACES_CLOSELY,
            Milestone.RECOGNIZES_FAMILIAR_PEOPLE_AND_THINGS_AT_A_DISTANCE,
            Milestone.LOOKS_AROUND_AT_THINGS_NEARBY,
            Milestone.BRINGS_THINGS_TO_MOUTH,
            Milestone.SHOWS_CURIOSITY_ABOUT_THINGS_AND_TRIES_TO_GET_THINGS_THAT_ARE_OUT_OF_REACH,
            Milestone.BEGINS_TO_PASS_THINGS_FROM_ONE_HAND_TO_THE_OTHER,
            Milestone.WATCHES_THE_PATH_OF_SOMETHING_AS_IT_FALLS,
            Milestone.LOOKS_FOR_THINGS_SHE_SEES_YOU_HIDE,
            Milestone.PLAYS_PEEK_A_BOO,
            Milestone.PUTS_THINGS_IN_HIS_MOUTH,
            Milestone.MOVES_THINGS_SMOOTHLY_FROM_ONE_HAND_TO_THE_OTHER,
            Milestone.PICKS_UP_THINGS_LIKE_CEREAL_OS_BETWEEN_THUMB_AND_INDEX_FINGER,
            Milestone.EXPLORES_THINGS_IN_DIFFERENT_WAYS_LIKE_SHAKING_BANGING_THROWING,
            Milestone.FINDS_HIDDEN_THINGS_EASILY,
            Milestone.LOOKS_AT_THE_RIGHT_PICTURES_OR_THING_WHEN_ITS_NAMED,
            Milestone.COPIES_GESTURES,
            Milestone.STARTS_TO_USE_THINGS_CORRECTLY_FOR_EXAMPLE_DRINKS_FROM_A_CUP_BRUSHES_HAIR,
            Milestone.BANGS_TWO_THINGS_TOGETHER,
            Milestone.PUTS_THINGS_IN_A_CONTAINER_TAKES_THINGS_OUT_OF_A_CONTAINER,
            Milestone.LETS_THINGS_GO_WITHOUT_HELP,
            Milestone.POKES_WITH_INDEX_FINGER,
            Milestone.FOLLOWS_SIMPLE_DIRECTIONS_LIKE_PICK_UP_THE_TOY,
            Milestone.KNOWS_WHAT_ORDINARY_THINGS_ARE_FOR_FOR_EXAMPLE_TELEPHONE_BRUSH_SPOON,
            Milestone.POINTS_TO_GET_THE_ATTENTION_OF_OTHERS,
            Milestone.SHOWS_INTEREST_IN_A_DOLL_OR_STUFFED_ANIMAL_BY_PRETENDING_TO_FEED,
            Milestone.POINTS_TO_ONE_BODY_PART,
            Milestone.SCRIBBLES_ON_HIS_OWN,
            Milestone.CAN_FOLLOW_ONE_STEP_VERBAL_COMMANDS_WITHOUT_ANY_GESTURES_FOR_EXAMPLE_SITS_WHEN_YOU_SAY_SIT_DOWN,
            Milestone.FINDS_THINGS_EVEN_WHEN_HIDDEN_UNDER_TWO_OR_THREE_COVERS,
            Milestone.BEGINS_TO_SORT_SHAPES_AND_COLORS,
            Milestone.COMPLETES_SENTENCES_AND_RHYMES_IN_FAMILIAR_BOOKS,
            Milestone.PLAYS_SIMPLE_MAKE_BELIEVE_GAMES,
            Milestone.BUILDS_TOWERS_OF_FOUR_OR_MORE_BLOCKS,
            Milestone.MIGHT_USE_ONE_HAND_MORE_THAN_THE_OTHER,
            Milestone.FOLLOWS_TWO_STEP_INSTRUCTIONS_SUCH_AS_PICK_UP_YOUR_SHOES_AND_PUT_THEM_IN_THE_CLOSET,
            Milestone.NAMES_ITEMS_IN_A_PICTURE_BOOK_SUCH_AS_A_CAT_BIRD_OR_DOG,
            Milestone.CAN_WORK_TOYS_WITH_BUTTONS_LEVERS_AND_MOVING_PARTS,
            Milestone.PLAYS_MAKE_BELIEVE_WITH_DOLLS_ANIMALS_AND_PEOPLE,
            Milestone.DOES_PUZZLES_WITH_THREE_OR_FOUR_PIECES,
            Milestone.UNDERSTANDS_WHAT_TWO_MEANS,
            Milestone.COPIES_A_CIRCLE_WITH_PENCIL_OR_CRAYON,
            Milestone.TURNS_BOOK_PAGES_ONE_AT_A_TIME,
            Milestone.BUILDS_TOWERS_OF_MORE_THAN_SIX_BLOCKS,
            Milestone.SCREWS_AND_UNSCREWS_JAR_LIDS_OR_TURNS_DOOR_HANDLE,
            Milestone.NAMES_SOME_COLORS_AND_SOME_NUMBERS,
            Milestone.UNDERSTANDS_THE_IDEA_OF_COUNTING,
            Milestone.STARTS_TO_UNDERSTAND_TIME,
            Milestone.REMEMBERS_PARTS_OF_A_STORY,
            Milestone.UNDERSTANDS_THE_IDEA_OF_SAME_AND_DIFFERENT,
            Milestone.DRAWS_A_PERSON_WITH_TWO_TO_FOUR_BODY_PARTS,
            Milestone.USES_SCISSORS,
            Milestone.STARTS_TO_COPY_SOME_CAPITAL_LETTERS,
            Milestone.PLAYS_BOARD_OR_CARD_GAMES,
            Milestone.TELLS_YOU_WHAT_HE_THINKS_IS_GOING_TO_HAPPEN_NEXT_IN_A_BOOK,
            Milestone.COUNTS_TEN_OR_MORE_THINGS,
            Milestone.CAN_DRAW_A_PERSON_WITH_AT_LEAST_SIX_BODY_PARTS,
            Milestone.CAN_PRINT_SOME_LETTERS_OR_NUMBERS,
            Milestone.COPIES_A_TRIANGLE_AND_OTHER_GEOMETRIC_SHAPES,
            Milestone.KNOWS_ABOUT_THINGS_USED_EVERY_DAY_LIKE_MONEY_AND_FOOD
    ),

    MOVEMENT_AND_PHYSICAL_DEVELOPMENT("Movement and Physical Development",
            Milestone.CAN_HOLD_HEAD_UP_AND_BEGINS_TO_PUSH_UP_WHEN_LYING_ON_TUMMY,
            Milestone.MAKES_SMOOTHER_MOVEMENTS_WITH_ARMS_AND_LEGS,
            Milestone.HOLDS_HEAD_STEADY_UNSUPPORTED,
            Milestone.PUSHES_DOWN_ON_LEGS_WHEN_FEET_ARE_ON_A_HARD_SURFACE,
            Milestone.MAY_BE_ABLE_TO_ROLL_OVER_FROM_TUMMY_TO_BACK,
            Milestone.CAN_HOLD_A_TOY_AND_SHAKE_IT_AND_SWING_AT_DANGLING_TOYS,
            Milestone.BRINGS_HANDS_TO_MOUTH,
            Milestone.WHEN_LYING_ON_STOMACH_PUSHES_UP_TO_ELBOWS,
            Milestone.ROLLS_OVER_IN_BOTH_DIRECTIONS_FRONT_TO_BACK_BACK_TO_FRONT,
            Milestone.BEGINS_TO_SIT_WITHOUT_SUPPORT,
            Milestone.WHEN_STANDING_SUPPORTS_WEIGHT_ON_LEGS_AND_MIGHT_BOUNCE,
            Milestone.ROCKS_BACK_AND_FORTH_SOMETIMES_CRAWLING_BACKWARD_BEFORE_MOVING_FORWARD,
            Milestone.STANDS_HOLDING_ON,
            Milestone.CAN_GET_INTO_SITTING_POSITION,
            Milestone.SITS_WITHOUT_SUPPORT,
            Milestone.PULLS_TO_STAND,
            Milestone.CRAWLS,
            Milestone.GETS_TO_A_SITTING_POSITION_WITHOUT_HELP,
            Milestone.PULLS_UP_TO_STAND_WALKS_HOLDING_ON_TO_FURNITURE,
            Milestone.MAY_TAKE_A_FEW_STEPS_WITHOUT_HOLDING_ON,
            Milestone.MAY_STAND_ALONE,
            Milestone.WALKS_ALONE,
            Milestone.MAY_WALK_UP_STEPS_AND_RUN,
            Milestone.PULLS_TOYS_WHILE_WALKING,
            Milestone.CAN_HELP_UNDRESS_HERSELF,
            Milestone.DRINKS_FROM_A_CUP,
            Milestone.EATS_WITH_A_SPOON,
            Milestone.STANDS_ON_TIPTOE,
            Milestone.KICKS_A_BALL,
            Milestone.BEGINS_TO_RUN,
            Milestone.CLIMBS_ONTO_AND_DOWN_FROM_FURNITURE_WITHOUT_HELP,
            Milestone.WALKS_UP_AND_DOWN_STAIRS_HOLDING_ON,
            Milestone.THROWS_BALL_OVERHEAD,
            Milestone.MAKES_OR_COPIES_STRAIGHT_LINES_AND_CIRCLES,
            Milestone.CLIMBS_WELL,
            Milestone.RUNS_EASILY,
            Milestone.PEDALS_A_TRICYCLE_THREE_WHEEL_BIKE,
            Milestone.WALKS_UP_AND_DOWN_STAIRS_ONE_FOOT_ON_EACH_STEP,
            Milestone.HOPS_AND_STANDS_ON_ONE_FOOT_UP_TO_TWO_SECONDS,
            Milestone.CATCHES_A_BOUNCED_BALL_MOST_OF_THE_TIME,
            Milestone.POURS_CUTS_WITH_SUPERVISION_AND_MASHES_OWN_FOOD,
            Milestone.STANDS_ON_ONE_FOOT_FOR_TEN_SECONDS_OR_LONGER,
            Milestone.HOPS_MAY_BE_ABLE_TO_SKIP,
            Milestone.CAN_DO_A_SOMERSAULT,
            Milestone.USES_A_FORK_AND_SPOON_AND_SOMETIMES_A_TABLE_KNIFE,
            Milestone.CAN_USE_THE_TOILET_ON_HER_OWN,
            Milestone.SWINGS_AND_CLIMBS
    );

    Set<Milestone> allMilestonesRelatedToThisSkill;
    Set<Milestone> currentlyMeasuredMilestonesRelatedToThisSkill;
    String title;

    Skill(String title, Milestone... milestones) {
        this.title = title;
        this.allMilestonesRelatedToThisSkill = new HashSet<>();
        this.currentlyMeasuredMilestonesRelatedToThisSkill = new HashSet<>();

        for (Milestone milestone : milestones) {
            allMilestonesRelatedToThisSkill.add(milestone);
            if (milestone.isCurrentlyMeasured()) {
                currentlyMeasuredMilestonesRelatedToThisSkill.add(milestone);
            }
        }

        // TODO -> java 1.8 update... filter and lambda instead of the lovely for-loop above
        //Collections.addAll(allMilestonesRelatedToThisSkill, milestones);
        //this.currentlyMeasuredMilestonesRelatedToThisSkill = allMilestonesRelatedToThisSkill.stream().filter(milestone -> milestone.isCurrentlyMeasured()).collect(Collectors.toSet());
    }

  public Set<Milestone> getAllMilestonesRelatedToThisSkill() {
      if (this.allMilestonesRelatedToThisSkill == null) {
          this.allMilestonesRelatedToThisSkill = new HashSet<>();
          this.allMilestonesRelatedToThisSkill.add(Milestone.NONE);
      }
    return this.allMilestonesRelatedToThisSkill;
  }

  public Set<Milestone> getCurrentlyMeasuredMilestonesRelatedToThisSkill() {
      return this.currentlyMeasuredMilestonesRelatedToThisSkill;
  }

  @Override
  public String toString() {
    return this.title;
  }

}
