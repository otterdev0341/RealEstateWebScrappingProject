package geo_location;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.testng.annotations.Test;

public class GeoHelper {

	public static void main(String[] args) {

		

	}

	public ArrayList<String> getLatLong(String param_url) {
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
		} 

		// Extract long
		Pattern long_pattern = Pattern.compile(REGX_LONG);
		Matcher long_matcher = long_pattern.matcher(url);
		if (long_matcher.find()) {
			String temp_long = long_matcher.group(1);
			result_long = temp_long.substring(2);
		} 

		ArrayList<String> result = new ArrayList<>();
		result.add(result_lat);
		result.add(result_long);
		result.add(param_url);
		
		return (result);

	}

}
