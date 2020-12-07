public class AnimalFactory
{
        //use getAnimal to get an animal of a
    public Animal createAnimal(String Type) throws ClassNotFoundException
    {
        if(Type == null)
        {
            return null;
        }
        if(Type.equalsIgnoreCase("DOGGO"))
        {
            return new Doggo();
        }
        if(Type.equalsIgnoreCase("PUPPY"))
        {
            return new Puppy();

        }else if(Type.equalsIgnoreCase("YORK"))
        {
            return new York();

        } else if(Type.equalsIgnoreCase("GOLDFISH"))
        {
            return new ImpostorDog();
        }
        else if(Type.equalsIgnoreCase("FISH"))
        {
            return new BoringFish();
        }
        else if(Type.equalsIgnoreCase("SHARK"))
        {
            return new Shark();
        }
        else
        {
            throw new ClassNotFoundException("This animal cannot be created!");
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {
        AnimalFactory factory = new AnimalFactory();
        factory.createAnimal("YORK").bark();

        factory.createAnimal("GOLDFISH").bark();

        factory.createAnimal("SHARK").bark();

        factory.createAnimal("PUPPY").bark();


    }
}
abstract class Animal
{
    void bark ()
    {
    }
}
class Puppy extends Animal
{
    @Override
    public void bark()
    {
        System.out.println("whooof");
    }
}
class ImpostorDog extends Animal
{
    @Override
    public void bark()
    {
        System.out.println("Meow");
    }
}
class Doggo extends Animal
{
    @Override
    public void bark()
    {
        System.out.println("WHOOF WHOOF");
    }
}
class York extends Animal
{
    @Override
    public void bark()
    {
        System.out.println("Yihihihihi");
    }
}
class Goldfish extends Animal
{
    @Override
    public void bark()
    {
        System.out.println("No wishes for you!");
    }
}
class Shark extends Animal
{
    @Override
    public void bark()
    {
        System.out.println("ARGHHHH");
    }
}
class BoringFish extends Animal
{
    @Override
    public void bark()
    {
        System.out.println("Bulbulbulbulbul");
    }
}