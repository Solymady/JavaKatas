package katas.exercises;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class QueueWithFailoverTest {

    private QueueWithFailover queue;

    @BeforeEach
    void setUp() {
        queue = new QueueWithFailover(3); // Timeout of 3 seconds
    }

    @Test
    void testIsEmpty() {
        assertTrue(queue.isEmpty());

        queue.sendJob("Job 1");
        assertFalse(queue.isEmpty());
    }

    @Test
    void testSendAndGetJob() {
        queue.sendJob("Job 1");
        queue.sendJob("Job 2");

        assertEquals("Job 1", queue.getJob());
        assertEquals("Job 2", queue.getJob());
    }

    @Test
    void testJobDoneRemovesJob() {
        queue.sendJob("Job 1");
        String job = queue.getJob();

        queue.jobDone(job);

        assertEquals(0, queue.inFlightSize());
    }

    @Test
    void testJobTimeoutAndFailover() throws InterruptedException {
        queue.sendJob("Job 1");
        queue.sendJob("Job 2");

        String job = queue.getJob();
        Thread.sleep(4000); // Wait for the job to timeout

        queue.returnExpiredJobsToQueue();

        assertEquals(2, queue.size()); // Job 1 should be back in the queue
    }

    @Test
    void testExceptionOnEmptyQueue() {
        Exception exception = assertThrows(QueueWithFailover.EmptyQueueException.class, queue::getJob);
        assertEquals("The job queue is empty.", exception.getMessage());
    }

    @Test
    void testExceptionOnInvalidJobDone() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> queue.jobDone("Invalid Job"));
        assertTrue(exception.getMessage().contains("Job not found in hidden jobs"));
    }

    @Test
    void testInFlightSize() {
        queue.sendJob("Job 1");
        queue.getJob();

        assertEquals(1, queue.inFlightSize());
    }

    @Test
    void testReturnExpiredJobsToQueue() throws InterruptedException {
        queue.sendJob("Job 1");
        queue.sendJob("Job 2");
        String job = queue.getJob();

        Thread.sleep(4000); // Wait for the job to timeout
        queue.returnExpiredJobsToQueue();

        assertEquals(2, queue.size()); // Job 1 should be back in the queue
        assertFalse(queue.isEmpty());
        assertTrue(queue.inFlightSize() == 0); // No jobs should be in flight
    }
}
