package com.ekalw.qa.util;

import java.util.ArrayList;

import com.ekalw.qa.base.TestBase;
import com.ekalw.qa.excelutility.Xls_Reader;

public class SIMSWebDataUtil extends TestBase {
	
	static Xls_Reader reader; 
	//= new Xls_Reader("C:\\Users\\P10481692\\Desktop\\DataBookCapita.xlsx");
	
	public static ArrayList<Object[]> getTeacherSaveDataFromExcel(){
		
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		
		try {
			reader = new Xls_Reader("C:\\Users\\P10481692\\Desktop\\DataBookCapita.xlsx");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for(int rowNum=2; rowNum<=reader.getRowCount("TeacherValidData");rowNum++){
			
			String firstname= reader.getCellData("TeacherValidData", "FirstName", rowNum);
			String lastname=reader.getCellData("TeacherValidData", "LastName", rowNum);
			String mobilenumber=reader.getCellData("TeacherValidData","MobileNumber", rowNum);
			String emailid=reader.getCellData("TeacherValidData","EmailId", rowNum);
			String aadharnumber=reader.getCellData("TeacherValidData","AadharNumber", rowNum);
			String addressline1=reader.getCellData("TeacherValidData","AddressLine1", rowNum);
			String addressline2=reader.getCellData("TeacherValidData","AddressLine2", rowNum);
			String addressline3=reader.getCellData("TeacherValidData","AddressLine3", rowNum);
			String postalcode=reader.getCellData("TeacherValidData","PostalCode", rowNum);
			String gender=reader.getCellData("TeacherValidData","Gender", rowNum);
			String dob=reader.getCellData("TeacherValidData","DOB", rowNum);
			String slectorganisation=reader.getCellData("TeacherValidData","SelectOrganisation", rowNum);
			String selectstate=reader.getCellData("TeacherValidData","SelectState", rowNum);
	//we are creating a simple object array		
			Object ob[]={firstname,lastname,mobilenumber,emailid,aadharnumber,addressline1,addressline2,addressline3,postalcode,gender,dob,slectorganisation,selectstate};
	//now adding object array value to arraylist object myData
			myData.add(ob);
		}
			return myData;
	}
	
	//Teacher Reset Data
	public static ArrayList<Object[]> getTeacherResetDataFromExcel(){
		
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		
		try {
			reader = new Xls_Reader("C:\\Users\\P10481692\\Desktop\\DataBookCapita.xlsx");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for(int rowNum=2; rowNum<=reader.getRowCount("TeacherResetData");rowNum++){
			
			String firstname= reader.getCellData("TeacherResetData", "FirstName", rowNum);
			String lastname=reader.getCellData("TeacherResetData", "LastName", rowNum);
			String mobilenumber=reader.getCellData("TeacherResetData","MobileNumber", rowNum);
			String emailid=reader.getCellData("TeacherResetData","EmailId", rowNum);
			String aadharnumber=reader.getCellData("TeacherResetData","AadharNumber", rowNum);
			String addressline1=reader.getCellData("TeacherResetData","AddressLine1", rowNum);
			String addressline2=reader.getCellData("TeacherResetData","AddressLine2", rowNum);
			String addressline3=reader.getCellData("TeacherResetData","AddressLine3", rowNum);
			String postalcode=reader.getCellData("TeacherResetData","PostalCode", rowNum);
			String gender=reader.getCellData("TeacherResetData","Gender", rowNum);
			String dob=reader.getCellData("TeacherResetData","DOB", rowNum);
			String slectorganisation=reader.getCellData("TeacherResetData","SelectOrganisation", rowNum);
			String selectstate=reader.getCellData("TeacherResetData","SelectState", rowNum);
	//we are creating a simple object array		
			Object ob[]={firstname,lastname,mobilenumber,emailid,aadharnumber,addressline1,addressline2,addressline3,postalcode,gender,dob,slectorganisation,selectstate};
	//now adding object array value to arraylist object myData
			myData.add(ob);
		}
			return myData;
	}
	
	//School Organisation Reset Data
	public static ArrayList<Object[]> getSchoolOrganisationResetDataFromExcel(){
		
		ArrayList<Object[]> myData= new ArrayList<Object[]>();
		
		try {
			reader = new Xls_Reader("C:\\Users\\P10481692\\Desktop\\DataBookCapita.xlsx");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for(int rowNum=2;rowNum<=reader.getRowCount("SchoolOrganisationResetData");rowNum++){
			
			String SchoolName = reader.getCellData("SchoolOrganisationResetData", "SchoolName", rowNum);
			String MainContact = reader.getCellData("SchoolOrganisationResetData", "MainContact", rowNum);
			String MCN = reader.getCellData("SchoolOrganisationResetData", "MCN", rowNum);
			String SIN = reader.getCellData("SchoolOrganisationResetData", "SIN", rowNum);
			String SchoolType = reader.getCellData("SchoolOrganisationResetData", "SchoolType", rowNum);
			String Group = reader.getCellData("SchoolOrganisationResetData", "Group", rowNum);
			String AssociatedTrust = reader.getCellData("SchoolOrganisationResetData", "AssociatedTrust", rowNum);
			String Address1 = reader.getCellData("SchoolOrganisationResetData", "Address1", rowNum);
			String Address2 = reader.getCellData("SchoolOrganisationResetData", "Address2", rowNum);
			String Address3 = reader.getCellData("SchoolOrganisationResetData", "Address3", rowNum);
			String PIN = reader.getCellData("SchoolOrganisationResetData", "PIN", rowNum);
			String State = reader.getCellData("SchoolOrganisationResetData", "State", rowNum);
			String SupervisorName = reader.getCellData("SchoolOrganisationResetData", "SupervisorName", rowNum);
			String MobileNumber = reader.getCellData("SchoolOrganisationResetData", "MobileNumber", rowNum);
			
			//we are creating a simple object array
			Object ob[] = {SchoolName,MainContact,MCN,SIN,SchoolType,Group,AssociatedTrust,Address1,Address2,Address3,PIN,State,SupervisorName,MobileNumber};
			
			//we are adding object array value to arraylist object myData
			myData.add(ob);
		}
		return myData;
	}
	
	//School Organisation Valid Save data
	public static ArrayList<Object[]> getSchoolOrganisationSaveDataFromExcel(){
		
		ArrayList<Object[]> myData= new ArrayList<Object[]>();
		
		try {
			reader = new Xls_Reader("C:\\Users\\P10481692\\Desktop\\DataBookCapita.xlsx");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for(int rowNum=2;rowNum<=reader.getRowCount("SchoolOrganisationValidData");rowNum++){
			
			String SchoolName = reader.getCellData("SchoolOrganisationValidData", "SchoolName", rowNum);
			String MainContact = reader.getCellData("SchoolOrganisationValidData", "MainContact", rowNum);
			String MCN = reader.getCellData("SchoolOrganisationValidData", "MCN", rowNum);
			String SIN = reader.getCellData("SchoolOrganisationValidData", "SIN", rowNum);
			String SchoolType = reader.getCellData("SchoolOrganisationValidData", "SchoolType", rowNum);
			String Group = reader.getCellData("SchoolOrganisationValidData", "Group", rowNum);
			String AssociatedTrust = reader.getCellData("SchoolOrganisationValidData", "AssociatedTrust", rowNum);
			String Address1 = reader.getCellData("SchoolOrganisationValidData", "Address1", rowNum);
			String Address2 = reader.getCellData("SchoolOrganisationValidData", "Address2", rowNum);
			String Address3 = reader.getCellData("SchoolOrganisationValidData", "Address3", rowNum);
			String PIN = reader.getCellData("SchoolOrganisationValidData", "PIN", rowNum);
			String State = reader.getCellData("SchoolOrganisationValidData", "State", rowNum);
			String SupervisorName = reader.getCellData("SchoolOrganisationValidData", "SupervisorName", rowNum);
			String MobileNumber = reader.getCellData("SchoolOrganisationValidData", "MobileNumber", rowNum);
			
			//we are creating a simple object array
			Object ob[] = {SchoolName,MainContact,MCN,SIN,SchoolType,Group,AssociatedTrust,Address1,Address2,Address3,PIN,State,SupervisorName,MobileNumber};
			
			//we are adding object array value to arraylist object myData
			myData.add(ob);
		}
		return myData;
	}

}
