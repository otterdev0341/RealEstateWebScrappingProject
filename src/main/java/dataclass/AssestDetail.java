package dataclass;

import java.util.ArrayList;

public class AssestDetail {
	// main attibute
	private String assest_id;
	private String assest_name;
	private String assest_url;

	// details attibute
	private String date_of_post;
	private String assest_landmark;
	private String price_per_sqr_m;
	private String land_area;
	private String floor;
	private String bedroom;
	private String useable_area;

	// location
	private String location;

	// project owner

	// assest type
	private String assest_type;

	// facilities
	private ArrayList<String> assest_facilities;

	// assest_image_ref
	private ArrayList<String> assest_images;

	// geo details
	private String geo_lat;
	private String geo_long;
	private String geo_url;

	// Contructor
	public AssestDetail(String assest_id, String assest_name, String assest_url, String date_of_post,
			String assest_landmark, String price_per_sqr_m, String land_area, String floor, String bedroom,
			String useable_area, String location, String assest_type, ArrayList<String> assest_facilities,
			ArrayList<String> assest_images, String geo_lat, String geo_long, String geo_url) {
		super();
		this.assest_id = assest_id;
		this.assest_name = assest_name;
		this.assest_url = assest_url;
		this.date_of_post = date_of_post;
		this.assest_landmark = assest_landmark;
		this.price_per_sqr_m = price_per_sqr_m;
		this.land_area = land_area;
		this.floor = floor;
		this.bedroom = bedroom;
		this.useable_area = useable_area;
		this.location = location;

		this.assest_type = assest_type;
		this.assest_facilities = assest_facilities;
		this.assest_images = assest_images;
		this.geo_lat = geo_lat;
		this.geo_long = geo_long;
		this.geo_url = geo_url;
	}
	// Setter getter

	public String getAssest_id() {
		return assest_id;
	}

	public void setAssest_id(String assest_id) {
		this.assest_id = assest_id;
	}

	public String getAssest_name() {
		return assest_name;
	}

	public void setAssest_name(String assest_name) {
		this.assest_name = assest_name;
	}

	public String getAssest_url() {
		return assest_url;
	}

	public void setAssest_url(String assest_url) {
		this.assest_url = assest_url;
	}

	public String getDate_of_post() {
		return date_of_post;
	}

	public void setDate_of_post(String date_of_post) {
		this.date_of_post = date_of_post;
	}

	public String getAssest_landmark() {
		return assest_landmark;
	}

	public void setAssest_landmark(String assest_landmark) {
		this.assest_landmark = assest_landmark;
	}

	public String getPrice_per_sqr_m() {
		return price_per_sqr_m;
	}

	public void setPrice_per_sqr_m(String price_per_sqr_m) {
		this.price_per_sqr_m = price_per_sqr_m;
	}

	public String getLand_area() {
		return land_area;
	}

	public void setLand_area(String land_area) {
		this.land_area = land_area;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getBedroom() {
		return bedroom;
	}

	public void setBedroom(String bedroom) {
		this.bedroom = bedroom;
	}

	public String getUseable_area() {
		return useable_area;
	}

	public void setUseable_area(String useable_area) {
		this.useable_area = useable_area;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getAssest_type() {
		return assest_type;
	}

	public void setAssest_type(String assest_type) {
		this.assest_type = assest_type;
	}

	public ArrayList<String> getAssest_facilities() {
		return assest_facilities;
	}

	public void setAssest_facilities(ArrayList<String> assest_facilities) {
		this.assest_facilities = assest_facilities;
	}

	public ArrayList<String> getAssest_images() {
		return assest_images;
	}

	public void setAssest_images(ArrayList<String> assest_images) {
		this.assest_images = assest_images;
	}

	public String getGeo_lat() {
		return geo_lat;
	}

	public void setGeo_lat(String geo_lat) {
		this.geo_lat = geo_lat;
	}

	public String getGeo_long() {
		return geo_long;
	}

	public void setGeo_long(String geo_long) {
		this.geo_long = geo_long;
	}

	public String getGeo_url() {
		return geo_url;
	}

	public void setGeo_url(String geo_url) {
		this.geo_url = geo_url;
	}

	@Override
	public String toString() {
		return "AssestDetail [assest_id=" + assest_id + ", assest_name=" + assest_name + ", assest_url=" + assest_url
				+ ", date_of_post=" + date_of_post + ", assest_landmark=" + assest_landmark + ", price_per_sqr_m="
				+ price_per_sqr_m + ", land_area=" + land_area + ", floor=" + floor + ", bedroom=" + bedroom
				+ ", useable_area=" + useable_area + ", location=" + location + ", assest_type=" + assest_type
				+ ", assest_facilities=" + assest_facilities + ", assest_images=" + assest_images + ", geo_lat="
				+ geo_lat + ", geo_long=" + geo_long + ", geo_url=" + geo_url + "]";
	}

}

// to String method
