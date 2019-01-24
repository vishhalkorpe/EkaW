package com.ekalw.qa.util;

import java.util.ArrayList;

import com.ekalw.qa.base.TestBase;
import com.ekalw.qa.excelutility.Xls_Reader;

public class TestUtilTeachersData extends TestBase {
	
	static Xls_Reader reader; 
	//= new Xls_Reader("C:\\Users\\P10481692\\Desktop\\DataBookCapita.xlsx");
	
	public static ArrayList<Object[]> getTeacherDataFromExcel(){
		
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

}
