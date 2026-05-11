package modell;

import java.util.Objects;

public class Fuvar {
    private String rsz;
    private int idoMp;
    private double osszeg;
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

    public double getOsszeg() {
        return osszeg;
    }

    public String getFizMod() {
        return fizMod;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.rsz);
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.osszeg) ^ (Double.doubleToLongBits(this.osszeg) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Fuvar other = (Fuvar) obj;
        if (Double.doubleToLongBits(this.osszeg) != Double.doubleToLongBits(other.osszeg)) {
            return false;
        }
        return Objects.equals(this.rsz, other.rsz);
    }
    
    
}
