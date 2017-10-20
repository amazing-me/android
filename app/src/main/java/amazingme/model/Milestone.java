package amazingme.model;

import amazingme.util.Constants;

public enum Milestone {

    //TODO -> not all milestones are included, only those thought to be measurable in amazingme :: https://www.cdc.gov/ncbddd/actearly/milestones/milestones-2mo.html

    // for default constructors and cases
    NONE,

    //2 month milestones
    BEGINS_TO_SMILE_AT_PEOPLE("Begins to smile at people", Constants.TWO_MONTHS, Constants.SIX_YEARS, false),
    CAN_BRIEFLY_CALM,HERSELF ("Can briefly calm herself", Constants.TWO_MONTHS, Constants.SIX_YEARS, false),
    TRIES_TO_LOOK_AT_PARENT("Tries to look at parent", Constants.TWO_MONTHS, Constants.SIX_YEARS, false),

    COOS_OR_MAKES_GURGLING_SOUNDS("Coos or makes gurgling sounds", Constants.TWO_MONTHS, Constants.SIX_YEARS, false),
    TURNS_HEAD_TOWARD_SOUNDS("Turns head towards sounds", Constants.TWO_MONTHS, Constants.SIX_YEARS, false),

    PAYS_ATTENTION_TO_FACES("Pays attention to faces", Constants.TWO_MONTHS, Constants.SIX_YEARS, true),
    BEGINS_TO_FOLLOW_THINGS_WITH_EYES("Begins to follow things with eyes", Constants.TWO_MONTHS, Constants.SIX_YEARS, true),
    CRIES_AND_FUSSES_IF_ACTIVITY_DOESNT_CHANGE("Cries and fusses if activity doesn't change", Constants.TWO_MONTHS, Constants.SIX_YEARS, false),

    CAN_HOLD_HEAD_UP_AND_BEGINS_TO_PUSH_UP_WHEN_LYING_ON_TUMMY("Can hold head up and push up when lying on tummy", Constants.TWO_MONTHS, Constants.SIX_YEARS, false),
    MAKES_SMOOTHER_MOVEMENTS_WITH_ARMS_AND_LEGS("Makes smoother movements with arms and legs", Constants.TWO_MONTHS, Constants.SIX_YEARS, false),

    //4 month milestones
    SMILES_SPONTANEOUSLY_ESPECIALLY_AT_PEOPLE("Smiles spontaneously especially at people", Constants.FOUR_MONTHS, Constants.SIX_YEARS, false),
    LIKES_TO_PLAY_WITH_PEOPLE_AND_MIGHT_CRY_WHEN_PLAYING_STOPS("Likes to play with people and might cry when playing stops", Constants.FOUR_MONTHS, Constants.SIX_YEARS, false),
    COPIES_SOME_MOVEMENTS_AND_FACIAL_EXPRESSIONS_LIKE_SMILING_OR_FROWNING("Copies some movements and facial expressions like smiling or frowning", Constants.FOUR_MONTHS, Constants.SIX_YEARS, true),

    BEGINS_TO_BABBLE("Begins to babble", Constants.FOUR_MONTHS, Constants.SIX_YEARS, false),
    BABBLES_WITH_EXPRESSION_AND_COPIES_SOUNDS_HE_HEARS("Babbles with expression and copies sounds he hears", Constants.FOUR_MONTHS, Constants.SIX_YEARS, false),
    CRIES_IN_DIFFERENT_WAYS_TO_SHOW_HUNGER_PAIN_OR_BEING_TIRED("Cries in different ways to show hunger, pain, or being tired", Constants.FOUR_MONTHS, Constants.SIX_YEARS, false),

    LETS_YOU_KNOW_IF_HE_IS_HAPPY_OR_SAD("Lets you know if he is happy or sad", Constants.FOUR_MONTHS, Constants.SIX_YEARS, true),
    RESPONDS_TO_AFFECTION("Responds to affection", Constants.FOUR_MONTHS, Constants.SIX_YEARS, false),
    REACHES_FOR_TOY_WITH_ONE_HAND("Reaches for toy with one hand", Constants.FOUR_MONTHS, Constants.SIX_YEARS, false),
    USES_HANDS_AND_EYES_TOGETHER_SUCH_AS_SEEING_A_TOY_AND_REACHING_FOR_IT("Uses hands and eyes together", Constants.FOUR_MONTHS, Constants.SIX_YEARS, false),
    FOLLOWS_MOVING_THINGS_WITH_EYES_FROM_SIDE_TO_SIDE("Follows moving thins with eyes from side to side", Constants.FOUR_MONTHS, Constants.SIX_YEARS, false),
    WATCHES_FACES_CLOSELY("Watches faces closely", Constants.FOUR_MONTHS, Constants.SIX_YEARS, true),
    RECOGNIZES_FAMILIAR_PEOPLE_AND_THINGS_AT_A_DISTANCE("Recognizes familiar people and things at a distance", Constants.FOUR_MONTHS, Constants.SIX_YEARS, true),

    HOLDS_HEAD_STEADY_UNSUPPORTED("Holds head steady", Constants.FOUR_MONTHS, Constants.SIX_YEARS, false),
    PUSHES_DOWN_ON_LEGS_WHEN_FEET_ARE_ON_A_HARD_SURFACE("Pushes down on legs when feet are on a hard surface", Constants.FOUR_MONTHS, Constants.SIX_YEARS, false),
    MAY_BE_ABLE_TO_ROLL_OVER_FROM_TUMMY_TO_BACK("May be able to roll over from tummy to back", Constants.FOUR_MONTHS, Constants.SIX_YEARS, false),
    CAN_HOLD_A_TOY_AND_SHAKE_IT_AND_SWING_AT_DANGLING_TOYS("Can hold a toy and shake it and swing at dangling toys", Constants.FOUR_MONTHS, Constants.SIX_YEARS, false),
    BRINGS_HANDS_TO_MOUTH("Brings hands to mouth", Constants.FOUR_MONTHS, Constants.SIX_YEARS, false),
    WHEN_LYING_ON_STOMACH_PUSHES_UP_TO_ELBOWS("When lying on stomach pushes up to elbows", Constants.FOUR_MONTHS, Constants.SIX_YEARS, false),

    //6 month milestones
    KNOWS_FAMILIAR_FACES_AND_BEGINS_TO_KNOW_IF_SOMEONE_IS_A_STRANGER("Knows familiar faces and begins to know if someone is a stranger", Constants.SIX_MONTHS, Constants.SIX_YEARS, true),
    LIKES_TO_PLAY_WITH_OTHERS_ESPECIALLY_PARENTS("Likes to play with others especially parents", Constants.SIX_MONTHS, Constants.SIX_YEARS, false),
    RESPONDS_TO_OTHER_PEOPLES_EMOTIONS_AND_OFTEN_SEEMS_HAPPY("Responds to other people's emotions and often seems happy", Constants.SIX_MONTHS, Constants.SIX_YEARS, true),
    LIKES_TO_LOOK_AT_SELF_IN_A_MIRROR("Likes to look at self in a mirror", Constants.SIX_MONTHS, Constants.SIX_YEARS, false),

    RESPONDS_TO_SOUNDS_BY_MAKING_SOUNDS("Responds to sounds by making sounds", Constants.SIX_MONTHS, Constants.SIX_YEARS, false),
    STRINGS_VOWELS_TOGETHER_WHEN_BABBLING_AH_EH_OH_AND_LIKES_TAKING_TURNS_WITH_PARENT_WHILE_MAKING_SOUNDS("Strings vowels", Constants.SIX_MONTHS, Constants.SIX_YEARS, false),
    RESPONDS_TO_OWN_NAME("Responds to own name", Constants.SIX_MONTHS, Constants.SIX_YEARS,true),
    MAKES_SOUNDS_TO_SHOW_JOY_AND_DISPLEASURE("Makes sounds to show joy or displeasure", Constants.SIX_MONTHS, Constants.SIX_YEARS, false),
    BEGINS_TO_SAY_CONSONANT_SOUNDS_JABBERING_WITH_M_B("Begins to say consonant sounds jabbering with M and B", Constants.SIX_MONTHS, Constants.SIX_YEARS, false),

    LOOKS_AROUND_AT_THINGS_NEARBY("Looks around at things nearby", Constants.SIX_MONTHS, Constants.SIX_YEARS, true),
    BRINGS_THINGS_TO_MOUTH("Brings things to mouth", Constants.SIX_MONTHS, Constants.SIX_YEARS, false),
    SHOWS_CURIOSITY_ABOUT_THINGS_AND_TRIES_TO_GET_THINGS_THAT_ARE_OUT_OF_REACH("Shows curiosity about things out of reach", Constants.SIX_MONTHS, Constants.SIX_YEARS, false),
    BEGINS_TO_PASS_THINGS_FROM_ONE_HAND_TO_THE_OTHER("Begins to pass things from one hand to the other", Constants.SIX_MONTHS, Constants.SIX_YEARS, false),

    ROLLS_OVER_IN_BOTH_DIRECTIONS_FRONT_TO_BACK_BACK_TO_FRONT("Rolls over in both directions front to back, back to front", Constants.SIX_MONTHS, Constants.SIX_YEARS, false),
    BEGINS_TO_SIT_WITHOUT_SUPPORT("Begins to sit without support", Constants.SIX_MONTHS, Constants.SIX_YEARS, false),
    WHEN_STANDING_SUPPORTS_WEIGHT_ON_LEGS_AND_MIGHT_BOUNCE("When standing supports weight on legs and might bounce", Constants.SIX_MONTHS, Constants.SIX_YEARS, false),
    ROCKS_BACK_AND_FORTH_SOMETIMES_CRAWLING_BACKWARD_BEFORE_MOVING_FORWARD("Rocks back and forth sometimes crawling backwards", Constants.SIX_MONTHS, Constants.SIX_YEARS, false),

    //9 month milestones
    MAY_BE_AFRAID_OF_STRANGERS("May be afraid of strangers", Constants.NINE_MONTHS, Constants.SIX_YEARS, true),
    MAY_BE_CLINGY_WITH_FAMILIAR_ADULTS("May be clingy with familiar adults", Constants.NINE_MONTHS, Constants.SIX_YEARS, false),
    HAS_FAVORITE_TOYS("Has favorite toys", Constants.NINE_MONTHS, Constants.SIX_YEARS, true),

    UNDERSTANDS_NO("Understands no", Constants.NINE_MONTHS, Constants.SIX_YEARS, true),
    MAKES_A_LOT_OF_DIFFERENT_SOUNDS_LIKE_MAMAMAMA_AND_BABABABABA("Makes a lot of different sounds like mamama and bababa", Constants.NINE_MONTHS, Constants.SIX_YEARS, false),
    COPIES_SOUNDS_AND_GESTURES_OF_OTHERS("Copies sounds and gestures of others", Constants.NINE_MONTHS, Constants.SIX_YEARS, true),
    USES_FINGERS_TO_POINT_AT_THINGS("Uses fingers to point at things", Constants.NINE_MONTHS, Constants.SIX_YEARS, true),

    WATCHES_THE_PATH_OF_SOMETHING_AS_IT_FALLS("Watches the path of something as it falls", Constants.NINE_MONTHS, Constants.SIX_YEARS, false),
    LOOKS_FOR_THINGS_SHE_SEES_YOU_HIDE("Looks for things she sees you hide", Constants.NINE_MONTHS, Constants.SIX_YEARS, false),
    PLAYS_PEEK_A_BOO("Plays peek a boo", Constants.NINE_MONTHS, Constants.SIX_YEARS, false),
    PUTS_THINGS_IN_HIS_MOUTH("Puts thigs in his mouth", Constants.NINE_MONTHS, Constants.SIX_YEARS, false),
    MOVES_THINGS_SMOOTHLY_FROM_ONE_HAND_TO_THE_OTHER("Moves things smoothly from one hand to the other", Constants.NINE_MONTHS, Constants.SIX_YEARS, false),
    PICKS_UP_THINGS_LIKE_CEREAL_OS_BETWEEN_THUMB_AND_INDEX_FINGER("Picks up things like cereal os between thumb and index finger", Constants.NINE_MONTHS, Constants.SIX_YEARS, false),

    STANDS_HOLDING_ON("Stands holding on", Constants.NINE_MONTHS, Constants.SIX_YEARS, false),
    CAN_GET_INTO_SITTING_POSITION("Can get into sitting position", Constants.NINE_MONTHS, Constants.SIX_YEARS, false),
    SITS_WITHOUT_SUPPORT("Sits without support", Constants.NINE_MONTHS, Constants.SIX_YEARS, false),
    PULLS_TO_STAND("Pulls to stand", Constants.NINE_MONTHS, Constants.SIX_YEARS, false),
    CRAWLS("Crawls", Constants.NINE_MONTHS, Constants.SIX_YEARS, false),

    //1 year milestones
    IS_SHY_OR_NERVOUS_WITH_STRANGERS("Is shy or nervous with strangers", Constants.ONE_YEAR, Constants.SIX_YEARS, true),
    CRIES_WHEN_MOM_OR_DAD_LEAVES("Cries when mom or dad leaves", Constants.ONE_YEAR, Constants.SIX_YEARS,false),
    HAS_FAVORITE_THINGS_AND_PEOPLE("Has favorite things and people", Constants.ONE_YEAR, Constants.SIX_YEARS, true),
    SHOWS_FEAR_IN_SOME_SITUATIONS("Shows fear in some situations", Constants.ONE_YEAR, Constants.SIX_YEARS, false),
    HANDS_YOU_A_BOOK_WHEN_HE_WANTS_TO_HEAR_A_STORY("Hands you a book when he wants to hear a story", Constants.ONE_YEAR, Constants.SIX_YEARS, false),
    REPEATS_SOUNDS_OR_ACTIONS_TO_GET_ATTENTION("Repeats sounds or actions to get attention", Constants.ONE_YEAR, Constants.SIX_YEARS, true),
    PUTS_OUT_ARM_OR_LEG_TO_HELP_WITH_DRESSING("Puts out arm or leg to help with dressing", Constants.ONE_YEAR, Constants.SIX_YEARS, false),
    PLAYS_GAMES_SUCH_AS_PEEK_A_BOO_AND_PAT_A_CAKE("plays games such as peek a boo and pat a cake", Constants.ONE_YEAR, Constants.SIX_YEARS, false),

    RESPONDS_TO_SIMPLE_SPOKEN_REQUESTS("Responds to simple spoken requests", Constants.ONE_YEAR, Constants.SIX_YEARS, true),
    USES_SIMPLE_GESTURES_LIKE_SHAKING_HEAD_NO_OR_WAVING_BYE_BYE("Uses simple gestures like shaking head no or waving bye bye", Constants.ONE_YEAR, Constants.SIX_YEARS, true),
    MAKES_SOUNDS_WITH_CHANGES_IN_TONE_SOUNDS_MORE_LIKE_SPEECH("Makes sounds with changes in tone sounds more like speech", Constants.ONE_YEAR, Constants.SIX_YEARS, false),
    SAYS_MAMA_AND_DADA_AND_EXCLAMATIONS_LIKE_UH_OH("Says mama and dada and exclamations like uh oh", Constants.ONE_YEAR, Constants.SIX_YEARS, true),
    TRIES_TO_SAY_WORDS_YOU_SAY("Tries to say words you say", Constants.ONE_YEAR, Constants.SIX_YEARS, false),

    EXPLORES_THINGS_IN_DIFFERENT_WAYS_LIKE_SHAKING_BANGING_THROWING("Explores things in different ways like shaking, banging, and throwing", Constants.ONE_YEAR, Constants.SIX_YEARS, false),
    FINDS_HIDDEN_THINGS_EASILY("Finds hidden things easily", Constants.ONE_YEAR, Constants.SIX_YEARS, false),
    LOOKS_AT_THE_RIGHT_PICTURES_OR_THING_WHEN_ITS_NAMED("Looks at the right pictures or thing when it's named", Constants.ONE_YEAR, Constants.SIX_YEARS, true),
    COPIES_GESTURES("Copies gestures", Constants.ONE_YEAR, Constants.SIX_YEARS, true),
    STARTS_TO_USE_THINGS_CORRECTLY_FOR_EXAMPLE_DRINKS_FROM_A_CUP_BRUSHES_HAIR("Starts to use things correctly for example drinks from a cup brushes hair", Constants.ONE_YEAR, Constants.SIX_YEARS, true),
    BANGS_TWO_THINGS_TOGETHER("Bands two things together", Constants.ONE_YEAR, Constants.SIX_YEARS, false),
    PUTS_THINGS_IN_A_CONTAINER_TAKES_THINGS_OUT_OF_A_CONTAINER("Puts things in a container and takes things out of a container", Constants.ONE_YEAR, Constants.SIX_YEARS, false),
    LETS_THINGS_GO_WITHOUT_HELP("Lets things go without help", Constants.ONE_YEAR, Constants.SIX_YEARS, false),
    POKES_WITH_INDEX_FINGER("Pokes with index finger", Constants.ONE_YEAR, Constants.SIX_YEARS, true),
    FOLLOWS_SIMPLE_DIRECTIONS_LIKE_PICK_UP_THE_TOY("Follows simple directions like pick up the toy", Constants.ONE_YEAR, Constants.SIX_YEARS, true),

    GETS_TO_A_SITTING_POSITION_WITHOUT_HELP("Gets to a sitting position without help", Constants.ONE_YEAR, Constants.SIX_YEARS, false),
    PULLS_UP_TO_STAND_WALKS_HOLDING_ON_TO_FURNITURE("Pulls up to stand walks holding on to furniture", Constants.ONE_YEAR, Constants.SIX_YEARS, false),
    MAY_TAKE_A_FEW_STEPS_WITHOUT_HOLDING_ON("May take a few steps without holding on", Constants.ONE_YEAR, Constants.SIX_YEARS, false),
    MAY_STAND_ALONE("May stand alone", Constants.ONE_YEAR, Constants.SIX_YEARS, false),

    //18 Month Milestone
    LIKES_TO_HAND_THINGS_TO_OTHERS_AS_PLAY("Likes to hand things to others as play", Constants.EIGHTEEN_MONTHS, Constants.SIX_YEARS, false),
    MAY_HAVE_TEMPER_TANTRUMS("May have temper tantrums", Constants.EIGHTEEN_MONTHS, Constants.SIX_YEARS, false),
    MAY_BE_AFRAID_OF_STRANGERS_TWO("May be afraid of strangers", Constants.EIGHTEEN_MONTHS, Constants.SIX_YEARS,true),
    SHOWS_AFFECTION_TO_FAMILIAR_PEOPLE("Shows affection to familiar people", Constants.EIGHTEEN_MONTHS, Constants.SIX_YEARS, true),
    PLAYS_SIMPLE_PRETEND_SUCH_AS_FEEDING_A_DOLL("Plays simple pretend such as feeding a doll", Constants.EIGHTEEN_MONTHS, Constants.SIX_YEARS, false),
    MAY_CLING_TO_CAREGIVERS_IN_NEW_SITUATIONS("May cling to caregivers in new situations", Constants.EIGHTEEN_MONTHS, Constants.SIX_YEARS, false),
    POINTS_TO_SHOW_OTHERS_SOMETHING_INTERESTING("Points to show others something interesting", Constants.EIGHTEEN_MONTHS, Constants.SIX_YEARS, true),
    EXPLORES_ALONE_BUT_WITH_PARENT_CLOSE_BY("Explores alone but with parent close by", Constants.EIGHTEEN_MONTHS, Constants.SIX_YEARS, false),

    SAYS_SEVERAL_SINGLE_WORDS("Says several single words", Constants.EIGHTEEN_MONTHS, Constants.SIX_YEARS, false),
    SAYS_AND_SHAKES_HEAD_NO("Says and shakes head no", Constants.EIGHTEEN_MONTHS, Constants.SIX_YEARS, true),
    POINTS_TO_SHOW_SOMEONE_WHAT_HE_WANTS("Points to show someone what he wants", Constants.EIGHTEEN_MONTHS, Constants.SIX_YEARS, true),

    KNOWS_WHAT_ORDINARY_THINGS_ARE_FOR_FOR_EXAMPLE_TELEPHONE_BRUSH_SPOON("Knows what ordinary things are for, for example telephone, brush, and spoon", Constants.EIGHTEEN_MONTHS, Constants.SIX_YEARS, true),
    POINTS_TO_GET_THE_ATTENTION_OF_OTHERS("Points to get the attention of others", Constants.EIGHTEEN_MONTHS, Constants.SIX_YEARS, false),
    SHOWS_INTEREST_IN_A_DOLL_OR_STUFFED_ANIMAL_BY_PRETENDING_TO_FEED("Shows interest in a doll or stuffed animal by pretending to feed", Constants.EIGHTEEN_MONTHS, Constants.SIX_YEARS, false),
    POINTS_TO_ONE_BODY_PART("Points to one body part", Constants.EIGHTEEN_MONTHS, Constants.SIX_YEARS, true),
    SCRIBBLES_ON_HIS_OWN("Scribbles on his own", Constants.EIGHTEEN_MONTHS, Constants.SIX_YEARS, true),
    CAN_FOLLOW_ONE_STEP_VERBAL_COMMANDS_WITHOUT_ANY_GESTURES_FOR_EXAMPLE_SITS_WHEN_YOU_SAY_SIT_DOWN("Cand follow one step verbal commands", Constants.EIGHTEEN_MONTHS, Constants.SIX_YEARS, true),

    WALKS_ALONE("Walks alone", Constants.EIGHTEEN_MONTHS, Constants.SIX_YEARS, false),
    MAY_WALK_UP_STEPS_AND_RUN("May walk up steps and run", Constants.EIGHTEEN_MONTHS, Constants.SIX_YEARS, false),
    PULLS_TOYS_WHILE_WALKING("Pulls toy while walking", Constants.EIGHTEEN_MONTHS, Constants.SIX_YEARS, false),
    CAN_HELP_UNDRESS_HERSELF("Can help undress herself", Constants.EIGHTEEN_MONTHS, Constants.SIX_YEARS, false),
    DRINKS_FROM_A_CUP("Drinks from a cup", Constants.EIGHTEEN_MONTHS, Constants.SIX_YEARS, true),
    EATS_WITH_A_SPOON("eats with a spoon", Constants.EIGHTEEN_MONTHS, Constants.SIX_YEARS, true),

    //2 Year Milestones
    COPIES_OTHERS_ESPECIALLY_ADULTS_AND_OLDER_CHILDREN("Copies others especially adults and other children", Constants.TWO_YEARS, Constants.SIX_YEARS, true),
    GETS_EXCITED_WHEN_WITH_OTHER_CHILDREN("Gets excited when with other children", Constants.TWO_YEARS, Constants.SIX_YEARS, false),
    SHOWS_MORE_AND_MORE_INDEPENDENCE("Shows more and more independence", Constants.TWO_YEARS, Constants.SIX_YEARS, false),
    SHOWS_DEFIANT_BEHAVIOR_DOING_WHAT_HE_HAS_BEEN_TOLD_NOT_TO("Shows defiant behavior doing what he has been told not to", Constants.TWO_YEARS, Constants.SIX_YEARS, false),
    PLAYS_MAINLY_BESIDE_OTHER_CHILDREN_BUT_IS_BEGINNING_TO_INCLUDE_OTHER_CHILDREN_SUCH_AS_IN_CHASE_GAMES("Plays mainly besie other children but may include them", Constants.TWO_YEARS, Constants.SIX_YEARS,false),

    POINTS_TO_THINGS_OR_PICTURES_WHEN_THEY_ARE_NAMED("Points to things or pictures when they are named", Constants.TWO_YEARS, Constants.SIX_YEARS, true),
    KNOWS_NAMES_OF_FAMILIAR_PEOPLE_AND_BODY_PARTS("Knows names of familiar people and body parts", Constants.TWO_YEARS, Constants.SIX_YEARS, true),
    SAYS_SENTENCES_WITH_TWO_TO_FOUR_WORDS("Says sentences with two to four words", Constants.TWO_YEARS, Constants.SIX_YEARS, false),
    FOLLOWS_SIMPLE_INSTRUCTIONS("Follows simple introductions", Constants.TWO_YEARS, Constants.SIX_YEARS, true),
    REPEATS_WORDS_OVERHEARD_IN_CONVERSATION("Repeats words overheard in conversation", Constants.TWO_YEARS, Constants.SIX_YEARS, true),
    POINTS_TO_THINGS_IN_A_BOOK("Points to things in a book", Constants.TWO_YEARS, Constants.SIX_YEARS, true),

    FINDS_THINGS_EVEN_WHEN_HIDDEN_UNDER_TWO_OR_THREE_COVERS("Finds things even when hidden under two or three covers", Constants.TWO_YEARS, Constants.SIX_YEARS, false),
    BEGINS_TO_SORT_SHAPES_AND_COLORS("Begins to sort shapes and colors", Constants.TWO_YEARS, Constants.SIX_YEARS, true),
    COMPLETES_SENTENCES_AND_RHYMES_IN_FAMILIAR_BOOKS("Completes sentences and rhymes in familiar books", Constants.TWO_YEARS, Constants.SIX_YEARS, true),
    PLAYS_SIMPLE_MAKE_BELIEVE_GAMES("plays simple make believe games", Constants.TWO_YEARS, Constants.SIX_YEARS, false),
    BUILDS_TOWERS_OF_FOUR_OR_MORE_BLOCKS("Builds towers of four or more blocks", Constants.TWO_YEARS, Constants.SIX_YEARS, false),
    MIGHT_USE_ONE_HAND_MORE_THAN_THE_OTHER("Might use one hand more than the other", Constants.TWO_YEARS, Constants.SIX_YEARS, false),
    FOLLOWS_TWO_STEP_INSTRUCTIONS_SUCH_AS_PICK_UP_YOUR_SHOES_AND_PUT_THEM_IN_THE_CLOSET("Follows two step instructions", Constants.TWO_YEARS, Constants.SIX_YEARS, true),
    NAMES_ITEMS_IN_A_PICTURE_BOOK_SUCH_AS_A_CAT_BIRD_OR_DOG("names items in a picture book", Constants.TWO_YEARS, Constants.SIX_YEARS, true),

    STANDS_ON_TIPTOE("Stands on tiptoe", Constants.TWO_YEARS, Constants.SIX_YEARS, false),
    KICKS_A_BALL("kicks a ball", Constants.TWO_YEARS, Constants.SIX_YEARS,false),
    BEGINS_TO_RUN("Begins to run", Constants.TWO_YEARS, Constants.SIX_YEARS, false),
    CLIMBS_ONTO_AND_DOWN_FROM_FURNITURE_WITHOUT_HELP("Climbs onto and down from furniture without help", Constants.TWO_YEARS, Constants.SIX_YEARS, false),
    WALKS_UP_AND_DOWN_STAIRS_HOLDING_ON("Walks up and down stairs holding on", Constants.TWO_YEARS, Constants.SIX_YEARS, false),
    THROWS_BALL_OVERHEAD("Throws ball overhead", Constants.TWO_YEARS, Constants.SIX_YEARS, false),
    MAKES_OR_COPIES_STRAIGHT_LINES_AND_CIRCLES("Makes or copies straight lines and circles", Constants.TWO_YEARS, Constants.SIX_YEARS, true),

    //3 Year Milestones
    COPIES_ADULTS_AND_FRIENDS("Copies adults and friends", Constants.THREE_YEARS, Constants.SIX_YEARS, true),
    SHOWS_AFFECTION_FOR_FRIENDS_WITHOUT_PROMPTING("Shows affection for friends without prompting", Constants.THREE_YEARS, Constants.SIX_YEARS, true),
    TAKES_TURNS_IN_GAMES("Takes turns in game", Constants.THREE_YEARS, Constants.SIX_YEARS, true),
    SHOWS_CONCERN_FOR_CRYING_FRIEND("Shows concern for crying friend", Constants.THREE_YEARS, Constants.SIX_YEARS, true),
    UNDERSTANDS_THE_IDEA_OF_MINE_AND_HIS_OR_HERS("Understands the idea of mine and his or hers", Constants.THREE_YEARS, Constants.SIX_YEARS, true),
    SHOWS_WIDE_RANGE_OF_EMOTIONS("Shows wide range of emotions", Constants.THREE_YEARS, Constants.SIX_YEARS, true),
    SEPARATES_EASILY_FROM_MOM_AND_DAD("Seperates easily from mom and dad", Constants.THREE_YEARS, Constants.SIX_YEARS, false),
    MAY_GET_UPSET_WITH_MAJOR_CHANGES_IN_ROUTINE("May get upset with major changes in routine", Constants.THREE_YEARS, Constants.SIX_YEARS, false),
    DRESSES_AND_UNDRESSES_SELF("Dressed and undresses self", Constants.THREE_YEARS, Constants.SIX_YEARS, false),

    FOLLOWS_INSTRUCTIONS_WITH_TWO_OR_THREE_STEPS("Follows instructions with two or three steps", Constants.THREE_YEARS, Constants.SIX_YEARS, true),
    CAN_NAME_MOST_FAMILIAR_THINGS("Can name most familiar things", Constants.THREE_YEARS, Constants.SIX_YEARS, true),
    UNDERSTANDS_WORDS_LIKE_IN_ON_AND_UNDER("Understands words like in on and under", Constants.THREE_YEARS, Constants.SIX_YEARS, true),
    SAYS_FIRST_NAME_AGE_AND_SEX("Says first name, age, and sex", Constants.THREE_YEARS, Constants.SIX_YEARS, true),
    NAMES_A_FRIEND("Names a friend", Constants.THREE_YEARS, Constants.SIX_YEARS, true),
    SAYS_WORDS_LIKE_I_ME_WE_AND_YOU_AND_SOME_PLURALS_CARS_DOGS_CATS("Says words like I, me, we, and you and some plurals", Constants.THREE_YEARS, Constants.SIX_YEARS, true),
    TALKS_WELL_ENOUGH_FOR_STRANGERS_TO_UNDERSTAND_MOST_OF_THE_TIME("Talks well enough for strangers to understand them most of the time", Constants.THREE_YEARS, Constants.SIX_YEARS,false),
    CARRIES_ON_A_CONVERSATION_USING_TWO_TO_THREE_SENTENCES("Carries on conversation using two to three sentences", Constants.THREE_YEARS, Constants.SIX_YEARS, false),

    CAN_WORK_TOYS_WITH_BUTTONS_LEVERS_AND_MOVING_PARTS("Can work with buttons levers and moving parts", Constants.THREE_YEARS, Constants.SIX_YEARS, false),
    PLAYS_MAKE_BELIEVE_WITH_DOLLS_ANIMALS_AND_PEOPLE("Plays make believe with dolls, animals, and people", Constants.THREE_YEARS, Constants.SIX_YEARS, false),
    DOES_PUZZLES_WITH_THREE_OR_FOUR_PIECES("Does puzzles with three or four pieces", Constants.THREE_YEARS, Constants.SIX_YEARS, true),
    UNDERSTANDS_WHAT_TWO_MEANS("Understands what two means", Constants.THREE_YEARS, Constants.SIX_YEARS, true),
    COPIES_A_CIRCLE_WITH_PENCIL_OR_CRAYON("Copies a circle with pencil or crayon", Constants.THREE_YEARS, Constants.SIX_YEARS, true),
    TURNS_BOOK_PAGES_ONE_AT_A_TIME("Turns book pages one at a time", Constants.THREE_YEARS, Constants.SIX_YEARS, false),
    BUILDS_TOWERS_OF_MORE_THAN_SIX_BLOCKS("Builds towers of more than six blocks", Constants.THREE_YEARS, Constants.SIX_YEARS, false),
    SCREWS_AND_UNSCREWS_JAR_LIDS_OR_TURNS_DOOR_HANDLE("Screws and unscrews jar lids or turns door handle", Constants.THREE_YEARS, Constants.SIX_YEARS, false),

    CLIMBS_WELL("Climbs well", Constants.THREE_YEARS, Constants.SIX_YEARS, false),
    RUNS_EASILY("Runs easily", Constants.THREE_YEARS, Constants.SIX_YEARS, false),
    PEDALS_A_TRICYCLE_THREE_WHEEL_BIKE("Pedals a tricycle wheel bike", Constants.THREE_YEARS, Constants.SIX_YEARS, false),
    WALKS_UP_AND_DOWN_STAIRS_ONE_FOOT_ON_EACH_STEP("Walks up and down stairs one foot on each step", Constants.THREE_YEARS, Constants.SIX_YEARS, false),

    //4 Year Milestones
    ENJOYS_DOING_NEW_THINGS("Enjoys doing new things", Constants.FOUR_YEARS, Constants.SIX_YEARS, false),
    PLAYS_MOM_AND_DAD("Plays mom and dad", Constants.FOUR_YEARS, Constants.SIX_YEARS, false),
    IS_MORE_AND_MORE_CREATIVE_WITH_MAKE_BELIEVE_PLAY("Is more creative with make believe play", Constants.FOUR_YEARS, Constants.SIX_YEARS, false),
    WOULD_RATHER_PLAY_WITH_OTHER_CHILDREN_THAN_BY_HIMSELF("Would rather play with other children than by himself", Constants.FOUR_YEARS, Constants.SIX_YEARS, false),
    COOPERATES_WITH_OTHER_CHILDREN("Cooperates with other children", Constants.FOUR_YEARS, Constants.SIX_YEARS, false),
    OFTEN_CANT_TELL_WHATS_REAL_AND_WHATS_MAKE_BELIEVE("Often cant tell whats real and whats make believe", Constants.FOUR_YEARS, Constants.SIX_YEARS, false),
    TALKS_ABOUT_WHAT_SHE_LIKES_AND_WHAT_SHE_IS_INTERESTED_IN("Talks about what she likes and what she is interested in", Constants.FOUR_YEARS, Constants.SIX_YEARS, false),

    KNOWS_SOME_BASIC_RULES_OF_GRAMMAR_SUCH_AS_CORRECTLY_USING_HE_AND_SHE("Knows some basic rules of grammar such as correctly using he and she", Constants.FOUR_YEARS, Constants.SIX_YEARS, true),
    SINGS_A_SONG_OR_SAYS_A_POEM_FROM_MEMORY_SUCH_AS_THE_ITSY_BITSY_SPIDER_OR_THE_WHEELS_ON_THE_BUS("Sings songs", Constants.FOUR_YEARS, Constants.SIX_YEARS, false),
    TELLS_STORIES("Tells stories", Constants.FOUR_YEARS, Constants.SIX_YEARS, false),
    CAN_SAY_FIRST_AND_LAST_NAME("Can say first and last name", Constants.FOUR_YEARS, Constants.SIX_YEARS, true),

    NAMES_SOME_COLORS_AND_SOME_NUMBERS("Names some colors and some numbers", Constants.FOUR_YEARS, Constants.SIX_YEARS,true),
    UNDERSTANDS_THE_IDEA_OF_COUNTING("Understands the idea of counting", Constants.FOUR_YEARS, Constants.SIX_YEARS, true),
    STARTS_TO_UNDERSTAND_TIME("Starts to understand time", Constants.FOUR_YEARS, Constants.SIX_YEARS, true),
    REMEMBERS_PARTS_OF_A_STORY("Remembers parts of a story", Constants.FOUR_YEARS, Constants.SIX_YEARS, true),
    UNDERSTANDS_THE_IDEA_OF_SAME_AND_DIFFERENT("Understands the idea of same and different", Constants.FOUR_YEARS, Constants.SIX_YEARS, true),
    DRAWS_A_PERSON_WITH_TWO_TO_FOUR_BODY_PARTS("Draws a person with two to four body parts", Constants.FOUR_YEARS, Constants.SIX_YEARS, true),
    USES_SCISSORS("Uses scissors", Constants.FOUR_YEARS, Constants.SIX_YEARS, false),
    STARTS_TO_COPY_SOME_CAPITAL_LETTERS("Starts to copy some capital letters", Constants.FOUR_YEARS, Constants.SIX_YEARS, true),
    PLAYS_BOARD_OR_CARD_GAMES("Plays board or card games", Constants.FOUR_YEARS, Constants.SIX_YEARS,true),
    TELLS_YOU_WHAT_HE_THINKS_IS_GOING_TO_HAPPEN_NEXT_IN_A_BOOK("Tells you what he thinks is going to happen next in a book", Constants.FOUR_YEARS, Constants.SIX_YEARS, false),

    HOPS_AND_STANDS_ON_ONE_FOOT_UP_TO_TWO_SECONDS("Hops and stands on one foot up to two seconds", Constants.FOUR_YEARS, Constants.SIX_YEARS, false),
    CATCHES_A_BOUNCED_BALL_MOST_OF_THE_TIME("Catches a bounced ball most of the time", Constants.FOUR_YEARS, Constants.SIX_YEARS, false),
    POURS_CUTS_WITH_SUPERVISION_AND_MASHES_OWN_FOOD("Pours, cuts, with supervision, and mashes own food", Constants.FOUR_YEARS, Constants.SIX_YEARS, false),

    //5 year milestones
    WANTS_TO_PLEASE_FRIENDS("Wants to please friends", Constants.FIVE_YEARS, Constants.SIX_YEARS, false),
    WANTS_TO_BE_LIKE_FRIENDS("Wants to be like friends", Constants.FIVE_YEARS, Constants.SIX_YEARS, false),
    MORE_LIKELY_TO_AGREE_WITH_RULES("More likely to agree with rules", Constants.FIVE_YEARS, Constants.SIX_YEARS, false),
    LIKES_TO_SING_DANCE_AND_ACT("Likes to sing, dance, and act", Constants.FIVE_YEARS, Constants.SIX_YEARS, false),
    IS_AWARE_OF_GENDER("Is aware of gender", Constants.FIVE_YEARS, Constants.SIX_YEARS, true),
    CAN_TELL_WHATS_REAL_AND_WHATS_MAKE_BELIEVE("Can tell what's real and what's make believe", Constants.FIVE_YEARS, Constants.SIX_YEARS, false),
    SHOWS_MORE_INDEPENDENCE_FOR_EXAMPLE_MAY_VISIT_A_NEXT_DOOR_NEIGHBOR_BY_HIMSELF_ADULT_SUPERVISION_STILL_NEEDED("Shows more independence", Constants.FIVE_YEARS, Constants.SIX_YEARS, false),
    IS_SOMETIMES_DEMANDING_AND_SOMETIMES_VERY_COOPERATIVE("Is sometimes demanding and sometimes very cooperative", Constants.FIVE_YEARS, Constants.SIX_YEARS, false),

    SPEAKS_VERY_CLEARLY("Speaks very clearly", Constants.FIVE_YEARS, Constants.SIX_YEARS, false),
    TELLS_A_SIMPLE_STORY_USING_FULL_SENTENCES("Tells a simple story using full sentences", Constants.FIVE_YEARS, Constants.SIX_YEARS, false),
    USES_FUTURE_TENSE_FOR_EXAMPLE_GRANDMA_WILL_BE_HERE("Uses future tense", Constants.FIVE_YEARS, Constants.SIX_YEARS, true),
    SAYS_NAME_AND_ADDRESS("Says name and address", Constants.FIVE_YEARS, Constants.SIX_YEARS, true),

    COUNTS_TEN_OR_MORE_THINGS("Counts ten or more things", Constants.FIVE_YEARS, Constants.SIX_YEARS, true),
    CAN_DRAW_A_PERSON_WITH_AT_LEAST_SIX_BODY_PARTS("Can draw a person with at least six body parts", Constants.FIVE_YEARS, Constants.SIX_YEARS, true),
    CAN_PRINT_SOME_LETTERS_OR_NUMBERS("Can print some letters or numbers", Constants.FIVE_YEARS, Constants.SIX_YEARS, true),
    COPIES_A_TRIANGLE_AND_OTHER_GEOMETRIC_SHAPES("Copies a triangle and other geometric shapes", Constants.FIVE_YEARS, Constants.SIX_YEARS, true),
    KNOWS_ABOUT_THINGS_USED_EVERY_DAY_LIKE_MONEY_AND_FOOD("Knows about things used every day like money and food", Constants.FIVE_YEARS, Constants.SIX_YEARS, true),

    STANDS_ON_ONE_FOOT_FOR_TEN_SECONDS_OR_LONGER("Stands on one foot for ten seconds or longer", Constants.FIVE_YEARS, Constants.SIX_YEARS, false),
    HOPS_MAY_BE_ABLE_TO_SKIP("Hops may be able to skip", Constants.FIVE_YEARS, Constants.SIX_YEARS, false),
    CAN_DO_A_SOMERSAULT("Can do a somersault", Constants.FIVE_YEARS, Constants.SIX_YEARS, false),
    USES_A_FORK_AND_SPOON_AND_SOMETIMES_A_TABLE_KNIFE("Uses a fork, and spoon, and sometimes a table knife", Constants.FIVE_YEARS, Constants.SIX_YEARS, false),
    CAN_USE_THE_TOILET_ON_HER_OWN("Can use the toilet on her own", Constants.FIVE_YEARS, Constants.SIX_YEARS, false),
    SWINGS_AND_CLIMBS("Swings and climbs", Constants.FIVE_YEARS, Constants.SIX_YEARS, false);

    int appropriateAgeMinimum;
    int appropriateAgeMaximum;
    String descriptor;
    boolean isCurrentlyMeasured;

    Milestone(String description, int minAge, int maxAge, boolean isCurrentlyMeasured) {
        this.descriptor = description;
        this.appropriateAgeMinimum = minAge;
        this.appropriateAgeMaximum = maxAge;
        this.isCurrentlyMeasured = isCurrentlyMeasured;
    }

    Milestone() {
        this("no description available", 0, 0, false);
    }

    @Override
    public String toString() {
        return this.descriptor;
    }

    public boolean isCurrentlyMeasured() {
        return this.isCurrentlyMeasured;
    }
}
