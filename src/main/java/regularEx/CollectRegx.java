package regularEx;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.testng.annotations.Test;

public class CollectRegx {

	public static void main(String[] args) {

		String url = "https://www.google.com/maps/place/%E0%B8%8B%E0%B8%AD%E0%B8%A2+%E0%B9%82%E0%B8%84%E0%B8%81%E0%B9%82%E0%B8%95%E0%B8%99%E0%B8%94+3+%E0%B8%95%E0%B8%B3%E0%B8%9A%E0%B8%A5%E0%B9%80%E0%B8%8A%E0%B8%B4%E0%B8%87%E0%B8%97%E0%B8%B0%E0%B9%80%E0%B8%A5+%E0%B8%AD%E0%B8%B3%E0%B9%80%E0%B8%A0%E0%B8%AD%E0%B8%96%E0%B8%A5%E0%B8%B2%E0%B8%87+%E0%B8%A0%E0%B8%B9%E0%B9%80%E0%B8%81%E0%B9%87%E0%B8%95+83110/@8.0196502,98.3115514,17z/data=!3m1!4b1!4m6!3m5!1s0x305037882ad55329:0xe6404b2e788430b3!8m2!3d8.0196449!4d98.3141263!16s%2Fg%2F1hm3t58jv?entry=ttu";
		String url_laguna = "https://www.google.com/maps/place/%E0%B8%95%E0%B8%B3%E0%B8%9A%E0%B8%A5%E0%B9%80%E0%B8%8A%E0%B8%B4%E0%B8%87%E0%B8%97%E0%B8%B0%E0%B9%80%E0%B8%A5+%E0%B8%AD%E0%B8%B3%E0%B9%80%E0%B8%A0%E0%B8%AD%E0%B8%96%E0%B8%A5%E0%B8%B2%E0%B8%87+%E0%B8%A0%E0%B8%B9%E0%B9%80%E0%B8%81%E0%B9%87%E0%B8%95+83110/@8.0097105,98.208562,12z/data=!3m1!4b1!4m6!3m5!1s0x30503832631341df:0x40223bc2c3824c0!8m2!3d8.0118764!4d98.3033694!16s%2Fg%2F1v4lzjt3?entry=ttu";
		CollectRegx test = new CollectRegx();
		String[] result = test.getRegx(url_laguna);
		for (String string : result) {
			System.out.println(string);
		}

	}

	public String[] getRegx(String param_url) {
		String url = param_url;
		final String REGX_LAT = "(\\w[a-zA-Z][0-9]\\.[0-9]+)";
		final String REGX_LONG = "(\\w[a-zA-Z][^!][0-9]\\.[0-9]+)";
		String result_lat = null;
		String result_long = null;

		// Extract lat
		Pattern lat_pattern = Pattern.compile(REGX_LAT);
		Matcher lat_matcher = lat_pattern.matcher(url);
		if (lat_matcher.find()) {

			String temp_lat = lat_matcher.group(1);
			result_lat = temp_lat.substring(2);
		} else {
			result_lat = "";
		}

		// Extract long
		Pattern long_pattern = Pattern.compile(REGX_LONG);
		Matcher long_matcher = long_pattern.matcher(url);
		if (long_matcher.find()) {
			String temp_long = long_matcher.group(1);
			result_long = temp_long.substring(2);
		} else {
			result_long = "";
		}

		String[] result = { result_lat, result_long };
		return (result);

	}

}
