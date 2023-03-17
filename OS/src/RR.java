import java.util.Scanner;
public class RR
{
    public static void main(String [] args)
    {
        int n, quantum,count=0,temp,sq=0, BurstTime[], WaitingTime[], TurnaroundTime[], RemainingBurstTime[];
        float AverageWaitingTime =0, AverageTurnaroundTime =0;
        Scanner s=new Scanner(System.in);
        System.out.print("Enter the number of processes: ");
        n = s.nextInt();
        BurstTime = new int[n];
        WaitingTime = new int[n];
        TurnaroundTime = new int[n];
        RemainingBurstTime = new int[n];
        System.out.print("Enter the burst time of the process");
        System.out.println();
        for (int i=0;i<n;i++)
        {
            System.out.print("P"+i+" = ");
            BurstTime[i] = s.nextInt();
            RemainingBurstTime[i] = BurstTime[i];
        }
        System.out.print("Enter the quantum time: ");
        quantum = s.nextInt();
        while(true)
        {
            for (int i=0;i<n;i++)
            {
                temp = quantum;
                if(RemainingBurstTime[i] == 0)
                {
                    count++;
                    continue;
                }
                if(RemainingBurstTime[i]> quantum)
                    RemainingBurstTime[i]= RemainingBurstTime[i] - quantum;
                else
                if(RemainingBurstTime[i]>=0)
                {
                    temp = RemainingBurstTime[i];
                    RemainingBurstTime[i] = 0;
                }
                sq = sq + temp;
                TurnaroundTime[i] = sq;
            }
            if(n == count)
                break;
        }
        System.out.print("\nP#\t      BT\t       TT\t          WT\n");
        for(int i=0;i<n;i++)
        {
            WaitingTime[i]= TurnaroundTime[i]- BurstTime[i];
            AverageWaitingTime = AverageWaitingTime + WaitingTime[i];
            AverageTurnaroundTime = AverageTurnaroundTime + TurnaroundTime[i];
            System.out.print("\n "+(i+1)+"\t "+ BurstTime[i]+"\t\t "+ TurnaroundTime[i]+"\t\t "+ WaitingTime[i]+"\n");
        }
        AverageWaitingTime = AverageWaitingTime /n;
        AverageTurnaroundTime = AverageTurnaroundTime /n;
        System.out.println("\nAverage waiting Time = "+ AverageWaitingTime );
        System.out.println();
        System.out.println("Average turnaround time = "+ AverageTurnaroundTime);
    }
}