import java.util.Scanner;
public class SJF {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of processes");
        int n = scanner.nextInt();
        int [] BurstTime = new int[n];
        int [] ArrivalTime = new int[n];
        int [] WaitingTime = new int[n];
        int [] TurnaroundTime = new int[n];
        int [] isCompleted = new int[n];
        int CurrentTime=0;
        int CompletedProcesses=0;

        for (int i=0; i<n; i++){
            System.out.println("Enter Arrival Time and Burst Time for process " + (i+1) +": ");
            ArrivalTime[i] = scanner.nextInt();
            BurstTime[i] = scanner.nextInt();
            isCompleted[i] = 0;
        }

        System.out.println("Scheduling Order: ");
        while (true){
            int ShortestBt = Integer.MAX_VALUE;
            int ShortestBTIndex = -1;
            if (CompletedProcesses == n)
                break;
            for (int i=0; i<n; i++){
                if (ArrivalTime[i] <= CurrentTime && BurstTime[i] < ShortestBt && isCompleted[i]==0 )
                {
                    ShortestBt = BurstTime[i];
                    ShortestBTIndex = i;
                }
            }

            if (ShortestBTIndex == -1){
                CurrentTime++;
            }
            else {
                System.out.print("P" + (ShortestBTIndex+1) + " | ");
                WaitingTime[ShortestBTIndex] = CurrentTime - ArrivalTime[ShortestBTIndex];
                TurnaroundTime[ShortestBTIndex] = WaitingTime[ShortestBTIndex] + BurstTime[ShortestBTIndex];
                isCompleted[ShortestBTIndex] = 1;
                CurrentTime += BurstTime[ShortestBTIndex];
                CompletedProcesses++;
            }

        }

        double TotalWT = 0;
        double TotalTT = 0;
        for (int i=0; i<n; i++){
            TotalWT += WaitingTime[i];
            TotalTT += TurnaroundTime[i];
        }

        System.out.println();
        System.out.println("#" + "\t" + "WT" + "\t" + "TT");
        for (int i=0; i<n; i++){
            System.out.println("P" + (i+1) + "\t" + WaitingTime[i] + "\t" + TurnaroundTime[i] );
        }

        System.out.println("Average Waiting Time: " + (TotalWT/n));
        System.out.println("Average Turnaround Time: " + (TotalTT/n));
    }
}