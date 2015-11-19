import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class InsertBean {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Emp obj1 = new Emp();
		Emp obj2 = new Emp();
		Emp obj3 = new Emp();
		Emp obj4 = new Emp();
		Emp obj5 = new Emp();
		
		//row1
		obj1.setId(1);
		obj1.setName("Anupama");
		//row2
		obj2.setId(2);
		obj2.setName("Padma");
				
		//row3
		obj3.setId(3);
		obj3.setName("Shamala");
		
		//row4
		obj4.setId(4);
		obj4.setName("Tanu");
		
		//row5
		obj5.setId(5);
		obj5.setName("manu");
		
		
		List<Emp> list = new ArrayList<Emp>();
		
		list.add(obj1);
		list.add(obj2);
		list.add(obj3);
		list.add(obj4);
		list.add(obj5);
		
		try
		{
		
			//load the class
			Class.forName("oracle.jdbc.OracleDriver");
		
			//get the connection
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@10.150.68.40:1521:B5O112DM","CDMDW_OWN","cdmdw_usr");
			
			/*//Create table
			Statement stmt = con.createStatement();
			String query = "Create table Emp1(id int,name varchar2(20))";
			stmt.executeQuery(query);*/
			
			String query = "insert into Emp1 values(?,?)";
			
			PreparedStatement stmt = con.prepareStatement(query);
			
			for(Emp e : list)
			{
				stmt.setInt(1, e.getId());
				stmt.setString(2, e.getName());
				stmt.executeUpdate();
			}
			
			System.out.println("record insertion completed ");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		

	}

}
