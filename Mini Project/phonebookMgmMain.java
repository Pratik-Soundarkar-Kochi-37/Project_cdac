//package try2;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class phonebookMgmMain  {

	public static void main(String[] args) throws Exception {
		int loop = 0;
		boolean done =false;
		phonebookMgm new_phonebook = new phonebookMgm();
		BufferedReader readme = new BufferedReader(new InputStreamReader(System.in));
		do {
		System.out.println("****Welcome to the Phonebook****");
		System.out.println("1.To Insert the contact\n2.To Search the contact");
		System.out.println("3.To Delete the contact\n4.To Update the contact details\n5.duplication Name\n6.dup PhnNumber\n7.Exit");
		System.out.print("Enter your choice : ");
		int n = Integer.parseInt(readme.readLine());
		switch(n)
		{
		case 1: new_phonebook.Insert(); new_phonebook.display();
				break;
				
		case 2: System.out.println("1.To search by name\n2.To search by contact number\n3.To search by email-id");
				int m = Integer.parseInt(readme.readLine());
				
				switch(m) {
				case 1 : new_phonebook.searchName(); break;
				case 2 : new_phonebook.searchPhoneNo(); break;
				case 3 : new_phonebook.searchEmail(); break;
				default : System.out.println("Select between 1 to 3");
				}
				break;
				
		case 3: new_phonebook.deleteContact(); /*new_phonebook.display()*/; break;
		
		case 4: new_phonebook.updateDetails(); new_phonebook.display();System.out.println(); break;

		case 5:new_phonebook.dupName(); new_phonebook.display();System.out.println(); break;
		case 6:new_phonebook.dupPhn_no(); new_phonebook.display(); break;

		case 7: System.out.println("Thank You for using Our phonebook"); done =true; break;

		default : System.out.println("Select between 1 to 5");
		}
	}while(!done);
}
}