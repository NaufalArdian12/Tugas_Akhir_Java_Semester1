import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

public class withFunction {

    static Scanner scanner = new Scanner(System.in);

    // Declaration Login
    static int usign = 3, psign = 3;
    static String[] Log = { "Safrizal", "Naufal", "Vahira", "Tarno" };
    static String[] pass = { "Admin1", "Admin2", "Admin3", "Admin4" };
    static boolean signUp = false, login = false, menuLog = false, menu = true, lagi = true;
    static String namaLog = "", passLog, date = "", again, namaSignup, passSignup = "", passSignup1;
    static int option, repreat = 0, user = -1;
    static int userChoice;

    // Array Kota dan harga
    static String[][] perkiraan = {
            { "Surabaya", "Malang", "100", "12000" },
            { "Surabaya", "Jakarta", "780", "14000" },
            { "Surabaya", "Pasuruan", "70", "10000" },
            { "Malang", "Surabaya", "100", "12000" },
            { "Malang", "Jakarta", "850", "21000" },
            { "Malang, Pasuruan", "75", "10000" },
            { "Jakarta", "Malang", "850", "21000" },
            { "Jakarta", "Surabaya", "780", "14000" },
            { "Jakarta", "Pasuruan", "820", "22000" },
            { "Pasuruan", "Malang", "75", "10000" },
            { "Pasuruan", "Surabaya", "70", "10000" },
            { "Pasuruan", "Jakarta", "820", "22000" },
    };
    // int[] perkiraanharga = {{ }};
    // untuk Input
    static String formattedDate = "";
    static String expeditionName = "";
    static String inputDate = "";
    static String anything = "";
    static int totalGoods = 0, weight = 0, day = 0;
    static int startDate = 0, endDate = 0;
    static double totalDistance = 0.0, rangeTime = 0.0, distanceCost = 0.0;
    static double costPerTime = 0.0, totalCost = 0.0, costPerKilometer = 0.0;

    static void SignUp() {
        System.out.println("|========================================|");
        System.out.println("                Sign Up                   ");
        System.out.println("|========================================|");
        System.out.printf("Apply the username : ");
        namaSignup = scanner.next();
        if (namaSignup.length() < 3) {
            ClearScreen();
            System.out.println("Minimum 3 text ");
            SignUp();
        }
        for (int i = 0; i < usign; i++) {
            if (namaSignup.equals(Log[i])) {
                System.out.println("Username has loged in on another account");
                SignUp();
            }
        }
        System.out.print("Type password  : ");
        passSignup1 = scanner.next();
        System.out.print("Repeat password : ");
        passSignup = scanner.next();
        if (passSignup.equals(passSignup1)) {
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
            ClearScreen();
            System.out.println("Your account has been succes registered ");
            Login();
        } else {
            ClearScreen();
            System.out.println("The password is not syncron !!!");
            SignUp();
        }
    }

    static void Login() {
        user = -1;
        System.out.println(" |========================================|");
        System.out.println("|                   Login                 |");
        System.out.println(" |========================================|");
        System.out.printf("Input username : ");
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
            ClearScreen();
            System.out.println("wrong username or password ");
            Login();
        }
        if (passLog.equals(pass[user])) {
            ClearScreen();
            MainMenu();
        } else {
            System.out.print("\033[H\033[2J");
            System.out.println("wrong username or password");
        }
    }

    static void MenuInput() {
        System.out.println("Welcome to the Expedition Java Application!");
        System.out.print("Please enter the name of the expedition: ");
        expeditionName = scanner.nextLine();

        // menampilkan tanggal sekarang
        Date currentDate = new Date();
        LocalDateTime localDateTime = LocalDateTime.now();
        day = localDateTime.getDayOfMonth();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        formattedDate = format.format(currentDate);
        System.out.println("Date Now : " + formattedDate);

        // menginput tanggal perkiraan
        System.out.print("Enter an approximate date (dd/MM/yyyy) : ");
        inputDate = scanner.nextLine();

        // mengubah tanggal perkiraan dari String ke Date
        SimpleDateFormat inputDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date expectedDate = inputDateFormat.parse(inputDate);
            System.out.println("The approximate dates entered are : " + expectedDate);
        } catch (Exception e) {
            System.out.println("Incorrect date Format entered.");
        }

        // System.out.print("Please enter the start date (DD-MM-YYYY): ");
        // startDate = scanner.nextInt();

        // System.out.print("Please enter the end date (DD-MM-YYYY): ");
        // endDate = scanner.nextInt();
        ClearScreen();
        System.out.println("Malang");
        System.out.println("Surabaya");
        System.out.println("Jakarta");
        System.out.println("Pasuruan");
        System.out.print("From where : ");
        String fromWhere = scanner.nextLine();

        ClearScreen();
        System.out.println("Malang");
        System.out.println("Surabaya");
        System.out.println("Jakarta");
        System.out.println("Pasuruan");
        System.out.print("To Where : ");
        String toWhere = scanner.nextLine();

        int row = 0;
        for (int i = 0; i < perkiraan.length; i++) {
            for (int j = 0; j < perkiraan[i].length; j++) {
                if (perkiraan[i][j].equalsIgnoreCase(fromWhere)) {
                    if (perkiraan[i][j + 1].equalsIgnoreCase(toWhere)) {
                        row = i;
                    }
                }
            }
        }

        totalDistance = Double.parseDouble(perkiraan[row][2]);

        ClearScreen();
        System.out.print("Please enter Range Time days : ");
        rangeTime = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        System.out.print("Please enter the weight of Goods: ");
        weight = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Please enter the total number of Goods: ");
        totalGoods = scanner.nextInt();
        scanner.nextLine();

        distanceCost = Double.parseDouble(perkiraan[row][3]);

        // Calculations kilogrma
        int costPerKg = 4000;
        totalCost = costPerKg * (totalGoods * weight) + distanceCost;
        ClearScreen();
        MainMenu();
    }

    static void NewPass() {
        System.out.print("Input New Password: ");
        String newPass = scanner.next();
        pass[user] = newPass;
        System.out.println("Password changed successfully!");
        MainMenu();
    }

    static void Account() {
        System.out.println("Username: " + Log[user]);
        System.out.println("Password: " + pass[user]);
        System.out.println("Insert anything to go back");
        anything = scanner.nextLine();
    }

    static void Detail() {
        System.out.println("\nExpedition Details:");
        System.out.println("Name: " + expeditionName);
        System.out.println("Start Date: " + formattedDate);
        System.out.println("Range Time : " + rangeTime);
        System.out.println("End Date: " + inputDate);
        System.out.println("Total Distance (km): " + totalDistance);
        System.out.println("Cost Distance: " + distanceCost);
        System.out.println("weight of good: " + weight);
        System.out.println("Total Goods: " + totalGoods);
        System.out.println("Total Cost: " + totalCost);
        System.out.println("Insert anything to go back");
        anything = scanner.nextLine();
        MainMenu();
    }

    static void Additional() {
        System.out.println("\nAdditional Information:");
        if (totalDistance > 1000) {
            System.out.println("This is a long expedition!");
        } else {
            System.out.println("This is a short expedition.");
        }

        if (totalGoods > 50) {
            System.out.println("Large group! Special arrangements may be needed.");
        } else {
            System.out.println("Manageable group size.");
        }

        if (costPerKilometer > 2.5) {
            System.out.println("The expedition may be costly.");
        } else {
            System.out.println("The expedition is reasonably priced.");
        }
        System.out.println("Insert anything to go back");
        anything = scanner.nextLine();
        MainMenu();
    }

    static void MainMenu() {
        System.out.println("|=========================================|");
        System.out.println("|              Logged In Menu             |");
        System.out.println("|=========================================|");
        System.out.println("|           1. Go to Option Menu          |");
        System.out.println("|           2. Change Password            |");
        System.out.println("|           3. View Account Info          |");
        System.out.println("|           4. View expedition details    |");
        System.out.println("|           5. View additional information|");
        System.out.println("|           6. Logout                     |");
        System.out.println("|=========================================| ");
        System.out.printf("Choose an option: ");
        userChoice = scanner.nextInt();
        scanner.nextLine();

        switch (userChoice) {
            case 1:
                ClearScreen();
                MenuInput();
            case 2:
                ClearScreen();
                NewPass();
            case 3:
                ClearScreen();
                Account();
            case 4:
                ClearScreen();
                Detail();
            case 5:
                ClearScreen();
                Additional();
            case 6:
                Run();
            default:
                ClearScreen();
                System.out.println("Wrong inpiut");
                MainMenu();
        }
    }

    static void ClearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    static void Run() {
        System.out.println("|========================================|");
        System.out.println("                                           ");
        System.out.println("               EXPEDITION                ");
        System.out.println("                                           ");
        System.out.println("|========================================|");
        System.out.println("1. SignUp First if you dont have account");
        System.out.println("2. Login If you Have an account Before");
        option = scanner.nextInt();
        ClearScreen();
        switch (option) {
            case 1:
                SignUp();
            case 2:
                Login();
            default:
                System.out.println("Wrong input");
                Run();
        }
    }

    public static void main(String[] args) {
        ClearScreen();
        Run();
    }
}