import java.util.Scanner;


public class CodinganKedua {
    public static void main(String[] args) {        
        Scanner scanner = new Scanner(System.in);

            // Declaration Login
            boolean signUp = false, login = false;
            int option;
            String name="Mitra", nameLogin , pass="Mitra123", passLogin, pass1, again; 
            // Declaration
            String expeditionName, startDate, endDate;
            String totalGoods;
            double totalDistance, rangeTime, totalTime, costPerTime, totalCost, costPerKilometer;

            // Login And SignUp
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println(" ----------------");
            System.out.println("|    EXPEDITION   |");
            System.out.println(" ----------------");
            System.out.println("1. SignUp First if you dont have account");
            System.out.println("2. Login If you Have an account Before");
            option = scanner.nextInt();
            System.out.print("\033[H\033[2J");
            System.out.flush();
        switch (option) {
            case 1 :
                do{
                    
                }
                break;
        
            default:
                break;
        }


            // Input
            System.out.println("Welcome to the Expedition Java Application!");
            System.out.print("Please enter the name of the expedition: ");
            expeditionName = scanner.nextLine();

            System.out.print("Please enter the start date (DD-MM-YYYY): ");
            startDate = scanner.nextLine();

            System.out.print("Please enter the end date (DD-MM-YYYY): ");
            endDate = scanner.nextLine();

            System.out.print("Please enter the total distance (in kilometers): ");
            totalDistance = scanner.nextDouble();

            System.out.print("Please enter Range Time days : ");
            rangeTime = scanner.nextDouble();

            scanner.nextLine(); // Consume newline
            System.out.print("Please enter the total number of Goods: ");
            totalGoods = scanner.nextLine();

            System.out.print("Please enter the cost per Goods (in currency): ");
            costPerTime = scanner.nextDouble();

            // Calculations
            totalTime = totalDistance / rangeTime;
            totalCost = Double.parseDouble(totalGoods) * costPerTime;
            costPerKilometer = totalCost / totalDistance;

            // Output
            System.out.println("\nExpedition Details:");
            System.out.println("Name: " + expeditionName);
            System.out.println("Start Date: " + startDate);
            System.out.println("End Date: " + endDate);
            System.out.println("Total Distance (km): " + totalDistance);
            System.out.println("Range Time (days): " + rangeTime);
            System.out.println("Total Time (hours): " + totalTime);
            System.out.println("Total Goods: " + totalGoods);
            System.out.println("Cost per Goods: " + costPerTime);
            System.out.println("Total Cost: " + totalCost);
            System.out.println("Cost per Kilometer: " + costPerKilometer);

            // Additional Information
            if (totalDistance > 1000) {
                System.out.println("This is a long expedition!");
            } else {
                System.out.println("This is a short expedition.");
            }

            if (Double.parseDouble(totalGoods) > 50) {
                System.out.println("Large group! Special arrangements may be needed.");
            } else {
                System.out.println("Manageable group size.");
            }

            if (costPerKilometer > 2.5) {
                System.out.println("The expedition may be costly.");
            } else {
                System.out.println("The expedition is reasonably priced.");
            }

            // Switch case
            System.out.println("\nPlease select an option:");
            System.out.println("1. View expedition details");
            System.out.println("2. View additional information");
            System.out.println("3. Exit");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("\nExpedition Details:");
                    System.out.println("Name: " + expeditionName);
                    System.out.println("Start Date: " + startDate);
                    System.out.println("End Date: " + endDate);
                    System.out.println("Total Distance (km): " + totalDistance);
                    System.out.println("Range Time (days): " + rangeTime);
                    System.out.println("Total Time (hours): " + totalTime);
                    System.out.println("Total Goods: " + totalGoods);
                    System.out.println("Cost per Goods: " + costPerTime);
                    System.out.println("Total Cost: " + totalCost);
                    System.out.println("Cost per Kilometer: " + costPerKilometer);
                    break;
                case 2:
                    System.out.println("\nAdditional Information:");
                    if (totalDistance > 1000) {
                        System.out.println("This is a long expedition!");
                    } else {
                        System.out.println("This is a short expedition.");
                    }

                    if (Double.parseDouble(totalGoods) > 50) {
                        System.out.println("Large group! Special arrangements may be needed.");
                    } else {
                        System.out.println("Manageable group size.");
                    }

                    if (costPerKilometer > 2.5) {
                        System.out.println("The expedition may be costly.");
                    } else {
                        System.out.println("The expedition is reasonably priced.");
                    }
                    break;
                case 3:
                    System.out.println("\nThank you for using the Expedition Java Application!");
                    break;
                default:
                    System.out.println("\nInvalid option selected.");
                    break;
            }

            scanner.close();
    }
}