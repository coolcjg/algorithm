package chap08;

public class KMPmatch {
	
	static int kmpMatch(String txt, String pat) {
		int positionText = 1; //txt 커서
		int positionPattern = 0; //pat 커서
		int[] skip = new int[pat.length() +1]; //컨너뛰기 표
		
		//건너뛰기 표 만들기.
		skip[positionText] = 0;
		while(positionText != pat.length()) {
			if(pat.charAt(positionText) == pat.charAt(positionPattern)) {
				
				skip[++positionText] = ++positionPattern;
			}else if(positionPattern == 0) {
				
				skip[++positionText] = positionPattern;
			}else {
				
				positionPattern = skip[positionPattern];
			}
		
		}
		
		for(int i=0; i< skip.length; i++) {
			System.out.println(i + "  : " + skip[i]);
		}
		
		//검색
		positionText = positionPattern = 0;
		
		while(positionText != txt.length() && positionPattern != pat.length()) {
			if(txt.charAt(positionText) == pat.charAt(positionPattern)) {
				System.out.println("1");
				System.out.println("positionText" + positionText);
				System.out.println("positionPattern" + positionPattern);
				positionText++;
				positionPattern++;
				
			}else if( positionPattern ==0) {
				System.out.println("2");
				System.out.println("positionText" + positionText);
				System.out.println("positionPattern" + positionPattern);
				positionText++;
			}else {
				System.out.println("3");
				System.out.println("positionText" + positionText);
				System.out.println("positionPattern" + positionPattern);
				positionPattern = skip[positionPattern];
			}
		}
		
		if (positionPattern == pat.length())
			return positionText - positionPattern;
		return -1;

	}
	
	public static void main(String args[]) {
		int result =kmpMatch("ZABCABXACCADEFABCABD", "ABCABD");
		System.out.println("result : " + result);
	}

}
