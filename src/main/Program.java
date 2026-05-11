package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
        System.out.println("2. Legdrágább fuvar rendszáma: "+ legdragabbFuvar());
        System.out.println("3. A legolcsobb fuvar forintban: "+ legolcsobbFuvar()+ "Forint");
        System.out.println("4. Hány kártyás fizetés volt?: "+hanyKartyasFizetes());
        System.out.println("5. Minden fizetési mód meghatározott?: "+mindenFizetesiModMeghatarozott());
        System.out.println("6. Hány darab autó van a rendszerben?: "+ hanyAutoVanARendszerben());
        System.out.println("7. Hányféle fizetési mód van?: "+hanyfeleFizetesiMod());
        System.out.println("8. Melyik autoból hány darab van: ");
        melyikbolMennyi();
        
    }
    
    private static int fuvarokErteke(){
        int osszeg = 0;
        
        for (int i = 0; i < fuvarok.size(); i++) {
            osszeg+=fuvarok.get(i).getOsszeg();
        }
        return osszeg;
    }
    
    private static String legdragabbFuvar() {
        Fuvar maxFuvar = fuvarok.get(0);

        for (int i = 1; i < fuvarok.size(); i++) {
            if (fuvarok.get(i).getOsszeg() > maxFuvar.getOsszeg()) {
                maxFuvar = fuvarok.get(i);
            }
        }

        return maxFuvar.getRsz();
    }
    
    private static double legolcsobbFuvar() {
        Fuvar minFuvar = fuvarok.get(0);

        for (int i = 1; i < fuvarok.size(); i++) {
            if (minFuvar.getOsszeg() > fuvarok.get(i).getOsszeg()) {
                minFuvar = fuvarok.get(i);
            }
        }

        return minFuvar.getOsszeg()*360;
    }
    
    private static int hanyKartyasFizetes(){
        int kartyasFizetes = 0;
        
        for (int i = 0; i < fuvarok.size(); i++) {
            if (fuvarok.get(i).getFizMod().equals("Kártya")) {
                kartyasFizetes+=1;
            }
        }
        return kartyasFizetes;
    }
    
    private static String mindenFizetesiModMeghatarozott(){
        int i = 0;
        int N = fuvarok.size();
        
        while(i<N && !("-".equals(fuvarok.get(i).getFizMod()))){
            i++;
        }
        return i==N? "Igen" : "Nem";
    }
    
    private static int hanyAutoVanARendszerben(){
        HashSet<String> egyediAutok = new HashSet<>();
        
        for (Fuvar fuvar : fuvarok) {
            egyediAutok.add(fuvar.getRsz());
        }
        
        return egyediAutok.size();
    }
    
    private static int hanyfeleFizetesiMod(){
        HashSet<String> egyediFizMod = new HashSet<>();
        
        for (Fuvar fuvar : fuvarok) {
            if (!(fuvar.getFizMod().equals("-"))) {
                egyediFizMod.add(fuvar.getFizMod());
            }
        }
        return egyediFizMod.size();
    }
    
    private static void melyikbolMennyi(){
        Map<String, Integer> mm = new HashMap<>();
        
        for (Fuvar fuvar : fuvarok) {
            String kulcs = fuvar.getRsz();
            if (mm.containsKey(kulcs)) {
                int ertek = mm.get(kulcs);
                mm.put(kulcs, ++ertek);
            }else{
                mm.put(kulcs, 1);
            }
        }
        
        mm.forEach((rendszam, darab) -> {
            System.out.printf("%d-DB -> %s%n", darab, rendszam);
        });
    }
}