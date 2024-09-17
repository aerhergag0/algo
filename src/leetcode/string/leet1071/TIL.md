
- 직접 구현한 GCD, LCM
```java
public int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}

public int lcm(int x, int y) {
	return (x * y) / gcd(x, y);
}
```

- BigInteger를 이용한 방법
```java
BigInteger b1 = BigInteger.valueOf(a);
BigInteger b2 = BigInteger.valueOf(b);
int gcd = b1.gcd(b2).intValue();
int lcm = b1.multiply(b2).divide(b1.gcd(b2)).intValue(); // lcm = b1 * b2 / gcd(b1,b2)
```