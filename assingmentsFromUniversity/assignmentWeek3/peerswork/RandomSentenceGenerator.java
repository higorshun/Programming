package peerswork;

/**
 * For the first exercise of the lab, you should write a similar program that implements the following rules:
 * <p>
 * 1. <sentence> ::= <simple_sentence> [ <conjunction> <sentence> ]
 * <p>
 * 2. <simple_sentence> ::= <noun_phrase> <verb_phrase>
 * <p>
 * 3. <noun_phrase> ::= <proper_noun> | <determiner> [ <adjective> ]. <common_noun> [ who <verb_phrase> ]
 * <p>
 * 5.  <verb_phrase> ::= <intransitive_verb> | <transitive_verb> <noun_phrase> | is
 * <adjective> | believes that <simple_sentence>
 * <p>
 * 8. <conjunction> ::= and | or | but | because
 * <p>
 * 9. <proper_noun> ::= Fred | Jane | Richard Nixon | Miss America
 * <p>
 * 10. <common_noun> ::= man | woman | fish | elephant | unicorn
 * <p>
 * 11. <determiner> ::= a | the | every | some
 * <p>
 * 12. <adjective> ::= big | tiny | pretty | bald
 * <p>
 * 13. <intransitive_verb> ::= runs | jumps | talks | sleeps
 * <p>
 * 14. <transitive_verb> ::= loves | hates | sees | knows | looks for | finds
 **/
public class RandomSentenceGenerator {

    static final private String[] conjunction = {"and", "or", "but", "because"};
    static final private String[] proper_noun = {"red", "Jane", "Richard Nixon", "Miss America"};
    static final private String[] common_noun = {"man", "woman", "fish", "elephant", "unicorn"};
    static final private String[] determiner = {"a", "the", "every", "some"};
    static final private String[] adjective = {"big", "tiny", "pretty", "bald"};
    static final private String[] intransitive_verb = {"runs", "jumps", "talks", "sleeps"};
    static final private String[] transitive_verb = {"loves", "hates", "sees", "knows", "looks for", "finds"};

    // Picks random strings from the StringList
    static String randomItem(String[] StringList) {
        return StringList[(int) Math.random() * StringList.length];
    }

    // Generates random sentence, according to the rule.
    static void randomSentence() {
        /* A simple sentence*/
        randomSimpleSentence();
        if (Math.random() > 0.75) {// 25% of sentences continue with another clause.

            System.out.println(" " + randomItem(conjunction));
            randomSimpleSentence();

        }
    }

    // Generates a random simple sentence, according to the rule.
    static void randomSimpleSentence() {
        randomNounPhrase();
        randomVerbPhrase();
    }

    //	Generates a randomNounPhrase, according to the rule.
    static void randomNounPhrase() {
        if (Math.random() > 0.5)// 50% chance of having another noun phrase.
            System.out.println(" " + randomItem(proper_noun));
        else { // or next
            System.out.println(" " + randomItem(determiner));
            if (Math.random() > 0.25) { //75% chance of having a random adjective and common noun.
                System.out.println(" " + randomItem(adjective) + " ");
                System.out.println(" " + randomItem(common_noun));
                if (Math.random() > 0.5) { // 50% chance of having a random Verb phrase.
                    System.out.println("who");
                    randomVerbPhrase();
                }
            }
        }
    }

    // Generates a randomVerbPhrase, according to the rule.
    static void randomVerbPhrase() {
        if (Math.random() > 0.75) {// 25% chance of having intransitive verb.
            System.out.println(" " + randomItem(intransitive_verb));
        } else if (Math.random() > 0.50) {// or 50% chance of having a transitive verb and random Noun Phrase.

            System.out.println(" " + randomItem(transitive_verb));
            randomNounPhrase();
        } else if (Math.random() > 0.25)// 75% chance of having a random adjective
            System.out.println(" " + randomItem(adjective));
        else {
            System.out.println("believes that");
            randomVerbPhrase();
            randomNounPhrase();
        }

    }

    //Prints out random sentences every 5 seconds.
    public static void main(String[] args) {
        while (true) {
            randomSentence();
            System.out.println(".\n\n");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
            }
        }
    }
} 
            

              
             

            
                
 