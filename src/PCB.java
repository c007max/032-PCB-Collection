//	http://www.java2s.com/Tutorial/Java/0140__Collections/LinkedListClass.htm

import java.util.Comparator;
import java.util.LinkedList	;
import java.util.Random ;

public class PCB implements Comparable<PCB>
{
	private String 	PCB_state;
	private int		PCB_ID ;
	private String	pgmCounter;
	private int		CPU_used;
	private int		CPU_max;
	private int		CPU_left;
	private int		timeWaiting;
	private int		memBase ;
	private int		memLimit ;
	
	private static int	PCB__K;
	@SuppressWarnings("unused")
	private Random random__X ;
		
	// constructor methods
	// default constructor
		
	public PCB ()
	{
		Random random__X	= new Random();

		PCB__K		+= 1 ;	//=====>	Increment the static variable for Process ID
		PCB_state	= "Ready" ;
		PCB_ID		= PCB__K ; 
		pgmCounter	= "" ;
		CPU_used	= 0 ;
		CPU_max		= random__X.nextInt(50) + 1 ;	// Assign max to be between 1:50
		CPU_left	= CPU_max ;
		timeWaiting	= 0 ;
		memBase	= 0 ;
		memLimit	= random__X.nextInt(50) + 26 ;	// Assign memory needed between 25:75
	}	
	
	// constructor for memory tracking
			
	public PCB (int m0)
	{
		PCB__K		= 0 ;	
		PCB_state	= "@" ;
		PCB_ID		= 0 ; 
		pgmCounter	= "" ;
		CPU_used	= 0 ;
		CPU_max		= 0 ; 
		CPU_left	= 0 ; 
		timeWaiting	= 0 ;
		memBase	= 0 ;
		memLimit	= m0 ;
	}	
	
	
	public String showPCB()
	{
		return "state: " + PCB_state
			+ "\tID: "	+ Integer.toString(PCB_ID)
//		//	+ "\tK: "	+ pgmCounter
			+ "\tCPU max: "	+ Integer.toString(CPU_max)
			+ "\tCPU used: "	+ Integer.toString(CPU_used)	
			+ "\tCPU left: "	+ Integer.toString(CPU_left)
			+ "\tWait: "	+ Integer.toString(timeWaiting)
			+ "\tmemBase: "	+ Integer.toString(memBase)
			+ "\tmemLimit: "+ Integer.toString(memLimit)
			;
	}

	public int compareTo (PCB pcb0) 
	{
		int mem0	= pcb0.get_memBase();
		return this.memBase - mem0 ;
	}	
	
	public int compareTo (int cpu0) 
	{
		return this.CPU_left - cpu0 ;
	}	
	
	//	set methods
	
	public String get_state()
	{
		return PCB_state;
	}
	
	public int get_ID()
	{
		return PCB_ID;
	}
	
	public int get_CPU_used()
	{
		return CPU_used;
	}
	
	public int get_CPU_max()
	{
		return CPU_max;
	}	
	
	public int get_CPU_left()
	{
		return CPU_left;
	}	
	
	public String get_pgmCounter()
	{
		return pgmCounter;
	}	
	
	public int get_timeWaiting()
	{
		return timeWaiting;
	}	
	
	public int get_memBase()
	{
		return memBase;
	}	
	
	public int get_Limit()
	{
		return memLimit;
	}	
	
	// Set methods , void returns no value

	
	public void set_PCB_ID (int id0)
	{
		PCB_ID	= id0 ;
	}
	
	public void set_state(String state0)
	{
		PCB_state	= state0 ;
	}
	
	public void set_CPU_used(int CPU0)
	{
		CPU_used	= CPU0 ;
	}

	public void set_CPU_left()
	{
		CPU_left	= CPU_max - CPU_used ;
	}
	
	public void add_CPU_used(int c0)
	{
		CPU_used	+= c0 ;
	}
	
	public void set_CPU_max(int CPU0)
	{
		CPU_max	= CPU0 ;
	}
	
	public void set_pgmCounter(String pgmCounter0)
	{
		pgmCounter	= pgmCounter0 ;
	}
	
	public void set_timeWaiting(int timeWaiting0)
	{
		timeWaiting	= timeWaiting0 ;
	}
	
	public void add_timeWaiting(int t0)
	{
		timeWaiting	+= t0 ;
	}
	
	public void set_memBase (int m0)
	{
		memBase = m0 ;
	}
	
	public void set_memLimit (int m0)
	{
		memLimit = m0 ;
	}
	
	class comparator_by_CPU_left implements Comparator<PCB> 
	{
	    @Override
	    public int compare(PCB p1, PCB p2) 
	    {
	        return p1.get_CPU_left()	- p2.get_CPU_left(); 
	    }
	}
}