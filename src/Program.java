
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

            java.util.ArrayList<Person> list = new java.util.ArrayList<>();
            list.add(erika);
            list.add(hugo);

            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(list);
            byte[] data = bos.toByteArray();
            oos.close();

            ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data));

            java.util.ArrayList<Person> list2 = (java.util.ArrayList<Person>) ois.readObject();
            ois.close();

            Person erika2 = (Person) list2.get(0);
            Person hugo2 = (Person) list2.get(1);

            ois.close();

            System.out.println(erika2);
            System.out.println(hugo2);
            System.out.println(hugo2.getAdresse() == erika2.getAdresse());

        }


}