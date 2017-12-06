import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

public class CircularQueueTests {
    private CircularQueue<Integer> testQueue;

    @Before
    public void before(){
        testQueue = new CircularQueue<>();
    }
    @Test
    public void is_empty_when_created(){
        Assert.assertEquals(testQueue.isEmpty(), true);
    }

    @Test
    public void is_not_empty_when_item_added() {
        testQueue.enqueue(20);
        Assert.assertEquals(false, testQueue.isEmpty());
    }

    @Test
    public void can_enqueue_and_dequeue_in_FIFO_order() {
        testQueue.enqueue(10);
        testQueue.enqueue(4);
        testQueue.enqueue(6);
        Assert.assertEquals(10, (int)testQueue.dequeue());
        Assert.assertEquals(4, (int)testQueue.dequeue());
        Assert.assertEquals(6, (int)testQueue.dequeue());
        Assert.assertEquals(true, testQueue.isEmpty());
    }

    @Test(expected = NoSuchElementException.class)
    public void will_raise_an_exception_for_dequeue_when_empty() {
        testQueue.dequeue();
    }

    @Test
    public void can_peek_at_next_item_without_removing() {
        testQueue.enqueue(8);
        testQueue.enqueue(5);
        Assert.assertEquals(8, (int)testQueue.peek());
        Assert.assertEquals(8, (int)testQueue.dequeue());
    }

    @Test
    public void can_enqueue_and_dequeue_multiple_times() {
        testQueue.enqueue(1);
        testQueue.enqueue(2);
        Assert.assertEquals(1, (int)testQueue.dequeue());
        Assert.assertEquals(2, (int)testQueue.dequeue());
        Assert.assertEquals(true, testQueue.isEmpty());
        testQueue.enqueue(1);
        testQueue.enqueue(2);
        Assert.assertEquals(1, (int)testQueue.dequeue());
        Assert.assertEquals(2, (int)testQueue.dequeue());
        Assert.assertEquals(true, testQueue.isEmpty());
        testQueue.enqueue(1);
        testQueue.enqueue(2);
        Assert.assertEquals(1, (int)testQueue.dequeue());
        Assert.assertEquals(2, (int)testQueue.dequeue());
        Assert.assertEquals(true, testQueue.isEmpty());
    }

    @Test
    public void it_can_be_created_with_an_initial_capacity_and_will_be_empty() {
        CircularQueue<Integer> smallQueue = new CircularQueue<>(2);
        Assert.assertEquals(true, smallQueue.isEmpty());
    }

    @Test
    public void it_can_grow_beyond_its_initial_capacity() {
        CircularQueue<Integer> smallQueue = new CircularQueue<>(2);
        smallQueue.enqueue(3);
        smallQueue.enqueue(2);
        smallQueue.enqueue(1);
        Assert.assertEquals(3, (int)smallQueue.dequeue());
        Assert.assertEquals(2, (int)smallQueue.dequeue());
        Assert.assertEquals(1, (int)smallQueue.dequeue());
    }
}
