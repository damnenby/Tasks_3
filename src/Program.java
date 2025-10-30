
import java.io.*;

public class Program
{
    public static void main(String[] args) throws Exception
    {
        Adresse adresse = new Adresse();
        adresse.setStrasse("Ringstr. 1");
        adresse.setOrt("Musterstadt");
        Person hugo = new Person();
        hugo.setName("Hugo Schmidt");
        hugo.setAdresse(adresse);
        Person erika = new Person();
        erika.setName("Erika Schmidt");
        erika.setAdresse(adresse);
// Hier fehlt Ihr Code

            FileOutputStream fos = new FileOutputStream("tempFile");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(hugo);
            oos.writeObject(erika);
            oos.close();

            FileInputStream fis = new FileInputStream("tempFile");
            ObjectInputStream ois = new ObjectInputStream(fis);

            Person erika2 = (Person)ois.readObject();

            ois.close();

            System.out.println(erika2.getAdresse());

        }


}