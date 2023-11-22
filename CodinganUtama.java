import java.util.Scanner;

public class CodinganUtama {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Declaration
        String expeditionName, startDate, endDate;
        String totalParticipants;
        double totalDistance, averageSpeed, totalTime, costPerParticipant, totalCost, costPerKilometer;

        // Input
        System.out.println("Welcome to the Expedition Java Application!");
        System.out.print("Please enter the name of the expedition: ");
        expeditionName = scanner.nextLine();

        System.out.print("Please enter the start date (YYYY-MM-DD): ");
        startDate = scanner.nextLine();

        System.out.print("Please enter the end date (YYYY-MM-DD): ");
        endDate = scanner.nextLine();

        System.out.print("Please enter the total distance (in kilometers): ");
        totalDistance = scanner.nextDouble();

        System.out.print("Please enter the average speed (in kilometers per hour): ");
        averageSpeed = scanner.nextDouble();

        scanner.nextLine(); // Consume newline
        System.out.print("Please enter the total number of participants: ");
        totalParticipants = scanner.nextLine();

        System.out.print("Please enter the cost per participant (in currency): ");
        costPerParticipant = scanner.nextDouble();

        // Calculations
        totalTime = totalDistance / averageSpeed;
        totalCost = Double.parseDouble(totalParticipants) * costPerParticipant;
        costPerKilometer = totalCost / totalDistance;

        // Output
        System.out.println("\nExpedition Details:");
        System.out.println("Name: " + expeditionName);
        System.out.println("Start Date: " + startDate);
        System.out.println("End Date: " + endDate);
        System.out.println("Total Distance (km): " + totalDistance);
        System.out.println("Average Speed (km/hr): " + averageSpeed);
        System.out.println("Total Time (hours): " + totalTime);
        System.out.println("Total Participants: " + totalParticipants);
        System.out.println("Cost per Participant: " + costPerParticipant);
        System.out.println("Total Cost: " + totalCost);
        System.out.println("Cost per Kilometer: " + costPerKilometer);

        // Additional Information
        if (totalDistance > 1000) {
            System.out.println("This is a long expedition!");
        } else {
            System.out.println("This is a short expedition.");
        }

        if (Double.parseDouble(totalParticipants) > 50) {
            System.out.println("Large group! Special arrangements may be needed.");
        } else {
            System.out.println("Manageable group size.");
        }

        if (costPerKilometer > 2.5) {
            System.out.println("The expedition may be costly.");
        } else {
            System.out.println("The expedition is reasonably priced.");
        }

        System.out.println("\nThank you for using the Expedition Java Application!");

    }
}
