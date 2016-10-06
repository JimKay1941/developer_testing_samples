package chapter14.searchengine

import spock.lang.Specification

/**
 * Tests from the TDD session using Spock.
 */
class SearchEngineSpecification extends Specification {

    private SearchEngine searchEngine;

    def setup() {
        searchEngine = new SearchEngine();
    }

    def "searching when no documents are indexed gives nothing"() {
        expect:
        searchEngine.find("fox") == []
    }

    def "searching for a document's only word gives that document's id"() {
        setup:
        searchEngine.addToIndex(1, "fox")
        expect:
        searchEngine.find("fox") == [1]
    }

    def "all indexed documents are searched"() {
        setup:
        searchEngine.addToIndex(1, "fox")
        searchEngine.addToIndex(2, "dog")
        expect:
        searchEngine.find("dog") == [2]
    }

    def "documents may contain more than one word"() {
        setup:
        searchEngine.addToIndex(1, "the quick brown fox")
        expect:
        searchEngine.find(word) == [documentId]

        // Slightly more strict than the JUnit version.
        where:
        word << ["the", "quick", "brown", "fox"]
        documentId << [1, 1, 1, 1]
    }

    def "searching for a word that matches two documents gives bo tdhocuments' ids"() {
        setup:
        searchEngine.addToIndex(1, "fox")
        searchEngine.addToIndex(2, "fox")
        expect:
        searchEngine.find("fox").sort() == [1, 2]
    }

    def "multiple matches in a document produce one match"() {
        setup:
        searchEngine.addToIndex(1,
                "the quick brown fox jumped over the lazy dog")
        expect:
        searchEngine.find("the") == [1]
    }

    def "documents are sorted by word frequency"() {
        setup:
        searchEngine.addToIndex(1, "fox fox dog")
        searchEngine.addToIndex(2, "fox fox fox")
        searchEngine.addToIndex(3, "dog fox dog")
        expect:
        searchEngine.find("fox") == [2, 1, 3]
        searchEngine.find("dog") == [3, 1]
    }

    def "case doesn't matter"() {
        setup:
        searchEngine.addToIndex(1, "FOX fox FoX");
        searchEngine.addToIndex(2, "foX FOx");
        searchEngine.addToIndex(3, "FoX");
        expect:
        searchEngine.find("fox") == [1, 2, 3]
        searchEngine.find("FOX") == [1, 2, 3]
    }

    def "punctuation marks are ignored"() {
        setup:
        searchEngine.addToIndex(1, "quick, quick: quick.");
        searchEngine.addToIndex(2, "(brown) [brown] \"brown\" 'brown'");
        searchEngine.addToIndex(3, "fox; -fox fox? fox!");
        expect:
        searchEngine.find("quick") == [1]
        searchEngine.find("brown") == [2]
        searchEngine.find("fox") == [3]
    }
}
