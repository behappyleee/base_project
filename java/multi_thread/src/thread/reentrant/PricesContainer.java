package thread.reentrant;

public class PricesContainer {

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
