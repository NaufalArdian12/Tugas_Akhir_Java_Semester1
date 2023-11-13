import java.util.Scanner;
import java.util.Arrays;

public class CodinganKedua {
    public static void main(String[] args) {        
        Scanner scanner = new Scanner(System.in);

            // Declaration Login
            int usign = 3, psign = 3;
            String[] Log = { "Necha", "Rizqi", "Rio" };
            String[] pass = { "test", "pasti", "bisa" };
            boolean signUp = false, login = false, menuLog = true, menu = true, lagi = true;
            String namaLog = "", passLog, date = "", again, namaSignup, passSignup = "", passSignup1;
            int option, repreat = 0,  user = -1;
            // boolean signUp = false, login = false;
            // String name="Mitra", nameLogin , pass="Mitra123", passLogin, pass1, again; 
            // Declaration
            String expeditionName, startDate, endDate;
            String totalGoods;
            double totalDistance, rangeTime, totalTime, costPerTime, totalCost, costPerKilometer;

            // Login And SignUp
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println(" ---------||-------");
            System.out.println("|    EXPEDITION   |");
            System.out.println(" ---------||-------");
            System.out.println("1. SignUp First if you dont have account");
            System.out.println("2. Login If you Have an account Before");
            option = scanner.nextInt();
            System.out.print("\033[H\033[2J");
            System.out.flush();
            switch (option) {
                case 1:
                    do {
                        signUp = false;
                        System.out.println(" ---------||-------");
                        System.out.println("|    Sign Up      |");
                        System.out.println(" ---------||-------");
                        System.out.print("Apply the username : ");
                        namaSignup = scanner.next();
                        if (namaSignup.length() < 3) {
                            System.out.println("Minimum 3 text ");
                            continue;
                        }
                        for (int i = 0; i < usign; i++) {
                            if (namaSignup.equals(Log[i])) {
                                repreat = i;
                                System.out.println("Username has loged in on another account");
                                break;
                            }
                        }
                        if (namaSignup.equals(Log[repreat])) {
                            continue;
                        }
                        System.out.print("Type password  : ");
                        passSignup1 = scanner.next();
                        System.out.print("Repeat password : ");
                        passSignup = scanner.next();
                        if (passSignup.equals(passSignup1)) {
                            signUp = true;
                            System.out.print("\033[H\033[2J");
                            break;
                        } else {
                            System.out.print("\033[H\033[2J");
                            System.out.println("The password is not syncron !!!");
                        }
                    } while (signUp != true); {
                    String[] newNama = new String[usign + 1];
                    usign++;
                    for (int i = 0; i < Log.length; i++) {
                        newNama[i] = Log[i];
                    }
                    Log = newNama;
                    String[] newPass = new String[psign + 1];
                    psign++;
                    for (int i = 0; i < pass.length; i++) {
                        newPass[i] = pass[i];
                    }
                    pass = newPass;
                    Log[usign - 1] = namaSignup;
                    pass[psign - 1] = passSignup;
                    System.out.print("\033[H\033[2J");
                    System.out.println("Your account has been succes registered ");
                }
                case 2:
                    do {
                        login = false;
                        user = -1;
                        System.out.println(" ---------||-------");
                        System.out.println("|     Login      |");
                        System.out.println(" ---------||-------");
                        System.out.print("Input username : ");
                        namaLog = scanner.next();
                        for (int i = 0; i < Log.length; i++) {
                            if (namaLog.equals(Log[i])) {
                                user = i;
                                break;
                            }
                        }
                        System.out.print("Input Password : ");
                        passLog = scanner.next();
                        if (user == -1) {
                            System.out.print("\033[H\033[2J");
                            System.out.println("wrong username or password ");
                            continue;
                        }
                        if (passLog.equals(pass[user])) {
                            login = true;
                        } else {
                            System.out.print("\033[H\033[2J");
                            System.out.println("wrong username or password");
                        }
                    } while (login != true);
                    System.out.print("\033[H\033[2J");
                    break;
                case 3:
                    menuLog = false;
                    break;
                default:
                    System.out.print("\033[H\033[2J");

                    System.out.println("UPSSS!!!");
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

            int option1 = scanner.nextInt();

            switch (option1) {
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