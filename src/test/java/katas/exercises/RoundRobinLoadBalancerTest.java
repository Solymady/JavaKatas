package katas.exercises;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RoundRobinLoadBalancerTest {

    private RoundRobinLoadBalancer loadBalancer;

    @BeforeEach
    void setUp() {
        loadBalancer = new RoundRobinLoadBalancer();
    }

    @Test
    void testAddAndRouteRequest() {
        RoundRobinLoadBalancer.IP server1 = new RoundRobinLoadBalancer.IP("192.168.0.1");
        RoundRobinLoadBalancer.IP server2 = new RoundRobinLoadBalancer.IP("192.168.0.2");
        RoundRobinLoadBalancer.IP server3 = new RoundRobinLoadBalancer.IP("192.168.0.3");

        loadBalancer.addServer(server1);
        loadBalancer.addServer(server2);
        loadBalancer.addServer(server3);

        assertEquals(server1, loadBalancer.routeRequest());
        assertEquals(server2, loadBalancer.routeRequest());
        assertEquals(server3, loadBalancer.routeRequest());
        assertEquals(server1, loadBalancer.routeRequest()); // Back to the first server
    }

    @Test
    void testRemoveServer() {
        RoundRobinLoadBalancer.IP server1 = new RoundRobinLoadBalancer.IP("192.168.0.1");
        RoundRobinLoadBalancer.IP server2 = new RoundRobinLoadBalancer.IP("192.168.0.2");
        RoundRobinLoadBalancer.IP server3 = new RoundRobinLoadBalancer.IP("192.168.0.3");

        loadBalancer.addServer(server1);
        loadBalancer.addServer(server2);
        loadBalancer.addServer(server3);

        loadBalancer.removeServer(server2);

        assertEquals(server1, loadBalancer.routeRequest());
        assertEquals(server3, loadBalancer.routeRequest());
        assertEquals(server1, loadBalancer.routeRequest());
    }

    @Test
    void testNoServersAvailable() {
        assertNull(loadBalancer.routeRequest());
    }

    @Test
    void testDuplicateServerAddition() {
        RoundRobinLoadBalancer.IP server1 = new RoundRobinLoadBalancer.IP("192.168.0.1");

        loadBalancer.addServer(server1);
        loadBalancer.addServer(server1); // Adding the same server again

        assertEquals(server1, loadBalancer.routeRequest());
        assertEquals(server1, loadBalancer.routeRequest()); // Still routes to the same server
    }

    @Test
    void testEdgeCaseRemoveNonExistentServer() {
        RoundRobinLoadBalancer.IP server1 = new RoundRobinLoadBalancer.IP("192.168.0.1");
        RoundRobinLoadBalancer.IP server2 = new RoundRobinLoadBalancer.IP("192.168.0.2");

        loadBalancer.addServer(server1);
        loadBalancer.removeServer(server2); // Attempt to remove a non-existent server

        assertEquals(server1, loadBalancer.routeRequest());
    }

    @Test
    void testResetIndexAfterRemoval() {
        RoundRobinLoadBalancer.IP server1 = new RoundRobinLoadBalancer.IP("192.168.0.1");
        RoundRobinLoadBalancer.IP server2 = new RoundRobinLoadBalancer.IP("192.168.0.2");

        loadBalancer.addServer(server1);
        loadBalancer.addServer(server2);

        assertEquals(server1, loadBalancer.routeRequest());
        loadBalancer.removeServer(server2); // Remove second server
        assertEquals(server1, loadBalancer.routeRequest()); // Should still route correctly
    }
}
