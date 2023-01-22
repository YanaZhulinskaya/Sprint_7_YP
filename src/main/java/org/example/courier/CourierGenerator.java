package org.example.courier;

import java.util.Random;

public class CourierGenerator {
    private static final Random rnd = new Random();
    private static int getRnd(){
        return rnd.nextInt(1000);
    }

    public static final Courier defaultCourier =  new Courier("name1"+getRnd(), "1111"+getRnd(), "Николай"+getRnd());

    public static Courier getWithPasswordOnly (){

        return new Courier(null,"1111"+getRnd(),"Николай"+getRnd());
    }

    public static Courier getWithLoginOnly (){

        return new Courier("name1"+getRnd(), null, "Николай"+getRnd());
    }

    public static Courier getWithIncorrectCredentials(){

        return new Courier("name1", "11", "Николай");
    }


}