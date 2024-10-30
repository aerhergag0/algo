package codes.string.leet1071;

public class Leet1071 {
	public String gcdOfStrings(String str1, String str2) {
		int gcdOfString = gcd(str1.length(), str2.length());
		String gcdStr1 = str1.substring(0, gcdOfString);
		String gcdStr2 = str2.substring(0, gcdOfString);

		if (gcdStr1.repeat(str1.length() / gcdOfString).equals(str1)
				&& gcdStr2.repeat(str2.length() / gcdOfString).equals(str2)
				&& gcdStr1.equals(gcdStr2)
		) {
			return gcdStr1;
		} else {
			return "";
		}
	}

	public int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}
}
