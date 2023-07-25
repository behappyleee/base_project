import java.math.BigInteger;

public class FactorialThread extends Thread {

    private long inputNumber;
    private BigInteger result = BigInteger.ZERO;
    private boolean isFinished = false;

    public FactorialThread(long inputNumber) {
        this.inputNumber = inputNumber;
    }

    @Override
    public void run() {
        this.result = factorial(inputNumber);
        this.isFinished = true;
    }
    
    // Thread 가 스케줄링 되면 private 변수에 값을 저장
    // 결과 값이 너무 크면 Overflow 가능성이 있어 BigInteger 를 사용
    public BigInteger factorial(long n) {
        BigInteger tempResult = BigInteger.ONE;
        for(long i=n; i>0; i--) {
            tempResult = tempResult.multiply(new BigInteger(Long.toBinaryString(i)));
        }
        return tempResult;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public BigInteger getResult() {
        return result;
    }

}
