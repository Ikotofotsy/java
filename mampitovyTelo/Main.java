package mampitovyTelo;

import java.util.ArrayList;
import java.util.Random;

class Main{
    private static void distributeCard(Pack pack, User user, int numberOfCard){
        System.out.println("Ditribute card ...\n");
        short unicodeColor = 0;
        String value = "";
        for(int i = 1; i <= numberOfCard; i++){
            unicodeColor = radomUnicodeColor(pack);
            value = radomValue(pack);
            if(pack.exists(new Card(unicodeColor, value))){
                pack.removeCard(new Card(unicodeColor, value));
                user.setMainCard(new Card(unicodeColor, value));
            }else{
                numberOfCard++;
            }
        }
    }

    private static short radomUnicodeColor(Pack pack){
        Random random = new Random();
        ArrayList<Short> cardColors = pack.getCardColors();
        int randomIndex = random.nextInt(cardColors.size());
        return cardColors.get(randomIndex);
    }

    private static String radomValue(Pack pack){
        Random random = new Random();
        ArrayList<String> cardValues = pack.getcardValues();
        int randomIndex = random.nextInt(cardValues.size());
        return cardValues.get(randomIndex);
    }
    public static void main(String[] args) {
        Pack pack = new Pack(2);
        User user1 = new User("user1");
        User user2 = new User("user2");
        User user3 = new User("user3");
        User user4 = new User("user4");
        System.err.println("Card in Sabot: " + pack.packItems.size() +"\n");
        distributeCard(pack, user1, 12);
        distributeCard(pack, user2, 12);
        distributeCard(pack, user3, 12);
        distributeCard(pack, user4, 12);
        System.err.println("Card Sabot: " + pack.packItems.size() + "\n");

        System.err.println("\nMain card : " +user1.getPseudo()+ "=>"+ user1.getMainCard().size() + "\n");
        for(Card card : user1.getMainCard()){
            card.print();
        }
        System.err.println("\nMain card : " +user2.getPseudo()+ "=>"+ user2.getMainCard().size() + "\n");
        for(Card card : user2.getMainCard()){
            card.print();
        }
        System.err.println("\nMain card : " +user3.getPseudo()+ "=>"+ user3.getMainCard().size() + "\n");
        for(Card card : user3.getMainCard()){
            card.print();
        }
        System.err.println("\nMain card : " +user4.getPseudo()+ "=>"+ user4.getMainCard().size() + "\n");
        for(Card card : user4.getMainCard()){
            card.print();
        }
    }
}