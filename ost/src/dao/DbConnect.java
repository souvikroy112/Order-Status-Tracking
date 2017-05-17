package dao;

import java.sql.*;
import java.util.ArrayList;

import model.Admin;
import model.DistVsStatus;
import model.DistVsZone;
import model.Distributor;
import model.Manager;
import model.Order;
import model.Product;
import model.Salesman;
import model.SalmnVsStatus;
import model.SalmnVsZone;
import model.Zone;

public class DbConnect {

	private static String url="jdbc:db2://localhost:50000/webtek1",user_name="db2admin",password="Xyz@1234"; 		
	private static Connection con=null;
	/*static{
			try {
				Class.forName("com.ibm.db2.jcc.DB2Driver");
				con=DriverManager.getConnection(url,user_name,password);
				System.out.println("Connection done");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		// TODO Auto-generated method stub
		/*public static boolean newDepartment(Department ob)//Insert query for database
		{
		try{
		 String sql="insert into abcd.department (dept_id,dept_name,location) values (?,?,?)";	
		PreparedStatement psmt=con.prepareStatement(sql);
		psmt.setLong(1, ob.getDept_id());
		psmt.setString(2, ob.getDept_name());
		psmt.setString(3, ob.getLocation());
		int i=psmt.executeUpdate();
        return (i!=0);
		}
		catch(Exception e){
			System.out.println(e);
			
		}
		return false ;
		}
		public static boolean updateDepartment(Department ob)//update query for database
		{
			try{
				java.sql.Statement stat=null;
				stat=con.createStatement();
	            String sql = "UPDATE abcd.department " +
	                   "SET dept_name ='"+ob.getDept_name()+"',location='"+ob.getLocation()+"' WHERE dept_id="+ob.getDept_id();
	            int i=stat.executeUpdate(sql);
		        return (i!=0);
				}
				catch(Exception e){
					System.out.println(e);	
				}
		
			return false;
		}
		public static boolean deleteDepartment(Department ob)//delete query for database
		{
			try{
				java.sql.Statement stat=null;
				stat=con.createStatement();
	            String sql = "delete abcd.department " +
	                   " WHERE dept_id="+ob.getDept_id();
	            int i=stat.executeUpdate(sql);
		        return (i!=0);
				}
				catch(Exception e){
					System.out.println(e);	
				}
		
			return false;
		}
		public static ArrayList<Department> getDepartment()//Select query for database
		{
			try{
				String sql="select * from abcd.department";
				PreparedStatement psat=con.prepareStatement(sql);
				ResultSet rsat=psat.executeQuery();
				ArrayList<Department> al=new ArrayList<Department>();
				while(rsat.next())
				{
					Department d=new Department();
					d.setDept_id(rsat.getLong("dept_id"));
					d.setDept_name(rsat.getString("dept_name"));
					d.setLocation(rsat.getString("location"));
					al.add(d);
				
				}
				return al;
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			return null;
		}
		public static void main(String[] args) 
		{	
			Department ob=new Department();
			ob.setDept_id(3);
			ob.setDept_name("ece");
			ob.setLocation("kolkata");
			if(DbConnect.newDepartment(ob))
			{
				System.out.println("insertion successful");
			}
			else
			{
				System.out.println("not successful");
			}
			ob.setDept_id(2);
			ob.setDept_name("mechanical");
			ob.setLocation("Kolkata");
			if(DbConnect.updateDepartment(ob))
			{
				System.out.println("update successful");
			}
			else
			{
				System.out.println("not successful");
			}
			ob.setDept_id(3);
			if(DbConnect.deleteDepartment(ob))
			{
				System.out.println("delete successful");
			}
			else
			{
				System.out.println("not successful");
			}
			ArrayList<Department> al=DbConnect.getDepartment();
			if(al==null || al.size()==0)
			{
				System.out.println("Here is no department yet");
			}
			else
			{
				System.out.println("Department  Details");
				for(Department d:al)
				{
					System.out.println("Department id:"+d.getDept_id());
					System.out.println("Department Name:"+d.getDept_name());
					System.out.println("Department Location:"+d.getLocation());
				}
			}
		}*/
	public static Connection getCon(){
		Connection con=null;
		try {
			Class.forName("com.ibm.db2.jcc.DB2Driver");
			con=DriverManager.getConnection(url, user_name, password);
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	public static boolean isValid(Admin ob) {
		Connection con=getCon();
		try{
			String sql="select * from ost.admin where admin_id=? and password=?";
			PreparedStatement psmt=con.prepareStatement(sql);
			psmt.setLong(1, ob.getAdmin_id());
			psmt.setString(2, ob.getPassword());
			ResultSet rs=psmt.executeQuery();
			if(rs.next()){
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return false;
	}
	public static boolean newManager(Manager ob) {
		Connection con=getCon();
		try{
			String sql="insert into ost.manager (mgr_name,mgr_dob,mgr_city,mgr_contact,mgr_email) values(?,?,?,?,?)";
			PreparedStatement psmt=con.prepareStatement(sql,java.sql.Statement.RETURN_GENERATED_KEYS);
			psmt.setString(1, ob.getMgr_name());
			psmt.setString(2, ob.getMgr_dob());
			psmt.setString(3, ob.getMgr_city());
			psmt.setString(4, ob.getMgr_contact());
			psmt.setString(5, ob.getMgr_email());
			int i=psmt.executeUpdate();
			ResultSet rs=psmt.getGeneratedKeys();
			if(rs.next() && i!=0){
				ob.setMgr_id(rs.getLong(1));
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				con.close();
			}catch(Exception e){
				System.out.println(e);
			}
		}
		return false;
	}
	public static ArrayList<Manager> getManagerDetails(Manager ob) {
		Connection con=getCon();
		
		try{
			String sql="select mgr_id,mgr_name,mgr_dob,mgr_city,mgr_contact,mgr_email from ost.manager where mgr_id=?";
			PreparedStatement psat=con.prepareStatement(sql);
			psat.setLong(1, ob.getMgr_id());
			ResultSet rsat=psat.executeQuery();
			ArrayList<Manager> al=new ArrayList<Manager>();
			while(rsat.next())
			{
				Manager d=new Manager();
				d.setMgr_id(rsat.getLong("mgr_id"));
				d.setMgr_name(rsat.getString("mgr_name"));
				d.setMgr_dob(rsat.getString("mgr_dob"));
				d.setMgr_city(rsat.getString("mgr_city"));
				d.setMgr_contact(rsat.getString("mgr_contact"));
				d.setMgr_email(rsat.getString("mgr_email"));
				al.add(d);
			
			}
			return al;
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return null;
	}
	public static boolean updateManager(Manager ob) {
		Connection con=getCon();
		try{
			String sql="update ost.manager set mgr_name=?, mgr_dob=?, mgr_city=?, mgr_contact=?, mgr_email=? where mgr_id=?";		
			PreparedStatement psmt=con.prepareStatement(sql);
			psmt.setString(1, ob.getMgr_name());
			psmt.setString(2, ob.getMgr_dob());
			psmt.setString(3, ob.getMgr_city());
			psmt.setString(4, ob.getMgr_contact());
			psmt.setString(5, ob.getMgr_email());
			psmt.setLong(6, ob.getMgr_id());
			int i=psmt.executeUpdate();
			return(i!=0);
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		// TODO Auto-generated method stub
		return false;
	}
	public static boolean isValidManager(Manager ob) {
		Connection con=getCon();
		try{
			if(ob.getMgr_password().equals("password"))
			{
				return false;
			}
			else
			{
				String sql="select * from ost.manager where mgr_id=? and mgr_password=?";
				PreparedStatement psmt=con.prepareStatement(sql);
				psmt.setLong(1, ob.getMgr_id());
				psmt.setString(2, ob.getMgr_password());
				ResultSet rs=psmt.executeQuery();
				if(rs.next()){
					return true;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		// TODO Auto-generated method stub
		return false;
	}
	public static boolean isValidNewManager(Manager ob) {
		Connection con=getCon();
		try{
			String sql="select * from ost.manager where mgr_id=? and mgr_dob=?";
			PreparedStatement psmt=con.prepareStatement(sql);
			psmt.setLong(1, ob.getMgr_id());
			psmt.setString(2, ob.getMgr_dob());
			ResultSet rs=psmt.executeQuery();
			if(rs.next()){
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		// TODO Auto-generated method stub
		return false;
	}
	public static boolean updateNewManagerPassword(Manager ob) {
		Connection con=getCon();
		try{
			String sql="update ost.manager set mgr_password=? where mgr_id=?";		
			PreparedStatement psmt=con.prepareStatement(sql);
			psmt.setString(1, ob.getMgr_password());
			psmt.setLong(2, ob.getMgr_id());
			System.out.println(ob.getMgr_id());
			int i=psmt.executeUpdate();
			return(i!=0);
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		// TODO Auto-generated method stub
		return false;
	}
	public static boolean newProduct(Product ob) {
		Connection con=getCon();
		
		try{
			String sql="insert into ost.product (p_title,description,price,catagory) values(?,?,?,?)";
			PreparedStatement psmt=con.prepareStatement(sql,java.sql.Statement.RETURN_GENERATED_KEYS);
			psmt.setString(1, ob.getP_name());
			psmt.setString(2, ob.getDescription());
			psmt.setLong(3, ob.getPrice());
			psmt.setString(4, ob.getCatagory());
			int i=psmt.executeUpdate();
			ResultSet rs=psmt.getGeneratedKeys();
			if(rs.next() && i!=0){
				ob.setP_id(rs.getLong(1));
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return false;
	}
	public static ArrayList<Product> getProductDetails(Product ob) {
		Connection con=getCon();
		
		try{
			String sql="select p_id,p_title,description,price,catagory from ost.product where p_id=?";
			PreparedStatement psat=con.prepareStatement(sql);
			psat.setLong(1, ob.getP_id());
			ResultSet rsat=psat.executeQuery();
			ArrayList<Product> al=new ArrayList<Product>();
			while(rsat.next())
			{
				Product d=new Product();
				d.setP_id(rsat.getLong("p_id"));
				d.setP_name(rsat.getString("p_title"));
				d.setDescription(rsat.getString("description"));
				d.setPrice(rsat.getLong("price"));
				d.setCatagory(rsat.getString("catagory"));
				al.add(d);
			
			}
			return al;
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return null;
	}
	public static boolean updateProduct(Product ob) {
		Connection con=getCon();
		try{
			String sql="update ost.product set p_title=?, description=?, price=?, catagory=? where p_id=?";		
			PreparedStatement psmt=con.prepareStatement(sql);
			psmt.setString(1, ob.getP_name());
			psmt.setString(2, ob.getDescription());
			psmt.setLong(3, ob.getPrice());
			psmt.setString(4, ob.getCatagory());
			psmt.setLong(5, ob.getP_id());
			int i=psmt.executeUpdate();
			return(i!=0);
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return false;
	}
	public static boolean deleteProduct(Product ob) {
		Connection con=getCon();
		
		try{
			String sql="delete from ost.product where p_id=?";		
			PreparedStatement psmt=con.prepareStatement(sql);
			psmt.setLong(1, ob.getP_id());
			int i=psmt.executeUpdate();
			return(i!=0);
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return false;
	}
	public static boolean newSalesman(Salesman ob, long mgr_id) {
		Connection con=getCon();
		 
		try{
			String sql="insert into ost.salesman (mgr_id,salmn_name,salmn_dob,salmn_city,salmn_contact,salmn_email,zone_id) values(?,?,?,?,?,?,?)";
			PreparedStatement psmt=con.prepareStatement(sql,java.sql.Statement.RETURN_GENERATED_KEYS);
			psmt.setLong(1, mgr_id);
			psmt.setString(2, ob.getSalmn_name());
			psmt.setString(3, ob.getSalmn_dob());
			psmt.setString(4, ob.getSalmn_city());
			psmt.setString(5, ob.getSalmn_contact());
			psmt.setString(6, ob.getSalmn_email());
			psmt.setLong(7, ob.getSalmn_zone_id());
			int i=psmt.executeUpdate();
			ResultSet rs=psmt.getGeneratedKeys();
			if(rs.next() && i!=0){
				ob.setSalmn_id(rs.getLong(1));
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return false;
	}
	public static ArrayList<Salesman> getSalesmanDetails(Salesman ob) {
		Connection con=getCon();
		
		try{
			String sql="select salmn_id,salmn_name,salmn_dob,salmn_city,salmn_contact,salmn_email from ost.salesman where salmn_id=?";
			PreparedStatement psat=con.prepareStatement(sql);
			psat.setLong(1, ob.getSalmn_id());
			ResultSet rsat=psat.executeQuery();
			ArrayList<Salesman> al=new ArrayList<Salesman>();
			while(rsat.next())
			{
				Salesman d=new Salesman();
				d.setSalmn_id(rsat.getLong("salmn_id"));
				d.setSalmn_name(rsat.getString("salmn_name"));
				d.setSalmn_dob(rsat.getString("salmn_dob"));
				d.setSalmn_city(rsat.getString("salmn_city"));
				d.setSalmn_contact(rsat.getString("salmn_contact"));
				d.setSalmn_email(rsat.getString("salmn_email"));
				al.add(d);
			
			}
			return al;
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return null;
	}
	public static boolean updateSalesman(Salesman ob) {
		Connection con=getCon();
		
		try{
			String sql="update ost.salesman set salmn_name=?, salmn_dob=?, salmn_city=?, salmn_contact=?, salmn_email=? where salmn_id=?";		
			PreparedStatement psmt=con.prepareStatement(sql);
			psmt.setString(1, ob.getSalmn_name());
			psmt.setString(2, ob.getSalmn_dob());
			psmt.setString(3, ob.getSalmn_city());
			psmt.setString(4, ob.getSalmn_contact());
			psmt.setString(5, ob.getSalmn_contact());
			psmt.setLong(6, ob.getSalmn_id());
			int i=psmt.executeUpdate();
			return(i!=0);
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return false;
	}
	public static boolean deleteSalasman(Salesman ob) {
		Connection con=getCon();
		try{
			String sql="delete from ost.salesman where salmn_id=?";		
			PreparedStatement psmt=con.prepareStatement(sql);
			psmt.setLong(1, ob.getSalmn_id());
			int i=psmt.executeUpdate();
			return(i!=0);
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return false;
	}
	public static boolean isValidSalesman(Salesman ob) {
		Connection con=getCon();
		try{
			if(ob.getSalmn_password().equals("password"))
			{
				return false;
			}
			else
			{
				String sql="select * from ost.salesman where salmn_id=? and salmn_password=?";
				PreparedStatement psmt=con.prepareStatement(sql);
				psmt.setLong(1, ob.getSalmn_id());
				psmt.setString(2, ob.getSalmn_password());
				ResultSet rs=psmt.executeQuery();
				if(rs.next()){
					return true;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		// TODO Auto-generated method stub
		return false;
	}
	public static boolean isValidNewSalesman(Salesman ob) {
		Connection con=getCon();
		
		try{
			String sql="select * from ost.salesman where salmn_id=? and salmn_dob=?";
			PreparedStatement psmt=con.prepareStatement(sql);
			psmt.setLong(1, ob.getSalmn_id());
			psmt.setString(2, ob.getSalmn_dob());
			ResultSet rs=psmt.executeQuery();
			if(rs.next()){
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return false;
	}
	public static boolean updateNewSalesmanPassword(Salesman ob) {
		Connection con=getCon();
		try{
			String sql="update ost.salesman set salmn_password=? where salmn_id=?";		
			PreparedStatement psmt=con.prepareStatement(sql);
			psmt.setString(1, ob.getSalmn_password());
			psmt.setLong(2, ob.getSalmn_id());
			System.out.println(ob.getSalmn_id());
			int i=psmt.executeUpdate();
			return(i!=0);
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		// TODO Auto-generated method stub
		return false;
	}
	public static boolean newDistributor(Distributor ob, Zone zone) {
		Connection con=getCon();
		
		try{
			String sql="insert into ost.distributor (zone_id,dis_name,dis_city,dis_password,dis_mobile) values(?,?,?,?,?)";
			PreparedStatement psmt=con.prepareStatement(sql,java.sql.Statement.RETURN_GENERATED_KEYS);
			System.out.println(zone.getZone_id());
			psmt.setLong(1, zone.getZone_id());
			psmt.setString(2, ob.getDis_name());
			psmt.setString(3, ob.getDis_city());
			psmt.setString(4, ob.getDis_password());
			psmt.setString(5, ob.getDis_mobile());
			int i=psmt.executeUpdate();
			ResultSet rs=psmt.getGeneratedKeys();
			if(rs.next() && i!=0){
				ob.setDis_id(rs.getLong(1));
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		// TODO Auto-generated method stub
		return false;
	}
	public static ArrayList<Distributor> isValidDistributor(Distributor ob) {
		Connection con=getCon();
		
		try{
			String sql="select * from ost.distributor where dis_id=? and dis_password=?";
			PreparedStatement psmt=con.prepareStatement(sql);
			psmt.setLong(1, ob.getDis_id());
			psmt.setString(2, ob.getDis_password());
			ResultSet rs=psmt.executeQuery();
			ArrayList<Distributor> al=new ArrayList<Distributor>();
			if(rs.next()){

				Distributor d=new Distributor();
				d.setDis_status(rs.getString("dis_status"));
				al.add(d);
				return al;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return null;
	}
	public static ArrayList<Distributor> getDistributor() {
		Connection con=getCon();
		
		try{
			boolean flag=false;
			String sql="select dis_id,dis_name,dis_city,dis_mobile from ost.distributor where dis_status='inactive'";
			PreparedStatement psmt=con.prepareStatement(sql);
			ResultSet rs=psmt.executeQuery();
			ArrayList<Distributor> al=new ArrayList<Distributor>();
			while(rs.next()){
				flag=true;
				Distributor d=new Distributor();
				d.setDis_id(rs.getLong("dis_id"));
				d.setDis_name(rs.getString("dis_name"));
				d.setDis_city(rs.getString("dis_city"));
				d.setDis_mobile(rs.getString("dis_mobile"));
				al.add(d);
			}
			if(flag==true)
			return al;
			else
				return null;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return null;
	}
	public static boolean updateStatusDistributor(Distributor ob) {
		Connection con=getCon();
		
		try{
			String sql="update ost.distributor set dis_status=? where dis_id=?";		
			PreparedStatement psmt=con.prepareStatement(sql);
			psmt.setString(1, ob.getDis_status());
			psmt.setLong(2, ob.getDis_id());
			int i=psmt.executeUpdate();
			return(i!=0);
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}		
		return false;
	}
public static ArrayList<Product> getAllProducts() {
	Connection con=getCon();
		
	try{
		String sql="select * from ost.product";
		boolean flag=false;
		PreparedStatement psat=con.prepareStatement(sql);
		ResultSet rsat=psat.executeQuery();
		ArrayList<Product> al=new ArrayList<Product>();
		while(rsat.next())
		{
			flag=true;
			Product d=new Product();
			d.setP_id(rsat.getLong("p_id"));
			d.setP_name(rsat.getString("p_title"));
			d.setDescription(rsat.getString("description"));
			d.setPrice(rsat.getLong("price"));
			d.setCatagory(rsat.getString("catagory"));
			al.add(d);
		
		}
		if(flag==true)
		return al;
		else
			return null;
	}catch(Exception e)
	{
		e.printStackTrace();
	}finally{
		try{
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
		return null;
	}

public static boolean newOrder(Order ob, Product ob1, Distributor ob2) {
	Connection con=getCon();
	try{
		String sql="insert into ost.order (p_id,order_date,unit,total_price,dis_id) values(?,current date,?,?,?)";
		PreparedStatement psmt=con.prepareStatement(sql,java.sql.Statement.RETURN_GENERATED_KEYS);
		psmt.setLong(1, ob1.getP_id());
		psmt.setLong(2, ob.getUnit());
		psmt.setLong(3, (ob.getUnit()*ob1.getPrice()));
		psmt.setLong(4, ob2.getDis_id());
		int i=psmt.executeUpdate();
		ResultSet rs=psmt.getGeneratedKeys();
		if(rs.next() && i!=0){
			ob.setOrder_id(rs.getLong(1));
			return true;
		}
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	// TODO Auto-generated method stub
	
	return false;
}
public static ArrayList<Order> getOrderStatus(Object ob) {
	Connection con=getCon();
	try{
		String sql="select * from ost.order where dis_id=?";
		boolean flag=false;
		PreparedStatement psat=con.prepareStatement(sql);
		psat.setLong(1, Long.parseLong(ob.toString()));
		ResultSet rsat=psat.executeQuery();
		ArrayList<Order> al=new ArrayList<Order>();
		while(rsat.next())
		{
			flag=true;
			Order d=new Order();
			d.setOrder_id(rsat.getLong("order_id"));
			d.setOrder_date(rsat.getString("order_date"));
			d.setExpected_delivery(rsat.getString("expected_delivery"));
			d.setAcrual_deliver(rsat.getString("actual_delivery"));
			d.setStatus(rsat.getString("status"));
			d.setSalm_id_order(rsat.getLong("salmn_id"));
			al.add(d);
		
		}
		if(flag==true)
		return al;
		else
			return null;
	}catch(Exception e)
	{
		e.printStackTrace();
	}finally{
		try{
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
		return null;
	}
public static ArrayList<Order> getOrderDetails(Object ob) {
	Connection con=getCon();
	try{
		String sql="select o.order_id,o.order_date,o.expected_delivery,o.actual_delivery,o.status from ost.order as o,(select d.dis_id,d.dis_name from ost.distributor as d where d.zone_id=(select zone_id from ost.salesman as s where s.salmn_id=?)) as t where o.dis_id=t.dis_id and (salmn_id is null or salmn_id=?)";
		boolean flag=false;
		PreparedStatement psat=con.prepareStatement(sql);
		psat.setLong(1, Long.parseLong(ob.toString()));
		psat.setLong(2, Long.parseLong(ob.toString()));
		ResultSet rsat=psat.executeQuery();
		ArrayList<Order> al=new ArrayList<Order>();
		while(rsat.next())
		{
			flag=true;
			Order d=new Order();
			d.setOrder_id(rsat.getLong("order_id"));
			d.setOrder_date(rsat.getString("order_date"));
			d.setExpected_delivery(rsat.getString("expected_delivery"));
			d.setAcrual_deliver(rsat.getString("actual_delivery"));
			d.setStatus(rsat.getString("status"));
			al.add(d);
		
		}
		if(flag==true)
		return al;
		else
			return null;
	}catch(Exception e)
	{
		e.printStackTrace();
	}finally{
		try{
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
		return null;
	}
public static boolean updateExpectedOrderDate(Order ob) {
	
	Connection con=getCon();
	
	try{
		String sql="update ost.order set expected_delivery=?,status='processing',salmn_id=? where order_id=?";		
		PreparedStatement psmt=con.prepareStatement(sql);
		psmt.setString(1, ob.getExpected_delivery());
		psmt.setLong(2, ob.getSalm_id_order());
		psmt.setLong(3, ob.getOrder_id());
		int i=psmt.executeUpdate();
		return(i!=0);
		
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}		
	return false;
}
public static boolean updateDeliveredOrderDate(Order ob) {
	
Connection con=getCon();
	
	try{
		String sql="update ost.order set actual_delivery=current date,status='delivered' where order_id=?";		
		PreparedStatement psmt=con.prepareStatement(sql);
		psmt.setLong(1, ob.getOrder_id());
		int i=psmt.executeUpdate();
		return(i!=0);
		
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}		
	return false;
}
public static ArrayList<SalmnVsStatus> getSalesmanStatusReport(){
	Connection con=getCon();
		
	try{
		String sql="select salmn_id,status,count(status) as number from ost.order group by salmn_id,status";
		boolean flag=false;
		PreparedStatement psat=con.prepareStatement(sql);
		ResultSet rsat=psat.executeQuery();
		ArrayList<SalmnVsStatus> al=new ArrayList<SalmnVsStatus>();
		while(rsat.next())
		{
			flag=true;
			SalmnVsStatus d=new SalmnVsStatus();
			d.setSalmn_id(rsat.getLong(1));
			d.setStatus(rsat.getString(2));
			d.setNumber(Long.parseLong(rsat.getString(3)));
			al.add(d);
		
		}
		if(flag==true)
		return al;
		else
			return null;
	}catch(Exception e)
	{
		e.printStackTrace();
	}finally{
		try{
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
		return null;
	}

public static ArrayList<DistVsStatus> getDistributorStatusReport(){
	Connection con=getCon();
		
	try{
		String sql="select dis_id,status,count(status) as number from ost.order group by dis_id,status";
		boolean flag=false;
		PreparedStatement psat=con.prepareStatement(sql);
		ResultSet rsat=psat.executeQuery();
		ArrayList<DistVsStatus> al=new ArrayList<DistVsStatus>();
		while(rsat.next())
		{
			flag=true;
			DistVsStatus d=new DistVsStatus();
			d.setDis_id(Long.parseLong(rsat.getString(1)));
			d.setStatus(rsat.getString(2));
			d.setNumber(Long.parseLong(rsat.getString(3)));
			al.add(d);
		
		}
		if(flag==true)
		return al;
		else
			return null;
	}catch(Exception e)
	{
		e.printStackTrace();
	}finally{
		try{
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
		return null;
	}

public static ArrayList<SalmnVsZone> getSalesmanZoneReport(){
	Connection con=getCon();
		
	try{
		String sql="SELECT s.salmn_id,s.zone_id,count(o.order_id) as orders FROM ost.salesman as s LEFT OUTER JOIN ost.order as o ON s.salmn_id = o.salmn_id group by s.salmn_id,s.zone_id";
		boolean flag=false;
		PreparedStatement psat=con.prepareStatement(sql);
		ResultSet rsat=psat.executeQuery();
		ArrayList<SalmnVsZone> al=new ArrayList<SalmnVsZone>();
		while(rsat.next())
		{
			flag=true;
			SalmnVsZone d=new SalmnVsZone();
			d.setSalmn_id(Long.parseLong(rsat.getString(1)));
			d.setZone_id(Long.parseLong(rsat.getString(2)));
			d.setNumber(Long.parseLong(rsat.getString(3)));
			al.add(d);
		
		}
		if(flag==true)
		return al;
		else
			return null;
	}catch(Exception e)
	{
		e.printStackTrace();
	}finally{
		try{
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
		return null;
	}
public static ArrayList<DistVsZone> getDistributorZoneReport(){
	Connection con=getCon();
		
	try{
		String sql="SELECT s.dis_id,s.zone_id,count(o.order_id) as orders FROM ost.distributor as s LEFT OUTER JOIN ost.order as o ON s.dis_id = o.dis_id group by s.dis_id,s.zone_id";
		boolean flag=false;
		PreparedStatement psat=con.prepareStatement(sql);
		ResultSet rsat=psat.executeQuery();
		ArrayList<DistVsZone> al=new ArrayList<DistVsZone>();
		while(rsat.next())
		{
			flag=true;
			DistVsZone d=new DistVsZone();
			d.setDis_id(Long.parseLong(rsat.getString(1)));
			d.setZone_id(Long.parseLong(rsat.getString(2)));
			d.setNumber(Long.parseLong(rsat.getString(3)));
			al.add(d);
		
		}
		if(flag==true)
		return al;
		else
			return null;
	}catch(Exception e)
	{
		e.printStackTrace();
	}finally{
		try{
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
		return null;
	}
		
}



