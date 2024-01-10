package thread.stack.heap;

public class ResourceShareThread {

    public static void main(String[] args) throws InterruptedException {

        // Thread 가 프로세스 내에서 공유할 수 있는 리소스
        // 아주 전형적인 멀티 스레드 소프트웨어 아키텍처 - 데이터 베이스와 소프트웨어 추상화 계층의 역할을 하는
        // 마이크로 서비스가 있음

        // 각 요청은 서로 다른 스레드로 처리가 되지만 결국 시간이 지난 요청은 데이터 베이스로 가거나
        // 아니면 데이터 베이스에서 오게 됨, 해당 데이터 베이스에 대한 연결은 하나의 객체 또는 객체 집합으로
        // 나타내는데 모든 요청 스레드 간에 공유가 됨

        InventoryCounter inventoryCounter = new InventoryCounter();
        IncrementingThread incrementingThread = new IncrementingThread(inventoryCounter);
        DecrementingThread decrementingThread = new DecrementingThread(inventoryCounter);

        incrementingThread.start();

        incrementingThread.join();

        decrementingThread.start();

        decrementingThread.join();
    }

    public static class DecrementingThread extends Thread {

        private InventoryCounter inventoryCounter;

        public DecrementingThread(InventoryCounter inventoryCounter) {
            this.inventoryCounter = inventoryCounter;
        }

        @Override
        public void run() {
            for(int i=0; i<10000; i++) {
                inventoryCounter.decrement();
            }
        }
    }


    public static class IncrementingThread extends Thread {

        private InventoryCounter inventoryCounter;

        public IncrementingThread(InventoryCounter inventoryCounter) {
            this.inventoryCounter = inventoryCounter;
        }

        @Override
        public void run() {
            for(int i=0; i<10000; i++) {
                inventoryCounter.increment();
            }
        }
    }

    // 간단한 전자 상거래 코드
    private static class InventoryCounter {
        private int items = 0;

        public void increment() {
            items++;
        }

        public void decrement() {
            items--;
        }

        public int getItems() {
            return items;
        }
    }


}
