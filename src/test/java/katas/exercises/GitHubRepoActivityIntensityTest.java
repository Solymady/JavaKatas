package katas.exercises;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Instant;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class GitHubRepoActivityIntensityTest {
/*
    @Test
    void testCalculateAverageTimeBetweenCommits() {
        // Arrange: Mock timestamps
        List<Instant> mockTimestamps = List.of(
                Instant.parse("2023-12-01T12:00:00Z"),
                Instant.parse("2023-12-01T14:00:00Z"),
                Instant.parse("2023-12-01T18:00:00Z"),
                Instant.parse("2023-12-02T06:00:00Z")
        );

        // Act: Calculate the average time between commits
        double averageTime = GitHubRepoActivityIntensity.calculateAverageTimeBetweenCommits(mockTimestamps);

        // Assert: Validate the average time in hours
        assertEquals(6.0, averageTime, 0.01, "Average time between commits should be 6.0 hours");
    }

    @Test
    void testFetchCommitTimestamps() throws Exception {
        // Arrange: Mock HttpURLConnection
        HttpURLConnection mockConnection = mock(HttpURLConnection.class);

        // Prepare mock API response JSON
        String mockResponse = """
            [
                {"commit": {"committer": {"date": "2023-12-01T12:00:00Z"}}},
                {"commit": {"committer": {"date": "2023-12-01T14:00:00Z"}}}
            ]
        """;

        InputStream inputStream = new ByteArrayInputStream(mockResponse.getBytes());
        when(mockConnection.getResponseCode()).thenReturn(200);
        when(mockConnection.getInputStream()).thenReturn(inputStream);

        // Mock URL behavior
        URL mockUrl = mock(URL.class);
        when(mockUrl.openConnection()).thenReturn(mockConnection);

        // Spy on GitHubRepoActivityIntensity to mock the createUrl method
        GitHubRepoActivityIntensity gitHubRepoActivity = spy(GitHubRepoActivityIntensity.class);
        doReturn(mockUrl).when(gitHubRepoActivity).createUrl(anyString());

        // Act: Fetch commit timestamps
        List<Instant> timestamps = gitHubRepoActivity.fetchCommitTimestamps("mockOwner", "mockRepo");

        // Assert: Validate the timestamps
        assertNotNull(timestamps, "Timestamps list should not be null");
        assertEquals(2, timestamps.size(), "There should be exactly 2 timestamps");
        assertEquals(Instant.parse("2023-12-01T12:00:00Z"), timestamps.get(0), "First timestamp should match");
        assertEquals(Instant.parse("2023-12-01T14:00:00Z"), timestamps.get(1), "Second timestamp should match");

        // Verify mock interactions
        verify(mockConnection).getResponseCode();
        verify(mockConnection).getInputStream();
    }*/
}
