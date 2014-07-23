package unit.user.parts;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.junit.BeforeClass;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import user.bean.RegistrantInfo;
import user.parts.ReadRegistInfo;
import user.parts.RegInfDAO;

public class RegInfDAOtest extends RegistrantInfo{
	
	private static final long serialVersionUID = 1L;
	RegInfDAO riDAO;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	    System.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.naming.java.javaURLContextFactory");
	    System.setProperty(Context.URL_PKG_PREFIXES, "org.apache.naming");

	    InitialContext ic = new InitialContext();
	    ic.createSubcontext("java:");
	    ic.createSubcontext("java:comp");
	    ic.createSubcontext("java:comp/env");
	    ic.createSubcontext("java:comp/env/jdbc");

	    MysqlDataSource ds = new MysqlDataSource();
	    ds.setUser("root");
	    ds.setPassword("yano");

	    ic.bind("java:comp/env/jdbc/Task", ds);
	}
	
	//private InitialContext initCon;
	//private DataSource ds;
	//private Connection con;
	//private PreparedStatement stmt;
	//private ResultSet rs;
	
	String id = "";
	String name = "";
	String age = "";
	String msg = "";
	String str ="";
	
	String[][] rec = {{"001","鈴木太郎","35"},
			  {"002","Tommy","25"},
			  {"003","山田花子","30"}};
	
	String[] comprareUT001 = {"001 鈴木太郎 35","002 Tommy 25", "003 山田花子 30","004 佐藤路未央 29"};
	String[] comprareUT002 = {"001 鈴木太郎 35","002 Michael 28", "003 山田花子 30"};
	String[] comprareUT003 = {"002 Tommy 25", "003 山田花子 30"};
	String[] comprareUT004 = {"001 鈴木太郎 35","002 Tommy 25", "003 山田花子 30"};
	
	@Before
	public void recoveryInsert(){			
		riDAO = new RegInfDAO();
		System.out.println("■初期レコードを挿入します\n");
		for(int i=0;i<=2;i++){	
		System.out.println(rec[i][0]+","+rec[i][1]+","+rec[i][2]);
		riDAO.insert(rec[i][0],rec[i][1],rec[i][2]);
		}
		System.out.println("--------------------");
	}
	
	@After
	public void recoveryDelete(){
		System.out.println("■テストレコードを削除します\n");
		String id = "";
		riDAO = new RegInfDAO();
		
		for(int i=1;i<=4;i++){
			id = "00" + String.valueOf(i);
			System.out.println("ID:"+id+"削除");
			riDAO.delete(id);
		}
		System.out.println("--------------------");
	}
	

	@Test
	public void testInsert(){
		System.out.println("★UT002_001\n");
		
		String id = "004";
		String name = "佐藤路未央";
		String age = "29";
		
		riDAO = new RegInfDAO();
		riDAO.insert(id,name,age);
		
		ArrayList<RegistrantInfo> list;
        list = riDAO.getReglist();
        for(int i = 0; i < list.size(); i++){
            RegistrantInfo ri = list.get(i);
            str = ri.getrId();
            str = str +" "+ ri.getrName();
            str = str +" "+ ri.getrAge();
            
            assertEquals(str,comprareUT001[i]);
            
            System.out.println(str);  
        }
        System.out.println("--------------------");
	}

	
	@Test
	public void testUpdate() {
		System.out.println("★UT002_002\n");
		
		String id = "002";
		String name = "Michael";
		String age = "28";	
		
		riDAO = new RegInfDAO();
		riDAO.update(id,name,age);
		
		ArrayList<RegistrantInfo> list;
        list = riDAO.getReglist();  
        for(int i = 0; i < list.size(); i++){
            RegistrantInfo ri = list.get(i);
            str = ri.getrId();
            str = str +" "+ ri.getrName();
            str = str +" "+ ri.getrAge();
            	    
            assertEquals(str,comprareUT002[i]);
            
            System.out.println(str);
        }
        System.out.println("--------------------");
	}

	@Test
	public void testDelete() {
		System.out.println("★UT002_003\n");
		String id = "001";
		
		riDAO = new RegInfDAO();
		riDAO.delete(id);
		
		ArrayList<RegistrantInfo> list;
        list = riDAO.getReglist();
        for(int i = 0; i < list.size(); i++){
            RegistrantInfo ri = list.get(i);
            str = ri.getrId();
            str = str +" "+ ri.getrName();
            str = str +" "+ ri.getrAge();
            	
            assertEquals(str,comprareUT003[i]);
            
            System.out.println(str);
        }
        System.out.println("--------------------");
	}
	
	@Test
	public void testGetReglist() {
		System.out.println("★UT002_004\n");
		ArrayList<RegistrantInfo> list;
        list = riDAO.getReglist();
        
        for(int i = 0; i < list.size(); i++){
            RegistrantInfo ri = list.get(i);
            str = ri.getrId();
            str = str +" "+ ri.getrName();
            str = str +" "+ ri.getrAge();
           
            assertEquals(str,comprareUT004[i]);
            
            System.out.println(str);
        }
        System.out.println("--------------------");
	}
	
	@Test
	public void testGetNextId(){
		System.out.println("★UT002_005\n");
		recoveryDelete();
			
        str = riDAO.getNextId();
        assertEquals(str,"001");
        
        System.out.println(str);
        System.out.println("--------------------");
	}
	
	@After
	public void tearDown(){
	    riDAO.close();
	}
}
