package mampitovyTelo;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class User {
    
    public User(String pseudo){
        this.pseudo = pseudo;
    }

    public String getPseudo(){

        return this.pseudo;
    }

    public void setMainCards(Card card){
        this.mainCards.add(card);
    }

    private int getPoints(){
        int points = 0;
        this.mainCards.sort(Comparator.comparing(Card::getValue));
        for(int i = 0; i < this.mainCards.size()-2; i++){
            if(this.mainCards.get(i).isEqualsValues(this.mainCards.get(i+1)) && this.mainCards.get(i+1).isEqualsValues(this.mainCards.get(i+2))){
                ArrayList<Card> checkCardsColors = new ArrayList<Card>();
                checkCardsColors.add(this.mainCards.get(i));
                checkCardsColors.add(this.mainCards.get(i+1));
                checkCardsColors.add(this.mainCards.get(i+2));
                if(Card.differentsColors(checkCardsColors)){
                    points++;
                    i+=2;
                }
            }
        }

        return points;
    }

    public void showMainCards(){
        int index_card = 0;
        this.mainCards.sort(Comparator.comparing(Card::getValue));
        for(Card card : this.mainCards){
            System.out.printf("   %d:",index_card);
            card.print();
            index_card++;
        }
        System.out.println("\nPoint :" + this.getPoints());
    }

    public boolean win(){

        return (this.getPoints() == 4);
    }

    public Card removeOneCard(){
        System.out.println("Which card to remove? (Enter the number)>");
        this.mainCards.sort(Comparator.comparing(Card::getValue));
        int index_card = 0;
        index_card = this.input();
        Card card = this.mainCards.get(index_card);
        this.mainCards.remove(index_card);

        return card;
    }

    private int input(){
        Scanner scn = new Scanner(System.in);
        int res = scn.nextInt();
        return res;

    }


    private String pseudo = "";
    private ArrayList<Card> mainCards = new ArrayList<Card>();
}
