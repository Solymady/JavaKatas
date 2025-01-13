package katas.exercises;

//import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class GitHubRepoActivityIntensity { /**

    private static final String GITHUB_API_BASE_URL = "https://api.github.com/repos";
    private final HttpClient httpClient;

    public GitHubRepoActivityIntensity(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public List<Instant> fetchCommitTimestamps(String owner, String repo) throws Exception {
        List<Instant> timestamps = new ArrayList<>();
        int page = 1;
        boolean hasMoreCommits = true;

        while (hasMoreCommits) {
            String urlStr = String.format("%s/%s/%s/commits?page=%d", GITHUB_API_BASE_URL, owner, repo, page);
            URL url = new URL(urlStr);

            try (InputStream inputStream = httpClient.get(url);
                 BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }

                JSONArray commits = new JSONArray(response.toString());
                if (commits.length() == 0) {
                    hasMoreCommits = false;
                } else {
                    for (int i = 0; i < commits.length(); i++) {
                        String timestamp = commits.getJSONObject(i)
                                .getJSONObject("commit")
                                .getJSONObject("committer")
                                .getString("date");
                        timestamps.add(Instant.parse(timestamp));
                    }
                    page++;
                }
            }
        }

        return timestamps;
    }

    public static double calculateAverageTimeBetweenCommits(List<Instant> timestamps) {
        if (timestamps.size() < 2) {
            return 0.0;
        }

        timestamps.sort(Instant::compareTo);
        long totalDuration = 0;

        for (int i = 1; i < timestamps.size(); i++) {
            totalDuration += Math.abs(Duration.between(timestamps.get(i - 1), timestamps.get(i)).toMillis());
        }

        double averageDuration = (double) totalDuration / (timestamps.size() - 1);
        return averageDuration / (1000 * 60 * 60); // Convert milliseconds to hours
    }

    public interface HttpClient {
        InputStream get(URL url) throws Exception;
    }

    public static class DefaultHttpClient implements HttpClient {
        private final String authToken;

        public DefaultHttpClient(String authToken) {
            this.authToken = authToken;
        }

        @Override
        public InputStream get(URL url) throws Exception {
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/vnd.github+json");

            // Add Authorization header with the token
            if (authToken != null && !authToken.isEmpty()) {
                conn.setRequestProperty("Authorization", "Bearer " + authToken);
            }

            if (conn.getResponseCode() != 200) {
                throw new Exception("Failed to fetch commits: HTTP error code " + conn.getResponseCode());
            }

            return conn.getInputStream();
        }
    }

    public static void main(String[] args) {
        try {
            String authToken = "your_personal_access_token_here"; // Replace with your GitHub token
            HttpClient httpClient = new DefaultHttpClient(authToken);
            GitHubRepoActivityIntensity gitHubRepoActivity = new GitHubRepoActivityIntensity(httpClient);

            List<Instant> timestamps = gitHubRepoActivity.fetchCommitTimestamps("torvalds", "linux");
            double avgTime = calculateAverageTimeBetweenCommits(timestamps);

            System.out.printf("The average time between commits in the repository is %.2f hours.%n", avgTime);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }**/
}
