package unit.user.parts;

import static org.junit.Assert.*;

import org.junit.Test;

import user.parts.RegInfCheck;

public class RegInfCheckTest {

	@Test
	public void testCheckName_1() {

		String inputName = "0123456789";
		String msg = "";
		String errMsg = "���O��10���ȓ��œ��͂��Ă��������B<br />";
			
		RegInfCheck ric = new RegInfCheck();
		ric.checkName(inputName);
		System.out.println("UT001-001: "+ric.getErrMsg());
		assertEquals( "�z��O�̃G���[",msg,ric.getErrMsg());			
	}

	@Test
	public void testCheckName_2() {

		String inputName = "��������������������";
		String msg = "";
		String errMsg = "���O��10���ȓ��œ��͂��Ă��������B<br />";
			
		RegInfCheck ric = new RegInfCheck();
		ric.checkName(inputName);
		System.out.println("UT001-002: "+ric.getErrMsg());
		assertEquals( "�z��O��",msg,ric.getErrMsg());			
	}
	
	@Test
	public void testCheckName_3() {

		String inputName = "01234567890";
		String msg = "";
		String errMsg = "���O��10���ȓ��œ��͂��Ă��������B<br />";
			
		RegInfCheck ric = new RegInfCheck();
		ric.checkName(inputName);
		System.out.println("UT001-003: "+ric.getErrMsg());
		assertEquals("�G���[���b�Z�[�W:"+ric.getErrMsg(),errMsg,ric.getErrMsg());			
	}
	
	@Test
	public void testCheckName_4() {

		String inputName = "����������������������";
		String msg = "";
		String errMsg = "���O��10���ȓ��œ��͂��Ă��������B<br />";
			
		RegInfCheck ric = new RegInfCheck();
		ric.checkName(inputName);
		System.out.println("UT001-004: "+ric.getErrMsg());
		assertEquals("�G���[���b�Z�[�W:"+ric.getErrMsg(),errMsg,ric.getErrMsg());				
	}
	
	@Test
	public void testCheckAge_1() {
		String inputAge = "16";
		String msg = "";
		String errMsg = "�N���(16-60)�͈̔͂œ��͂��Ă��������B<br />";
		RegInfCheck ric = new RegInfCheck();
		ric.checkAge(inputAge);
		System.out.println("UT001-005: "+ric.getErrMsg());
		assertEquals("�G���[���b�Z�[�W:"+ric.getErrMsg(),msg,ric.getErrMsg());		
	}
	
	@Test
	public void testCheckAge_2() {
		String inputAge = "60";
		String msg = "";
		String errMsg = "�N���(16-60)�͈̔͂œ��͂��Ă��������B<br />";
		RegInfCheck ric = new RegInfCheck();
		ric.checkAge(inputAge);
		System.out.println("UT001-006: "+ric.getErrMsg());
		assertEquals("�G���[���b�Z�[�W:"+ric.getErrMsg(),msg,ric.getErrMsg());	
	}
	
	@Test
	public void testCheckAge_3() {
		String inputAge = "15";
		String msg = "";
		String errMsg = "�N���(16-60)�͈̔͂œ��͂��Ă��������B<br />";
		RegInfCheck ric = new RegInfCheck();
		ric.checkAge(inputAge);
		System.out.println("UT001-007: "+ric.getErrMsg());
		assertEquals("�G���[���b�Z�[�W:"+ric.getErrMsg(),errMsg,ric.getErrMsg());	
	}
	
	@Test
	public void testCheckAge_4() {
		String inputAge = "61";
		String msg = "";
		String errMsg = "�N���(16-60)�͈̔͂œ��͂��Ă��������B<br />";
		RegInfCheck ric = new RegInfCheck();
		ric.checkAge(inputAge);
		System.out.println("UT001-008: "+ric.getErrMsg());
		assertEquals("�G���[���b�Z�[�W:"+ric.getErrMsg(),errMsg,ric.getErrMsg());	
	}
	
	@Test
	public void testCheckAge_5() {
		String inputAge = "�P�U";
		String msg = "";
		String errMsg = "�N��͐��l(���p)�œ��͂��Ă��������B<br />";
		RegInfCheck ric = new RegInfCheck();
		ric.checkAge(inputAge);
		System.out.println("UT001-009: "+ric.getErrMsg());
		assertEquals("�G���[���b�Z�[�W:"+ric.getErrMsg(),errMsg,ric.getErrMsg());	
	}
	
	@Test
	public void testCheckAge_6() {
		String inputAge = "����������";
		String msg = "";
		String errMsg = "�N��͐��l(���p)�œ��͂��Ă��������B<br />�N���(16-60)�͈̔͂œ��͂��Ă��������B<br />";
		RegInfCheck ric = new RegInfCheck();
		ric.checkAge(inputAge);
		System.out.println("UT001-010: "+ric.getErrMsg());
		assertEquals("�G���[���b�Z�[�W:"+ric.getErrMsg(),errMsg,ric.getErrMsg());		
	}
	
	@Test
	public void testCheckAge_7() {
		String inputAge = "16����������";
		String msg = "";
		String errMsg = "�N��͐��l(���p)�œ��͂��Ă��������B<br />�N���(16-60)�͈̔͂œ��͂��Ă��������B<br />";
		RegInfCheck ric = new RegInfCheck();
		ric.checkAge(inputAge);
		System.out.println("UT001-011: "+ric.getErrMsg());
		assertEquals("�G���[���b�Z�[�W:"+ric.getErrMsg(),errMsg,ric.getErrMsg());		
	}

	@Test
	public void testCheckId_1() {
		String inputId = "999";
		String msg = "";
		String errMsg = "�o�^�\��ID�i999�j�𒴂��Ă��܂��B�Ǘ��҂ɖ₢���킹�Ă��������B<br />";
		RegInfCheck ric = new RegInfCheck();
		ric.checkId(inputId);
		System.out.println("UT001-012: "+ric.getErrMsg());
		assertEquals("�G���[���b�Z�[�W:"+ric.getErrMsg(),msg,ric.getErrMsg());		
	}
	
	@Test
	public void testCheckId_2() {
		String inputId = "1000";
		String msg = "";
		String errMsg = "�o�^�\��ID�i999�j�𒴂��Ă��܂��B�Ǘ��҂ɖ₢���킹�Ă��������B<br />";
		RegInfCheck ric = new RegInfCheck();
		ric.checkId(inputId);
		System.out.println("UT001-013: "+ric.getErrMsg());
		assertEquals("�G���[���b�Z�[�W:"+ric.getErrMsg(),errMsg,ric.getErrMsg());		
	}

}
