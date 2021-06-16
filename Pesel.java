package pesel;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
public class Pesel {
    public static void main(String[] args) {
        PeselCreator p = new PeselCreator();
        p.main();       
}
}
class PeselCreator{   
    public int n = 0;
    Scanner in = new Scanner(System.in);
    Random losowanie = new Random();
    StringBuilder sb = new StringBuilder();
    public int [] years = new int[n];
    public int ordinalNumber = 0;
    int[] wage = {1, 3, 7, 9, 1, 3, 7, 9, 1, 3};
    public int [] months = new int[n];
    public int [] days = new int[n];
    public int [] ordinalNumTab = new int[n]; 
    public String [] peselTab = new String[n];
    private int birthYear;
    
    int getBirthYear(){
        do {
            try {
                System.out.println("Podaj rok urodzenia z przedziału 1900 - 2299");
                birthYear = in.nextInt();
                if (birthYear <= 2299 & 1900 <= birthYear){
                    break;
                }
                else{
                    System.out.println("Rok musi być liczbą z przedziału 1900 - 2299, wciśnij p jeśli chcesz podać ponownie rok, lub wciśnij inny klawisz jeśli chcesz zakończyć");
                    String n = in.next();
                    if ("p".equals(n)){
                        continue;
                    }
                    else {
                        PeselCreator pesel = new PeselCreator();
                        pesel.want();
                    }
                }
            }
            catch (Exception e){
                System.out.println("Podałeś zły format!");
                System.exit(0);
                }
            } while(true)    ;      
    return birthYear;
    }
    
    
    int getBirthMonth(){
        int birthMonth;
        while(true) {
            try {
                System.out.println("Podaj miesiąc urodzenia z przedziału 1-12:");
                birthMonth = in.nextInt();
                if (birthMonth <= 12 & 1 <= birthMonth){
                    break;
                }
                else{
                    System.out.println("Miesiąc powinien być liczbą z przedziału 1-12, wciśnij p jeśli chcesz podać ponownie miesiąc, lub wciśnij inny klawisz jeśli chcesz zakończyć");
                    String n = in.next();
                    if ("p".equals(n)){
                        continue;
                    }
                    else {
                        PeselCreator pesel = new PeselCreator();
                        pesel.want();
                    }
                }
            }
            catch (Exception e){
                System.out.println("Podałeś złą formę miesiąca!");
                System.exit(0);
            }
        }        
    return birthMonth;
    }
    
    static int setMonth(int birthYear, int birthMonth){
        int month = birthMonth;
        if (2000 <= birthYear & birthYear <= 2099){
            month += 20;
        }
        else if (2100 <= birthYear & birthYear <= 2199){
            month += 40;
        }
        else if (2200 <= birthYear & birthYear <= 2299){
            month += 60;
        }
        return month;
    }
    
    int getBirthDay(int birthYear, int birthMonth){
        int[] oneMonth = {1, 3, 5, 7, 8, 10, 12};
        int[] secondMonth = {4, 6, 9, 11};       
        int birthDay;
        while(true) {
            try {
                System.out.println("Podaj dzień urodzenia:");
                birthDay = in.nextInt();
                if (wyszukajElementTablicy(oneMonth, birthMonth) == true) {
                    if (0 < birthDay & birthDay <=31) {
                        break;
                    }
                    else {
                        System.out.println("Podałeś zły numer, wciśnij p jeśli chcesz podać ponownie numer dnia, lub wciśnij inny klawisz jeśli chcesz zakończyć");
                        String n = in.next();
                        if ("p".equals(n)){
                            continue;
                        }
                        else {
                            PeselCreator pesel = new PeselCreator();
                            pesel.want();
                        }
                    }                   
                }
                else if (wyszukajElementTablicy(secondMonth, birthMonth) == true) {
                    if (0 < birthDay & birthDay <=31) {
                        break;
                    }
                    else {
                        System.out.println("Podałeś zły numer, wciśnij p jeśli chcesz podać ponownie numer dnia, lub wciśnij inny klawisz jeśli chcesz zakończyć");
                        String n = in.next();
                        if ("p".equals(n)){
                            continue;
                        }
                        else {
                            PeselCreator pesel = new PeselCreator();
                            pesel.want();
                        }
                    }                   
                }
                else if (birthMonth == 2){
                    if ((birthYear % 4 == 0) & ((birthYear % 100 != 0) | (birthYear % 400 == 0))) { //leap year
                        if (0 < birthDay & birthDay <=29) {
                            break;
                        }
                        else {
                        System.out.println("Podałeś zły numer, wciśnij p jeśli chcesz podać ponownie numer dnia, lub wciśnij inny klawisz jeśli chcesz zakończyć");
                        String n = in.next();
                        if ("p".equals(n)){
                            continue;
                        }
                        else {
                            PeselCreator pesel = new PeselCreator();
                            pesel.want();
                        }
                        }
                    }
                    else {
                        if (0 < birthDay & birthDay <=29) {
                            break;
                        }
                        else {
                        System.out.println("Podałeś zły numer, wciśnij p jeśli chcesz podać ponownie numer dnia, lub wciśnij inny klawisz jeśli chcesz zakończyć");
                        String n = in.next();
                        if ("p".equals(n)){
                            continue;
                        }
                        else {
                            PeselCreator pesel = new PeselCreator();
                            pesel.want();
                        }
                        }
                    }
                }
            }
            catch (Exception e){
                System.out.println("Podałeś złą formę!");
                System.exit(0);
            }
        }
        return birthDay;
    }
    
    char getSex(){
        char sex;
        while(true) {
            try {
                System.out.print("Podaj płeć (\"k\" lub \"m\"):");
                sex = in.next().charAt(0);
                if (sex == 'm') {
                    break;
                }
                else if (sex == 'k'){
                    break;
                }                   
                else{
                    System.out.println("Podałeś niepoprawną formę płci, wciśnij p jeśli chcesz podać ponownie płeć, lub wciśnij inny klawisz jeśli chcesz zakończyć");
                    char n = in.next().charAt(0);
                    if (n == 'p'){
                        continue;
                    }
                    else {
                        PeselCreator pesel = new PeselCreator();
                        pesel.want();
                    }
                }
            }
            catch (Exception e){
                System.out.println("Podałeś niepoprawną formę płci!");
                System.exit(0);
            }
        }
        return sex;
    }
    
    void verification(int birthYear, int birthDay, int birthMonth, int month, char sex) {
        System.out.println("Czy chcesz dokonać wpisu: " + birthDay + ", " + birthMonth + ", " + birthYear + ", " + sex + "? Klawisz t - tak, pozostałe - nie:");
        String n = in.next();
        if ("t".equals(n)){
            PeselCreator pesel = new PeselCreator();
            pesel.peselMethod(birthYear, month, birthDay, sex);
            pesel.want();           
        }
        else {           
            PeselCreator pesel = new PeselCreator();
            pesel.want();           
        }
    }
    
    public String[] want() {
        System.out.println("Czy chcesz dokonać kolejnego wpisu? Klawisz t - tak, pozostałe - nie:");
        String m = in.next();
        String[] sortedPesel = new String[1];
        if ("t".equals(m)){
            PeselCreator pesel = new PeselCreator();   
            pesel.main();          
        }
        else {
            PeselCreator pesel = new PeselCreator();   
            sortedPesel = PeselCreator.sort(peselTab, years, months, days, ordinalNumTab);    
            writeToFile(sortedPesel);
        }
        return sortedPesel;
        }
    
    public static int[] addX(int n, int arr[], int x) 
    { 
        int i;   
        int newarr[] = new int[n + 1];   
        for (i = 0; i < n; i++) 
            newarr[i] = arr[i];  
        newarr[n] = x; 
        return newarr; 
    } 
    public static String[] addX(int n, String arr[], String x) 
    { 
        int i;   
        String newarr[] = new String[n + 1];   
        for (i = 0; i < n; i++) 
            newarr[i] = arr[i];  
        newarr[n] = x; 
        return newarr; 
    } 
    
    void peselMethod(int birthYear, int month, int birthDay, char sex) { 
        List<Number> tempPesel = new LinkedList<>();
        
        years = addX(n, years, birthYear); 
        months = addX(n, months, month); 
        days = addX(n, days, birthDay); 
        ordinalNumTab = addX(n, ordinalNumTab, ordinalNumber);         
        tempPesel.add(Math.floorDiv((birthYear % 100),10));
        tempPesel.add((birthYear % 100)%10);    
        tempPesel.add(Math.floorDiv(month,10));
        tempPesel.add(month % 10);
        tempPesel.add(Math.floorDiv(birthDay,10));
        tempPesel.add(birthDay % 10);
        tempPesel.add(Math.floorDiv(ordinalNumber,100));
        tempPesel.add(Math.floorDiv(ordinalNumber,10));
        tempPesel.add(ordinalNumber % 10);
        while (true){
            int numSex = losowanie.nextInt((9)+1);
            if (numSex % 2 == 0){
                if ('k' == sex) {
                    tempPesel.add(numSex);
                    break;
                }
            }
            else {
                if (sex == 'm') {
                    tempPesel.add(numSex);
                    break;
                }
            }
        }
        while (true) {
            int sum = 0;
            for (int i = 0; i < 10; i++){
                int num = (int) tempPesel.get(i);
                int res = wage[i] * num;
                sum += res;           
            }
            int control_num = 10 - (sum % 10);
            if (control_num == 10) {
               PeselCreator pesel = new PeselCreator();
               pesel.peselMethod(birthYear, month, birthDay, sex);
            }
            else {
                tempPesel.add(control_num);
                break;
            }
        }
        String delim = "";
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < tempPesel.size() - 1) {
            sb.append((int) tempPesel.get(i));
            sb.append(delim);
            i++;
        }
        sb.append((int) tempPesel.get(i));
        String res = sb.toString();
        System.out.println("Wygenerowany pesel:" + res);
        peselTab = addX(n, peselTab, res); 
        n++;       
    }
           
   static void change(int j, String[] peselTab, int[] years, int[] months, int[] days, int[] ordinalNumTab){
       String temp = peselTab[j];
       peselTab[j] = peselTab[j+1];
       peselTab[j + 1] = temp;
       int temp1 = years[j];
       years[j] = years[j+1];
       years[j + 1] = temp1;
       int temp2 = months[j];
       months[j] = months[j+1];
       months[j + 1] = temp2;
       int temp3 = days[j];
       days[j] = days[j+1];
       days[j + 1] = temp3;
       int temp4 = ordinalNumTab[j];
       ordinalNumTab[j] = ordinalNumTab[j+1];
       ordinalNumTab[j + 1] = temp4;             
   }
    
   
   static String[] sort(String[] peselTab, int[] years, int[] months, int[] days, int[] ordinalNumTab){
       int length = peselTab.length;
       for (int i = 0; i < (length - 1); i++){
           for (int j = 0; j < (length - i - 1); j++) {
               if (years[j] < years[j+1]) {
                   continue;
               }
               else if (years[j] > years[j+1]) {
                   PeselCreator.change(j, peselTab, years, months, days, ordinalNumTab);
               } else {
                   if (months[j] < months[j+1]) {
                       continue;
                   }
                   else if (months[j] > months[j+1]) {
                       PeselCreator.change(j, peselTab, years, months, days, ordinalNumTab);
                   } 
                   else {
                       if (days[j] < days[j+1]) {
                           continue;
                       }
                       else if (days[j] > days[j+1]) {
                           PeselCreator.change(j, peselTab, years, months, days, ordinalNumTab);
                       }
                       else {
                           if (ordinalNumTab[j] < ordinalNumTab[j+1]) {
                               continue;
                           }
                           else {
                               PeselCreator.change(j, peselTab, years, months, days, ordinalNumTab);
                           }
                       }
                   }
               }
           }
       }
       return peselTab;
   }
  
   
    boolean wyszukajElementTablicy(int[] tab, int birthMonth) {
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] == birthMonth) {
                return true;
            }
        }
        return false;
    }
    
    boolean createFile() {
    try {
      File myObj = new File("pesele.txt");
      if (myObj.createNewFile()) {
        System.out.println("File created: " + myObj.getName());
        return true;
      } else {
        System.out.println("File already exists.");
      }
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
      return false;
    }
        return true;
  }
    
    boolean writeToFile(String[] peselTab) {
    try
    {
        PrintWriter pr = new PrintWriter("pesele");    

        for (String peselTab1 : peselTab) {
            pr.println(peselTab1);
        }
    pr.close();
    }
    catch (Exception e)
    {   
    e.printStackTrace();
    System.out.println("No such file exists.");
    }
        return false;
    }

    
    void main(){
        if (createFile()){          
        PeselCreator pesel = new PeselCreator(); 
        int birthYear = pesel.getBirthYear();
        int birthMonth = pesel.getBirthMonth();
        int month = pesel.setMonth(birthYear, birthMonth);
        int birthDay = pesel.getBirthDay(birthYear, birthMonth);
        char sex = pesel.getSex();
        pesel.verification(birthYear, birthDay, birthMonth, month, sex);
        pesel.writeToFile(peselTab);
        }
        else {
            System.out.println("Błąd przy tworzeniu pliku!");
        }
    }  
}