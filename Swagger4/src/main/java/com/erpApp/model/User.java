package com.erpApp.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;



@Entity
/*
 * @NamedQueries(value = {@NamedQuery(name = "User.searchByEmail",query =
 * "SELECT u FROM User u WHERE u.email = ?1" ) ,@NamedQuery(name =
 * "User.fetchByFNameAndEmail",query =
 * "select u from User u where u.firstName = ?1 AND u.email = ?2")})
 */
/*
 * @NamedNativeQueries(value = {
 * 
 * @NamedNativeQuery(name ="User.searchByEmail",query =
 * "SELECT * FROM User  WHERE email = ?1" ,resultClass = User.class)
 * ,@NamedNativeQuery(name = "User.fetchByFirstNameAndEmail",query =
 * "SELECT * FROM User  WHERE f_name = ?1 AND email = ?2" ,resultClass =
 * User.class) ,@NamedNativeQuery(name ="User.getByEmailAndAdhar",query =
 * "SELECT * FROM User  WHERE email = ?1 AND adharNumber = ?2 " ,resultClass =
 * User.class) })
 */
public class User
{

	@Id
	@GeneratedValue
	private long userId ;
	
	//@NotEmpty(message ="First name is mandatory & it will be displayed as profile name")
	@Column(name = "f_name")
	private String firstName;
	
	private String lastName;
	
	//@NotEmpty(message = "You have to reveal your gender")
	private String gender ;
	
	//@NotEmpty(message = "Email id is mandatory & it will be your loggin id")
	//@Email
	@Column(unique = true)
	private String email;
	
	//@NotEmpty
	private String password;
	
	//@NotEmpty	
    transient private String repeatPassword;
	
	//@NotEmpty	
    //private String repeatPassword;
	
	//private Address address ;
	
	/*
	 * @DateTimeFormat(pattern="dd/MM/yyyy")
	 * 
	 * @Past(message="We can not create a acoount for person who is not yet born")
	 * private Date dob ;
	 */
		
	private String maritalStatus ;
	
//	@NotEmpty(message = "adhar number is mandatory & it will be used as your KYC")
	@Column(name = "adhar",unique = true)
	private String adharNumber ;
	
//	@NotEmpty(message = "You need to let us know for which branch of our bank you need registration")
	private String ifscCodeOfBank ;
	
//	@OneToMany(mappedBy = "accountHolder",fetch = FetchType.EAGER)
//	private Set<Account> accounts ;
	
	/*
	 * @OneToOne private Account account ;
	 */
	
	
	private boolean isKYCVerified ;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}


	


	public String getIfscCodeOfBank() {
		return ifscCodeOfBank;
	}

	public void setIfscCodeOfBank(String ifscCodeOfBank) {
		this.ifscCodeOfBank = ifscCodeOfBank;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}


	public boolean getIsKYCVerified() {
		return isKYCVerified;
	}

	public void setKYCVerified(boolean isKYCVerified) {
		this.isKYCVerified = isKYCVerified;
	}

	public static boolean isPasswordMatchingRepeatPassword(String psw, String repPsw)
	{
		System.out.println("UserBean static passwd validation()");
		if(psw.trim().length() != repPsw.trim().length())
			return false ;
		if(psw.trim().equals(repPsw.trim()) == false)
			return false ;
		else
			return true ;
	}
	
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public String getRepeatPassword() {
		return repeatPassword;
	}

	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}





	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getAdharNumber() {
		return adharNumber;
	}

	public void setAdharNumber(String adharNumber) {
		this.adharNumber = adharNumber;
	}



	public static SimpleDateFormat getSdf() {
		return sdf;
	}

	public static void setSdf(SimpleDateFormat sdf) {
		User.sdf = sdf;
	}

	public static boolean isValidDob(Date dob) throws ParseException
	{
		int dateInt = dob.getDate() ;
		int monthInt = dob.getMonth() ;
		int yearInt = dob.getYear() ;
		
		String dobStr = dateInt+"/"+monthInt+"/"+yearInt;
		validateDOB(dobStr);
		return true ;
	}
	
	 //validate dOb of contact
    private static void validateDOB(String dobStr) throws ParseException
    {
    	if(dobStr == null)
    		  throw new IllegalArgumentException("DOB OF CONTACT CAN NOT BE NULL");
    	if(dobStr.trim().length() == 0)
    		  throw new IllegalArgumentException("DOB OF CONTACT CAN NOT BE EMPTY/BLANK");
    	if((dobStr.trim().length() != 10) || (dobStr.contains("/") == false))
    		  throw new IllegalArgumentException("INVALID DOB FORMAT, PLEASE ENTER DOB IN DD/MM/YYYY FORMAT");
    	
    	String [] saDob = dobStr.split("/");
    	if(saDob.length != 3)
    		throw new IllegalArgumentException("INVALID DOB FORMAT, PLEASE ENTER DOB IN DD/MM/YYYY FORMAT");
    	String ddStr = saDob[0];
    	String mmStr = saDob[1];
    	String yyyyStr = saDob[2];
    	if((ddStr.trim().length() != 2) ||(mmStr.trim().length() != 2) || (yyyyStr.trim().length() != 4) )
    		throw new IllegalArgumentException("INVALID DOB FORMAT, PLEASE ENTER DOB IN DD/MM/YYYY FORMAT");
    	StringBuilder sb = new StringBuilder(dobStr.trim());
    	for(int i=0;i<sb.length() ;i++)
    	{
    		char chValid = sb.charAt(i);
    		if(  (chValid == 47)  || (chValid >= 48 && chValid <= 57)  )
    		{
    			//acceptable
    		}
    		else
    			throw new IllegalArgumentException("INVALID DOB FORMAT, PLEASE ENTER DOB IN DD/MM/YYYY FORMAT");
    	}
    	if( Integer.parseInt(ddStr) >=1 && Integer.parseInt(ddStr) <= 31 )
    			{
    		//acceptable
    			}
    	else
    		throw new IllegalArgumentException(ddStr+" CAN NOT BE A DAY");
    	if(Integer.parseInt(mmStr) >= 1 && Integer.parseInt(mmStr) <= 12)
    	{
    		//acceptable
    	}
    	else
    		throw new IllegalArgumentException(mmStr+" CAN NOT BE A MONTH");
    	if(Integer.parseInt(yyyyStr) == 0)
    		throw new IllegalArgumentException(yyyyStr+" CAN NOT BE A YEAR");
    	Date currentDate = new Date();
    	Date compDate = sdf.parse(dobStr);
  	  if((currentDate.getTime() - compDate.getTime()) < 0)
  		  throw new IllegalArgumentException("CAN NOT ADD CONTACT OF PERSON WHO IS NOT YET BORN");
  	  validateForCorrectDayOfMonth(yyyyStr,mmStr, ddStr);
  	  
    		
    }
    
    @Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
				+ ", email=" + email + ", password=" + password + ", maritalStatus=" + maritalStatus + ", adharNumber="
				+ adharNumber + ", ifscCodeOfBank=" + ifscCodeOfBank + ", isKYCVerified=" + isKYCVerified + "]";
	}

	//validate for right day of month
    private static void validateForCorrectDayOfMonth(String yyyyStr ,String mmStr,String ddStr)
    {
    	int mmInt = Integer.parseInt(mmStr);
    	int ddInt = Integer.parseInt(ddStr);
    	int yyyyInt = Integer.parseInt(yyyyStr);
    	
    	switch (mmInt)
    	{
		case 1:
			if(ddInt >= 1 && ddInt <= 31)
			{
				//acceptable
			}
			else
				throw new IllegalArgumentException(ddStr+" NEVER COMES IN THE MONTH "+"JANUARY");
						
			break;

		case 2:
			if( (yyyyInt % 4) == 0)
			{
					if(ddInt >= 1 && ddInt <= 29)
				{
					//acceptable
				}
				else
					throw new IllegalArgumentException(ddStr+" NEVER COMES IN THE MONTH "+"FEBRUARY");
			}
			else
			{
				if(ddInt >= 1 && ddInt <= 28)
				{
					//acceptable
				}
				else if(ddInt == 29)
					throw new IllegalArgumentException("29th OF FEB COMES IN ONLY LEAP YEARS");
				else
					throw new IllegalArgumentException(ddStr+" NEVER COMES IN THE MONTH "+"FEBRUARY");
			}
			
						
			break;
			
		case 3:
			if(ddInt >= 1 && ddInt <= 31)
			{
				//acceptable
			}
			else
				throw new IllegalArgumentException(ddStr+" NEVER COMES IN THE MONTH "+"MARCH");
						
			break;
			
		case 4:
			if(ddInt >= 1 && ddInt <= 30)
			{
				//acceptable
			}
			else
				throw new IllegalArgumentException(ddStr+" NEVER COMES IN THE MONTH "+"APRIL");
						
			break;
			
		case 5:
			if(ddInt >= 1 && ddInt <= 31)
			{
				//acceptable
			}
			else
				throw new IllegalArgumentException(ddStr+" NEVER COMES IN THE MONTH "+"MAY");
						
			break;
			
		case 6:
			if(ddInt >= 1 && ddInt <= 30)
			{
				//acceptable
			}
			else
				throw new IllegalArgumentException(ddStr+" NEVER COMES IN THE MONTH "+"JUNE");
						
			break;
			
		case 7:
			if(ddInt >= 1 && ddInt <= 31)
			{
				//acceptable
			}
			else
				throw new IllegalArgumentException(ddStr+" NEVER COMES IN THE MONTH "+"JULY");
						
			break;
			
		case 8:
			if(ddInt >= 1 && ddInt <= 31)
			{
				//acceptable
			}
			else
				throw new IllegalArgumentException(ddStr+" NEVER COMES IN THE MONTH "+"AUGUST");
						
			break;
			
		case 9:
			if(ddInt >= 1 && ddInt <= 30)
			{
				//acceptable
			}
			else
				throw new IllegalArgumentException(ddStr+" NEVER COMES IN THE MONTH "+"SEPTEMBER");
						
			break;
			
		case 10:
			if(ddInt >= 1 && ddInt <= 31)
			{
				//acceptable
			}
			else
				throw new IllegalArgumentException(ddStr+" NEVER COMES IN THE MONTH "+"OCTOBER");
						
			break;
			
		case 11:
			if(ddInt >= 1 && ddInt <= 30)
			{
				//acceptable
			}
			else
				throw new IllegalArgumentException(ddStr+" NEVER COMES IN THE MONTH "+"NOVEMBER");
						
			break;
		case 12:
			if(ddInt >= 1 && ddInt <= 31)
			{
				//acceptable
			}
			else
				throw new IllegalArgumentException(ddStr+" NEVER COMES IN THE MONTH "+"DECEMBER");
						
			break;
		default:throw new IllegalArgumentException(ddStr+" NEVER COMES IN THE MONTH "+mmStr);
		
		}
    }
}
