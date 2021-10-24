public class Recursion {

    public static void main(String[] args) {
//        down1(10);
//        down2(10);
        down3(10);
    }

    // Code-Zitat Anfang.
    public static void down1(int n){
        if (n <= 0) return; // Rekursionsende

        System.out.print(n + " ");
        down1(n-1); // rekursiver Aufruf
    }

    public static void down2(int n){
        if (n <= 0) return; // Rekursionsende

        down2(n-1); // rekursiver Aufruf
        System.out.print(n + " "); // Ausgabe _nach_ rek. Aufruf
    }
    // Code-Zitat Ende.
    // Quelle: Buch "Java ist auch eine Insel", 15. Auflage, Rheinwerk; Seite 215 ff.

    public static void down3(int n) {
        if (n <= 0) return; // Rekursionsende
        print3(n);
    }

    public static void print3(int n){
        System.out.print(n + " ");
        down3(n-1); // indirekte Rekursion
    }
}
