import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import sun.reflect.annotation.ExceptionProxy;

public class StackTests {
    private BasicStack testStack;
    @Before
    public void setup(){
        testStack = new BasicStack();
    }

    @Test
    public void it_will_be_empty_when_created() {
        Assert.assertTrue(testStack.isEmpty());
    }

    @Test
    public void it_will_not_be_empty_when_an_item_has_been_pushed_onto_it() {
        testStack.push(1);
        Assert.assertFalse(testStack.isEmpty());
    }

    @Test
    public void it_will_allow_an_item_to_be_pushed_and_popped_from_the_stack(){
        testStack.push(1);
        int poppedItem = testStack.pop();
        Assert.assertEquals(1,poppedItem);
    }

    @Test
    public void it_will_pop_items_in_LIFO_order(){
        testStack.push(1);
        testStack.push(2);
        Assert.assertEquals(2, testStack.pop());
        Assert.assertEquals(1, testStack.pop());
    }

    @Test
    public void it_will_be_empty_when_all_items_have_been_removed() {
        testStack.push(1);
        testStack.push(2);
        testStack.pop();
        testStack.pop();
        Assert.assertTrue(testStack.isEmpty());
    }

    @Test(expected = DataAccessException.class)
    public void it_will_throw_an_exception_when_trying_to_pop_when_empty() {
        testStack.pop();
    }
}
