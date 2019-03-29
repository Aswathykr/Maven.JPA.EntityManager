package entities;

import javax.persistence.*;

import java.util.Set;

import static javax.persistence.CascadeType.ALL;

@Entity
public class CD {
    @Id
    @GeneratedValue()
    private int id;

    private String title;
    private String description;
    private int year;

    @OneToMany(cascade = ALL, fetch = FetchType.EAGER)
    private Set<Musician> artists;

    private int price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String desc) {
        this.description = desc;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Set<Musician> getMusicians() {
        return artists;
    }

    public void setMusicians(Set<Musician> artists) {
        this.artists = artists;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
