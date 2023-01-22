package org.example.order;

public class OrderGenerator {
    public static Order getWithGrey(){
        return new Order("Александр","Иванов","ул.Партизанская 7", new String[]{"GREY"});
    }

    public static Order getWithBlack(){
        return new Order("Александр","Иванов","ул.Партизанская 7", new String[]{"BLACK"});
    }

    public static Order getWithoutTwoColours(){
        return new Order("Алекандр","Иванов","ул.Партизанская 7",null);
    }

    public static Order getWithTwoColours(){
        return new Order("Александр","Иванов","ул.Партизанская 7", new String[]{"GREY","BLACK"});
    }
}
