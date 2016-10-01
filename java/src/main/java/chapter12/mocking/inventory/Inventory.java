package chapter12.mocking.inventory;

/**
 * The purpose of this class is to simulate a repository. It's "production code" from the
 * perspective of the examples that use it, but it's actually a stub :)
 */
public class Inventory {

    // This method simulates a repository method that would look in some kind
    // of persistent storage.
    public static Book getBookByTitle(String title) {
        switch (title) {
            case "Developer Testing":
                return new Book("Developer Testing", 20);
            case "TDD from scratch":
                return new Book("TDD from scratch", 15);
            case "Refactoring":
                return new Book("Refactoring", 30);
            default:
                throw new IllegalArgumentException(String
                        .format("Can't find book with title '%s'", title));
        }
    }

    public static Training getTraining(String name) {
        return new Training("TDD for Dummies", 999);
    }
}