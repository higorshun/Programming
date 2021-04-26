import java.util.concurrent.ThreadLocalRandom;

import static java.lang.Math.random;

public class randomSentences {
    /**
     * This program implements generate random sentences according to the rules from Lab 3
     * of the Unit 2 from the CS1103. The would program generate and output one
     * random sentence every three seconds until it is halted (for example, by typing Control-C in
     * the terminal window where it is running).
     */

    static final String[] conjunction = {"and", "or", "but", "because"};
    static final String[] properNoun = {"Fred", "Jane", "Richard Nixon", "Miss America", "Bozo", "Manuel", "Pedro",
            "Pierre"};
    static final String[] commonNoun = {"man", "woman", "fish", "elephant", "unicorn"};
    static final String[] determiner = {"a", "the", "every", "some", "few", "many"};
    static final String[] adjective = {"big", "tiny", "pretty", "bald", "yellow", "red", "difficult", "sweet",
            "lovely", "tall", "slow"};
    static final String[] intransitiveVerb = {"runs", "jumps", "talks", "sleeps"};
    static final String[] transitiveVerb = {"loves", "hates", "see", "knows", "looks for", "finds"};

    /**
     * The main routine prints out one random sentence every time that the
     * program is open.For this specific example, I set this program to generate 10 sentences.
     */
    public static void main(String[] args) {
        int sentenceCounter = 0;
        while (sentenceCounter < 10) {
            sentence();
            System.out.println(".\n\n");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sentenceCounter++;
        }

    }

    /**
     * Method to generates sentence according to the rule
     * <sentence> ::= <simple_sentence> [ <conjunction> <sentence> ]
     */
    static void sentence() {
        simpleSentence();
        if (Math.random() > 0.5) { //50% of probability to follow this path
            System.out.print(" " + randomItem(conjunction));
            sentence();
        }
    }

    /**
     * Method to generates simple sentence according to the rule
     * <simple_sentence> ::= <noun_phrase> <verb_phrase>
     */

    static void simpleSentence() {
        nounPhrase();
        verbPhrase();
    }

    /**
     * Method to generates Noun Phrases according to the rule
     * <noun_phrase> ::= <proper_noun> | <determiner> [ <adjective> ]. <common_noun> [ who <verb_phrase> ]
     */
    static void nounPhrase() {

        switch (randomSwitchCase(2)) {
            case 1:
                System.out.print(" " + randomItem(properNoun) + " ");
                break;
            case 2:
                System.out.print(" " + randomItem(determiner) + " ");
                if (Math.random() > 0.5) { //50% of probability to follow this path
                    System.out.print(" " + randomItem(adjective) + " ");
                }
                System.out.print(" " + randomItem(commonNoun));
                if (Math.random() > 0.5) { //50% of probability to follow this path
                    System.out.print(" who");
                    verbPhrase();
                }
                break;
        }
    }

    /**
     * The method follow the rule
     * <verb_phrase> ::= <intransitive_verb> | <transitive_verb> <noun_phrase> | is <adjective> |
     * believes that <simple_sentence>
     * According to the rule, the are several combinations to generate the
     * verb phrase because it has 3 | (or) symbol.
     */
    static void verbPhrase() {
        switch (randomSwitchCase(4)) {
            case 1:
                System.out.print(" " + randomItem(intransitiveVerb));
                break;
            case 2:
                System.out.print(" " + randomItem(transitiveVerb));
                nounPhrase();
                break;
            case 3:
                System.out.print(" is " + randomItem(adjective));
                break;
            case 4:
                System.out.print(" believes that");
                simpleSentence();
                break;
        }
    }

    /**
     * This method returns a string in a list of arrays
     *
     * @param listOfStrings requires an array of Strings
     * @return after a choosing randomly an index number from return the correspondent word
     */
    static String randomItem(String[] listOfStrings) {

        int choiceNumber = (int) (random() * listOfStrings.length);
        return listOfStrings[choiceNumber];
    }

    /**
     * This method gets the minimum and maximum number of cases and randomizes
     *
     * @param numberOfCases number of cases inside the switch statement
     * @return a random number
     */
    static int randomSwitchCase(int numberOfCases) {

        return ThreadLocalRandom.current().nextInt(1, numberOfCases + 1);

    }
}