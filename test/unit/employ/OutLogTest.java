package unit.employ;

import static org.junit.Assert.*;
import employ.*;

import java.io.*;

import org.junit.Test;

public class OutLogTest {

	String s ="sample：サンプル";
	int i = 12345;
	
	String file_name ="C:/test/log/log.txt";
	String log;
	String str ="";
	
	@Test
	public void test_outLogDmp_1() {
		System.out.println("★UT003_001\n");
		
		File file = new File(file_name);
		FileReader fr = null;
		FileWriter fw =null;
		
		try {
			fr = new FileReader(file);
			fw = new FileWriter(file, false);
			fw.write("");
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		BufferedReader br = new BufferedReader(fr);
		
		OutLog.outLogDmp(s);
		
		try {	
			while((log=br.readLine())!= null){
				str = str + log;
			}			
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		assertEquals(DateString.getDate14() + ":" + s,str);
		
		System.out.println("期待値:"+DateString.getDate14() + ":" + s);
		System.out.println("ログ:"+str);
		System.out.println("------------------------------------");
	}
	
	
	@Test
	public void test_outLogDmp_2() {
		System.out.println("★UT003_002\n");
		
		File file = new File(file_name);
		FileReader fr = null;
		FileWriter fw =null;
		try {
			fr = new FileReader(file);
			fw = new FileWriter(file, false);
			fw.write("");
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		BufferedReader br = new BufferedReader(fr);

		OutLog.outLogDmp(i);
		
		try {	
			while((log=br.readLine())!= null){
				str = str + log;
			}			
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		assertEquals(DateString.getDate14() + ":" + i ,str);
		
		System.out.println("期待値:"+DateString.getDate14() + ":" + i);
		System.out.println("ログ:"+str);
		System.out.println("------------------------------------");
	}
}
