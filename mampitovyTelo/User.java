package mampitovyTelo;
import java.util.ArrayList;

public class User {
    private String pseudo = "";
    private ArrayList<Card> mainCard = new ArrayList<Card>();

    public User(String pseudo){
        this.pseudo = pseudo;
    }

    public String getPseudo(){
        return this.pseudo;
    }

    public void setMainCard(Card card){
        this.mainCard.add(card);
    }

    public ArrayList<Card> getMainCard(){
        return this.mainCard;
    }

    public void showMainCard(){
        
    }
}
