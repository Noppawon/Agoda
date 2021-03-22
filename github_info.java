import java.net.URL;
import java.util.Scanner;

import RepositoryService;
import RepositoryIssue;
import Repository;
import GitHubClient;

import java.util.ArrayList;
import java.util.List;

public class github_info {
        
        /*public URL getIssue(URL url) {
            return "https://api.github.com/"
        }*/
        private static String  github_url = "https://api.github.com";
        private static String github_api = "search/issues";
       
        /*@param issues
        @param pullRequests
        @return a new list of issues*/

        public static List<TurboIssue> combineWithPullRequests(List<TurboIssue> issues,
                                                       List<PullRequest> pullRequests) {
        List<TurboIssue> issuesCopy = new ArrayList<>(issues);

        for (PullRequest pullRequest : pullRequests) {
        int id = pullRequest.getNumber();

        Optional<Integer> corresponding = findIssueWithId(issuesCopy, id);
        if (corresponding.isPresent()) {
            TurboIssue issue = issuesCopy.get(corresponding.get());
            issuesCopy.set(corresponding.get(), issue.combineWithPullRequest(pullRequest));
        } else {
            String errorMsg = "No corresponding issue for pull request " + pullRequest;
            logger.error(errorMsg);
        }
    }

    return issuesCopy;
}
        
        public static void main(String[] args) {
            String username = "noppawon";
            String password = "Harrytoey26";
            
            ArrayList pull_requeList = new ArrayList<String>();

            System.out.println("Enter the respository name (format: owner/respository):");
            Scanner respo_input = new Scanner(System.in);
            String respo_name = respo_input.nextLine();
            String[] respo_split = respo_name.split("//");
            //String owner = respo_split[0];
            //Stirng respo = respo_split[1];

            System.out.println("Enter the information type (pull-request, issues):");
            Scanner type_info_input = new Scanner(System.in);
            String type_info = type_info_input.nextLine();

            GitHubClient client = new GitHubClient();
            client.setCredentials(username, password);

            RepositoryService issue = new RepositoryService();
            Repository openmrs = null;
            

            
        }
}
