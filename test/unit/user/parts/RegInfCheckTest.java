package unit.user.parts;

import static org.junit.Assert.*;

import org.junit.Test;

import user.parts.RegInfCheck;

public class RegInfCheckTest {

	@Test
	public void testCheckName_1() {

		String inputName = "0123456789";
		String msg = "";
		String errMsg = "名前は10桁以内で入力してください。<br />";
			
		RegInfCheck ric = new RegInfCheck();
		ric.checkName(inputName);
		System.out.println("UT001-001: "+ric.getErrMsg());
		assertEquals( "想定外のエラー",msg,ric.getErrMsg());			
	}

	@Test
	public void testCheckName_2() {

		String inputName = "あいうえおかきくけこ";
		String msg = "";
		String errMsg = "名前は10桁以内で入力してください。<br />";
			
		RegInfCheck ric = new RegInfCheck();
		ric.checkName(inputName);
		System.out.println("UT001-002: "+ric.getErrMsg());
		assertEquals( "想定外の",msg,ric.getErrMsg());			
	}
	
	@Test
	public void testCheckName_3() {

		String inputName = "01234567890";
		String msg = "";
		String errMsg = "名前は10桁以内で入力してください。<br />";
			
		RegInfCheck ric = new RegInfCheck();
		ric.checkName(inputName);
		System.out.println("UT001-003: "+ric.getErrMsg());
		assertEquals("エラーメッセージ:"+ric.getErrMsg(),errMsg,ric.getErrMsg());			
	}
	
	@Test
	public void testCheckName_4() {

		String inputName = "あいうえおかきくけこさ";
		String msg = "";
		String errMsg = "名前は10桁以内で入力してください。<br />";
			
		RegInfCheck ric = new RegInfCheck();
		ric.checkName(inputName);
		System.out.println("UT001-004: "+ric.getErrMsg());
		assertEquals("エラーメッセージ:"+ric.getErrMsg(),errMsg,ric.getErrMsg());				
	}
	
	@Test
	public void testCheckAge_1() {
		String inputAge = "16";
		String msg = "";
		String errMsg = "年齢は(16-60)の範囲で入力してください。<br />";
		RegInfCheck ric = new RegInfCheck();
		ric.checkAge(inputAge);
		System.out.println("UT001-005: "+ric.getErrMsg());
		assertEquals("エラーメッセージ:"+ric.getErrMsg(),msg,ric.getErrMsg());		
	}
	
	@Test
	public void testCheckAge_2() {
		String inputAge = "60";
		String msg = "";
		String errMsg = "年齢は(16-60)の範囲で入力してください。<br />";
		RegInfCheck ric = new RegInfCheck();
		ric.checkAge(inputAge);
		System.out.println("UT001-006: "+ric.getErrMsg());
		assertEquals("エラーメッセージ:"+ric.getErrMsg(),msg,ric.getErrMsg());	
	}
	
	@Test
	public void testCheckAge_3() {
		String inputAge = "15";
		String msg = "";
		String errMsg = "年齢は(16-60)の範囲で入力してください。<br />";
		RegInfCheck ric = new RegInfCheck();
		ric.checkAge(inputAge);
		System.out.println("UT001-007: "+ric.getErrMsg());
		assertEquals("エラーメッセージ:"+ric.getErrMsg(),errMsg,ric.getErrMsg());	
	}
	
	@Test
	public void testCheckAge_4() {
		String inputAge = "61";
		String msg = "";
		String errMsg = "年齢は(16-60)の範囲で入力してください。<br />";
		RegInfCheck ric = new RegInfCheck();
		ric.checkAge(inputAge);
		System.out.println("UT001-008: "+ric.getErrMsg());
		assertEquals("エラーメッセージ:"+ric.getErrMsg(),errMsg,ric.getErrMsg());	
	}
	
	@Test
	public void testCheckAge_5() {
		String inputAge = "１６";
		String msg = "";
		String errMsg = "年齢は数値(半角)で入力してください。<br />";
		RegInfCheck ric = new RegInfCheck();
		ric.checkAge(inputAge);
		System.out.println("UT001-009: "+ric.getErrMsg());
		assertEquals("エラーメッセージ:"+ric.getErrMsg(),errMsg,ric.getErrMsg());	
	}
	
	@Test
	public void testCheckAge_6() {
		String inputAge = "あいうえお";
		String msg = "";
		String errMsg = "年齢は数値(半角)で入力してください。<br />年齢は(16-60)の範囲で入力してください。<br />";
		RegInfCheck ric = new RegInfCheck();
		ric.checkAge(inputAge);
		System.out.println("UT001-010: "+ric.getErrMsg());
		assertEquals("エラーメッセージ:"+ric.getErrMsg(),errMsg,ric.getErrMsg());		
	}
	
	@Test
	public void testCheckAge_7() {
		String inputAge = "16あいうえお";
		String msg = "";
		String errMsg = "年齢は数値(半角)で入力してください。<br />年齢は(16-60)の範囲で入力してください。<br />";
		RegInfCheck ric = new RegInfCheck();
		ric.checkAge(inputAge);
		System.out.println("UT001-011: "+ric.getErrMsg());
		assertEquals("エラーメッセージ:"+ric.getErrMsg(),errMsg,ric.getErrMsg());		
	}

	@Test
	public void testCheckId_1() {
		String inputId = "999";
		String msg = "";
		String errMsg = "登録可能なID（999）を超えています。管理者に問い合わせてください。<br />";
		RegInfCheck ric = new RegInfCheck();
		ric.checkId(inputId);
		System.out.println("UT001-012: "+ric.getErrMsg());
		assertEquals("エラーメッセージ:"+ric.getErrMsg(),msg,ric.getErrMsg());		
	}
	
	@Test
	public void testCheckId_2() {
		String inputId = "1000";
		String msg = "";
		String errMsg = "登録可能なID（999）を超えています。管理者に問い合わせてください。<br />";
		RegInfCheck ric = new RegInfCheck();
		ric.checkId(inputId);
		System.out.println("UT001-013: "+ric.getErrMsg());
		assertEquals("エラーメッセージ:"+ric.getErrMsg(),errMsg,ric.getErrMsg());		
	}

}
