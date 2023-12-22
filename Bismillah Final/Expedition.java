import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Expedition {

    static Scanner scanner = new Scanner(System.in);

    // Declaration Login
    static int usign = 3, psign = 3, banyakUser = 0;
    static String[] Log = { "Safrizal", "Naufal", "Vahira", "Tarno" };
    static String[] pass = { "Admin1", "Admin2", "Admin3", "Admin4" };
    static String[] uLog = {};
    static String[] uPass = {};
    static boolean signUp = false, login = false, menuLog = false, menu = true, lagi = true;
    static String namaLog = "", passLog, date = "", again, namaSignup, passSignup = "", passSignup1;
    static int option, repreat = 0, user = -1;
    static int userChoice;
    static int int_random = ThreadLocalRandom.current().nextInt();

    // Array Kota dan harga
    static String[][] perkiraan = {
            { "Surabaya", "Malang", "100", "12000" },
            { "Surabaya", "Jakarta", "780", "14000" },
            { "Surabaya", "Pasuruan", "70", "10000" },
            { "Malang", "Surabaya", "100", "12000" },
            { "Malang", "Jakarta", "850", "21000" },
            { "Malang, Pasuruan", "75", "10000" },
            { "Jakarta", "Malang", "850", "21000" },
            { "Jakarta", "Pasuruan", "820", "22000" },
            { "Pasuruan", "Malang", "75", "10000" },
            { "Pasuruan", "Surabaya", "70", "10000" },
            // Utama Fitur
            // jakarta
            { "Jakarta", "Surabaya", "780", "14000" },
            { "Surabaya", "Jakarta", "780", "14000" },
            { "Jakarta", "Semarang", "448", "35000" },
            { "Semarang", "Jakarta", "448", "35000" },
            { "Jakarta", "Bandung", "157", "24000" },
            { "Bandung", "Jakarta", "157", "24000" },
            // Bandung
            { "Bandung", "Semarang", "365", "25000" },
            { "Semarang", "Bandung", "365", "25000" },
            { "Bandung", "Surabaya", "705", "41000" },
            { "Surabaya", "Bandung", "705", "41000" },
            // semarang
            { "Surabaya", "Semarang", "350", "26000" },
            { "Semarang", "Surabaya", "350", "26000" },
    };
    static int order = 0;
    static String coordinate[][] = {};

    static String[][] wareHouse = { 
        {"Jakarta", "Jl. Pluit Karang Utara No.153 14450 Daerah Khusus Ibukota Jakarta Jawa"}, 
        {"Bandung", "Jl. Cikapayang No.18 40132 Bandung Jawa Barat"},
        {"Surabaya", "Sinar, buduran 3 blok b1, Area Sawah, Siwalanpanji, Kec. Buduran Kabupaten Sidoarjo Jawa Timur"},
        {"Semarang", " Jl. Kyai Saleh No.10, Mugassari, Semarang Selatan, Mugassari, Semarang Sel., Kota Semarang, Jawa Tengah" },
        {"Pasuruan", " JL. Dr Wahidin Sudirohusodo No 07, Pekuncen Tanggung Rejo Kota Pasuruan."},
        {"Malang", "Jalan Untung Suropati Utara No.Kav. 2, Klojen, Kesatrian, Kec. Blimbing Kota Malang Jawa Timur"},
    };

    // int[] perkiraanharga = {{ }};
    // untuk Input
    static String fromWhere = "";
    static String toWhere = "";
    static String paymenType = "";
    static String formattedDate = "";
    static String expeditionName = "";
    static String recipientName = "";
    static String inputDate = "";
    static String anything = "";
    static String serviceType = "";
    // static String Recieve = "";
    static int totalGoods = 0, weight = 0, day = 0;
    static int startDate = 0, endDate = 0;
    static double totalDistance = 0.0, rangeTime = 0.0, distanceCost = 0.0;
    static double costPerTime = 0.0, totalCost = 0.0, costPerKilometer = 0.0;
    static String paymentType = "";

    static void SignUp() {
        System.out.println("|================================================================================|");
        System.out.println("|                                    Sign Up                                     |");
        System.out.println("|================================================================================|");
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
        for (int i = 0; i < uLog.length; i++) {
            if (namaSignup.equals(uLog[i])) {
                System.out.println("Username has loged in on another account");
                SignUp();
            }
        }
        System.out.print("Type password  : ");
        passSignup1 = scanner.next();
        System.out.print("Repeat password : ");
        passSignup = scanner.next();
        if (passSignup.equals(passSignup1)) {
            banyakUser++;
            String[] newNama = new String[banyakUser];
            for (int i = 0; i < uLog.length; i++) {
                newNama[i] = uLog[i];
            }
            uLog = newNama;
            String[] newPass = new String[banyakUser];
            for (int i = 0; i < uPass.length; i++) {
                newPass[i] = uPass[i];
            }
            uPass = newPass;
            uLog[banyakUser - 1] = namaSignup;
            uPass[banyakUser - 1] = passSignup;
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
        System.out.println(" |================================================================================|");
        System.out.println(" |                                    Login                                       |");
        System.out.println(" |================================================================================|");
        System.out.printf("Input username : ");
        namaLog = scanner.next();
        for (int i = 0; i < Log.length; i++) {
            if (namaLog.equals(Log[i])) {
                user = i;
                System.out.print("Input Password : ");
                passLog = scanner.next();
                if (passLog.equals(pass[user])) {
                    ClearScreen();
                    MainMenuAdmin();
                } else {
                    ClearScreen();
                    System.out.println("wrong password");
                    Login();
                }
            }
        }
        for (int i = 0; i < uLog.length; i++) {
            if (namaLog.equals(uLog[i])) {
                user = i;
                System.out.print("Input Password : ");
                passLog = scanner.next();
                if (passLog.equals(passSignup)) {
                //if (passLog.equals(uPass[user]) || passLog.equals(passSignup)) {
                    ClearScreen();
                    MainMenuUser();
                } else {
                    ClearScreen();
                    System.out.println("wrong password");
                    Login();
                }
            }
        }
        ClearScreen();
        System.out.println("There is no such username sign up first or try again!");
        Run();
    }

    static void MenuInput() {
        System.out.println("Welcome to the Expedition Java Application!");
        System.out.print("Please enter the sender name: ");
        expeditionName = scanner.nextLine();

        System.out.print("Please enter the recipient name: ");
        recipientName = scanner.nextLine();

        // System.out.print("Please enter the start date (DD-MM-YYYY): ");
        // startDate = scanner.nextInt();

        // System.out.print("Please enter the end date (DD-MM-YYYY): ");
        // endDate = scanner.nextInt();
        ClearScreen();
        System.out.println("|=========================================| ");
        System.out.println("Malang");
        System.out.println("Surabaya");
        System.out.println("Semarang");
        System.out.println("Bandung");
        System.out.println("Jakarta");
        System.out.println("Pasuruan");
        System.out.println("|=========================================| ");

        System.out.print("From where : ");
        fromWhere = scanner.nextLine();

        ClearScreen();
        System.out.println("|=========================================| ");
        System.out.println("Malang");
        System.out.println("Surabaya");
        System.out.println("Semarang");
        System.out.println("Bandung");
        System.out.println("Jakarta");
        System.out.println("Pasuruan");
        System.out.println("|=========================================| ");

        System.out.print("To Where : ");
        toWhere = scanner.nextLine();

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

        // menampilkan tanggal sekarang
        Date currentDate = new Date();
        LocalDateTime localDateTime = LocalDateTime.now();
        day = localDateTime.getDayOfMonth();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        formattedDate = format.format(currentDate);
        System.out.println("Date Now : " + formattedDate);

        // menginput tanggal perkiraan
        System.out.print("Enter an estimation date (dd/MM/yyyy) : ");
        inputDate = scanner.nextLine();

        // mengubah tanggal perkiraan dari String ke Date
        SimpleDateFormat inputDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date expectedDate = inputDateFormat.parse(inputDate);
            System.out.println("The estimation dates for shipping the goods is : " + expectedDate);
        } catch (Exception e) {
            System.out.println("Incorrect date Format entered.");
        }

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

        System.out.println("What service type do you choose");
        System.out.println("1. Regular");
        System.out.println("2. Economic");
        userChoice = scanner.nextInt();
        if (userChoice == 1) {
            distanceCost += 12000;
            serviceType = "Reguler";
        } else if (userChoice == 2) {
            distanceCost += 0;
            serviceType = "Economic";
        }

        // Calculations kilogrma
        int costPerKg = 4000; // fixed price reference by JNE
        // weight = 10kg
        // totalGoods = 2
        // distanceCost = 12000
        // simulation = 4000 * (10 * 2) + 12000

        totalCost = costPerKg * (totalGoods * weight) + distanceCost;
        ClearScreen();
        MainMenuUser();
    }
    //change password
    static void NewPass() {
        System.out.print("Input New Password: ");
        String newPass = scanner.next();
        passSignup = newPass;
        System.out.println("Password changed successfully!");
        MainMenuUser();
    }
    //
    static void Account() {
        System.out.println("Username: " + namaSignup);
        System.out.println("Password: " + passSignup);
        System.out.println("Insert anything to go back");
        anything = scanner.nextLine();
        MainMenuUser();
    }

    static void Detail() {
        System.out.println("\nExpedition Details + Payment:");
        System.out.println("Name: " + expeditionName);
        System.out.println("Start Date: " + formattedDate);
        System.out.println("Range Time : " + rangeTime);
        System.out.println("End Date: " + inputDate);
        System.out.println("Total Distance (km): " + totalDistance);
        System.out.println("Cost Distance: " + distanceCost);
        System.out.println("weight of good: " + weight);
        System.out.println("Total Goods: " + totalGoods);
        System.out.println("Total Cost: " + totalCost);
        System.out.println("Services: " + serviceType);
        System.out.println("|================================================================================| ");
        System.out.println("|                                       Payment                                  |");
        System.out.println("|================================================================================| ");

        System.out.print("Payment type (Direct / COD) : ");

        paymentType = scanner.nextLine();
        Double paymentAmount = 0.0;
        Double remain = 0.0;

        if (paymentType.equals("COD")) {
            System.out.println("|================================================================================| ");
            System.out.println("|                            Payment : Not yet paid off                          |");
            System.out.println("|================================================================================| ");
        } else {
            System.out.print("Payment amount : ");
            paymentAmount = scanner.nextDouble();
            remain = paymentAmount - totalCost;
            System.out.println("|================================================================================| ");
            System.out.println("|                                   Payment : Paid off                           |");
            System.out.println("|                                                                                |");
            System.out.println("  |                             Remain fee : Rp. " + remain + "                    |");
            System.out.println("|================================================================================| ");

        }

        coordinate = new String[1][3];
        
        order++;
        String newArray[][] = new String[order][3];
        for (int i = 0; i < coordinate.length; i++) {
            for (int j = 0; j < coordinate[i].length; j++) {
                newArray[i][j] = coordinate[i][j];
            }
        }
        coordinate[order - 1][0] = expeditionName;
        coordinate[order - 1][1] = recipientName;
        coordinate[order - 1][2] = fromWhere;
        ClearScreen();
        scanner.nextLine();
        System.out.println("Insert anything to go back");

        anything = scanner.nextLine();
        MainMenuUser();
    }

    static void Recieve() {
        // paymentType = scanner.nextLine();

        System.out.println("|================================================================================| ");
        System.out.println("                        Resi : Express" + getAlphaNumericString(7) + int_random);
        System.out.println("|================================================================================| ");
        System.out.println("                            Sender Name: " + expeditionName);
        System.out.println("                            Cost Distance: " + distanceCost);
        System.out.println("                            Weight of good: " + weight);
        System.out.println("                            Total Goods: " + totalGoods);
        System.out.println("                            Total Cost: " + totalCost);
        System.out.println("|================================================================================| ");
        System.out.println("                             Recipient Name: " + recipientName);
        System.out.println("                                 From: " + fromWhere);
        System.out.println("                                   To: " + toWhere);
        System.out.println("|================================================================================| ");
        // System.out.println( paymentType = "");
        System.out.println("Services: " + serviceType);
        System.out.println("|                         Shipment Type : " + paymentType + "                        |");
        System.out.println("|================================================================================| ");
        anything = scanner.nextLine();
        MainMenuUser();
    }

    static String getAlphaNumericString(int n) {

        // choose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index = (int) (AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }

    static void Additional() {
        System.out.println("\nAdditional Information:");
        if (totalDistance > 300) {
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
        MainMenuUser();
    }

    static void track() {
        System.out.println("|                              Your stuff is on the way                          | ");
        System.out.println("|================================================================================| ");
        System.out.println("                        Resi : Express" + getAlphaNumericString(7) + int_random);
        System.out.println("|================================================================================| ");
        System.out.println("                                 From: " + fromWhere);
        System.out.println("                                   To: " + toWhere);
        System.out.println("|================================================================================| ");

        System.out.println("Insert anything to go back");
        anything = scanner.nextLine();
        MainMenuUser();
    }

    static void EnglishNotes() {
        System.out.println("|================================================================================| ");
        System.out.println("|                                  NOTES                                         | ");
        System.out.println("|================================================================================| ");
        System.out.println("                            Sender Name: " + expeditionName);
        System.out.println("                            Cost Distance: " + distanceCost);
        System.out.println("                            Weight of good: " + weight);
        System.out.println("                            Total Goods: " + totalGoods);
        System.out.println("                            Total Cost: " + totalCost);
        System.out.println("|================================================================================| ");

        System.out.println("Insert anything to go back");
        anything = scanner.next();
        MainMenuAdmin();        
    }

    static void BahasaNotes() {
        System.out.println("|================================================================================| ");
        System.out.println("|                                  NOTES                                         | ");
        System.out.println("|================================================================================| ");
        System.out.println("                            Nama Pengirim: " + expeditionName);
        System.out.println("                            Biaya Jarak: " + distanceCost);
        System.out.println("                            Berat Barang: " + weight);
        System.out.println("                            Banyak Barang: " + totalGoods);
        System.out.println("                            Total Biaya: " + totalCost);
        System.out.println("|================================================================================| ");

        System.out.println("Tekan apa saja untuk keluar");
        anything = scanner.next();
        MainMenuAdmin();        
    }

    static void chechkWarehouse() {
        
        System.out.println("|=========================================| ");
        System.out.println("Malang");
        System.out.println("Surabaya");
        System.out.println("Semarang");
        System.out.println("Bandung");
        System.out.println("Jakarta");
        System.out.println("Pasuruan");
        System.out.println("|=========================================| ");
        System.out.print("Masukkan nama kota: ");
        String inputKota = scanner.next();
        
        String alamat = cariAlamat(inputKota);
        
        if (alamat != null) {
            System.out.println("Alamat " + inputKota + ": " + alamat);
        } else {
            System.out.println("Kota tidak ditemukan.");
        }

        System.out.println("Insert anything to go back");
        anything = scanner.next();
        MainMenuAdmin();
    }

    static String cariAlamat(String namaKota) {
        for (String[] data : wareHouse) {
            if (data[0].equalsIgnoreCase(namaKota)) {
                return data[1];
            }
        }
        return null;
    }

    static void MainMenuAdmin() {
        System.out.println("|================================================================================|");
        System.out.println("|                                  Logged In Menu                                |");
        System.out.println("|================================================================================|");
        System.out.println("|                              1. Print notes in English                         |");
        System.out.println("|                              2. Print notes in Bahasa                          |");
        System.out.println("|                              3. check warehouse                                |");
        System.out.println("|                              4. check Resi                                     |");
        System.out.println("|                              5. logout                                         |");
        System.out.println("|================================================================================|");
        System.out.printf("Choose an option: ");
        userChoice = scanner.nextInt();
        switch (userChoice) {
            case 1:
            ClearScreen();
                EnglishNotes();
            case 2:
            ClearScreen();
                BahasaNotes();
            case 3 :
            ClearScreen();
                chechkWarehouse();
            //case 4:
            //ClearScreen();
                //CheckResi();
            case 5 :
            ClearScreen();
                Run();
            default:
                break;
        }
    }

    static void MainMenuUser() {
        System.out.println("|================================================================================|");
        System.out.println("|                                  Logged In Menu                                |");
        System.out.println("|================================================================================|");
        System.out.println("|                              1. Input Menu                                     |");
        System.out.println("|                              2. Change Password                                |");
        System.out.println("|                              3. View Account Info                              |");
        System.out.println("|                              4. Detail & Payment                               |");
        System.out.println("|                              5. View additional information                    |");
        System.out.println("|                              6. Print Recieve                                  |");
        System.out.println("|                              7. Track my things                                |");
        System.out.println("|                              8. Logout                                         |");
        System.out.println("|================================================================================| ");
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
                ClearScreen();
                Recieve();
            case 7:
                ClearScreen();
                track();
            case 8:
                Run();
            default:
                ClearScreen();
                System.out.println("Wrong input");
                MainMenuUser();
        }
    }

    static void ClearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    static void Run() {
        System.out.println("|================================================================================|");
        System.out.println("                                  G1-EXPEDITION                                   ");
        System.out.println("|================================================================================|");
        System.out.println("                                                                                    ");
        System.out.println("                    1. SignUp First if you dont have account                       ");
        System.out.println("                    2. Login If you Have an account Before                         ");
        System.out.println("                                                                                    ");
        System.out.println("|================================================================================|");
        System.out.println("                        Jl. Soekarno Hatta No.9, Jatimulyo,                           ");
        System.out.println("                  Kec. Lowokwaru, Kota Malang, Jawa Timur 65141                   ");
        System.out.println("|================================================================================|");
        System.out.println("                                Choose Option 1 / 2:                                 ");
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