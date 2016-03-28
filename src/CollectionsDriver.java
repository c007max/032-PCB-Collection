import java.util.Collections;
import java.util.LinkedList ;
import java.util.Random ;

public class CollectionsDriver 
{			
	public static void main(String args[]) 	
	{
		Random random__X	= new Random();
		int QREADY__T = 5 ;	final int mem__T = 256;
		
		LinkedList<PCB> QReady	= new LinkedList<PCB>();	//#0010 Create List QReady
				
		PCB PCB_Ready	; 	//#0040 Create the field: PCB_Ready
		CPU_event ce	= new CPU_event();

		for (int ii = 0; ii < QREADY__T; ii++)
		{
			PCB pcb0 = new PCB();		//#0050 new PCB STATE:New
			pcb0.set_state("Ready");	//#0060 set PCB STATE:Ready
			QReady.add(pcb0) ;			//#0070 Add PCB object onto QReady 
		}
		
		for (PCB loopI : QReady)
			System.out.printf("%s\n"	,loopI.showPCB()) ;
		
		//	End of Initialization \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
   	
		//#0100	Iterator Interface	\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
						
		while (!QReady.isEmpty())		
		{
			PCB_Ready = QReady.removeFirst() ;
			
			int event__X	= ce.get_CPU_event() ;
			
			PCB_Ready.add_CPU_used(random__X.nextInt(15) +1);
			
			if (PCB_Ready.get_CPU_used() > PCB_Ready.get_CPU_max())
			{
				System.out.printf("\t##### process: %d\tCPU max: %d\t####\n"
						,PCB_Ready.get_ID()
						,PCB_Ready.get_CPU_used()
						);
				continue;
			}

			if (event__X == 1)
			{
				System.out.printf("\t##### process %d completed\t####\n"
						,PCB_Ready.get_ID()
						);
				continue;
			}
			else
				QReady.addLast(PCB_Ready) ;
			
	        Collections.sort(QReady, new comparator_by_CPU_left());
	        
			for (PCB loopI : QReady)
				System.out.printf("%s\n"	,loopI.showPCB()) ;		}
	}
}