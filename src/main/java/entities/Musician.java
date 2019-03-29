package entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;


@Entity
public class Musician {

    @Id
    @GeneratedValue()
    private int id;
    private String first_name;
    private String last_name;

    @Enumerated(EnumType.STRING)
    private InstrumentEnum instrument;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Musician)) return false;
        Musician musician = (Musician) o;
        return Objects.equals(first_name, musician.first_name) &&
                Objects.equals(last_name, musician.last_name) &&
                instrument == musician.instrument;
    }

    @Override
    public int hashCode() {
        return Objects.hash(first_name, last_name, instrument);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public InstrumentEnum getInstrument() {
        return instrument;
    }

    public void setInstrument(InstrumentEnum instrument) {
        this.instrument = instrument;
    }
}
