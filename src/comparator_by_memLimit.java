import java.util.Comparator;

class comparator_by_memLimit implements Comparator<PCB> 
{
    @Override
    public int compare(PCB p1, PCB p2) 
    {
        return p1.get_Limit()	- p2.get_Limit(); 
    }
}
