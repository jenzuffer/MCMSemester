package FunctionLayer;

public class Materiale {
    private int bøf = 0;
    private String navn, beskrivelse, enhed;
    private int antal, længde;

    public Materiale(String navn, int længde, int antal, String enhed, String beskrivelse) {
        this.navn = navn;
        this.beskrivelse = beskrivelse;
        this.enhed = enhed;
        this.antal = antal;
        this.længde = længde;
    }

    public String getNavn() {
        return navn;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public String getEnhed() {
        return enhed;
    }

    public int getAntal() {
        return antal;
    }

    public int getLængde() {
        return længde;
    }

    
    
    
}


