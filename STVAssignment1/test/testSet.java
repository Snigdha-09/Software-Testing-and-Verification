import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class testSet {
    private Set setInstance;
    private int[] setInstanceArray;

    @BeforeEach
    public void setupSetInstance(){
        setInstance = new Set();
    }
    @Test
    public void checkIfNumberIsInsertedInEmptySet(){
        Assertions.assertEquals(0, setInstance.toArray().length);
        setInstance.insert(3);
        setInstanceArray = setInstance.toArray();
        Assertions.assertEquals(1, setInstanceArray.length);
        Assertions.assertEquals(3, setInstanceArray[0]);
    }

    @Test
    public void checkIfNumberIsAddedAtTheEnd(){
        setInstance.insert(5);
        setInstance.insert(6);
        setInstance.insert(7);
        setInstanceArray = setInstance.toArray();
        Assertions.assertEquals(3, setInstanceArray.length);
        Assertions.assertEquals(5, setInstanceArray[0]);
        Assertions.assertEquals(6, setInstanceArray[1]);
        Assertions.assertEquals(7, setInstanceArray[2]);
    }

    @Test
    public void checkIfNumberIsAddedAtTheBeginning(){
        setInstance.insert(6);
        setInstance.insert(7);
        setInstance.insert(5);
        setInstanceArray = setInstance.toArray();
        Assertions.assertEquals(3, setInstanceArray.length);
        Assertions.assertEquals(5, setInstanceArray[0]);
        Assertions.assertEquals(6, setInstanceArray[1]);
        Assertions.assertEquals(7, setInstanceArray[2]);
    }

    @Test
    public void checkIfNumberIsInsertedInMiddle(){
        setInstance.insert(5);
        setInstance.insert(7);
        setInstance.insert(6);
        setInstanceArray = setInstance.toArray();
        Assertions.assertEquals(3, setInstanceArray.length);
        Assertions.assertEquals(5, setInstanceArray[0]);
        Assertions.assertEquals(6, setInstanceArray[1]);
        Assertions.assertEquals(7, setInstanceArray[2]);
    }

    @Test
    public void checkIfDuplicateElementIsNotAdded(){
        setInstance.insert(5);
        setInstance.insert(5);
        setInstanceArray = setInstance.toArray();
        Assertions.assertEquals(1, setInstanceArray.length);
        Assertions.assertEquals(5, setInstanceArray[0]);
    }

    @Test
    public void checkIfEmptySetHasNoArithmeticTriple(){
        Assertions.assertFalse(setInstance.containsArithTriple());
    }

    @Test
    public void checkIfSetWithArithmeticTripleReturnsTrueWithContainsArithTriple(){
        setInstance.insert(1);
        setInstance.insert(2);
        setInstance.insert(4);
        setInstance.insert(6);
        Assertions.assertTrue(setInstance.containsArithTriple());
    }

    @Test
    public void checkIfSetWithNoArithmeticTripleReturnsFalseWithContainsArithTriple(){
        setInstance.insert(1);
        setInstance.insert(2);
        setInstance.insert(4);
        setInstance.insert(7);
        Assertions.assertTrue(setInstance.containsArithTriple());
    }

    @Test
    public void checkIfZeroInSetLeadsToWrongOutputInContainsTriple(){
        setInstance.insert(0);
        setInstance.insert(4);
        setInstance.insert(6);
        Assertions.assertFalse(setInstance.containsArithTriple());
    }
}
