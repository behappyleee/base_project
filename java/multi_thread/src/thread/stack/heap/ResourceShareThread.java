package thread.stack.heap;

public class ResourceShareThread {

    public static void main(String[] args) throws InterruptedException {
        // Thread 가 프로세스 내에서 공유할 수 있는 리소스
        // 아주 전형적인 멀티 스레드 소프트웨어 아키텍처 - 데이터 베이스와 소프트웨어 추상화 계층의 역할을 하는
        // 마이크로 서비스가 있음

        // 각 요청은 서로 다른 스레드로 처리가 되지만 결국 시간이 지난 요청은 데이터 베이스로 가거나
        // 아니면 데이터 베이스에서 오게 됨, 해당 데이터 베이스에 대한 연결은 하나의 객체 또는 객체 집합으로
        // 나타내는데 모든 요청 스레드 간에 공유가 됨

        // 각 스레드를 그냥 실행 시켰을 시 실행되는 순서는 스케줄링을 하는 방식에 따라 달라짐
        // 결국에 매번 다른 시나리오가 나오게 됨
        // 문제는 각 스레드가 스케줄링이 되는 동안 다른스레드는 어떤 작업을 하는지 전혀 모르게 됨

        // 스레드간 리소스를 공유하는게 정말 중요함, 동시에 멀티 스레드를 어플리케이션으로 작업할 때 생길 수 있는 문제들이 있음
        // 변수를 공유해서 서로 다른 스레드로 비원자적 작업을 동시에 수행하는 작업을 관찰해 볼 수 있음
        InventoryCounter inventoryCounter = new InventoryCounter();
        IncrementingThread incrementingThread = new IncrementingThread(inventoryCounter);
        DecrementingThread decrementingThread = new DecrementingThread(inventoryCounter);

        incrementingThread.start();
        decrementingThread.start();

        // incrementingThread.join();  // IncrementThread 작업이 끝날 떄 까지 기다림

        System.out.println("WE CURRENTLY HAVE ITEMS 1 : " + inventoryCounter.getItems() + " ITEMS");

        //incrementingThread.join();
        decrementingThread.join();

        // Thread 가 순서가 보장이 안되면 ... 값들이 계속 달라짐 ! static 변수의 값이 계속 달라 짐 .... !
        System.out.println("WE CURRENTLY HAVE ITEMS 2 : " + inventoryCounter.getItems() + " ITEMS");

        // Atomic Operation - 하나 또는 여러 개 집합의 작업, 나머지 시스템이 보기에는 한 번에 동시 실행 된 것 처럼 보이는 작업
        // 공유 된 객체라서 Items 멤버 변수 또한 두 스레드에서 공유 되고 액세스가 가능해짐 두번쨰 문제는 두 스레드가 increment 쓰레드와
        // decrement thread 가 동시에 실행되어 단일 작업이 아님 다시말해서 Atomic 작업이 아님

    }

    public static class DecrementingThread extends Thread {

        private InventoryCounter inventoryCounter;

        public DecrementingThread(InventoryCounter inventoryCounter) {
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


    public static class IncrementingThread extends Thread {
        // InventoryCounter 가 두 스레드로 모두 전달되는 공유 된 객체라서 item 멤버 변수 또한 두 객체사이에서 공유가 됨
        private InventoryCounter inventoryCounter;

        public IncrementingThread(InventoryCounter inventoryCounter) {
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
