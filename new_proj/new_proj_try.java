package whatever.new_proj;

import java.util.*;

public class new_proj_try
{
    public static void main(String[] args){
        act_ply game_obj= new act_ply();
        game_obj.moving();
    }
}

class print_on_screen
{
    Scanner sc= new Scanner(System.in);
    String[][] ar= new String[7][25];
    String sp=" ";
    int row,column;
    int r_ch=5,c_ch=7;
    public void prnt(){
        for(row=0;row<7;row++){
            for(column=0;column<25;column++) {
                if (row == 0 || row == 6) {
                    ar[row][column]="_";
                }
                else if(column==0 || column==24){
                    ar[row][column]="|";
                }

                else if(row== r_ch && column == c_ch){
                    ar[row][column]="*";
                }

                else if(row== 3 && column== 18){
                    ar[row][column]="?";
                }
                else{
                    ar[row][column]=sp;
                }
                System.out.print(ar[row][column]);
            }
            System.out.println(" ");
        }
    }
}

class trader extends print_on_screen
{
    int choice;
    public void interact(){
        System.out.println("(?): What are you still doing here?\n1.Interact\n2.Leave");
        choice=sc.nextInt();

        if(choice==1){
            System.out.println("(*): I was just passing by....Who are you?");
            System.out.println("'The mysterious person stares at you'\n(?):Nothing is left here kid....It's all over..*sigh*");
            System.out.println("(?): Do you have some water?\n1.Yes\n2.No");
            choice=sc.nextInt();
            if(choice==1){
                System.out.println("Thanks traveller...I will now have to leave..\nThe mysterious character dissappears");
            }
            else if(choice==2){
                System.out.println("No problem traveller...Safe passage ahead..");
            }
        }
    }
}
class act_ply extends print_on_screen
{
    trader trader_obj1 = new trader();
    String movement;
    public void moving(){
        System.out.println("You are '*'");
        System.out.println("You control your character with 'w' 'a' 's' 'd'");
        System.out.println("'w' -> Move forward\n'a' -> Move left\n's' -> move backward\n'd' -> Move right");
        prnt();
        do{
            movement=sc.next();
            switch (movement) {
                case "w" -> r_ch--;
                case "a" -> c_ch--;
                case "s" -> r_ch++;
                case "d" -> c_ch++;
                default -> System.out.println("Wrong Input!");
            }
            if((r_ch<6 && r_ch>0) && (c_ch<24 && c_ch>0)){
                System.out.println(r_ch+" "+c_ch);
                prnt();
                if(r_ch==3 && c_ch==18){
                    trader_obj1.interact();
                }
            }
            else{
                System.out.println("Invalid Move!");
                if(r_ch==6){
                    r_ch--;
                }
                else if(r_ch==0){
                    r_ch++;
                }
                else if(c_ch==0){
                    c_ch++;
                }

                else if(c_ch==24){
                    c_ch--;
                }
                prnt();
            }
        }while(row!=0);
    }
}