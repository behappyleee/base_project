package thread.reentrant;

import java.util.Objects;
import java.util.Random;

public class ReentrantLockThread {

    public static class PricesContainer {
        private double bitcoinPrice;
        private double ethemPrice;
        private double litercoinPrice;
        private double bitcoinCashPrice;
        private double ripplePrice;

        public double getBitcoinPrice() {
            return bitcoinPrice;
        }

        public void setBitcoinPrice(double bitcoinPrice) {
            this.bitcoinPrice = bitcoinPrice;
        }

        public double getEthemPrice() {
            return ethemPrice;
        }

        public void setEthemPrice(double ethemPrice) {
            this.ethemPrice = ethemPrice;
        }

        public double getLitercoinPrice() {
            return litercoinPrice;
        }

        public void setLitercoinPrice(double litercoinPrice) {
            this.litercoinPrice = litercoinPrice;
        }

        public double getBitcoinCashPrice() {
            return bitcoinCashPrice;
        }

        public void setBitcoinCashPrice(double bitcoinCashPrice) {
            this.bitcoinCashPrice = bitcoinCashPrice;
        }

        public double getRipplePrice() {
            return ripplePrice;
        }

        public void setRipplePrice(double ripplePrice) {
            this.ripplePrice = ripplePrice;
        }
    }

    public static class PriceUpdater extends Thread {
        private PricesContainer pricesContainer;
        private Random random = new Random();

        public PriceUpdater(PricesContainer pricesContainer) {
            this.pricesContainer = pricesContainer;
        }

        // 가격을 보는 사람은 모든 가격을 한 번에 볼 수 있어야 함
        // 비동기 처리가 필요 함 !
        @Override
        public void run() {
            while (true) {
                try {
                    // lock 필요 !
                    // pricesContainer
                    // 모든 field 값들을 불러온다 !
                    pricesContainer.getBitcoinPrice();
                    pricesContainer.getEthemPrice();
                    pricesContainer.getEthemPrice();
                } finally {
                        // un lock 필요
                    //    pricesContainer
                }
            }
        }
    }
}

