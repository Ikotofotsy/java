package mampitovyTelo;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Main{
    
    public static void main(String[] args) {
        Pack pack = new Pack(1);
        User user1 = new User("user1");
        Players.add(user1);
        startGame(Players, pack);
        showSabotSize(pack);
        showUserCards(user1);
        System.out.println("\n");
        while (!endGame()) {
            showSabotSize(pack);
            int option = userAction();
            if(option == 1){
                System.out.println("Sabot : ");
                Card card = userGetCardInSabot(pack);
                card.print();
                user1.setMainCards(card);
                showUserCards(user1);
                tainy = user1.removeOneCard();
            }
            showUserCards(user1);
        }
        System.out.println("\n");
    }

    private static void showSabotSize(Pack sabot){
        System.out.println("Card in Sabot: " + sabot.packItems.size() + "\n");
    }

    private static int input(String text){
        System.out.printf("%s", text);
        Scanner sc = new Scanner(System.in);
        int res = 0;
        res = sc.nextInt();

        return res;
    }

    private static int userAction(){

        return input("1-Get card on sabot\t2-Get card from player");
    }

    private static boolean endGame(){
        for(User player : Players){
            if(player.win()){
                System.out.printf("End of game ! %s winnes!\n", player.getPseudo());
                player.showMainCards();

                return true;
            }
        }

        return false;
    }

    private static void startGame(ArrayList<User> players, Pack pack){
        System.out.printf("==============START GAME============\nDistribute cards ...\n");
        for(User player : players){
            distributeCard(pack, player, CARD_DISTRIBUTED);
        }
    }

    private static Card userGetCardInSabot(Pack Sabot){
        short unicodeColor = 0;
        String value = "";
        while(true){
            unicodeColor = radomUnicodeColorCard(Sabot);;
            value = radomValueCard(Sabot);
            Card card = new Card(unicodeColor, value);
            if(Sabot.exists(card)){
                Sabot.removeCard(card);

                return card;
            }
        }
    }

    private static void showUserCards(User player){
        System.out.printf(player.getPseudo() + " : \n");
        player.showMainCards();
        System.out.println("\n");
    }

    private static void distributeCard(Pack pack, User user, int numberOfCard){
        short unicodeColor = 0;
        String value = "";
        for(int i = 1; i <= numberOfCard; i++){
            unicodeColor = radomUnicodeColorCard(pack);
            value = radomValueCard(pack);
            Card card = new Card(unicodeColor, value);
            if(pack.exists(card)){
                pack.removeCard(card);
                user.setMainCards(card);
            }else{
                numberOfCard++;
            }
        }
    }

    private static short radomUnicodeColorCard(Pack pack){
        Random random = new Random();
        ArrayList<Short> cardColors = pack.getCardColors();
        int randomIndex = random.nextInt(cardColors.size());

        return cardColors.get(randomIndex);
    }

    private static String radomValueCard(Pack pack){
        Random random = new Random();
        ArrayList<String> cardValues = pack.getcardValues();
        int randomIndex = random.nextInt(cardValues.size());

        return cardValues.get(randomIndex);
    }
    
    private static final int CARD_DISTRIBUTED = 12;
    private static ArrayList<User> Players = new ArrayList<User>();
    private static ArrayList<Card> Tainys = new ArrayList<Card>();
    private static Card tainy;
}