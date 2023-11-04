package regularEx;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindRegX {

	public static void main(String[] args) {
		
		String context = "https://www.google.com/maps/place/%E0%B8%8B%E0%B8%AD%E0%B8%A2+%E0%B9%82%E0%B8%84%E0%B8%81%E0%B9%82%E0%B8%95%E0%B8%99%E0%B8%94+3+%E0%B8%95%E0%B8%B3%E0%B8%9A%E0%B8%A5%E0%B9%80%E0%B8%8A%E0%B8%B4%E0%B8%87%E0%B8%97%E0%B8%B0%E0%B9%80%E0%B8%A5+%E0%B8%AD%E0%B8%B3%E0%B9%80%E0%B8%A0%E0%B8%AD%E0%B8%96%E0%B8%A5%E0%B8%B2%E0%B8%87+%E0%B8%A0%E0%B8%B9%E0%B9%80%E0%B8%81%E0%B9%87%E0%B8%95+83110/@8.0196502,98.3115514,17z/data=!3m1!4b1!4m6!3m5!1s0x305037882ad55329:0xe6404b2e788430b3!8m2!3d8.0196449!4d98.3141263!16s%2Fg%2F1hm3t58jv?entry=ttu";
				
		
		// create pattern RegX
		Pattern pattern = Pattern.compile("(\\w[0-9]*\\.[0-9]+)");
		Matcher matcher = pattern.matcher(context);
		
		
//		if(matcher.find())
//		{
//			
//			System.out.println("Can find :"+ matcher.groupCount());
//			System.out.println(matcher.group(1));
//			
//		}
		
	}

}
