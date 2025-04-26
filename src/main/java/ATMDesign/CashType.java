package ATMDesign;

public enum CashType {
    BILL_100(100),
    BILL_50(50),
    BILL_20(20),
    BILL_10(10),
    BILL_5(5),
    BILL_1(1);
    public int value;
    CashType(int value) {
        this.value=value;
    }
}
