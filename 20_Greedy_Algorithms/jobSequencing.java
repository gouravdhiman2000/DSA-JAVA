import java.util.*;

public class jobSequencing {

    static class Job {
        int deadline;
        int profit;
        char id;

        Job(char i, int d, int p) {
            id = i;
            deadline = d;
            profit = p;
        }
    }

    public static void main(String[] args) {

        int jobsInfo[][] = {
            {4, 20},
            {1, 10},
            {1, 40},
            {1, 30}
        };

        ArrayList<Job> jobs = new ArrayList<>();

        char jobName = 'A';

        for(int i = 0; i < jobsInfo.length; i++) {
            jobs.add(new Job(jobName, jobsInfo[i][0], jobsInfo[i][1]));
            jobName++;
        }

        // Sort by profit (descending)
        Collections.sort(jobs, (a, b) -> b.profit - a.profit);

        ArrayList<Character> seq = new ArrayList<>();

        int time = 0;

        for(Job curr : jobs) {
            if(curr.deadline > time) {
                seq.add(curr.id);
                time++;
            }
        }

        System.out.println("Max jobs = " + seq.size());

        System.out.print("Job sequence: ");
        for(char job : seq) {
            System.out.print(job + " ");
        }
    }
}