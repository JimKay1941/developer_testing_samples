package chapter14.searchengine

import org.junit.Before
import org.junit.Test


/**
 * Tests from the TDD session using JUnit.
 */
class SearchEngineTest {

    private SearchEngine searchEngine;

    @Before
    public void setUp() {
        searchEngine = new SearchEngine();
    }

    @Test
    void searchingWhenNoDocumentsAreIndexedGivesNothing() {
        assert [] == searchEngine.find("fox")
    }

    @Test
    void searchingForADocumentsOnlyWordGivesThatDocumentsId() {
        searchEngine.addToIndex(1, "fox")
        assert [1] == searchEngine.find("fox")
    }

    @Test
    void allIndexedDocumentsAreSearched() {
        searchEngine.addToIndex(1, "fox")
        searchEngine.addToIndex(2, "dog")
        assert [2] == searchEngine.find("dog")
    }

    @Test
    void documentsMayContainMoreThanOneWord() {
        searchEngine.addToIndex(1, "the quick brown fox")
        assert [1] == searchEngine.find("brown")
        assert [1] == searchEngine.find("fox")
    }

    @Test
    void searchingForAWordThatMatchesTwoDocumentsGivesBothDocumentsIds ( ) {
        searchEngine.addToIndex(1, "fox")
        searchEngine.addToIndex(2, "fox")
        assert [1, 2] == searchEngine.find("fox").sort()
    }

    @Test
    void multipleMatchesInADocumentProduceOneMatch() {
        searchEngine.addToIndex(1,
                "the quick brown fox jumped over the lazy dog")
        assert [1] == searchEngine.find("the")
    }

    @Test
    void documentsAreSortedByWordFrequency() {
        searchEngine.addToIndex(1, "fox fox dog")
        searchEngine.addToIndex(2, "fox fox fox")
        searchEngine.addToIndex(3, "dog fox dog")
        assert [2, 1, 3] == searchEngine.find("fox")
        assert [3, 1] == searchEngine.find("dog")
    }

    @Test
    void caseDoesNotMatter() {
        searchEngine.addToIndex(1, "FOX fox FoX");
        searchEngine.addToIndex(2, "foX FOx");
        searchEngine.addToIndex(3, "FoX");
        assert [1, 2, 3] == searchEngine.find("fox")
        assert [1, 2, 3] == searchEngine.find("FOX")
    }

    @Test
    void punctuationMarksAreIgnored() {
        searchEngine.addToIndex(1, "quick, quick: quick.");
        searchEngine.addToIndex(2, "(brown) [brown] \"brown\" 'brown'");
        searchEngine.addToIndex(3, "fox; -fox fox? fox!");
        assert [1] == searchEngine.find("quick")
        assert [2] == searchEngine.find("brown")
        assert [3] == searchEngine.find("fox")
    }

}
