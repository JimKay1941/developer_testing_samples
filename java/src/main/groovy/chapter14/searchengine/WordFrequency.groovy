package chapter14.searchengine

/**
 * Class that holds a count of certain words for a document id.
 */
class WordFrequency {
    int documentId
    int count

    WordFrequency(int documentId) {
        this.documentId = documentId
    }
}