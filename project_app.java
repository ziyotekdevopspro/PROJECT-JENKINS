public class project_app  
{   
public static void main(String[] args)    
	{           
		System.out.print("Enter Firstname: ");   
		//reading a string from the user  
		String firstname = System.console().readLine();  
		System.out.print("Enter Lastname: ");   
		//reading a string from the user  
		String lastname = System.console().readLine();  
		String strhello = "Welcome and Hello " +firstname + " " + lastname;
        strhello = strhello + " to Ziyotek DEVOPS16 team.";
		System.out.println(strhello);   
	}   
}  