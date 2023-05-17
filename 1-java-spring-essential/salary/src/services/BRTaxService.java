package services;

public class BRTaxService extends TaxService {

    @Override
    public double tax (double amount) {
        return amount * 0.3;
    }
}
