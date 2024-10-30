# 태뷸레이션으로 구현한 피보나치

```java
int fibo(int k) {
    if (k <= 1) {
        return k;
    }

    int first = 1;
    int second = 0;
    int result = 0;

    for (int i = 1; i < k; i++) {
        result = first + second;
        second = first;
        first = result;
    }

    return result;
}
```