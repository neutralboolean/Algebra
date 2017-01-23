import java.util.ListIterator;
import java.util.LinkedList;
import java.util.ArrayList;

/*
Read all input into the op_order.
Traverse op_order: every time a parentheses is read, go until the matching
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
        
        op_order = new LinkedList<VariableUnit>();
    }
    public void assignValue(double val, char existing) {
        int pos = existing - 'a';
        ListIterator<VariableUnit> iter = alpha_arr.get(pos).listIterator(0);
    
        int count = 0;
        while(iter.hasNext()) {
            iter.next().assignValue(val);
            count++;
        };
        /* remove testing */
        System.out.print(count); System.out.println(" variables had values assigned.");
    }
  
    public VariableUnit solve() {
    	/*
    	 * This is currently a test of the algorithm for solving an Equation
    	 */
        LinkedList<VariableUnit> processor = new LinkedList<VariableUnit>();

            VariableUnit vu1 = new VariableUnit(250.0, 'x');
            VariableUnit vu2 = new VariableUnit('+');
            VariableUnit vu3 = new VariableUnit(250.0, 'x');
            VariableUnit vu4 = new VariableUnit(501.0, 'x');
            VariableUnit vu5 = new VariableUnit('y');
            VariableUnit vu6 = new VariableUnit('-');
            alpha_arr.get(('x' - 'a')).addLast(vu1);
            alpha_arr.get(('x' - 'a')).addLast(vu2);
            alpha_arr.get(('x' - 'a')).addLast(vu3);
            op_order.add(vu1); op_order.add(vu2); op_order.add(vu3); op_order.add(vu6);
            op_order.add(vu4); op_order.add(vu6); op_order.add(vu5);
            assignValue(2.0, 'x');
            
            System.out.print(vu1); System.out.print(vu2); System.out.print(vu3);
            System.out.print(vu6); System.out.print(vu4); System.out.print(vu6);
            System.out.print(vu5);
            System.out.println();
            System.out.println("------------------------------");
            
            VariableUnit temp, temp1;
            for (int i = 0; i < op_order.size(); i++) {
            	temp = op_order.pollFirst();
            	
            		switch (temp.getVariable()) {
                    	case '+':
                    		//if processor.isEmpty(): throw an exception
                    		temp1 = processor.pop().add(op_order.pollFirst());
                    		processor.push(temp1);
                    		break;
                    	case '-':
                    		//if processor.isEmpty(): throw an exception
                    		temp1 = processor.pop().subtract(op_order.pollFirst());
                    		processor.push(temp1);
                    		break;
                    	default:
                    		processor.push(temp);
            		}
            }

            /*
             * System.out.println("This equation is currently unsolvable.");
            	System.out.println("Try assigning values to some of the variables.");
            */
            while (!processor.isEmpty()) {
            	op_order.addFirst(processor.pop());
            }
            
            ListIterator<VariableUnit> iter = op_order.listIterator();
            
            while ( iter.hasNext() ) {
            	VariableUnit iter_temp = iter.next();
            	//System.out.print(iter_temp.hasValue());
            	if (iter_temp.hasValue()) {
            		System.out.print( Double.toString(iter_temp.subValue()) );
            	}
            	else {
            		System.out.print(iter_temp);
            	}
            };
            System.out.println();
            
            return new VariableUnit(Double.NaN, ' ');
    }
  
    //auxiliary methods

    public static void main(String args[]) {
        Equation eqn = new Equation();
        System.out.println(eqn.solve());
    }
}
