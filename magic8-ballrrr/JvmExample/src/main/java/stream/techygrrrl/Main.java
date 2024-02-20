package stream.techygrrrl;

import techygrrrl.magic8ballrrr.Answer;
import techygrrrl.magic8ballrrr.Magic8Ballrrr;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            log("❗️ You need to ask a question!");
            return;
        }

        String question = args[0];

        // TODO: Toggle through defaults or custom answers
        boolean shouldUseDefaultAnswers = true;

        Magic8Ballrrr magic8Ballrrr;

        if (shouldUseDefaultAnswers) {
            // Option 1: With default answers
            magic8Ballrrr = new Magic8Ballrrr();
            List<Answer> defaultAnswers = Magic8Ballrrr.defaultAnswers();
            log("These are the default answers:");
            System.out.println(defaultAnswers);
        } else {
            // Option 2: With custom answers
            ArrayList<Answer> customAnswers = new ArrayList<>();
            customAnswers.add(new Answer.Positive("Yes", "✅"));
            customAnswers.add(new Answer.Negative("No", "⛔️"));
            customAnswers.add(new Answer.Neutral("Maybe", "🔶"));
            magic8Ballrrr = new Magic8Ballrrr(customAnswers);
        }

        Answer answer = magic8Ballrrr.ask(question);

        log("You asked the following question:");
        log(question);

        log("...");
        log("...");
        log("...");
        log("...");

        log(answer.format());

        log("...");

        if (answer instanceof Answer.Negative) {
            log("This is a negative answer");
        } else if (answer instanceof Answer.Positive) {
            log("This is a positive answer");
        } else if (answer instanceof Answer.Neutral) {
            log("This is a neutral answer");
        }
    }

    /**
     * Super simple logging
     * @param message The string to output to the console
     */
    private static void log(String message) {
        System.out.println(message);
    }
}
