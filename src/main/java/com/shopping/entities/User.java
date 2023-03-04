package com.shopping.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
        @GeneratedValue(strategy = GenerationType.IDENTITY)        	 
	    @Id
		private int userid;
		private String userfullname;
		private String email;
		private String password;
		private String useraddress;
		private String phoneno;
		private String gender;
		private String city;
		private String postalcode;
		private String userrole;
		public User() {
		}
		public User(int userid, String userfullname, String email, String password, String useraddress, String phoneno,
				String gender, String city, String postalcode, String userrole) {
			this.userid = userid;
			this.userfullname = userfullname;
			this.email = email;
			this.password = password;
			this.useraddress = useraddress;
			this.phoneno = phoneno;
			this.gender = gender;
			this.city = city;
			this.postalcode = postalcode;
			this.userrole = userrole;
	  }
		public int getUserid() {
			return userid;
		}
		public void setUserid(int userid) {
			this.userid = userid;
		}
		public String getUserfullname() {
			return userfullname;
		}
		public void setUserfullname(String userfullname) {
			this.userfullname = userfullname;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getUseraddress() {
			return useraddress;
		}
		public void setUseraddress(String useraddress) {
			this.useraddress = useraddress;
		}
		public String getPhoneno() {
			return phoneno;
		}
		public void setPhoneno(String phoneno) {
			this.phoneno = phoneno;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getPostalcode() {
			return postalcode;
		}
		public void setPostalcode(String postalcode) {
			this.postalcode = postalcode;
		}
		public String getUserrole() {
			return userrole;
		}
		public void setUserrole(String userrole) {
			this.userrole = userrole;
		}
		@Override
		public String toString() {
			return "User [userid=" + userid + ", userfullname=" + userfullname + ", email=" + email + ", password="
					+ password + ", useraddress=" + useraddress + ", phoneno=" + phoneno + ", gender=" + gender
					+ ", city=" + city + ", postalcode=" + postalcode + ", userrole=" + userrole + "]";
		}
		
		
		
		
}
