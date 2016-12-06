package hrs.client.util;

public class RegExpHelper {
	public static boolean matchUsernameAndPWD(String str){
		return str.matches("^[0-9A-Za-z]{6,}$");
	}
	public static void main(String[] args) {
		System.out.println(RegExpHelper.matchUsernameAndPWD("12siWSsa"));
	}
}
