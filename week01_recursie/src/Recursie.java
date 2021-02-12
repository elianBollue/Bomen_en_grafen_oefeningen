import java.util.ArrayList;
import java.util.List;

public class Recursie {


    // Oefening 1: n-de Fibonacci-getal

    public static int fibonacci(int getal) {
        if(getal == 2){
            return 1;
        }
        if(getal <= 0){
            throw new IllegalArgumentException("Geen geldig getal");
        }
        if(getal <= 1){
            return getal;
        }
        else{
            return fibonacci(getal-1) + fibonacci(getal-2);
        }
    }

    // Oefening 2 : som van cijfers

    public static int somVanCijfers(int getal) {
        getal = Math.abs(getal);
        int eerste = getal%10;
        if(getal < 10){
            return getal;
        }
        else{
            return eerste + somVanCijfers((getal-eerste)/10);
        }
    }

    // Oefening 3: keer een string om
    public static String keerOm(String s) {
        if(s == null){
            throw new IllegalArgumentException("Lege string");
        }
        if(s.length() == 1 || s.trim().isEmpty()){
            return s;
        }
        else{
            return s.charAt(s.length() - 1) + keerOm(s.substring(0,s.length() - 1));
        }
    }

    //oefening 4: countX

    public static int countX(String s) {
        if(s == null){
            throw new IllegalArgumentException("Geen string");
        }
        if(s.trim().isEmpty() || s.length() == 0){
            return 0;
        }
        else{
            if(s.charAt(0) == 'x'){
                return 1 + countX(s.substring(1));
            }
            else{
                return countX(s.substring(1));
            }
        }
    }

    //oefening 5 : countHi
    public static int countHi(String s) {
        if(s == null){
            throw new IllegalArgumentException("Geen string");
        }
        if(s.trim().isEmpty() || s.length() == 0){
            return 0;
        }
        else{
            if(s.startsWith("hi")){
                return 1 + countHi(s.substring(2));
            }
            else{
                return countHi(s.substring(2));
            }
        }
    }

    // oefening 6
    public static String changeXY(String s) {
        if(s == null){
            throw new IllegalArgumentException("Geen string");
        }
        if(s.trim().isEmpty() || s.length() == 0){
            return s;
        }
        else{
            if(s.charAt(0) == 'x'){
                return "y" + changeXY(s.substring(1));
            }
            else{
                return s.charAt(0) + changeXY(s.substring(1));
            }
        }
    }

    // oefening 7

    public static String changePi(String s) {
        if(s == null){
            throw new IllegalArgumentException("Geen string");
        }
        if(s.trim().isEmpty() || s.length() < 2){
            return s;
        }
        else{
            if(s.startsWith("pi")){
                return "3.14" + changePi(s.substring(2));
            }
            else{
                return s.charAt(0) + changePi(s.substring(1));
            }
        }
    }

    // oefening 8:
    public static int tweelog(int getal) {
        if(getal <= 0){
            throw new IllegalArgumentException("ongeldig getal");
        }
        if(getal == 1){
            return 0;
        }
        else{
            return 1 + tweelog(getal/2);
        }
    }

    // oefening 9;
    public static double findMaximum(List<Double> lijst) {
        if(lijst == null || lijst.isEmpty()){
            throw new IllegalArgumentException("Lege lijst");
        }
        if(lijst.size() == 1){
            return lijst.get(0);
        }
        else{
            return Math.max(lijst.get(0),findMaximum(lijst.subList(1,lijst.size())));
        }
    }

    // oefening 10;
    public static ArrayList<String> findSubstrings(String string) {
        ArrayList<String> lijst = new ArrayList<>();
        if(string == null){
            throw new IllegalArgumentException("Geen string");
        }
        if(string.length() <= 1){
            lijst.add(string);
            return lijst;
        }
        else{
            lijst.add(string);
            lijst.add(string.substring(0,1));
            lijst.add(string.substring(string.length()));
            lijst.addAll(findSubstrings(string.substring(0,string.length()-1)));
            lijst.addAll(findSubstrings(string.substring(1)));
            return lijst;
        }
    }
}