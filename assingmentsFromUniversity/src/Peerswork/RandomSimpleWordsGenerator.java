package Peerswork;

public class RandomSimpleWordsGenerator {
    //Here I created several string arrays containing nouns, verbs, adjectives, etc.
    static final String[] conjunction = {"and", "or", "but", "because"};
    static final String[] proper_noun = {"James", "Layla", "Einstein", "Miss Universe"};
    static final String[] common_noun = {"man", "woman", "cat", "dog", "fish"};
    static final String[] determiner = {"a", "the", "every", "some"};
    static final String[] adjective = {"big", "small", "nice", "pretty"};
    static final String[] intransitive_verb = {"runs", "jumps", "escapes", "sleeps"};
    static final String[] transitive_verb = {"loves", "hates", "sees", "knows", "looks for", "cuddles"};

    //Here I created the method that works continuously and creates sentences.
    public static void main(String[] args) {
        while (true) {
            randomSentence();
            System.out.println("\n");
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
            }
        }
    }

    static void randomSentence() {
        randomNounPhrase();
        randomVerbPhrase();
        if (Math.random() > 0.75) {
            System.out.print(" " + randomItem(conjunction));
            randomSentence();
        }
    }

    static void randomNounPhrase() {
        if (Math.random() > 0.75) {
            System.out.print(" " + randomItem(proper_noun));
        } else {
            System.out.print(" " + randomItem(determiner));
            if (Math.random() > 0.5)
                System.out.print(" " + randomItem(adjective) + ".");
            System.out.print(" " + randomItem(common_noun));
            if (Math.random() > 0.5) {
                System.out.print(" who");
                randomVerbPhrase();
            }
        }
    }

    static void randomVerbPhrase() {
        if (Math.random() > 0.75)
            System.out.print(" " + randomItem(intransitive_verb));
        else if (Math.random() > 0.50) {
            System.out.print(" " + randomItem(transitive_verb));
            randomNounPhrase();
        } else if (Math.random() > 0.25)
            System.out.print(" is " + randomItem(adjective));
        else {
            System.out.print(" believes that");
            randomNounPhrase();
            randomVerbPhrase();
        }
    }

    static String randomItem(String[] listOfStrings) {
        return listOfStrings[(int) (Math.random() * listOfStrings.length)];
    }
}

