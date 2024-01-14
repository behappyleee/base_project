package thread.stack.heap;

public class ConcurrencyThread {

    // 두 개의 스레드가 하나의 카운터를 공유
    // 여러 개의 스레드로 인한 동시 실행 액세스로부터 임계 영역을 지켜주는
    // 다양한 도구를 갖추고 있음,

    public static void main(String[] args) throws InterruptedException {
        // synchronized 키워드는 Thread 1 개만 실행이 가능함, 다른 Thread 는 Block 상태가 됨

        // synchronized 키워드를 사용, Java 가 지원하는 synchronized 키워드를 사용하면
        // 여러 개의 스레드가 코드 블럭이나 전체 메서드에 액세스 할 수 없도록 설계 된 락킹 매커니즘
        InventoryCounter1 counter = new InventoryCounter1();
        IncrementingThread1 inc = new IncrementingThread1(counter);
        DecrementingThread1 dec = new DecrementingThread1(counter);

        inc.start();
        dec.start();

        inc.join();
        dec.join();

        System.out.println("We currently Have " + counter.getItems() + " items");
    }

    public static class DecrementingThread1 extends Thread {

        private InventoryCounter1 inventoryCounter;

        public DecrementingThread1(InventoryCounter1 inventoryCounter) {
            this.inventoryCounter = inventoryCounter;
        }

        @Override
        public void run() {
            for(int i=0; i<10000; i++) {
                if(i == 0) {
                    System.out.println("[START DECREMENT THREAD ] INDEX : " + i);
                };
                inventoryCounter.decrement();
                if(i == 9999) {
                    System.out.println("[END DECREMENT THREAD ] INDEX :  " + i);
                }
            }
        }
    }


    public static class IncrementingThread1 extends Thread {
        // InventoryCounter 가 두 스레드로 모두 전달되는 공유 된 객체라서 item 멤버 변수 또한 두 객체사이에서 공유가 됨
        private InventoryCounter1 inventoryCounter;

        public IncrementingThread1(InventoryCounter1 inventoryCounter) {
            this.inventoryCounter = inventoryCounter;
        }

        @Override
        public void run() {
            for(int i=0; i<10000; i++) {
                if(i == 0) {
                    System.out.println("[START INCREMENT THREAD ] INDEX : " + i);
                }
                inventoryCounter.increment();
                if(i == 9999) {
                    System.out.println("[END INCREMENT THREAD ] INDEX : " + i);
                }
            }
        }
    }

    // 간단한 전자 상거래 코드
    private static class InventoryCounter1 {
        private int items = 0;

        // 동기화 락이나 동기화 블록에서 중요한 점은 스레드는 자신이 임계영역 진입을 막지는 못 함
        Object lock = new Object();
        // synchronized keyword 를 사용
        // synchronized keyword 는 한번에 스레드 한개 씩 스레드를 임계점에 실행
        // synchronized 키워드를 사용하여 딱 그 영역데 대한 모든 블록은 해당 블록에서는 한개의 스레드만 실행을 허용
        // synchronized keyword 는 유연성을 높여 줌
        public synchronized void increment() {
            synchronized (this.lock) {
                items++;
            }
        }

        public synchronized void decrement() {
            synchronized (this.lock) {
                items--;
            }
        }

        public int getItems() {
            synchronized (lock) {
                return items;
            }
        }

    }

}
