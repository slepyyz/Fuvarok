package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import modell.Fuvar;

public class Program {
    
    private static List<Fuvar> fuvarok = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        Path path = Path.of("fuvarok.csv");
        List<String> sorok = Files.readAllLines(path);
        
        for (String sor : sorok) {
            String [] adatok = sor.split(";");
            String rsz = adatok[0];
            int idoMp = Integer.parseInt(adatok[1]);
            int osszeg = Integer.parseInt(adatok[2]);
            String fizMod = adatok[3];
            
            Fuvar fuvar = new Fuvar(rsz,idoMp,osszeg,fizMod);
            fuvarok.add(fuvar);  
        }
        feladatok();
    }
    
    private static void feladatok(){
        System.out.println("1. Az összes fuvar értéke: "+fuvarokErteke()+" Euro");
        System.out.println("2. legdrágább fuvar rendszáma: "+ legdragabbFuvar());
    }
    
    private static int fuvarokErteke(){
        int osszeg = 0;
        
        for (int i = 0; i < fuvarok.size(); i++) {
            osszeg+=fuvarok.get(i).getOsszeg();
        }
        return osszeg;
    }
    
    private static String legdragabbFuvar() {
        if (fuvarok.isEmpty()) return "Nincs adat";
        Fuvar maxFuvar = fuvarok.get(0);

        for (int i = 1; i < fuvarok.size(); i++) {
            if (fuvarok.get(i).getOsszeg() > maxFuvar.getOsszeg()) {
                maxFuvar = fuvarok.get(i);
            }
        }

        return maxFuvar.getRsz();
    }
}
