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
    }
    
    private static void feladatok(){
        
    }
    
}
