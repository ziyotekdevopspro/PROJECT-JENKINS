public class project_app  
{   
public static void main(String[] args)    
	{           
		System.out.print("Enter your firstname: ");   
		//reading a string from the user  
		String firstname = System.console().readLine();  
		System.out.print("Enter your lastname: ");   
		//reading a string from the user  
		String lastname = System.console().readLine();  
		String strhello = "Hello and welcome " +firstname + " " + lastname;
        strhello = strhello + " to Ziyotek DEVOPS16 team.";
		System.out.println(strhello);   
	}   
}  