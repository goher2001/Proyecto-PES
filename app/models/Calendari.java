package models;
import javax.persistence.*;

import play.db.jpa.*;
@Entity
public class Calendari extends Model{
    public String titulo;
    public int id;
    @ManyToOne
    public User User;
    public Calendari(String titulo, int id){
        this.titulo = titulo;
        this.id = id;
    }

}
