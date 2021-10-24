import play.test.*;
import play.jobs.*;
import models.*;

@OnApplicationStart
public class Bootstrap extends Job{
    public void doJob(){
        if(User.count()==0){
            User u1 = new User(1,"hola","christian").save();
            User u2 = new User(2,"erf","lluc").save();
            Event e1 = new Event("comida","comida juntos","10:00","12:00","14/23/22").save();
            Calendari c1 = new Calendari("enero",1).save();

            u1.calendaris.add(c1);
            u1.events.add(e1);
            u1.save();

            c1.User = u1;
            e1.User = u1;
        }
    }
}
