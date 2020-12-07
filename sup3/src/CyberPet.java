import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public abstract class CyberPet
 {
        String name;
        int morale;
        int hunger;
        int rest;
        abstract void react();
        int feed(int calories, int cost, int wallet)
        {
            //
            if(cost>wallet)
            {
                System.out.println("You don't have enough money!");
                return 0;
            }
            hunger -=calories;
            this.react();
            return -cost;
        }
        void pet(int n)
        {
         //
            morale+=n;
            this.react();
        }
        void sleep()
        {
            rest+=1;
            this.react();
        }
        void checkVitals()
        {
             System.out.println("Rest:" + rest + "points worth");
             System.out.println("Hunger:" + (10-hunger) + "points worth");
             System.out.println("Morale:" + morale + "points worth");
        }
        void set(String n)
        {
            name = n;
            System.out.println("Your pet's name is now set to " + name);
            morale = 10;
            hunger = 10;
            rest = 10;
        }
        boolean dead()
        {
            return (morale < 1 || hunger < 1 || rest < 1);
        }

 }
class Day
{
    int globalday;
    int tillnewday;
    boolean passDay(List<CyberPet> inventory, UI ui) throws NoPetsInInventory {
        globalday++;
        tillnewday = 0;
        if(inventory.size() == 0) throw new NoPetsInInventory("You need to get some pets first! ");
        for(int i = 0;i < inventory.size(); i++)
        {
            inventory.get(i).morale--;
            inventory.get(i).hunger--;
            inventory.get(i).rest--;
            if(inventory.get(i).dead())
            {
                ui.gameOver();
                return false;
            }
            if(i>0)
            {
                if ((inventory.get(i) instanceof CyborgFish) && (inventory.get(i - 1) instanceof RoboCat)) {
                    RoboCat cat = (RoboCat) inventory.get(i - 1);
                    cat.eatFish();
                    ui.gameOver();
                    return false;
                }
                if ((inventory.get(i - 1) instanceof CyborgFish) && (inventory.get(i) instanceof RoboCat)) {
                    RoboCat cat = (RoboCat) inventory.get(i - 1);
                    cat.eatFish();
                    ui.gameOver();
                    return false;
                }
            }
        }
        System.out.println("The day has passed. \nIt's day " + globalday + " now");
        return true;
    }
}
class DroidDino extends CyberPet
{
    @Override
    void react() {
        if (morale < 2 || hunger < 2 || rest < 2)
            System.out.println("ARGHH still unwell >:(!!!");
        else
            System.out.println("Arghhh! :)");
    }
}
class CyborgFish extends CyberPet
{
    @Override
    void react()
    {
        if (morale < 2 || hunger < 2 || rest < 2)
            System.out.println("BulBulBul I'm unwell :<<<");
        else
            System.out.println("BulBulBul :)))");
    }
}
class RoboCat extends CyberPet
{
    @Override
    void react()
    {
        if (morale < 2 || hunger < 2 || rest < 2)
            System.out.println("MEOOOOOOOW I don't feel well!");
        else
            System.out.println("meow c:");
    }

    void eatFish()
    {
        //game_over
        System.out.println("It seems like your cat ate the fish. You shouldn't have put them together.");
    }
}
class BionicPanda extends CyberPet {
    @Override
    void react() {
        if (morale < 2 || hunger < 2 || rest < 2)
            System.out.println("ARGHH still unwell >:(!!!");
        else
            System.out.println("Arghhh! :)");
    }
}

class UI
{
    void initialise()
    {
        System.out.println("Hello! Welcome to CyberPet Game.  If you want to quit, at any time, enter 'Q'." +
                "To create an animal, use digits:\n" +
                "1- Cyborg Fish\n" +
                "2- Bionic Panda\n" +
                "3- Robo Cat\n" +
                "4- Droid Dino\n" +
                "To check what animals you have, press I\n" +
                "To feed an animal, press 'F'\n" +
                "To make them sleep, press 'S'\n" +
                "To pet them, press 'P'\n" +
                "To check their vitals, press 'V'\n" +
                "To check your wallet, press 'W'\n" +
                "If you want to pass a day, press 'D'\n" +
                "If any of the animals die, you loose\n");
    }
    void gameOver()
    {
        System.out.println("Game over. Your pet died.");
    }
    void endGame()
    {
        System.out.println("Goodbye!");
    }
}
 class Gameplay
 {
     public static void main(String[] args) throws NoPetsInInventory, NotEnoughPets {
         List<CyberPet> inventory = new ArrayList<>();
         UI ui = new UI();
         ui.initialise();
         Day day = new Day();
         Scanner keyboard = new Scanner(System.in);
         int wallet = 1000;
         LOOP: while (true)
         {
             day.tillnewday++;
             if(day.tillnewday > 9)
                 if(day.passDay(inventory, ui))
                     break LOOP;
             switch (keyboard.next())
             {
                 case ("W"):
                 {
                     System.out.println("You have "+ wallet + " money");
                     break;
                 }
                 case ("D"):
                 {
                     System.out.println("A new day has come!");
                     day.passDay(inventory, ui);
                     break;
                 }
                 case ("Q"):
                 {
                     ui.endGame();
                     break LOOP;
                 }
                 case ("1"):
                 {
                     System.out.println("Please provide a name\n");
                     inventory.add(new CyborgFish());
                     String n = keyboard.next();
                     inventory.get(inventory.size()-1).set(n);
                     break;
                 }
                 case ("2"):
                 {
                     System.out.println("Please provide a name\n");
                     inventory.add(new BionicPanda());
                     String n = keyboard.next();
                     inventory.get(inventory.size()-1).set(n);
                     break;
                 }
                 case ("3"):
                 {
                     System.out.println("Please provide a name\n");
                     inventory.add(new RoboCat());
                     String n = keyboard.next();
                     inventory.get(inventory.size()-1).set(n);

                     break;
                 }
                 case ("4"):
                 {
                     System.out.println("Please provide a name\n");
                     String n = keyboard.next();
                     inventory.add(new DroidDino());
                     inventory.get(inventory.size()-1).set(n);
                     break;
                 }
                 case ("I"):
                 {
                     if(inventory.size() == 0) throw new NoPetsInInventory("You need to get some pets first! ");
                     System.out.println("Here are your pets\n");
                     for (int i = 0;i<inventory.size();i++)
                         System.out.println(i+1 + ": " + inventory.get(i).name);
                     break;
                 }
                 case ("V"):
                 {
                     Scanner petid = new Scanner(System.in);
                     System.out.println("Enter the number of the pet in inventory you would like to check");
                     int id_to_check = petid.nextInt()-1;
                     if(id_to_check >= inventory.size()) throw new NotEnoughPets("you don't have a pet of this number!");
                     CyberPet pet_to_check = inventory.get(id_to_check);
                     pet_to_check.checkVitals();
                     break;
                 }
                 case ("F"):
                 {
                     System.out.println("Enter the number of the pet in inventory you would like to feed");
                     Scanner petid = new Scanner(System.in);
                     int id_to_check = petid.nextInt()-1;
                     if(id_to_check >= inventory.size()) throw new NotEnoughPets("you don't have a pet of this number!");
                        CyberPet pet_to_feed = inventory.get(id_to_check);
                     System.out.println("What food would you like your pet to have?\n" +
                             "S- Spaghetti\n" +
                             "B- Bread\n" +
                             "E- Energy Drink\n");
                     switch (keyboard.next())
                     {
                         case ("S"):
                             {
                                 wallet = pet_to_feed.feed(4,10, wallet);
                                 break;
                             }
                         case ("B"):
                             {
                                wallet = pet_to_feed.feed(1,1, wallet);
                                break;
                             }
                         case ("E"):
                             {
                                 wallet = pet_to_feed.feed(3,10, wallet);
                                 pet_to_feed.sleep();
                                 pet_to_feed.pet(-1);
                                 break;
                             }
                     }
                 }
               //  throw new UnsupportedOperationException();
             }
         }
     }
 }
class NoPetsInInventory extends Exception {
    public NoPetsInInventory(String errorMessage) {
        super(errorMessage);}
    }
class NotEnoughPets extends Exception {
    public NotEnoughPets(String errorMessage) {
        super(errorMessage);}
}