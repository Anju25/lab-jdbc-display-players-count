package controller;

import java.sql.SQLException;
import java.util.HashMap;
//import java.util.TreeMap;
import java.util.Map.Entry;

import dao.SkillDAO;
//import model.Conference;
import model.Skill;

public class Main
{
	public static HashMap<Skill,Integer> hashmap=new HashMap<Skill,Integer>();
	public static void main(String args[]) throws ClassNotFoundException, SQLException
	{
		SkillDAO skilldao=new SkillDAO();
		hashmap=skilldao.skillCount();
		//TreeMap<Skill,Integer> map=new TreeMap<Skill,Integer>(hashmap);
	    
		for(Entry<Skill, Integer> pair: hashmap.entrySet())
		{
		   Skill s=pair.getKey();
           int value=pair.getValue();	
	      System.out.println(s.getSkillname()+" "+value);
		}
	}
}