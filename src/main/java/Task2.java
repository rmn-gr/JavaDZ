import java.util.*;

//Проверку на уникальность номеров не делал, честно лень))
public class Task2 {
    public static void main(String[] args) {

        HashMap<String, ArrayList<String>> phonebook = new HashMap<String, ArrayList<String>>();
        addContact(phonebook, "Ivan", "11111");
        addContact(phonebook, "Ivan", "22222");
        addContact(phonebook, "Ivan", "33333");

        addContact(phonebook, "Kola", "11111");
        addContact(phonebook, "Kola", "22222");

        addContact(phonebook, "Igor", "11111");
        addContact(phonebook, "Igor", "22222");
        addContact(phonebook, "Igor", "33333");
        addContact(phonebook, "Igor", "44444");

        addContact(phonebook, "Masha", "11111");

        printPhoneBook(phonebook);


    }

    public static void addContact(HashMap<String, ArrayList<String>> pb, String name, String phone){
        if (pb.containsKey(name)){
            pb.get(name).add(phone);
        }
        else{
            pb.put(name, new ArrayList<String>());
            pb.get(name).add(phone);
        }
    }


    public static void printPhoneBook(HashMap<String, ArrayList<String>> pb){
        Comparator<ArrayList<String>> comp = Comparator.comparing(contact->contact.size());
        ArrayList<ArrayList<String>> pbList = new ArrayList<>();
        for (Map.Entry<String, ArrayList<String>> entry: pb.entrySet()) {
            ArrayList<String> contact = new ArrayList<>();
            contact.add(entry.getKey());
            contact.addAll(entry.getValue());
            pbList.add(contact);
        }
        pbList.sort(comp);
        Collections.reverse(pbList);
        if (pbList.isEmpty()){
            System.out.println("List is empty! Add somebody and them print.\n");
        }
        else{
            for (ArrayList<String> contact: pbList) {
                System.out.printf("Contact name %s\n", contact.get(0));
                if (contact.size() > 1){
                    for (int i = 1; i < contact.size(); i++) {
                        System.out.printf("Phone %d: %s\n", i,contact.get(i));
                    }
                }
                else {
                    System.out.print("Doesn't have any numbers!\n");
                }
                System.out.println();
            }

        }

    }

}