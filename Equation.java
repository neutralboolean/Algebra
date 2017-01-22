import java.util.ListIterator;
import java.util.LinkedList;
import java.util.ArrayList;
import java.lang.Exception;

/*
Read all input into the op_order.
Traverse op_order: everytime a parentheses is read, go until the matching
    parentheses and pass it to a new Equation instance.

*/
public class Equation {
    private ArrayList<LinkedList<VariableUnit>> alpha_arr;
        //list of all in-use variables
    private LinkedList<VariableUnit> op_order;
        //maintains the order of the VariableUnits that are parsed from input
  
    public Equation() {
        alpha_arr = new ArrayList<LinkedList<VariableUnit>>();
        for (int i = 0; i < 26; i++) {
            LinkedList<VariableUnit> list = new LinkedList<VariableUnit>();
            alpha_arr.add(list);
        }
    }
    public void assignValue(double val, char existing) {
        int pos = existing - 'a';
        ListIterator<VariableUnit> iter = alpha_arr.get(pos).listIterator(0);
    
        while(iter.hasNext()) {
            iter.next().assignValue(val);
        };
    }
  
    public double solve(LinkedList<VariableUnit> llvu ) {
        LinkedList<VariableUnit> processor = new LinkedList<VariableUnit>();
        try {
            VariableUnit vu1 = new VariableUnit()
            VariableUnit vu2 = new VariableUnit('+')
        }
        catch (UnsolvableException ex) {
            System.out.println("This equation is currently unsolvable.");
            System.out.println("Try assigning values to some of the variables.");
            return Double.NaN;
        }
        
    }
  
    //auxiliary methods

    public static void main(String args[]) {
        Equation eqn = new Equation();
        System.out.println(eqn.alpha_arr.get(0).peekFirst() == null);
    }
}
