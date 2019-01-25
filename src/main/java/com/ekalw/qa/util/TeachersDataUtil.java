package com.ekalw.qa.util;

import java.util.ArrayList;

import com.ekalw.qa.base.TestBase;
import com.ekalw.qa.excelutility.Xls_Reader;

public class TeachersDataUtil extends TestBase {
	
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

}
