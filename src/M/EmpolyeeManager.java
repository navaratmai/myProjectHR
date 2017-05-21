package M;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import common.GlobalData;

public class EmpolyeeManager
{
	public static ArrayList<EmpolyeeDB> getAllEmpolyee()
	{
		ArrayList<EmpolyeeDB> list = new ArrayList<EmpolyeeDB>();

		try
		{
			Class.forName(GlobalData.DATABASE_driver);
			Connection con =  DriverManager.getConnection("" +
					GlobalData.DATABASE_URL, GlobalData.DATABASE_USERNAME,GlobalData.DATABASE_PASSWORD);
			if(con != null){
				System.out.println("Database Connected.");
			} else {
				System.out.println("Database Connect Failed.");
			}
			
			Statement st = null;
			String query = "SELECT EMPLOYEES.EMPLOYEE_ID,EMPLOYEES.FIRST_NAME,EMPLOYEES.EMAIL,DEPARTMENTS.DEPARTMENT_NAME,EMPLOYEES.SALARY "
					+ "FROM HR.EMPLOYEES "
					+ "FULL OUTER JOIN HR.DEPARTMENTS "
					+ "ON HR.EMPLOYEES.DEPARTMENT_ID = HR.DEPARTMENTS.DEPARTMENT_ID";

			st = con.createStatement();

			ResultSet rs = st.executeQuery(query);

			while (rs.next())
			{

				int EMPLOYEE_ID = rs.getInt("EMPLOYEE_ID");
				String FIRST_NAME = rs.getString("FIRST_NAME");
				String EMAIL = rs.getString("EMAIL");
				String DEPARTMENT_NAME = rs.getString("DEPARTMENT_NAME");
				int SALARY = rs.getInt("SALARY");
				/**String HIRE_DATE = rs.getString("HIRE_DATE");
				int DEPARTMENT_ID = rs.getInt("DEPARTMENT_ID");**/
				//,HIRE_DATE,DEPARTMENT_ID
				EmpolyeeDB cc = new EmpolyeeDB(EMPLOYEE_ID,FIRST_NAME,EMAIL,DEPARTMENT_NAME,SALARY);
				list.add(cc);
				
				
			}
			st.close();
		} catch (Exception e)
		{
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}

		return list;
	}
	public static ArrayList<EmpolyeeDB> searchEmpolyee(String s,String a,String t,String b)
	{
		ArrayList<EmpolyeeDB> list = new ArrayList<EmpolyeeDB>();

		try
		{
			Class.forName(GlobalData.DATABASE_driver);
			Connection con =  DriverManager.getConnection("" +
					GlobalData.DATABASE_URL, GlobalData.DATABASE_USERNAME,GlobalData.DATABASE_PASSWORD);
			if(con != null){
				System.out.println("Database Connected.");
			} else {
				System.out.println("Database Connect Failed.");
			}
		
			String query = "SELECT EMPLOYEES.EMPLOYEE_ID,EMPLOYEES.FIRST_NAME,"
					+ "EMPLOYEES.EMAIL,DEPARTMENTS.DEPARTMENT_NAME,EMPLOYEES.SALARY "
					+ "FROM HR.EMPLOYEES "
					+ "FULL OUTER JOIN HR.DEPARTMENTS "
					+ "ON EMPLOYEES.DEPARTMENT_ID = DEPARTMENTS.DEPARTMENT_ID "
					+ "WHERE (EMPLOYEES.EMPLOYEE_ID = '"+s+"') OR (EMPLOYEES.SALARY BETWEEN '"+a+"' AND '"+t+"') OR (DEPARTMENTS.DEPARTMENT_ID = '"+b+"') ";

			Statement st = con.createStatement();

			ResultSet rs = st.executeQuery(query);
			
			while (rs.next())
			{
				int EMPLOYEE_ID = rs.getInt("EMPLOYEE_ID");
				String FIRST_NAME = rs.getString("FIRST_NAME");
				String EMAIL = rs.getString("EMAIL");
				String DEPARTMENT_NAME = rs.getString("DEPARTMENT_NAME");
				int SALARY = rs.getInt("SALARY");
				
				EmpolyeeDB cc = new EmpolyeeDB(EMPLOYEE_ID,FIRST_NAME,EMAIL,DEPARTMENT_NAME,SALARY);
				list.add(cc);
			
			}
			st.close();
		} catch (Exception e)
		{
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}

		return list;
	}
}
