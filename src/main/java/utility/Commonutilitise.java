package utility;

import java.util.Date;

public class Commonutilitise {
	public static String GenerateEmail()

	{
		return new Date().toString().replaceAll("\\s","").replaceAll("\\:","")+"@gmail.com";
		
	}

}



