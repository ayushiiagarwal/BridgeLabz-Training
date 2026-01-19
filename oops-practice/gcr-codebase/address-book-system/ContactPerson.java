public class ContactPerson {
    private String firstName, lastName, address, city, state, zipCode, phone, email;

    public ContactPerson(String firstName, String lastName, String address, String city,
			String state, String zipCode, String phone, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.phone = phone;
		this.email = email;
	}

    public String getFirstName(){ 
        return firstName; 
    }
    public void setFirstName(String firstName){
        this.firstName = firstName; 
    }

    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
	    this.address = address;
	}

    public String getCity(){
        return city;
    }
    public void setCity(String city){
        this.city = city;
    }

    public String getState() {
		return state;
	}
    public void setState(String state){
	    this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}
    public void setZipCode(String zipCode){
	    this.zipCode = zipCode;
	}

    public String getPhone(){
        return phone;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }

    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    public String toString(){
        return firstName + " " + lastName + "\nCity: " + city + ", State: " 
        + state + "\nZipCode: " + zipCode + "\nPhone: " + phone + "\nEmail: " + email;
    }
}