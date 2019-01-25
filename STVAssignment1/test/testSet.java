import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class testSet {
    private Set setInstance;
    private int[] setInstanceArray;

    @BeforeEach
    public void setupSetInstance(){
        setInstance = new Set();
    }
    @Test
    public void checkIfNumberIsInsertedInEmptySet(){
        assertEquals(0, setInstance.toArray().length);
        setInstance.insert(3);
        setInstanceArray = setInstance.toArray();
        assertEquals(1, setInstanceArray.length);
        assertEquals(3, setInstanceArray[0]);
    }

    @Test
    public void checkIfNumberIsAddedAtTheEnd(){
        setInstance.insert(5);
        setInstance.insert(6);
        setInstance.insert(7);
        setInstanceArray = setInstance.toArray();
        assertEquals(3, setInstanceArray.length);
        assertEquals(5, setInstanceArray[0]);
        assertEquals(6, setInstanceArray[1]);
        assertEquals(7, setInstanceArray[2]);
    }

    @Test
    public void checkIfNumberIsAddedAtTheBeginning(){
        setInstance.insert(6);
        setInstance.insert(7);
        setInstance.insert(5);
        setInstanceArray = setInstance.toArray();
        assertEquals(3, setInstanceArray.length);
        assertEquals(5, setInstanceArray[0]);
        assertEquals(6, setInstanceArray[1]);
        assertEquals(7, setInstanceArray[2]);
    }

    @Test
    public void checkIfNumberIsInsertedInMiddle(){
        setInstance.insert(5);
        setInstance.insert(7);
        setInstance.insert(6);
        setInstanceArray = setInstance.toArray();
        assertEquals(3, setInstanceArray.length);
        assertEquals(5, setInstanceArray[0]);
        assertEquals(6, setInstanceArray[1]);
        assertEquals(7, setInstanceArray[2]);
    }

    @Test
    public void checkIfDuplicateElementIsNotAdded(){
        setInstance.insert(5);
        setInstance.insert(5);
        setInstanceArray = setInstance.toArray();
        assertEquals(1, setInstanceArray.length);
        assertEquals(5, setInstanceArray[0]);
    }

    @Test
    public void checkIfMemberOfEmptySet() {
        assertFalse(setInstance.member(2));
    }

    @Test
    public void checkIfFirstMemberOfSet() {
        setInstance.insert(1);
        setInstance.insert(2);
        setInstance.insert(3);
        assertTrue(setInstance.member(1));
    }

    @Test
    public void checkIfMiddleMemberOfSet() {
        setInstance.insert(1);
        setInstance.insert(2);
        setInstance.insert(3);
        assertTrue(setInstance.member(2));
    }

    @Test
    public void checkIfLastMemberOfSet() {
        setInstance.insert(1);
        setInstance.insert(2);
        setInstance.insert(3);
        assertTrue(setInstance.member(3));
    }

    @Test
    public void checkIfLessThanAllMemberOfSet() {
        setInstance.insert(4);
        setInstance.insert(7);
        setInstance.insert(10);
        assertFalse(setInstance.member(2));
    }

    @Test
    public void checkIfNotMemberOfSet() {
        setInstance.insert(4);
        setInstance.insert(7);
        setInstance.insert(10);
        assertFalse(setInstance.member(6));
    }

    @Test
    public void checkIfGreaterThanAllMemberOfSet() {
        setInstance.insert(4);
        setInstance.insert(7);
        setInstance.insert(10);
        assertFalse(setInstance.member(15));
    }

    @Test
    public void checkSectionOfTwoEmptySets() {
        Set testSectionSetInstance = new Set();
        setInstance.section(testSectionSetInstance);
        assertEquals(0,setInstance.toArray().length);
    }

    @Test
    public void checkSectionOfSetAndEmptySet() {
        setInstance.insert(1);
        setInstance.insert(3);
        setInstance.insert(5);
        setInstance.insert(11);

        Set testSectionSetInstance = new Set();
        setInstance.section(testSectionSetInstance);
        setInstanceArray = setInstance.toArray();

        assertEquals(4,setInstanceArray.length);
        assertEquals(1,setInstanceArray[0]);
        assertEquals(3,setInstanceArray[1]);
        assertEquals(5,setInstanceArray[2]);
        assertEquals(11,setInstanceArray[3]);
    }

    @Test
    public void checkSectionOfSetAndSubset() {
        setInstance.insert(1);
        setInstance.insert(3);
        setInstance.insert(6);
        setInstance.insert(9);
        setInstance.insert(11);

        Set testSectionSetInstance = new Set();
        testSectionSetInstance.insert(3);
        testSectionSetInstance.insert(9);

        setInstance.section(testSectionSetInstance);
        setInstanceArray = setInstance.toArray();

        assertEquals(3, setInstance.toArray().length);
        assertEquals(1,setInstanceArray[0]);
        assertEquals(6,setInstanceArray[1]);
        assertEquals(11,setInstanceArray[2]);
    }

    @Test
    public void checkSectionOfLargesetAndSmallset() {
        setInstance.insert(1);
        setInstance.insert(3);
        setInstance.insert(6);
        setInstance.insert(9);
        setInstance.insert(11);

        Set testSectionSetInstance = new Set();
        testSectionSetInstance.insert(3);
        testSectionSetInstance.insert(9);
        testSectionSetInstance.insert(10);

        setInstance.section(testSectionSetInstance);
        setInstanceArray = setInstance.toArray();

        assertEquals(3, setInstance.toArray().length);
        assertEquals(1,setInstanceArray[0]);
        assertEquals(6,setInstanceArray[1]);
        assertEquals(11,setInstanceArray[2]);
    }

    @Test
    public void checkSectionOfTwoExclusiveLargesetAndSmallset() {
        setInstance.insert(1);
        setInstance.insert(3);
        setInstance.insert(6);
        setInstance.insert(11);

        Set testSectionSetInstance = new Set();
        testSectionSetInstance.insert(4);
        testSectionSetInstance.insert(9);
        testSectionSetInstance.insert(10);

        setInstance.section(testSectionSetInstance);
        setInstanceArray = setInstance.toArray();

        assertEquals(4, setInstance.toArray().length);
        assertEquals(1,setInstanceArray[0]);
        assertEquals(3,setInstanceArray[1]);
        assertEquals(6,setInstanceArray[2]);
        assertEquals(11,setInstanceArray[3]);
    }

    @Test
    public void checkSectionOfEmptySetAndSet() {
        Set testSectionSetInstance = new Set();
        testSectionSetInstance.insert(4);
        testSectionSetInstance.insert(9);
        testSectionSetInstance.insert(10);

        setInstance.section(testSectionSetInstance);
        assertEquals(0,setInstance.toArray().length);
    }

    @Test
    public void checkSectionOfSubsetAndSet() {
        setInstance.insert(2);
        setInstance.insert(5);
        setInstance.insert(9);

        Set testSectionSetInstance = new Set();
        testSectionSetInstance.insert(1);
        testSectionSetInstance.insert(2);
        testSectionSetInstance.insert(5);
        testSectionSetInstance.insert(8);
        testSectionSetInstance.insert(9);

        setInstance.section(testSectionSetInstance);
        assertEquals(0,setInstance.toArray().length);
    }

    @Test
    public void checkSectionOfSmallsetAndLargeset() {
        setInstance.insert(2);
        setInstance.insert(5);
        setInstance.insert(10);

        Set testSectionSetInstance = new Set();
        testSectionSetInstance.insert(5);
        testSectionSetInstance.insert(7);
        testSectionSetInstance.insert(10);
        testSectionSetInstance.insert(12);
        testSectionSetInstance.insert(17);

        setInstance.section(testSectionSetInstance);
        setInstanceArray = setInstance.toArray();

        assertEquals(1,setInstanceArray.length);
        assertEquals(2, setInstanceArray[0]);
    }


    @Test
    public void checkSectionOfTwoExclusiveSmallsetAndLargeset() {
        setInstance.insert(2);
        setInstance.insert(7);
        setInstance.insert(15);

        Set testSectionSetInstance = new Set();
        testSectionSetInstance.insert(1);
        testSectionSetInstance.insert(4);
        testSectionSetInstance.insert(9);
        testSectionSetInstance.insert(12);
        testSectionSetInstance.insert(16);

        setInstance.section(testSectionSetInstance);
        setInstanceArray = setInstance.toArray();

        assertEquals(3,setInstanceArray.length);
        assertEquals(2,setInstanceArray[0]);
        assertEquals(7,setInstanceArray[1]);
        assertEquals(15,setInstanceArray[2]);
    }

    @Test
    public void checkSectionOfTwoEquivalentSets() {
        setInstance.insert(5);
        setInstance.insert(9);
        setInstance.insert(12);
        setInstance.insert(17);

        Set testSectionSetInstance = new Set();
        testSectionSetInstance.insert(5);
        testSectionSetInstance.insert(9);
        testSectionSetInstance.insert(12);
        testSectionSetInstance.insert(17);

        setInstance.section(testSectionSetInstance);
        assertEquals(0,setInstance.toArray().length);
    }

    @Test
    public void checkIfEmptySetHasNoArithmeticTriple(){
        assertFalse(setInstance.containsArithTriple());
    }

    @Test
    public void checkIfSetWithArithmeticTripleReturnsTrueWithContainsArithTriple(){
        setInstance.insert(1);
        setInstance.insert(2);
        setInstance.insert(4);
        setInstance.insert(6);
       assertTrue(setInstance.containsArithTriple());
    }

    @Test
    public void checkIfSetWithNoArithmeticTripleReturnsFalseWithContainsArithTriple(){
        setInstance.insert(1);
        setInstance.insert(2);
        setInstance.insert(4);
        setInstance.insert(7);
        assertTrue(setInstance.containsArithTriple());
    }

    @Test
    public void checkIfZeroInSetLeadsToWrongOutputInContainsTriple(){
        setInstance.insert(0);
        setInstance.insert(4);
        setInstance.insert(6);
        assertFalse(setInstance.containsArithTriple());
    }
}
