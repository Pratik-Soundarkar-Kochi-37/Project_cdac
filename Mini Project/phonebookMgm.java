// package try2;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.*;

public class phonebookMgm {
	
	phonebook head=null,tail=null;
	
	class phonebook {
		String name;
		String email;
		String phNo;
		phonebook prev , next;
		
		phonebook(String name,String email,String phno) {
			this.name = name;
			this.email = email;
			this.phNo = phno;
		}
	}
	
	public void Insert() {
		
		String n,e,p;
		int check,corretphno=0,checkmail=0;
		BufferedReader readme = new BufferedReader(new InputStreamReader(System.in));
		try
		{
			do {
			System.out.println("***Create Contact***");
			System.out.print("Enter the name : ");
			n = readme.readLine();
			do
			{
				System.out.println("Enter the email : ");
				e = readme.readLine();
				if(valid(e)) { checkmail++; }
				else { checkmail=0;
					System.out.println("ERROR...Please enter valid email address");
					}
			}while(checkmail==0);
			
			do 
			{ System.out.println("Enter the contact : ");
				p = readme.readLine();
				if(isValidMobileNo(p)) { corretphno++; }
			else { corretphno=0;
				System.out.println("ERROR...Please enter valid phone number");
				}
			}while(corretphno==0);
			
			phonebook new_contact = new phonebook(n,e,p);
			if(head==null) {
				head=new_contact;
				tail=new_contact;
			}
			else {
				tail.next= new_contact;
				new_contact.prev=tail;
				tail=new_contact;
			}
			System.out.print("Press 1 to add contact otherwise press any key : ");
			check = Integer.parseInt(readme.readLine());
		}while(check==1);
	}
		catch(Exception E) {
		System.out.println(E);
		}
	}
	
	public void display() {
		System.out.println("***Contact Details***");
		if(head==null)
		{
			System.out.println("Phonebook is empty");
		}
		else {
			phonebook temp =head;
			System.out.println("Name\tPhone Number\tE-mail Address");
			while(temp!=null) {
				System.out.println(temp.name+"\t"+temp.phNo+"\t"+temp.email);
				temp=temp.next;
			}
		}
	}
	    
	public static boolean isValidMobileNo(String str)  
	{  
	Pattern ptrn = Pattern.compile("[0-9]{10}");  
	Matcher match = ptrn.matcher(str);  
	return (match.find() && match.group().equals(str));  
	} 
	
	public static boolean valid(String mail)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                            "[a-zA-Z0-9_+&*-]+)*@" +
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                            "A-Z]{2,7}$";
                              
                    Pattern pat = Pattern.compile(emailRegex);
   
                    boolean val=pat.matcher(mail).matches();
					return val;
    }
	
	public void searchName()
	{
		BufferedReader readme = new BufferedReader(new InputStreamReader(System.in));
		int check=0;
		try
		{
			do {
		System.out.println("enter the name to search:");
		String n=readme.readLine();
		
		phonebook temp=head;
		boolean b=false;
		while(temp!=null)
		{
			if(temp.name.equals(n))
			{
				b=true;
				break;
			}
			temp=temp.next;
		}
		if(b)
		{
			System.out.println("Name:"+temp.name);
			System.out.println("email:"+temp.email);
			System.out.println("phNo:"+temp.phNo);
		}
		else
			System.out.println("Name doesn't found");
		System.out.print("Press 1 to continue search otherwise press any key : ");
		check = Integer.parseInt(readme.readLine());
		}while(check==1);
			}
		catch(Exception e1) {}
	}
	
	public void searchPhoneNo()
	{
		BufferedReader readme = new BufferedReader(new InputStreamReader(System.in));
		int check=0;String ph=null;int correctphno=0;
		try
		{
		do {
			do {
				 System.out.println("Enter the phone number to search : ");
					ph = readme.readLine();
					if(isValidMobileNo(ph)) { correctphno++; }
				else { correctphno=0;
					System.out.println("ERROR...Please enter valid phone number");
					}
				}while(correctphno==0);
		
		phonebook temp=head;
		boolean b=false;
		while(temp!=null)
		{
			if(temp.phNo.equals(ph))
			{
				b=true;
				break;
			}
			temp=temp.next;
		}
		if(b)
		{
			System.out.println("Name:"+temp.name);
			System.out.println("email:"+temp.email);
			System.out.println("phNo:"+temp.phNo);
		}
		else
			System.out.println("Phone number doesn't found");
		System.out.print("Press 1 to continue search otherwise press any key : ");
		check = Integer.parseInt(readme.readLine());
		}while(check==1);
			}
		catch(Exception e1) {}
	}
	
	public void searchEmail()
	{
		BufferedReader readme = new BufferedReader(new InputStreamReader(System.in));
		int check=0;int checkmail=0;String searchmail=null;
		try
		{
		do {
			do {
		System.out.println("enter the email to search:");
		 searchmail=readme.readLine();
		if(valid(searchmail)) { checkmail++; }
		else { checkmail=0;
			System.out.println("ERROR...Please enter valid email address");
			}
	}while(checkmail==0);
		
		phonebook temp=head;
		boolean b=false;
		while(temp!=null)
		{
			if(temp.email.equals(searchmail))
			{
				b=true;
				break;
			}
			temp=temp.next;
		}
		if(b)
		{
			System.out.println("Name:"+temp.name);
			System.out.println("email:"+temp.email);
			System.out.println("phNo:"+temp.phNo);
		}
		else
			System.out.println("email doesn't found");
		System.out.print("Press 1 to continue search otherwise press any key : ");
		check = Integer.parseInt(readme.readLine());
		}while(check==1);
		}
		catch(Exception e1) {}
	}

	public void updateDetails() {
		BufferedReader readme = new BufferedReader(new InputStreamReader(System.in));
		int n;String ph=null;int correctphno=0;
		try
		{
			phonebook temp=head;
		do {
			do {
				 System.out.print("Enter the phone number to update : ");
					ph = readme.readLine();
					if(isValidMobileNo(ph)) { correctphno++; }
				else { correctphno=0;
					System.out.println("ERROR...Please enter valid phone number");
					}
				}while(correctphno==0);
		
		while(temp!=null)
		{
			if(temp.phNo.equals(ph))
			{
				break;
			}
			temp=temp.next;
		}
		System.out.println("Press 1 - To Update name :\nPress 2 - To Update phone number : \nPress - 3 To Update email : ");
		int choice = Integer.parseInt(readme.readLine());
		switch(choice)
			{
			case 1 : 
				System.out.print("Enter Updated name : ");
				temp.name=readme.readLine();
				break;
			case 2 :
				System.out.print("Enter Updated phone number : ");
				temp.phNo=readme.readLine();
				break;
			case 3 :
				System.out.print("Enter Updated E-mail Id : ");
				temp.email=readme.readLine();
				break;
			
				default :
					System.out.println("Please enter valid choice");
	
			}
			System.out.print("Press 1 to update any orther Phonebook details, else press anny key :");
			n=Integer.parseInt(readme.readLine());
		}while(n==1);
		}
		
		catch(Exception e1) 
		{
			System.out.println(e1);
		}
	}
	
	public void deleteContact() {
		BufferedReader readme = new BufferedReader(new InputStreamReader(System.in));
		int n=0;
		try 
		{
		do {
	
		System.out.print("Enter the name to delete the contact : ");
		String c = readme.readLine();
		
		phonebook temp = head;
		phonebook pl = tail;
		if(head.name.equals(c))
		{
			//System.out.println("  ==--=-"+temp.name);
			head=temp.next;
		}
		else if(tail.name.equals(c))
		{
			tail= pl.prev;
			pl.prev.next=null;
		
		}
		else {
			while(temp.next!=null)
			{
				//System.out.println("  ==--=-"+temp.name);
				if(temp.name.equals(c)) {
					temp.next.prev = temp.prev;
					temp.prev.next = temp.next;
					//System.out.println("Deleted Successfully !!!");

					break;
			}
        	temp=temp.next;
			
		}
		}
		
		
		if(temp==null) {System.out.println("Name is not in the phonebook");}
		System.out.println("Deleted Successfully !!!");

		display();
		System.out.println();
		System.out.print("Press 1 - to delete the another contact details else press any key");
		n=Integer.parseInt(readme.readLine());
		}while(n==1);
		}
		catch(Exception e2)
		{
			System.out.println(e2);
		}	
	}
	public void dupName()
	{
		  //Node current will point to head  
		  phonebook current, index, temp;  
          
		  //Checks whether list is empty  
		  if(head == null) {  
			  return;  
		  }  
		  else {  
			  //Initially, current will point to head node  
			  for(current = head; current != null; current = current.next) {  
				  //index will point to node next to current  
				  for(index = current.next; index != null; index = index.next) {  
					  if(current.name.equals(index.name)) {   
						  temp = index;
						  
					
						  //index's previous node will point to node next to index thus, removes the duplicate node 
						  //changing its prev node next to the duplicate node next which points to next node  
						  index.prev.next = index.next;  
						  if(index.next != null)  
							  index.next.prev = index.prev;  
						  //Delete duplicate node by making temp to null  
						  temp = null;  
					  }  
				  }  
			  }  
		  }  
		}
		public void dupPhn_no()
		{
			  //Node current will point to head  
			  phonebook current, index, temp;  
			  
			  //Checks whether list is empty  
			  if(head == null) {  
				  return;  
			  }  
			  else {  
				  //Initially, current will point to head node  
				  for(current = head; current != null; current = current.next) {  
					  //index will point to node next to current  
					  for(index = current.next; index != null; index = index.next) {  
						  if(current.phNo.equals(index.phNo)) {   
							  temp = index;
							  
						
							  //index's previous node will point to node next to index thus, removes the duplicate node  
							  index.prev.next = index.next;  
							  if(index.next != null)  
								  index.next.prev = index.prev;  
							  //Delete duplicate node by making temp to null  
							  temp = null;  
						  }  
					  }  
				  }  
			  }  
			}
}