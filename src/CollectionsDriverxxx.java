import java.util.Collections;
import java.util.LinkedList ;
import java.util.Random ;

public class CollectionsDriverxxx 
{			
	public static void main(String args[]) 	
	{
		Random random__X	= new Random();
		int QREADY__T = 10 ;	final int mem__T = 256;
		
		LinkedList<PCBxxx> QReady	= new LinkedList<PCBxxx>();	//#0010 Create List QReady
		LinkedList<PCBxxx> QMemOpen	= new LinkedList<PCBxxx>();	//#0020 Create List QMemOpen
		LinkedList<PCBxxx> QMemUsed	= new LinkedList<PCBxxx>();	//#0030 Create List QMemUsed
		
		QMemOpen.add(new PCBxxx(mem__T)) ;	//#0032 Set the Open Memory
						
		PCBxxx PCB_Ready	; 	//#0040 Create the field: PCB_Ready

		for (int ii = 0; ii < QREADY__T; ii++)
		{
			PCBxxx pcb0 = new PCBxxx();		//#0050 new PCB STATE:New
			pcb0.set_state("Ready");	//#0060 set PCB STATE:Ready
			QReady.add(pcb0) ;			//#0070 Add PCB object onto QReady 
		}
		
		for (PCBxxx loopI : QReady)
			System.out.printf("%s\n"	,loopI.showPCB()) ;
		
		//	End of Initialization \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
   	
		//#0100	Iterator Interface	\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
		
		OpenMem om = new OpenMem();
		
		java.util.Iterator<PCBxxx> ix = QReady.iterator();
		
		while (ix.hasNext())		
		{
			PCB_Ready = ix.next();
			
			boolean memFound__B	= om.findOpenMem(PCB_Ready, QMemOpen, QMemUsed);
			
			for (PCBxxx loopI : QMemOpen)
				System.out.printf("\n@020Open\t%s\n"	,loopI.showPCB());
			
			for (PCBxxx loopI : QMemUsed)
				System.out.printf("@0200Used\t%s\n"	,loopI.showPCB());
						
			if (!memFound__B)
			{
				System.out.printf("##### No Memory Available for Process:%d\tneeding:%d\n"
						,PCB_Ready.get_ID() 
						,PCB_Ready.get_Limit()	);
				continue ;	// skip this process
			}
			System.out.println("=====");
		}
		
		//#0400	simulate memory free process
		
		while (!QMemUsed.isEmpty())
		{
			int QIndex	= random__X.nextInt(QMemUsed.size()) ;
			
			//	free the memory 
			System.out.printf("@0400 Removing: %d\n", QIndex) ;
			PCBxxx PCB_Done = QMemUsed.remove(QIndex);

			//	add the memory back to the QMemOpen
			QMemOpen.add(PCB_Done);		
			
			for (PCBxxx loopI : QMemOpen)
				System.out.printf("@0420 Open\t%s\n"	,loopI.showPCB());
			
			for (PCBxxx loopI : QMemUsed)
				System.out.printf("@0440 Used\t%s\n"	,loopI.showPCB());
						
			System.out.println("=====");
		}
		
		//#0500 Sort the QMemOpen 
		
		Collections.sort(QMemOpen);
		for (PCBxxx loopI : QMemOpen)
		{
			System.out.printf("@0500 sorted\t%s\n", loopI.showPCB()) ;
		}
		
		//#0600 Defragmentation processing
//		for (int ii = 0; ii < QMemOpen.size()-1; ii++)	
//		{
//			PCB pcb0 = QMemOpen.get(ii);
//			PCB pcb1 = QMemOpen.get(ii+1);
//		
//			int nextMem = pcb0.get_memBase() + pcb0.get_Limit();
//			if (nextMem == pcb1.get_memBase())
//			{
//				// adjacent memory
//				pcb0.set_memLimit(pcb0.get_Limit()+pcb1.get_Limit());
//				QMemOpen.remove(ii+1);
//			}
//			for (PCB loopI : QMemOpen)
//			{
//				System.out.printf("@0520 \t%s\n", loopI.showPCB()) ;
//			}
//		}
	}
}