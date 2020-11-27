package bank.model;

public enum Currency {
    USD(28.00),
    EUR(33.50),
    UAH(1.00),
    CHF(30.70),
    GBP(37.00);

    private final Double course;

    Currency(Double course) {
        this.course = course;
    }

    public Double getCourse() {
        return this.course;
    }
}
