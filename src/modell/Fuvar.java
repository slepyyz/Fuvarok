package modell;

public class Fuvar {
    private String rsz;
    private int idoMp;
    private int osszeg;
    private String fizMod;

    public Fuvar(String rsz, int idoMp, int osszeg, String fizMod) {
        this.rsz = rsz;
        this.idoMp = idoMp;
        this.osszeg = osszeg;
        this.fizMod = fizMod;
    }

    public String getRsz() {
        return rsz;
    }

    public int getIdoMp() {
        return idoMp;
    }

    public int getOsszeg() {
        return osszeg;
    }

    public String getFizMod() {
        return fizMod;
    }
    
    
}
