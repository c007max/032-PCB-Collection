import java.util.LinkedList;

public class OpenMem 
{

	public OpenMem ()
	{}
	
	public boolean findOpenMem	(
			PCBxxx PCB_Ready
			,LinkedList<PCBxxx> QMemOpen
			,LinkedList<PCBxxx> QMemUsed	)
	{
		boolean memFound__B = false ;
			
		int memNeed = PCB_Ready.get_Limit() ;
		for (int ii = 0; ii < QMemOpen.size(); ii ++)
		{
			PCBxxx memOpen = QMemOpen.get(ii) ;
			if (memOpen.get_Limit() > memNeed )
			{
				memFound__B = true;
				int base0 = memOpen.get_memBase() ;
				
				//	split the open memory 	@@ QMemOpen @@
				memOpen.set_memBase(base0 + memNeed);
				memOpen.set_memLimit(memOpen.get_Limit()-memNeed);
				memOpen.set_PCB_ID(PCB_Ready.get_ID());
				
				//	replace the open memory
				QMemOpen.set(ii ,memOpen);
				System.out.printf("@0110Open:%d\t%s\n"	
						,QMemOpen.size()	
						,memOpen.showPCB()
						);
					
				//	allocate the used memory	@@ QMemUsed @@
				PCBxxx memUsed = new PCBxxx(memNeed) ;
					
				//	set the base for the process
				memUsed.set_memBase(base0);
					
				//	push the used memory
				QMemUsed.addLast(memUsed);
					
				System.out.printf("@0120Used\t%s\n"	,memUsed.showPCB());
					
				break ;	// exit out of the FOR loop for memory
			}
		}
		return memFound__B ;
	}
}
