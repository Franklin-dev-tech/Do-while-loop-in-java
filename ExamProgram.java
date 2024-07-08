import java.util.Scanner;

public class ExamProgram {
    // Constant for the total number of coursework assessments
    private static final int TOTAL_COURSEWORK_ASSESSMENTS = 5;
    // Constant for the weight of coursework in the total score (50%)
    private static final double COURSEWORK_WEIGHT = 0.5;
    // Constant for the weight of the final exam in the total score (50%)
    private static final double EXAM_WEIGHT = 0.5;
    // Constant for the minimum required coursework percentage (67%)
    private static final double MINIMUM_COURSEWORK_PERCENTAGE = 0.67;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        do {
            // Display the menu options to the user
            displayMenu();
            // Read the user's choice
            int choice = scanner.nextInt();
            // Consume the newline character to prevent input issues
            scanner.nextLine();

            // Handle the user's choice using a switch statement
            switch (choice) {
                case 1:
                    // If choice is 1, prompt to view coursework results
                    viewCourseworkResults(scanner);
                    break;
                case 2:
                    // If choice is 2, prompt to view exam results
                    viewExamResults(scanner);
                    break;
                case 3:
                    // If choice is 3, exit the program
                    exit = true;
                    break;
                default:
                    // If an invalid choice is made, prompt the user to try again
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (!exit);  // Repeat the loop until the user chooses to exit

        // Close the scanner to release resources
        scanner.close();
    }

    // Method to display the menu options to the user
    private static void displayMenu() {
        System.out.println("Exam Program Menu:");
        System.out.println("1. View coursework results");
        System.out.println("2. View exam results");
        System.out.println("3. Exit the program");
        System.out.print("Enter your choice: ");
    }

    // Method to prompt the user to enter coursework results and display them
    private static void viewCourseworkResults(Scanner scanner) {
        int totalCourseworkScore = 0;

        // Loop to get the score for each coursework assessment
        for (int i = 1; i <= TOTAL_COURSEWORK_ASSESSMENTS; i++) {
            System.out.print("Enter the score for coursework assessment " + i + ": ");
            int score = scanner.nextInt();
            // Consume the newline character to prevent input issues
            scanner.nextLine();
            // Add the score to the total coursework score
            totalCourseworkScore += score;
        }

        // Calculate the coursework percentage
        double courseworkPercentage = (double) totalCourseworkScore / (TOTAL_COURSEWORK_ASSESSMENTS * 10) * 100;
        System.out.println("Total coursework score: " + totalCourseworkScore + " out of " + (TOTAL_COURSEWORK_ASSESSMENTS * 10));
        System.out.println("Coursework percentage: " + courseworkPercentage + "%");

        // Check if the coursework percentage meets the minimum requirement
        if (courseworkPercentage < MINIMUM_COURSEWORK_PERCENTAGE * 100) {
            System.out.println("You need to repeat the unit, regardless of your final exam grade.");
        } else {
            System.out.println("You have met the minimum coursework requirement.");
        }
    }

    // Method to prompt the user to enter exam results and calculate the total score
    private static void viewExamResults(Scanner scanner) {
        // Prompt the user to enter the final exam score
        System.out.print("Enter the final exam score: ");
        int examScore = scanner.nextInt();
        // Consume the newline character to prevent input issues
        scanner.nextLine();

        // Prompt the user to enter the total coursework score
        System.out.print("Enter the total coursework score: ");
        int totalCourseworkScore = scanner.nextInt();
        // Consume the newline character to prevent input issues
        scanner.nextLine();

        // Calculate the percentages for coursework and exam
        double courseworkPercentage = (double) totalCourseworkScore / (TOTAL_COURSEWORK_ASSESSMENTS * 10) * 100;
        double examPercentage = (double) examScore / 50 * 100;
        // Calculate the total score based on the weights of coursework and exam
        double totalScore = courseworkPercentage * COURSEWORK_WEIGHT + examPercentage * EXAM_WEIGHT;

        // Display the percentages and the total score
        System.out.println("Coursework percentage: " + courseworkPercentage + "%");
        System.out.println("Exam percentage: " + examPercentage + "%");
        System.out.println("Total score: " + totalScore + "%");
    }
}