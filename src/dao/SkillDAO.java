package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import model.Skill;
import utility.ConnectionManager;

public class SkillDAO
{
	public static HashMap<Skill,Integer> hashmap=new HashMap<Skill,Integer>();
	
	public HashMap<Skill,Integer> skillCount() throws ClassNotFoundException, SQLException
	{
		Connection con=ConnectionManager.getConnection();
		if(con!=null)
		{
			String sql="select skillname,count(*) as count from skilldetails group by skillname";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next())
			{
			   //int skillid=rs.getInt(1);
			   String name=rs.getString("skillname");
			   int count=rs.getInt("count");
			   Skill s=new Skill(count,name);
			   //String s1=s.getSkillname();
			   hashmap.put(s,count);
			}
					
		}
		return hashmap;
		
	}
	
	
	
	
}