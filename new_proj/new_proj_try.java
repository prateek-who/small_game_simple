package whatever.new_proj;

import java.util.*;

public class new_proj_try
{
    public static void main(String[] args){
        act_ply game_obj= new act_ply();
        game_obj.moving();
        game_obj.moving();
    }
}

class map
{
    trader trader_obj1 = new trader();
    Scanner sc= new Scanner(System.in);
    String[][] ar= new String[12][35]; //change row and colums here first
    String sp=" ";
    int row,column;
    int r_ch=5,c_ch=7;
    public void prnt_ar1(){
        for(row=0;row<7;row++){
            for(column=0;column<25;column++) {   //Don't forget to change rows and columns here aswell
                if (row == 0 || row == 6) {
                    ar[row][column]="_";
                }
                //If anything has to be printed on the screen, make sure to add it in (else if)
                else if(column==0 || column==24){
                    ar[row][column]="|";
                }

                else if(row== r_ch && column == c_ch){
                    ar[row][column]="*";
                }

                else if(row== 3 && column== 18){
                    ar[row][column]="?";
                } // Trader coordiantes. Can try to make it random each time.....?
                else{
                    ar[row][column]=sp;
                }
                System.out.print(ar[row][column]);
            }
            System.out.println(" ");
        }
    }

    public void prnt_ar2(){
        for(row=0;row<12;row++){
            for(column=0;column<35;column++) {
                if (row == 0 || row == 11) {
                    ar[row][column]="_";
                }
                //If anything has to be printed on the screen, make sure to add it in (else if)
                else if(column==0 || column==34){
                    ar[row][column]="|";
                }

                else if(row== r_ch && column == c_ch){
                    ar[row][column]="*";
                }

                else if(row== 7 && column== 5){
                    ar[row][column]="#";
                } // Survivor 1 with package coordiantes.

                else if(row== 9 && column == 22){
                    ar[row][column]="$";
                }// Deliever package here?

                else{
                    ar[row][column]=sp;
                }
                System.out.print(ar[row][column]);
            }
            System.out.println(" ");
        }
    }
}

class trader
{
    Scanner sc= new Scanner(System.in);
    //Can add more dialogues and even more characters in the future
    int choice,mys_fig_count=1,map_full=0,pack=0,surv_count=0,delivery_count=0;

    public void interact_mys_fig(){
        if(mys_fig_count==1) {
            System.out.println("(?): What are you still doing here?\n1.Interact\n2.Leave");
            choice = sc.nextInt();

            if (choice == 1) {
                System.out.println("(*): I was just passing by....Who are you?");
                System.out.println("*The mysterious person stares at you*\n(?):Nothing is left here kid....It's all over..*He sighs..*");
                System.out.println("(?): Do you have some water?\n1.Yes\n2.No");
                choice = sc.nextInt();
                if (choice == 1) {
                    System.out.println("(?): Thanks traveller...You can have this map, there are still some survivours towards the south....\n*The mysterious character dissappears into his broken shed*");
                    map_full++;
                    System.out.println("*You decide to leave*");
                }
                else if (choice == 2) {
                    System.out.println("(?): No problem traveller...Safe passage ahead..");
                    System.out.println("*You decide to leave*");
                }
                else{
                    System.out.println("*The mysterious figure looks at you weirdly and leaves*");
                    System.out.println("*You decide to leave*");
                }
            }
            else if(choice == 2){
                System.out.println("*You decide to leave*");
            }
            else{
                System.out.println("*The mysterious figure looks at you weirdly and leaves*");
                System.out.println("*You decide to leave*");
            }
            mys_fig_count++;
        }

        //if characeters comes here again, this will be played!
        else if(mys_fig_count==2){
            System.out.println("*An empty broken shed...You wonder where the mysterious figure went..\n1. Look inside\n2. Leave");
            choice=sc.nextInt();
            if(choice==1){
                System.out.println("*You peep inside the shed.There is a mattress stuffed in a corner. A broken lamp rests nexts to it. A peculiar piece of paper is hanging out from under the lamp*");
                System.out.println("*You decide to take it with you abd leave*");
                map_full++;
            }
            else{
                System.out.println("*You decide to leave*");
            }
        }
        else{
            System.out.println("*You decide to leave*");
        }
    }

    public void interact_survivors(){
        if(surv_count==0) {
            System.out.println("(#)Help!! It's an emergency!!\n1.Check the commotion\n2.Ignore");
            choice = sc.nextInt();

            if (choice == 1) {
                System.out.println("(*): What's the emergency?\n(#): Oh, someone actually responded! Well....umm..there's this package that I have. Could you delieve it to my friend in the east?");
                System.out.println("1.Yea, sure\n2.Sorry, I'm busy right");
                choice = sc.nextInt();


                if (choice == 1) {
                    pack++;
                    surv_count++;
                    delivery_count++;
                    System.out.println("(#): Thx a lot! I know it's impossible to know if this package will reach him, but it's always good to be hopeful right?");
                }
                else if (choice == 2) {
                    System.out.println("No problem sir, I'm always here if you change your mind!");
                }
                else {
                    System.out.println("The survivor looks at you weirdly and walks back into his camp");
                }
                surv_count++;
            }
        }

        else if(surv_count==1){
            System.out.println("*You stand in front of a dusty old tent*\n1.Enter\n2.Leave");
            choice=sc.nextInt();
            if(choice==1){
                System.out.println("(#): I knew you would come back!! Here's the package!");
                pack++;
                surv_count++;
                delivery_count++;
            }
            else{
                System.out.println("*You decide to leave*");
            }
        }

        else if(surv_count==2){
            System.out.println("The tent is torn apart in half. The previous inhabitants seem to have left already");
        }
        else{
            System.out.println("*You decide to leave*");
        }
    }

    public void interact_delivery(){
        if(delivery_count==0){
            System.out.println("*You approach a huge door*\n($): Unauthorized access detected!\n*Seems like you need some kind of package to open the door..*");
        }
        else {
            System.out.println("*You approach a huge door, a small package holder appears on the door*\n1. Insert package into the holder\n2. Walk away");
            choice=sc.nextInt();

            if (choice == 1) {
                pack--;
                System.out.println("*The door hums to life. It slowly opens and THEN A BRIGHT FALSH OF LIGHT.......*");
                map_full++;
            }

            else{
                System.out.println("You decide to leave the door for now. There's something wrong about that door...");
            }
        }
    }
}
class act_ply extends map
{
    String movement;
    public void moving(){
        if (trader_obj1.map_full==0) {
            System.out.println("You are '*'");
            System.out.println("You control your character with 'w' 'a' 's' 'd'");
            System.out.println("'w' -> Move forward\n'a' -> Move left\n's' -> move backward\n'd' -> Move right");
            prnt_ar1();
            do {
                movement = sc.next();
                switch (movement) {
                    case "w" -> r_ch--;
                    case "a" -> c_ch--;
                    case "s" -> r_ch++;
                    case "d" -> c_ch++;
                    default -> System.out.println("Wrong Input!");
                }
                if ((r_ch < 6 && r_ch > 0) && (c_ch < 24 && c_ch > 0)) {
//                System.out.println(r_ch+" "+c_ch); //Prints and checks coordiantes, can be deleted later!
                    prnt_ar1();
                    // Add character locations here aswell!!
                    if (r_ch == 3 && c_ch == 18) {
                        trader_obj1.interact_mys_fig();
                    }
                } else {
                    System.out.println("Invalid Move!");
                    if (r_ch == 6) {
                        r_ch--;
                    }
                    else if (r_ch == 0) {
                        r_ch++;
                    }
                    else if (c_ch == 0) {
                        c_ch++;
                    }
                    else if (c_ch == 24) {
                        c_ch--;
                    }
                    prnt_ar1();
                }
            } while (trader_obj1.map_full== 0);
        }

        else if (trader_obj1.map_full==1) {
            System.out.println("New map loaded............");
            prnt_ar2();
            do {
                movement = sc.next();
                switch (movement) {
                    case "w" -> r_ch--;
                    case "a" -> c_ch--;
                    case "s" -> r_ch++;
                    case "d" -> c_ch++;
                    default -> System.out.println("Wrong Input!");
                }
                if(trader_obj1.pack==1){
                    System.out.println("Holding 1 Package");
                }
                if ((r_ch < 11 && r_ch > 0) && (c_ch < 34 && c_ch > 0)) {
                    prnt_ar2();
                    if(r_ch == 7 && c_ch == 5){
                        trader_obj1.interact_survivors();
                    }

                    else if(r_ch == 9 && c_ch == 22){
                        trader_obj1.interact_delivery();
                    }
                }
                else {
                    System.out.println("Invalid Move!");
                    if (r_ch >= 11) {
                        r_ch--;
                    }
                    else if (r_ch <= 0) {
                        r_ch++;
                    }
                    else if (c_ch <= 0) {
                        c_ch++;
                    }
                    else if (c_ch >= 34) {
                        c_ch--;
                    }
                    prnt_ar2();
                }
            } while (trader_obj1.map_full== 1);
        }
    }
}
