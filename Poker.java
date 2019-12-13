import java.util.*;

public class Poker {
    private String[] deck = {
            "D1","D2","D3","D4","D5","D6","D7","D8","D9","D10","DJ","DQ","DK","DA",
            "C1","C2","C3","C4","C5","C6","C7","C8","C9","C10","CJ", "CQ","CK","CA",
            "H1","H2","H3","H4","H5","H6","H7","H8","H9","H10","HJ", "HQ","HK","HA",
            "S1","S2","S3","S4","S5","S6","S7","S8","S9","S10","SJ", "SQ","SK","SA"};
    private List<String> hand = new ArrayList<>();
    public Poker(){
        Collections.shuffle(Arrays.asList(deck));
    }

    public void playGame(){
        System.out.print("The first five cards are: ");
        for(int i = 0; i<5; i++){
            System.out.print(deck[i] +", ");
        }
        System.out.println(" ");
        int k = 0;
        String j;
        List<String> discard = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter up to 5 cards you want to get rid of (1 to quit): ");
        while (k<5) {
            j = in.next();
            if(!j.equals("1")){
                j = in.next();
                discard.add(j);
                k++;
            }else{
                break;
            }
        }
        List deckList = Arrays.asList(deck);
        String[] discard1 = discard.toArray(new String[0]);
        for(int l = 0; l<k; l++){
            int m = deckList.indexOf(discard1[l]);
            String n = deck[m];
            deck[m] = deck[l+5];
            deck[l+5] = n;
        }
        System.out.print("Your new hand is: ");
        for(int i = 0; i<5; i++){
            System.out.print(deck[i] +", ");
            hand.add(deck[i]);
        }
        System.out.println(" ");
    }

    public String scoreHand(){
        String score = null;
        int i = 0;
        List<String> check = new ArrayList<>(Collections.emptyList());
        List<String> check1 = new ArrayList<>(1);
        List<String> check3 = new ArrayList<>(Collections.emptyList());
        List<String> check4 = new ArrayList<>(Collections.emptyList());
        List<String> check5 = new ArrayList<>(Collections.emptyList());
        List<String> check6 = new ArrayList<>(Collections.emptyList());
        List<String> check7 = new ArrayList<>(Collections.emptyList());
        List<String> check8 = new ArrayList<>(Collections.emptyList());
        List<String> check9 = new ArrayList<>(Collections.emptyList());

        for(int j = 0; j<5; j++) {
            String k = hand.get(j);
            check.add(Character.toString(k.charAt(0)));

            for (int l = 1; l < check.size(); l++) { //checks for one pair, two pairs, three of a kind, and straight
                if (check.get(l).equals(check.get(l - 1))) { //checks for one pair
                    i = 1;
                }
                if (i == 1 && check.get(l).equals(check.get(l - 1))) { //checks for two pairs
                    i = 2;
                }
                if (i == 2 && check.get(l).equals(check.get(l - 1))) { //checks for three pairs
                    i = 3;
                }
            }

            int x = 0;
            check1.add(k);
            if (i == 3) { //checks for straight
                for (int m = 1; m < check1.size(); m++) {
                    check1.add(k);
                    if(check1.get(m - 1).equals(k + 1)){
                        x++;
                    }
                }
                if (x == 5) {
                    i = 4;
                }
            }
        }

        int y = 0;
        for(int n = 0; n<5; n++){ //checks for flush, straight flush, and royal flush
            String o = hand.get(n);
            check3.add(Character.toString(o.charAt(1)));
            if(i==4){ //checks for flush
                for(int u = 1; u<5; u++){
                    if(check3.get(u).equals(check3.get(u-1))){
                        y++;
                    }
                }
            }
            if(y==5){
                i = 5;
            }
            for(int w = 0; w<5; w++){ //checks for full house and four of a kind
                String v = hand.get(w);
                check4.add(Character.toString(v.charAt(0)));
                int x1 = 0;
                int x2 = 0;
                if(i==5){ //checks for full House
                    for(int q = 1; q<check4.size(); q++){
                        if (check4.get(q).equals(check4.get(q - 1))){
                            x1++;
                        }
                    }
                    for(int z = 1; z<check4.size(); z++){
                        if (check4.get(z).equals(check4.get(z-1))){
                            x2++;
                        }
                    }
                    if(x1==3 && x2==2){
                        i = 6;
                    }
                }
                int x3 = 0;
                if(i==6){ //checks for four of a kind
                    for(int h = 1; h<check5.size(); h++){
                        if(check5.get(h).equals(check5.get(h-1))){
                            x3++;
                        }
                    }
                    if(x3==4){
                        i = 7;
                    }
                }
            if(i==7){ //checks for straight flush
                int y1 = 0;
                int y2 = 0;
                for(int j1 = 0; j1<5; j1++) { //checks straight part
                    String k1 = hand.get(j1);
                    check.add(Character.toString(k1.charAt(0)));
                    for (int m1 = 1; m1 < check6.size(); m1++) {
                        check6.add(k1);
                        if(check6.get(m1 - 1).equals(k1+1)){
                            y1++;
                        }
                    }
                }
                String o1 = hand.get(n);
                check7.add(Character.toString(o1.charAt(1)));
                for(int u1 = 1; u1<5; u1++){ //checks flush part
                    if(check7.get(u1).equals(check7.get(u1-1))){
                        y2++;
                    }
                }
                if (y1 == 5 && y2 == 5) {
                    i = 8;
                }
            }
            int y3 = 0;
            int y4 = 0;
            if(i==8){ //checks for royal flush
                for(int c = 1; c<check8.size(); c++){ //checks royal part
                    String k2 = hand.get(c);
                    check8.add(Character.toString(k2.charAt(0)));
                }
                if (check8.contains("10")){
                    y3++;
                }
                if(check8.contains("J")){
                    y3++;
                }
                if(check8.contains("Q")){
                    y3++;
                }
                if(check8.contains("K")){
                    y3++;
                }
                if(check8.contains("A")){
                    y3++;
                }
                for(int h = 1; h<check9.size(); h++){
                    String o2 = hand.get(n);
                    check9.add(Character.toString(o2.charAt(1)));
                    for(int u2 = 1; u2<5; u2++){ //checks flush part
                        if(check7.get(u2).equals(check7.get(u2-1))){
                            y4++;
                        }
                    }
                }

                if(y3==5 && y4==5){
                    i = 9;
                }
            }
        }


        }


        if(i==0){
            score = "No Pair, 0 Payout";
        }else if(i==1){
            score = "One Pair, 1 Payout";
        }else if(i==2){
            score = "Two Pairs, 2 Payout";
        }else if(i==3){
            score = "Three of a Kind, 3 Payout";
        }else if(i==4){
            score = "Straight, 4 Payout";
        }else if(i==5){
            score = "Flush, 5 Payout";
        }else if(i==6){
            score = "Full House, 6 Payout";
        }else if(i==7){
            score = "Four of a Kind, 25 Payout";
        }else if(i==8){
            score = "Straight Flush, 50 Payout";
        }else if(i==9){
            score = "Royal Flush, 250 Payout";
        }else{
            score = "Sorry, something went wrong...";
        }
        return score;
    }
    public void getDeck(){
        for(int i = 0; i<deck.length; i++){
            System.out.print(deck[i] +", ");
        }
    }
}
