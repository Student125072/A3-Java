package oefening1;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Persoon {

    public String voornaam;
    public String achternaam;
    public String geboortedatum;

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public String getGeboortedatum() {
        return geboortedatum;
    }

    public void setGeboortedatum(String geboortedatum) {
        this.geboortedatum = geboortedatum;
    }

    public long ageDays(String geboortedatum) {
        LocalDate now = LocalDate.now();
        LocalDate dob = LocalDate.parse(geboortedatum);
        long daysbetween = ChronoUnit.DAYS.between(dob, now);
        return daysbetween;
    }

}
