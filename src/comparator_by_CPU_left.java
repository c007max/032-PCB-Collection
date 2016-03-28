import java.util.Comparator;

class comparator_by_CPU_left implements Comparator<PCB> 
{
    @Override
    public int compare(PCB p1, PCB p2) 
    {
        return p1.get_CPU_left()	- p2.get_CPU_left(); 
    }
}
