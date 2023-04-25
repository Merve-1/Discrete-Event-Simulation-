package system.modelinggg;
import java.util.*;



public class SystemModelinggg {
    static void function1(){
        //Service static array---------------------------------------------------------------------
        int Service[] = {3,4,2,3,4,5,2,2,3,4};
        //InterArrival static array----------------------------------------------------------------
        int InterArrival[] = {0,4,2,3,2,3,3,4,2,1};
        //Arrival generated array------------------------------------------------------------------
        int [] Arrival = new int [InterArrival.length];
        int NumberOfArrival = 0;
        for(int i = 1; i <InterArrival.length;i++){
        
            NumberOfArrival = NumberOfArrival + InterArrival[i];
            Arrival[i] = NumberOfArrival;
        
        }
        //Begin generated array-------------------------------------------------------------------
        int [] BeginService = new int [InterArrival.length];
        //end generated array---------------------------------------------------------------------
        int [] EndService = new int [InterArrival.length];
        int End =0;
        BeginService[0] = 0;
        for (int i =1 ; i <InterArrival.length;i++){
            //variable stores the addition of service and begin service
            End = Service[i-1]+BeginService[i-1];
            EndService[i-1] = End;
            //check if the end is samller than the arraivel
            if (End < Arrival[i]){
                BeginService[i] = Arrival[i];
            }
            //if not add the end of the previous service to the begin serive of the next customer
            else{
                BeginService[i] = End;
            }
            
        }
        
        End = Service[InterArrival.length-1]+BeginService[InterArrival.length-1];
        EndService[InterArrival.length-1]= End;
        
        
        //System generated array--------------------------------------------------------------------
        int [] SystemEqu = new int [InterArrival.length];
        for(int i = 0; i<InterArrival.length;i++){
            int systemeq = EndService[i] - Arrival[i];
            SystemEqu[i] = systemeq;
        }
        //Wainting generated array------------------------------------------------------------------
        
        int [] Waiting = new int [InterArrival.length];
        for(int i = 0;i<InterArrival.length;i++){
            int wait = BeginService[i] - Arrival[i];
            Waiting[i]= wait;
        }
        //Idle generated array----------------------------------------------------------------------
        
        int[] Idle = new int [InterArrival.length];
        for(int i = 1; i < InterArrival.length;i++){
            
            int idle = Arrival[i]-EndService[i-1];
            if(idle>0){
                Idle[i]= idle;
            }
            else{
                Idle[i]=0;
            }
        }
        //Qlen generated array-----------------------------------------------------------------------
        
        int[] Qlen = new int [InterArrival.length];
        int Addition = 0;
        int checkk= 0;
        for(int i = 1; i<InterArrival.length ;i++){
            
           checkk = BeginService[i] - Arrival[i];
           if (checkk > 0){
               Addition = 1;
           }
           if(Arrival[i] < BeginService[i-1]){
               Addition = Addition+1;
           }
           Qlen[i] = Addition;
           Addition=0;
        }
        
        System.out.println("Service"+Arrays.toString(Service)+"\n"+"InterArrival"
        +Arrays.toString(InterArrival)+"\n"+"Arrival"+Arrays.toString(Arrival)+"\n"
        +"Begin Service"+Arrays.toString(BeginService)+"\n"+"End Service"+Arrays.toString(EndService)
        +"\n"+"System"+Arrays.toString(SystemEqu)+"\n"+"Wait"+Arrays.toString(Waiting)
        +"\n"+"Idle"+Arrays.toString(Idle)
        +"\n"+"Qlen"+Arrays.toString(Qlen));
    
    //AVERAGE--------------------------------------------------
    double NumberOfCustomers = InterArrival.length;

    //Average Waiting Time-------------------------------------
    
    int loop1 = 0;
    for(int i = 0;i<InterArrival.length;i++){
        loop1 = loop1 +Waiting[i];
    }
    double TotalTimeCustomerWaitInQueue = loop1;
    double AverageWaitingTime = TotalTimeCustomerWaitInQueue/NumberOfCustomers;
    
    
    //Propabability(wait)--------------------------------------
    int loop2 = 0;
    for(int i=0;i<InterArrival.length;i++){
       if(Waiting[i]>0){
           loop2++;
       }
    }
    double TotalNumberOfCustomersWhoWait = loop2;
    double ProbabilityWait = (TotalNumberOfCustomersWhoWait/NumberOfCustomers);
    
    //Probaility idle Server----------------------------------
    int loop3 = 0;
    for(int i = 0; i <InterArrival.length ; i++){
        loop3 = loop3 + Idle[i];
    
    }
    double TotalIdleTimeOfServer = loop3;
    
    int loop4 = 0;
    for(int i = 0; i<InterArrival.length;i++){
        loop4 = loop4 + SystemEqu[i];
    }
    double TotalRunTimeOfSimulation = loop4;
    double ProbabilityIdleServer = TotalIdleTimeOfServer / TotalRunTimeOfSimulation;
    
    //Average Service Time----------------------------------------------------
    int loop5 = 0;
    for(int i =0; i <InterArrival.length;i++){
        loop5 = loop5 + Service[i];
    }
    double TotalServiceTime = loop5;
    double AverageServiceTime = TotalServiceTime /NumberOfCustomers;
    
    //Average Time Between Arrivals-------------------------------------------
    int loop6 = 0;
    for(int i = 0; i<InterArrival.length;i++){
        loop6 = loop6 + InterArrival[i];    
    }
    double SumOfInterArrTime = loop6;
    double AverageTimeBetweenArrivals = SumOfInterArrTime / (NumberOfCustomers-1);
          
    
    //Average queue time-----------------------------------------------------------
        int loop7 = 0;
        for(int i =0; i <InterArrival.length;i++){
            loop7= loop7+Qlen[i];
            
        }
        double TotalNumberOfQueue = loop7;
        double AverageQueueTime = TotalNumberOfQueue / NumberOfCustomers;
    
    //Average Time customer spends in the system -------------------------------
    double AverageTimeCustomersSpendsInTheSystem = TotalRunTimeOfSimulation / NumberOfCustomers;
       
    //Average time customer spends in queue-------------------------------------
    double TotalTimeCustomersSpendInQueue = TotalTimeCustomerWaitInQueue / TotalNumberOfCustomersWhoWait;
    
    //Service Utilization-------------------------------------------------------
    double ServiceUtilization = TotalServiceTime / (TotalServiceTime+TotalIdleTimeOfServer);
    
    
    
        System.out.println("Average-----------------------------------------"
        +"\n"+"Average Waiting Time = "+TotalTimeCustomerWaitInQueue
        +"/"+NumberOfCustomers+" = "+AverageWaitingTime+"\n"+"Probability (wait) = "
        +TotalNumberOfCustomersWhoWait+"/"+NumberOfCustomers+" = "+ProbabilityWait+
        "\n"+"Probability Idle Server= "+TotalIdleTimeOfServer+"/"+TotalRunTimeOfSimulation+" = "
        +ProbabilityIdleServer+"\n"+"Average Service Time = "
        +TotalServiceTime+"/"+NumberOfCustomers+" = "+AverageServiceTime
        +"\n"+"Average Time Between Arrivals = "
        +SumOfInterArrTime+"/"+(NumberOfCustomers-1)+" = "+AverageTimeBetweenArrivals
        +"\n"+"Average Time Customers Spends In The System = "
        +TotalRunTimeOfSimulation+"/"+NumberOfCustomers+" = "+AverageTimeCustomersSpendsInTheSystem
        +"\n"+"Total Time Customers Spend In Queue = "
        +TotalTimeCustomerWaitInQueue+"/"+TotalNumberOfCustomersWhoWait+" = "+TotalTimeCustomersSpendInQueue
        +"\n"+"Service Utilization = "
        +TotalServiceTime+"/"+(TotalServiceTime+TotalIdleTimeOfServer)+" = "+ServiceUtilization
        +"\n"+"Average Queue Time = "
        +TotalNumberOfQueue+"/"+NumberOfCustomers+" = "+AverageQueueTime);
    
    }
    static void function2(){
    //Random Generator----------------------------------------------------------------------
    
        System.out.println("Random Generator--------------------------------------");
     
        Scanner sc = new Scanner(System.in);
        
        //Number of customers
        System.out.print("Enter The rate : ");
        
        int rate = sc.nextInt();
        //Array to carry the the interarrival time
        int [] interArrival = new int [6];    
        int counter1=0;
        for(int i = 1 ; i <6;i++){
            counter1 = counter1 + rate;
            interArrival[i]=counter1;
        }
        System.out.println("Time Between Arrivals (min)");
        System.out.println(Arrays.toString(interArrival));
        //Array to carry the service time
        int [] serviceTime = new int [4]; 
        int counter2 =0;
        for(int i = 0 ; i <4;i++){
            
            counter2 = counter2 + rate;
            serviceTime[i]=counter2;
        }
        System.out.println("The Service Time (min)");
        System.out.println(Arrays.toString(serviceTime));
        //Array to carry the probability of the service time
        double [] PserviceTime = new double [4];  
        // Array to carry the cdf of the service
        double [] cdfOfService = new double [4];   
        System.out.println("Enter the Probability of the service time 'Between 0 and 1'");
        double EqualOne = 0;
        //check if the probability is between 0 and 1
        for(int i = 0 ; i <4;i++){
            double numberA =sc.nextDouble();
            if(numberA>0 &&numberA<1){
                PserviceTime[i]=numberA;
                EqualOne = EqualOne + numberA;
                //Enter data to the array of cdfService
                cdfOfService[i]=EqualOne;
            }
            else{
                //if the number is not between the zero and one repeat entering the probability
                while(!(numberA >0 && numberA<1)){
                System.out.println("Please Enter the Probability between 0 and 1 ");
                numberA =sc.nextDouble();}
                PserviceTime[i]=numberA;
                
                EqualOne = EqualOne + numberA;
                cdfOfService[i]=EqualOne;

            } 
        }
        //check the sum of the probability equal 1 
        if(EqualOne == 1){
            System.out.println(Arrays.toString(PserviceTime));
            System.out.println(Arrays.toString(cdfOfService));

        }
        // if the sum of the probability not equal 1 terminate the program
        else{
            System.out.println("Error");
            System.exit(0);
        }
        
        //Array to carry the probability of the service time
        double [] PArrivalTime = new double [6];  
        double [] cdfOfInterArr = new double [6];   
        double EqualOne2 = 0;
        System.out.println("Enter the Probability of the time between Arrivals 'Between 0 and 1'");
        for(int i = 0 ; i <6;i++){
            //check the probability of the arrival time is it between 0 and 1 or not  
            double numberB =sc.nextDouble();
            if(numberB>0 &&numberB<1){
                PArrivalTime[i]=numberB;
                EqualOne2 = EqualOne2 + numberB;
                cdfOfInterArr[i]= EqualOne2;
            }
            else{
                //if not force the user to re-enter the the probability again
                while(!(numberB >0 && numberB<1)){
                System.out.println("Please Enter the Probability between 0 and 1 ");
                numberB =sc.nextDouble();}
                PArrivalTime[i]=numberB;
                EqualOne2 = EqualOne2 + numberB;
                //adding data to the array of cdfArrival
                cdfOfInterArr[i]=EqualOne2;
            }
        }
         if(EqualOne2 == 1){
             //check if the sum of the array is equal to one or not if ture print the array
            System.out.println(Arrays.toString(PArrivalTime));
            System.out.println(Arrays.toString(cdfOfInterArr));
        }
        else{
             // if not terminate the program
            System.out.println("Error");
            System.exit(0);
        }
        Random rand = new Random();
       //random for Service
        double [] RanddomService = new double[100];
        double container = 0;
        for(int i = 0;i<100;i++){
            container = rand.nextDouble();
            RanddomService[i]=container;
            
        }
        System.out.println(Arrays.toString(RanddomService));
        

        //random for InterArr---------------------------------

        double [] RanddomInterArr= new double[100];
        double container2 = 0;
        for(int i = 0;i<100;i++){
            container2 = rand.nextDouble();
            RanddomInterArr[i]=container2;
            
        }
        System.out.println(Arrays.toString(RanddomInterArr));
        
        int [] newService = new int[100];
        //The new Array of the service
        for(int i = 0; i<100;i++){
            if(RanddomService[i]<cdfOfService[0]){
                newService[i]= serviceTime[0];
            }
            else if(RanddomService[i]<cdfOfService[1]){
                newService[i]= serviceTime[1];
            }
            else if(RanddomService[i]<cdfOfService[2]){
                newService[i]= serviceTime[2];
            }
            else if(RanddomService[i]<cdfOfService[3]){
                newService[i]= serviceTime[3];
            }
            
            
        }
        System.out.println(Arrays.toString(newService));
        //The new Array of the interArrival
        int [] newInterArr = new int[100];
        for(int i = 0; i<100;i++){
            if(RanddomService[i]<cdfOfInterArr[0]){
                newInterArr[i]= interArrival[0];
            }
            else if(RanddomService[i]<cdfOfInterArr[1]){
                newInterArr[i]= interArrival[1];
            }
            else if(RanddomService[i]<cdfOfInterArr[2]){
                newInterArr[i]= interArrival[2];
            }
            else if(RanddomService[i]<cdfOfInterArr[3]){
                newInterArr[i]= interArrival[3];
            }
            else if(RanddomService[i]<cdfOfInterArr[4]){
                newInterArr[i]= interArrival[4];
            }
            else if(RanddomService[i]<cdfOfInterArr[5]){
                newInterArr[i]= interArrival[5];
            }
            
        }
        System.out.println(Arrays.toString(newInterArr));
        
        
        //Arrival generated array------------------------------------------------------------------
        int [] Arrival = new int [newInterArr.length];
        int NumberOfArrival = 0;
        for(int i = 1; i <newInterArr.length;i++){
        
            NumberOfArrival = NumberOfArrival + newInterArr[i];
            Arrival[i] = NumberOfArrival;
        
        }
        //Begin generated array-------------------------------------------------------------------
        int [] BeginService = new int [newInterArr.length];
        //end generated array---------------------------------------------------------------------
        int [] EndService = new int [newInterArr.length];
        int End =0;
        BeginService[0] = 0;
        for (int i =1 ; i <newInterArr.length;i++){
            //variable stores the addition of service and begin service
            End = newService[i-1]+BeginService[i-1];
            EndService[i-1] = End;
            //check if the end is samller than the arraivel
            if (End < Arrival[i]){
                BeginService[i] = Arrival[i];
            }
            //if not add the end of the previous service to the begin serive of the next customer
            else{
                BeginService[i] = End;
            }
            
        }
        
        End = newService[newInterArr.length-1]+BeginService[newInterArr.length-1];
        EndService[newInterArr.length-1]= End;
        
        
        //System generated array--------------------------------------------------------------------
        int [] SystemEqu = new int [newInterArr.length];
        for(int i = 0; i<newInterArr.length;i++){
            int systemeq = EndService[i] - Arrival[i];
            SystemEqu[i] = systemeq;
        }
        //Wainting generated array------------------------------------------------------------------
        
        int [] Waiting = new int [newInterArr.length];
        for(int i = 0;i<newInterArr.length;i++){
            int wait = BeginService[i] - Arrival[i];
            Waiting[i]= wait;
        }
        //Idle generated array----------------------------------------------------------------------
        
        int[] Idle = new int [newInterArr.length];
        for(int i = 1; i < newInterArr.length;i++){
            
            int idle = Arrival[i]-EndService[i-1];
            if(idle>0){
                Idle[i]= idle;
            }
            else{
                Idle[i]=0;
            }
        }
        //Qlen generated array-----------------------------------------------------------------------
        
        int[] Qlen = new int [newInterArr.length];
        int Addition = 0;
        int checkk= 0;
        for(int i = 1; i<newInterArr.length ;i++){
            
           checkk = BeginService[i] - Arrival[i];
           if (checkk > 0){
               Addition = 1;
           }
           if(Arrival[i] < BeginService[i-1]){
               Addition = Addition+1;
           }
           Qlen[i] = Addition;
           Addition=0;
        }
        
        System.out.println("Service"+Arrays.toString(newService)+"\n"+"InterArrival"
        +Arrays.toString(newInterArr)+"\n"+"Arrival"+Arrays.toString(Arrival)+"\n"
        +"Begin Service"+Arrays.toString(BeginService)+"\n"+"End Service"+Arrays.toString(EndService)
        +"\n"+"System"+Arrays.toString(SystemEqu)+"\n"+"Wait"+Arrays.toString(Waiting)
        +"\n"+"Idle"+Arrays.toString(Idle)
        +"\n"+"Qlen"+Arrays.toString(Qlen));
    
    //AVERAGE--------------------------------------------------
    double NumberOfCustomers = newInterArr.length;

    //Average Waiting Time-------------------------------------
    
    int loop1 = 0;
    for(int i = 0;i<newInterArr.length;i++){
        loop1 = loop1 +Waiting[i];
    }
    double TotalTimeCustomerWaitInQueue = loop1;
    double AverageWaitingTime = TotalTimeCustomerWaitInQueue/NumberOfCustomers;
    
    
    //Propabability(wait)--------------------------------------
    int loop2 = 0;
    for(int i=0;i<newInterArr.length;i++){
       if(Waiting[i]>0){
           loop2++;
       }
    }
    double TotalNumberOfCustomersWhoWait = loop2;
    double ProbabilityWait = (TotalNumberOfCustomersWhoWait/NumberOfCustomers);
    
    //Probaility idle Server----------------------------------
    int loop3 = 0;
    for(int i = 0; i <newInterArr.length ; i++){
        loop3 = loop3 + Idle[i];
    
    }
    double TotalIdleTimeOfServer = loop3;
    
    int loop4 = 0;
    for(int i = 0; i<newInterArr.length;i++){
        loop4 = loop4 + SystemEqu[i];
    }
    double TotalRunTimeOfSimulation = loop4;
    double ProbabilityIdleServer = TotalIdleTimeOfServer / TotalRunTimeOfSimulation;
    
    //Average Service Time----------------------------------------------------
    int loop5 = 0;
    for(int i =0; i <newInterArr.length;i++){
        loop5 = loop5 + newService[i];
    }
    double TotalServiceTime = loop5;
    double AverageServiceTime = TotalServiceTime /NumberOfCustomers;
    
    //Average Time Between Arrivals-------------------------------------------
    int loop6 = 0;
    for(int i = 0; i<newInterArr.length;i++){
        loop6 = loop6 + newInterArr[i];    
    }
    double SumOfInterArrTime = loop6;
    double AverageTimeBetweenArrivals = SumOfInterArrTime / (NumberOfCustomers-1);
    
    //Average queue time-----------------------------------------------------------
        int loop7 = 0;
        for(int i =0; i <newInterArr.length;i++){
            loop7= loop7+Qlen[i];
            
        }
        double TotalNumberOfQueue = loop7;
        double AverageQueueTime = TotalNumberOfQueue / NumberOfCustomers;
    
    
    
    //Average Time customer spends in the system -------------------------------
    double AverageTimeCustomersSpendsInTheSystem = TotalRunTimeOfSimulation / NumberOfCustomers;
       
    //Average time customer spends in queue-------------------------------------
    double TotalTimeCustomersSpendInQueue = TotalTimeCustomerWaitInQueue / TotalNumberOfCustomersWhoWait;
    
    //Service Utilization-------------------------------------------------------
    double ServiceUtilization = TotalServiceTime / (TotalServiceTime+TotalIdleTimeOfServer);
    
    
    
        System.out.println("Average-----------------------------------------"
        +"\n"+"Average Waiting Time = "+TotalTimeCustomerWaitInQueue
        +"/"+NumberOfCustomers+" = "+AverageWaitingTime+"\n"+"Probability (wait) = "
        +TotalNumberOfCustomersWhoWait+"/"+NumberOfCustomers+" = "+ProbabilityWait+
        "\n"+"Probability Idle Server= "+TotalIdleTimeOfServer+"/"+TotalRunTimeOfSimulation+" = "
        +ProbabilityIdleServer+"\n"+"Average Service Time = "
        +TotalServiceTime+"/"+NumberOfCustomers+" = "+AverageServiceTime
        +"\n"+"Average Time Between Arrivals = "
        +SumOfInterArrTime+"/"+(NumberOfCustomers-1)+" = "+AverageTimeBetweenArrivals
        +"\n"+"Average Time Customers Spends In The System = "
        +TotalRunTimeOfSimulation+"/"+NumberOfCustomers+" = "+AverageTimeCustomersSpendsInTheSystem
        +"\n"+"Total Time Customers Spend In Queue = "
        +TotalTimeCustomerWaitInQueue+"/"+TotalNumberOfCustomersWhoWait+" = "+TotalTimeCustomersSpendInQueue
        +"\n"+"Service Utilization = "
        +TotalServiceTime+"/"+(TotalServiceTime+TotalIdleTimeOfServer)+" = "+ServiceUtilization+"\n"
        +"Average Queue Time = "
        +TotalNumberOfQueue+"/"+NumberOfCustomers+" = "+AverageQueueTime);

        
    }
    
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("For Fixed Number Enter 1 For Random Number Enter 2 : ");
        int num = scan.nextInt();
        if (num==1){
        function1();}
        
        if (num==2){
        function2();}
       
    
    
    
    
    }
    
}
