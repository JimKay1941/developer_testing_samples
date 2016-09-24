package chapter17.service;


public class PaymentService {
    private PaymentRepository paymentRepository;

    public String checksum(Payment payment) {
        return "63347f5d946164a23faca26b78a91e1c";
    }

    public void setPaymentRepository(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment findPaymentByReferenceNumber(long referenceNumberWithChecksum) {
        return null;
    }
}
