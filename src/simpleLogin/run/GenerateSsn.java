package simpleLogin.run;

import java.util.Arrays;
import java.util.Random;

public class GenerateSsn {
	
	public static String generate() {
		/*-- '880101-1234567'
		-- �� �ڸ��� ������ ���� ����
		--  234567 892345
		-- ������ �ֹι�ȣ ���ڸ��� ���� ��
		-- �� �ڸ��� ����� �� ���� �� 11�� ���� �������� ����
		-- �� ����� 11���� ����
		-- �� ����� 10���� ���� �������� ����
		-- ���� ������� �ֹι�ȣ �������ڸ��� ������ ��ȿ
		-- ���� ������ ��ȿ*/
		
		Random r = new Random();
		
		int[] arrSsn = new int[13];
		int[] validVal = new int[12];
		int sumVal = 0;
		int j = 2;
		for(int i=0; i<12; i++) {
			arrSsn[i] = r.nextInt(10);
			
			if(j > 9) {
				j = 2;
			}
			
			validVal[i] = arrSsn[i]*j;
			j++;
			sumVal += validVal[i];
		}
		
		arrSsn[12] = (11 - (sumVal%11))%10;

		StringBuilder ssn = new StringBuilder();
		for(int i=0; i<arrSsn.length; i++) {
			if (i == 6) {
				ssn.append("-");
			}
			ssn.append(arrSsn[i]);
		}
		return ssn.toString();
	}
	
	public static void main(String[] args) {
		for(int i=0; i<5; i++) {
			System.out.println(GenerateSsn.generate());
		}
	}

}
