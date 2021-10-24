package controllers;

import play.*;
import play.mvc.*;
import play.db.jpa.JPA;

import java.util.*;

import models.*;

import javax.persistence.Query;

public class Application extends Controller {
    public static void login(String Name, String Pwd){
        User us = User.find("byFullnameAndPassword", Name, Pwd).first();
        if(us != null){
            renderText("login " + Name);
        }
        else
            renderText("Abans registrar-se");
    }

    public static void index(int i) {
        new User(1234, "pwd", "Lluc").save();
        new User(2345, "pwd1", "Christian").save();
    }
    public static void DonardeBaixaUsuari(String nom){
        User u = User.find("byfullname",nom).first();
        if (u!=null) {
            if (u.calendaris != null) {
                Calendari c;
                int i = 0;
                while (i < u.calendaris.size()) {
                    c = u.calendaris.get(i);
                    c = null;
                    c.save();
                    i++;
                }
            }
            if (u.events != null) {
                Event e;
                int i = 0;
                while (i < u.events.size()) {
                    e = u.events.get(i);
                    e = null;
                    e.save();
                    i++;
                }
                u.delete();
                renderText("Usuari " + nom + " donat de baixa");
            }
        }

    }
    public static void DonardebaixaCalendari(int ID){
        Calendari c = Calendari.find("byid",ID).first();
        if (c!=null){
            c.User.calendaris.remove(c);
            c.User.save();

        }
        c.delete();
        renderText("Calendari" + ID+"esborrat");
    }
    public static void DonardebaixaEvent(String titulo){
        Event e = Event.find("bytitulo",titulo).first();
        if(e!=null){
            e.User.calendaris.remove(e);
            e.User.save();
        }
    }

}