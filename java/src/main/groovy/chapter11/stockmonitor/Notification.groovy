package chapter11.stockmonitor;

/**
 * Notification to send to a monitoring user.
 */
class Notification {
    String message
    String phoneNumber
    String email

    Notification(ContactInformation contactInformation, String message) {
        phoneNumber = contactInformation.phoneNumber
        email = contactInformation.email
        this.message = message
    }
}
