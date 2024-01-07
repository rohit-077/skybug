package skybug;
import java.util.*;

public class QuizApp {
    static Map<String, Map<List<String>, String>> quizData = new HashMap<>();
    static int score = 0;

    public static void main(String[] args) {
        initializeQuizData();
        startQuiz();
        displayResult();
    }

    static void initializeQuizData() {
        Map<List<String>, String> question1 = new HashMap<>();
        question1.put(Arrays.asList("A. Berlin", "B. Paris", "C. Madrid", "D. Rome"), "B");
        quizData.put("What is the capital of France?", question1);

        Map<List<String>, String> question2 = new HashMap<>();
        question2.put(Arrays.asList("A. Venus", "B. Mars", "C. Jupiter", "D. Saturn"), "B");
        quizData.put("Which planet is known as the Red Planet?", question2);

        // Additional questions
        Map<List<String>, String> question3 = new HashMap<>();
        question3.put(Arrays.asList("A. Blue Whale", "B. Elephant", "C. Giraffe", "D. Lion"), "A");
        quizData.put("What is the largest mammal on Earth?", question3);

        Map<List<String>, String> question4 = new HashMap<>();
        question4.put(Arrays.asList("A. William Shakespeare", "B. Jane Austen", "C. Charles Dickens", "D. Mark Twain"), "A");
        quizData.put("Who wrote the play 'Romeo and Juliet'?", question4);

        Map<List<String>, String> question5 = new HashMap<>();
        question5.put(Arrays.asList("A. Graphic User Interface", "B. General User Interaction", "C. General User Interface", "D. Graphical User Interaction"), "A");
        quizData.put("In computer science, what does GUI stand for?", question5);

        Map<List<String>, String> question6 = new HashMap<>();
        question6.put(Arrays.asList("A. Seoul", "B. Beijing", "C. Tokyo", "D. Bangkok"), "C");
        quizData.put("What is the capital of Japan?", question6);

        Map<List<String>, String> question7 = new HashMap<>();
        question7.put(Arrays.asList("A. Isaac Newton", "B. Galileo Galilei", "C. Albert Einstein", "D. Archimedes"), "A");
        quizData.put("Who is known as the 'Father of Physics'?", question7);

        Map<List<String>, String> question8 = new HashMap<>();
        question8.put(Arrays.asList("A. Au", "B. Ag", "C. AuAg", "D. AgAu"), "A");
        quizData.put("What is the chemical symbol for gold?", question8);

        Map<List<String>, String> question9 = new HashMap<>();
        question9.put(Arrays.asList("A. Python", "B. Java", "C. C++", "D. Ruby"), "B");
        quizData.put("Which programming language is known for its flexibility and readability?", question9);

        Map<List<String>, String> question10 = new HashMap<>();
        question10.put(Arrays.asList("A. 1945", "B. 1950", "C. 1940", "D. 1935"), "A");
        quizData.put("In which year did the World War II end?", question10);
    }

    static void startQuiz() {
        Scanner scanner = new Scanner(System.in);

        for (Map.Entry<String, Map<List<String>, String>> entry : quizData.entrySet()) {
            String question = entry.getKey();
            Map<List<String>, String> questionData = entry.getValue();

            System.out.println(question);
            displayOptions(questionData.keySet().iterator().next());

            System.out.println("Enter your answer (A, B, C, or D): ");
            String userAnswer = scanner.next().toUpperCase();

            if (validateAnswer(userAnswer, questionData)) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer is: " + questionData.values().iterator().next() + "\n");
            }
        }
    }

    static void displayOptions(List<String> options) {
        for (String option : options) {
            System.out.println(option);
        }
    }

    static boolean validateAnswer(String userAnswer, Map<List<String>, String> questionData) {
        return userAnswer.equals(questionData.values().iterator().next());
    }

    static void displayResult() {
        System.out.println("Quiz Completed!");
        System.out.println("Your Score: " + score + "/" + quizData.size());
    }
}