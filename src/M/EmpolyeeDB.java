package M;

public class EmpolyeeDB
{
	public int 		EMPLOYEE_ID;
	public String 	FIRST_NAME;
	public String 	EMAIL;
	public String 	DEPARTMENT_NAME;
	public int 		SALARY;
	//public String 	HIRE_DATE;
	//public int 		DEPARTMENT_ID;
	
	public EmpolyeeDB()
	{
		
	}
	//,String xHIRE_DATE ,int xDEPARTMENT_ID
	public EmpolyeeDB(int xEMPLOYEE_ID ,String xFIRST_NAME ,String xEMAIL ,String xDEPARTMENT_NAME ,int xSALARY )
	{
		EMPLOYEE_ID = xEMPLOYEE_ID;
		FIRST_NAME = xFIRST_NAME;
		EMAIL = xEMAIL;
		DEPARTMENT_NAME = xDEPARTMENT_NAME;
		SALARY = xSALARY;
		/**HIRE_DATE = xHIRE_DATE;
		DEPARTMENT_ID = xDEPARTMENT_ID;**/
		
	}
}
