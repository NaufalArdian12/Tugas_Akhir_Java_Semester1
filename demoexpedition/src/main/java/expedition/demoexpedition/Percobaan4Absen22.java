package expedition.demoexpedition;

N

public class Percobaan4Absen22 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan panjang alas: ");
        int alas = input.nextInt();

        System.out.print("Masukkan tinggi: ");
        int tinggi = input.nextInt();x

        float luas = (float) (0.5 * alas * tinggi);

        System.out.println("Luas garasi adalah: " + luas);
    }
}
