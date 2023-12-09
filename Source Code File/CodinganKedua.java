import java.util.Scanner;
import java.util.Arrays;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.text.SimpleDateFormat;

public class CodinganKedua {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Declaration Login
        int usign = 3, psign = 3;
        String[] Log = { "Safrizal", "Naufal", "Vahira", "Tarno" };
        String[] pass = { "Admin1", "Admin2", "Admin3", "Admin4" };
        boolean signUp = false, login = false, menuLog = false, menu = true, lagi = true;
        String namaLog = "", passLog, date = "", again, namaSignup, passSignup = "", passSignup1;
        int option, repreat = 0, user = -1;
        int userChoice;

        String[][] dateNonKabisat = {
                { "Senin", "Selasa", "Rabu", "Kamis", "jum'at", "Sabtu", "Minggu", "Senin", "Selasa", "Rabu", "Kamis",
                        "jum'at", "Sabtu", "Minggu", "Senin", "Selasa", "Rabu", "Kamis", "jum'at", "Sabtu", "Minggu",
                        "Senin", "Selasa", "Rabu", "Kamis", "jum'at", "Sabtu", "Minggu", "Senin", "Selasa", "Rabu" },
                { "Kamis", "jum'at", "Sabtu", "Minggu", "Senin", "Selasa", "Rabu", "Kamis", "jum'at", "Sabtu", "Minggu",
                        "Senin", "Selasa", "Rabu", "Kamis", "jum'at", "Sabtu", "Minggu", "Senin", "Selasa", "Rabu",
                        "Kamis", "jum'at", "Sabtu", "Minggu", "Senin", "Selasa", "Rabu" },
                { "Kamis", "Jum'at", "Sabtu", "Minggu", "Senin", "Selasa", "Rabu", "Kamis", "jum'at", "Sabtu", "Minggu",
                        "Senin", "Selasa", "Rabu", "Kamis", "jum'at", "Sabtu", "Minggu", "Senin", "Selasa", "Rabu",
                        "Kamis", "jum'at", "Sabtu", "Minggu", "Rabu", "Kamis", "jum'at", "Sabtu", "Minggu", "Senin" },
                { "Selasa", "Rabu", "Kamis", "jum'at", "Sabtu", "Minggu", "Senin", "Selasa", "Rabu", "Kamis", "jum'at",
                        "Sabtu", "Minggu", "Senin", "Selasa", "Rabu", "Kamis", "jum'at", "Sabtu", "Minggu", "Senin",
                        "Selasa", "Rabu", "Kamis", "jum'at", "Sabtu", "Minggu", "Senin", "Selasa", "Rabu" },
                { "Kamis", "jum'at", "Sabtu", "Minggu", "Senin", "Selasa", "Rabu", "Kamis", "jum'at", "Sabtu", "Minggu",
                        "Senin", "Selasa", "Rabu", "Kamis", "jum'at", "Sabtu", "Minggu", "Senin", "Selasa", "Rabu",
                        "Kamis", "jum'at", "Sabtu", "Minggu", "Senin", "Selasa", "Rabu", "Kamis", "Jum'at", "Sabtu" },
                { "Minggu", "Senin", "Selasa", "Rabu", "Kamis", "jum'at", "Sabtu", "Minggu", "Senin", "Selasa", "Rabu",
                        "Kamis", "jum'at", "Sabtu", "Minggu", "Senin", "Selasa", "Rabu", "Kamis", "jum'at", "Sabtu",
                        "Minggu", "Rabu", "Kamis", "jum'at", "Sabtu", "Minggu", "Senin", "Selasa", "Rabu" },
                { "Kamis", "jum'at", "Sabtu", "Minggu", "Senin", "Selasa", "Rabu", "Kamis", "jum'at", "Sabtu", "Minggu",
                        "Senin", "Selasa", "Rabu", "Kamis", "jum'at", "Sabtu", "Minggu", "Senin", "Selasa", "Rabu",
                        "Kamis", "jum'at", "Sabtu", "Minggu", "Senin", "Selasa", "Rabu", "Kamis", "Jum'at", "Sabtu" },
                { "Minggu", "Senin", "Selasa", "Rabu", "Kamis", "jum'at", "Sabtu", "Minggu", "Senin", "Selasa", "Rabu",
                        "Kamis", "jum'at", "Sabtu", "Minggu", "Senin", "Selasa", "Rabu", "Kamis", "jum'at", "Sabtu",
                        "Minggu", "Rabu", "Kamis", "jum'at", "Sabtu", "Minggu", "Senin", "Selasa", "Rabu", "Kamis" },
                { "jum'at", "Sabtu", "Minggu", "Senin", "Selasa", "Rabu", "Kamis", "jum'at", "Sabtu", "Minggu", "Senin",
                        "Selasa", "Rabu", "Kamis", "jum'at", "Sabtu", "Minggu", "Senin", "Selasa", "Rabu", "Kamis",
                        "jum'at", "Sabtu", "Minggu", "Senin", "Selasa", "Rabu", "Kamis", "Jum'at", "Sabtu" },
                { "Minggu", "Senin", "Selasa", "Rabu", "Kamis", "jum'at", "Sabtu", "Minggu", "Senin", "Selasa", "Rabu",
                        "Kamis", "jum'at", "Sabtu", "Minggu", "Senin", "Selasa", "Rabu", "Kamis", "jum'at", "Sabtu",
                        "Minggu", "Rabu", "Kamis", "jum'at", "Sabtu", "Minggu", "Senin", "Selasa", "Rabu", "Kamis" },
                { "jum'at", "Sabtu", "Minggu", "Senin", "Selasa", "Rabu", "Kamis", "jum'at", "Sabtu", "Minggu", "Senin",
                        "Selasa", "Rabu", "Kamis", "jum'at", "Sabtu", "Minggu", "Senin", "Selasa", "Rabu", "Kamis",
                        "jum'at", "Sabtu", "Minggu", "Senin", "Selasa", "Rabu", "Kamis", "Jum'at", "Sabtu" },
                { "Minggu", "Senin", "Selasa", "Rabu", "Kamis", "jum'at", "Sabtu", "Minggu", "Senin", "Selasa", "Rabu",
                        "Kamis", "jum'at", "Sabtu", "Minggu", "Senin", "Selasa", "Rabu", "Kamis", "jum'at", "Sabtu",
                        "Minggu", "Rabu", "Kamis", "jum'at", "Sabtu", "Minggu", "Senin", "Selasa", "Rabu", "Kamis" }
        };
        String[][] dateKabisat = {
                { "Senin", "Selasa", "Rabu", "Kamis", "jum'at", "Sabtu", "Minggu", "Senin", "Selasa", "Rabu", "Kamis",
                        "jum'at", "Sabtu", "Minggu", "Senin", "Selasa", "Rabu", "Kamis", "jum'at", "Sabtu", "Minggu",
                        "Senin", "Selasa", "Rabu", "Kamis", "jum'at", "Sabtu", "Minggu", "Senin", "Selasa", "Rabu" },
                { "Kamis", "jum'at", "Sabtu", "Minggu", "Senin", "Selasa", "Rabu", "Kamis", "jum'at", "Sabtu", "Minggu",
                        "Senin", "Selasa", "Rabu", "Kamis", "jum'at", "Sabtu", "Minggu", "Senin", "Selasa", "Rabu",
                        "Kamis", "jum'at", "Sabtu", "Minggu", "Senin", "Selasa", "Rabu", "Kamis" },
                { "Jum'at", "Sabtu", "Minggu", "Senin", "Selasa", "Rabu", "Kamis", "jum'at", "Sabtu", "Minggu", "Senin",
                        "Selasa", "Rabu", "Kamis", "jum'at", "Sabtu", "Minggu", "Senin", "Selasa", "Rabu", "Kamis",
                        "jum'at", "Sabtu", "Minggu", "Rabu", "Kamis", "jum'at", "Sabtu", "Minggu", "Senin", "Selasa" },
                { "Senin", "Selasa", "Rabu", "Kamis", "jum'at", "Sabtu", "Minggu", "Senin", "Selasa", "Rabu", "Kamis",
                        "jum'at", "Sabtu", "Minggu", "Senin", "Selasa", "Rabu", "Kamis", "jum'at", "Sabtu", "Minggu",
                        "Senin", "Selasa", "Rabu", "Kamis", "jum'at", "Sabtu", "Minggu", "Senin", "Selasa" },
                { "Rabu", "Kamis", "jum'at", "Sabtu", "Minggu", "Senin", "Selasa", "Rabu", "Kamis", "jum'at", "Sabtu",
                        "Minggu", "Senin", "Selasa", "Rabu", "Kamis", "jum'at", "Sabtu", "Minggu", "Senin", "Selasa",
                        "Rabu", "Kamis", "jum'at", "Sabtu", "Minggu", "Senin", "Selasa", "Rabu", "Kamis", "Jum'at" },
                { "Sabtu", "Minggu", "Senin", "Selasa", "Rabu", "Kamis", "jum'at", "Sabtu", "Minggu", "Senin", "Selasa",
                        "Rabu", "Kamis", "jum'at", "Sabtu", "Minggu", "Senin", "Selasa", "Rabu", "Kamis", "jum'at",
                        "Sabtu", "Minggu", "Rabu", "Kamis", "jum'at", "Sabtu", "Minggu", "Senin", "Selasa" },
                { "Rabu", "Kamis", "jum'at", "Sabtu", "Minggu", "Senin", "Selasa", "Rabu", "Kamis", "jum'at", "Sabtu",
                        "Minggu", "Senin", "Selasa", "Rabu", "Kamis", "jum'at", "Sabtu", "Minggu", "Senin", "Selasa",
                        "Rabu", "Kamis", "jum'at", "Sabtu", "Minggu", "Senin", "Selasa", "Rabu", "Kamis", "Jum'at" },
                { "Sabtu", "Minggu", "Senin", "Selasa", "Rabu", "Kamis", "jum'at", "Sabtu", "Minggu", "Senin", "Selasa",
                        "Rabu", "Kamis", "jum'at", "Sabtu", "Minggu", "Senin", "Selasa", "Rabu", "Kamis", "jum'at",
                        "Sabtu", "Minggu", "Rabu", "Kamis", "jum'at", "Sabtu", "Minggu", "Senin", "Selasa", "Rabu" },
                { "Kamis", "jum'at", "Sabtu", "Minggu", "Senin", "Selasa", "Rabu", "Kamis", "jum'at", "Sabtu", "Minggu",
                        "Senin", "Selasa", "Rabu", "Kamis", "jum'at", "Sabtu", "Minggu", "Senin", "Selasa", "Rabu",
                        "Kamis", "jum'at", "Sabtu", "Minggu", "Senin", "Selasa", "Rabu", "Kamis", "Jum'at" },
                { "Sabtu", "Minggu", "Senin", "Selasa", "Rabu", "Kamis", "jum'at", "Sabtu", "Minggu", "Senin", "Selasa",
                        "Rabu", "Kamis", "jum'at", "Sabtu", "Minggu", "Senin", "Selasa", "Rabu", "Kamis", "jum'at",
                        "Sabtu", "Minggu", "Rabu", "Kamis", "jum'at", "Sabtu", "Minggu", "Senin", "Selasa", "Rabu" },
                { "Kamis", "jum'at", "Sabtu", "Minggu", "Senin", "Selasa", "Rabu", "Kamis", "jum'at", "Sabtu", "Minggu",
                        "Senin", "Selasa", "Rabu", "Kamis", "jum'at", "Sabtu", "Minggu", "Senin", "Selasa", "Rabu",
                        "Kamis", "jum'at", "Sabtu", "Minggu", "Senin", "Selasa", "Rabu", "Kamis", "Jum'at" },
                { "Sabtu", "Minggu", "Senin", "Selasa", "Rabu", "Kamis", "jum'at", "Sabtu", "Minggu", "Senin", "Selasa",
                        "Rabu", "Kamis", "jum'at", "Sabtu", "Minggu", "Senin", "Selasa", "Rabu", "Kamis", "jum'at",
                        "Sabtu", "Minggu", "Rabu", "Kamis", "jum'at", "Sabtu", "Minggu", "Senin", "Selasa", "Rabu" }
        };

        // Array Kota dan harga
        String[][] perkiraan = {
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
        String formattedDate = "";
        String expeditionName = "";
        String inputDate = "";
        int totalGoods = 0, weight = 0, day = 0;
        int startDate = 0, endDate = 0;
        double totalDistance = 0.0, rangeTime = 0.0, distanceCost = 0.0;
        double costPerTime = 0.0, totalCost = 0.0, costPerKilometer = 0.0;
        // int option1 = scanner.nextInt();

        // boolean signUp = false, login = false;
        // String name="Mitra", nameLogin , pass="Mitra123", passLogin, pass1, again;

        // Declaration

        // INT UNTUK INPUT
        // String expeditionName, startDate, endDate;
        // String totalGoods;
        // double totalDistance, rangeTime, distanceCost, costPerTime, totalCost,
        // costPerKilometer;

        // Login And SignUp
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("|========================================|");
        System.out.println("                                           ");
        System.out.println("               EXPEDITION                ");
        System.out.println("                                           ");
        System.out.println("|========================================|");
        System.out.println("1. SignUp First if you dont have account");
        System.out.println("2. Login If you Have an account Before");
        option = scanner.nextInt();
        System.out.print("\033[H\033[2J");
        System.out.flush();
        switch (option) {
            case 1:
                do {
                    signUp = false;
                    System.out.println("|========================================|");
                    System.out.println("                Sign Up                   ");
                    System.out.println("|========================================|");
                    System.out.printf("Apply the username : ");
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

        // INT UNTUK INPUT

        // SUDAH MASUK KEDALAM MENU
        do {
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
                    System.out.println("Welcome to the Expedition Java Application!");
                    System.out.print("Please enter the name of the expedition: ");
                    expeditionName = scanner.nextLine();

                    // modif date
                    // LocalDateTime myDateObj = LocalDateTime.now();
                    // System.out.println("Before formatting: " + myDateObj);
                    // DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy
                    // HH:mm:ss");

                    // String formattedDate = myDateObj.format(myFormatObj);
                    // System.out.println("After formatting: " + formattedDate);

                    // menampilkan tanggal sekarang
                    Date currentDate = new Date();
                    LocalDateTime localDateTime = LocalDateTime.now();
                    day = localDateTime.getDayOfMonth();
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                    formattedDate = format.format(currentDate);
                    System.out.println("Date Now : " + formattedDate);

                    // menginput tanggal perkiraan
                    System.out.println("Enter an approximate date (dd/MM/yyyy) : ");
                    inputDate = scanner.nextLine();

                    // mengubah tanggal perkiraan dari String ke Date
                    SimpleDateFormat inputDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    do {
                        try {
                            Date expectedDate = inputDateFormat.parse(inputDate);
                            System.out.println("The approximate dates entered are : " + expectedDate);
                        } catch (Exception e) {
                            System.out.println("Incorrect date Format entered.");
                        }
                    } while (false);

                    // System.out.print("Please enter the start date (DD-MM-YYYY): ");
                    // startDate = scanner.nextInt();

                    // System.out.print("Please enter the end date (DD-MM-YYYY): ");
                    // endDate = scanner.nextInt();

                    System.out.println("Malang");
                    System.out.println("Surabaya");
                    System.out.println("Jakarta");
                    System.out.println("Pasuruan");
                    System.out.print("From where : ");
                    String fromWhere = scanner.nextLine();

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

                    System.out.print("Please enter Range Time days : ");
                    rangeTime = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline

                    System.out.println("Please enter the weight of Goods: ");
                    weight = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Please enter the total number of Goods: ");
                    totalGoods = scanner.nextInt();
                    scanner.nextLine();

                    distanceCost = Double.parseDouble(perkiraan[row][3]);

                    // Calculations kilogrma
                    int costPerKg = 4000;
                    totalCost = costPerKg * (totalGoods * weight) + distanceCost;
                    break;
                case 2:
                    System.out.print("Input New Password: ");
                    String newPass = scanner.next();
                    pass[user] = newPass;
                    System.out.println("Password changed successfully!");
                    continue;
                // break;
                case 3:
                    System.out.println("Username: " + Log[user]);
                    System.out.println("Password: " + pass[user]);
                    break;
                // break;
                // inisialisi 0,0
                case 4:
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
                    break;
                // break;
                case 5:
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
                    break;
                case 6:
                    System.out.println("\nThank you for using the Expedition Planner. Have a great day!");
                    menuLog = true;
                    break;
                // menuLog = true;
                // break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    continue;
                // break;
            }
        } while (menuLog != true);

        scanner.close();
        // Dibatasi array kota
        // CODINGAN AWAL
        // // Input
        // System.out.println("Welcome to the Expedition Java Application!");
        // System.out.print("Please enter the name of the expedition: ");
        // expeditionName = scanner.nextLine();

        // System.out.print("Please enter the start date (DD-MM-YYYY): ");
        // startDate = scanner.nextLine();

        // System.out.print("Please enter the end date (DD-MM-YYYY): ");
        // endDate = scanner.nextLine();

        // System.out.print("Please enter the total distance (in kilometers): ");
        // totalDistance = scanner.nextDouble();

        // System.out.print("Please enter Range Time days : ");
        // rangeTime = scanner.nextDouble();

        // scanner.nextLine(); // Consume newline
        // System.out.print("Please enter the total number of Goods: ");
        // totalGoods = scanner.nextLine();

        // System.out.print("Please enter the cost per Goods (in currency): ");
        // costPerTime = scanner.nextDouble();

        // // Calculations
        // distanceCost = totalDistance / rangeTime;
        // totalCost = Double.parseDouble(totalGoods) * costPerTime;
        // costPerKilometer = totalCost / totalDistance;

        // // Output
        // System.out.println("\nExpedition Details:");
        // System.out.println("Name: " + expeditionName);
        // System.out.println("Start Date: " + startDate);
        // System.out.println("End Date: " + endDate);
        // System.out.println("Total Distance (km): " + totalDistance);
        // System.out.println("Range Time (days): " + rangeTime);
        // System.out.println("Total Time (hours): " + distanceCost);
        // System.out.println("Total Goods: " + totalGoods);
        // System.out.println("Cost per Goods: " + costPerTime);
        // System.out.println("Total Cost: " + totalCost);
        // System.out.println("Cost per Kilometer: " + costPerKilometer);

        // // Additional Information
        // if (totalDistance > 1000) {
        // System.out.println("This is a long expedition!");
        // } else {
        // System.out.println("This is a short expedition.");
        // }

        // if (Double.parseDouble(totalGoods) > 50) {
        // System.out.println("Large group! Special arrangements may be needed.");
        // } else {
        // System.out.println("Manageable group size.");
        // }

        // if (costPerKilometer > 2.5) {
        // System.out.println("The expedition may be costly.");
        // } else {
        // System.out.println("The expedition is reasonably priced.");
        // }

        // // Switch case
        // System.out.println("\nPlease select an option:");
        // System.out.println("1. View expedition details");
        // System.out.println("2. View additional information");
        // System.out.println("3. Exit");

        // switch (option1) {
        // case 1:
        // System.out.println("\nExpedition Details:");
        // System.out.println("Name: " + expeditionName);
        // System.out.println("Start Date: " + startDate);
        // System.out.println("End Date: " + endDate);
        // System.out.println("Total Distance (km): " + totalDistance);
        // System.out.println("Range Time (days): " + rangeTime);
        // System.out.println("Total Time (hours): " + distanceCost);
        // System.out.println("Total Goods: " + totalGoods);
        // System.out.println("Cost per Goods: " + costPerTime);
        // System.out.println("Total Cost: " + totalCost);
        // System.out.println("Cost per Kilometer: " + costPerKilometer);
        // break;
        // case 2:
        // System.out.println("\nAdditional Information:");
        // if (totalDistance > 1000) {
        // System.out.println("This is a long expedition!");
        // } else {
        // System.out.println("This is a short expedition.");
        // }

        // if (Double.parseDouble(totalGoods) > 50) {
        // System.out.println("Large group! Special arrangements may be needed.");
        // } else {
        // System.out.println("Manageable group size.");
        // }

        // if (costPerKilometer > 2.5) {
        // System.out.println("The expedition may be costly.");
        // } else {
        // System.out.println("The expedition is reasonably priced.");
        // }
        // break;
        // case 3:
        // System.out.println("\nThank you for using the Expedition Java Application!");
        // break;
        // default:
        // System.out.println("\nInvalid option selected.");
        // break;
        // }

    }
}