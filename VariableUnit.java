import java.util.ListIterator;
import java.util.LinkedList;

public class VariableUnit{
    /**
     * Class Variable 
     * Implements the smallest variable unit of an Equation.
     * Facilitates addition, subtraction, multiplication, and division of
     * `VariableUnit`s.
     *  
     **/
    private Double coefficient;
    private Variable var;
    //private int exponent;
    //private Equation eqn;
    //private boolean f_of_g;
    
    //Constructors
    public VariableUnit (double dbl, char new_var) {
        coefficient = new Double(dbl);
        var = new Variable(new_var);
        //exponent = 1;
        //f_of_g = false;
    }
    
    public VariableUnit (double dbl) {
        coefficient = new Double(dbl);
        var = null;
    }
    
    public VariableUnit (char new_var) {
        if(Character.isLetter(new_var)) {
            coefficient = new Double(1.0);
            var = new Variable(new_var);
        }
        else {
            coefficient = new Double(Double.NaN);
            var = new Variable(new_var);
        }
    }
    /*
    //waiting on stable base
    public VariableUnit (double dbl, char new_var, int exp) {
        coefficient = dbl;
        var = new Variable(new_char);
        exponent = exp;
        f_of_g = false;
    }
    //waiting in implementation of full Equation class
    public VariableUnit (Equation composition) {
        eqn = composition;
        f_of_g = true;
    }
    */
    
    //Auxiliary methods
    public void assignValue(double val) {
        var.value = val;
    }
    public double subValue() {
        //return ( coefficient * ( Math.pow(var.subValue(), exponent ) );
        return ( coefficient * var.subValue()  );
    }
    
    private char getVariable() { return var.getVariable(); }
    
    public static boolean sameVariable(VariableUnit one, VariableUnit another) {
        return ( one.var.getVariable() == another.var.getVariable() );
    }
    
    public static boolean equal(VariableUnit one, VariableUnit another) {
        boolean result = (one.coefficient == another.coefficient) &&
        (sameVariable(one, another));
        return result;
    }
    
    public String toString() {
        String result;
        //if there is a `Variable`
        if (var != null) {
            //if the `Variable` is an operator
            if (coefficient.isNaN()) {
                result = Character.toString(getVariable());
            }
            else {
                result = coefficient.toString() + getVariable();
            }
        }
        else {
            result = coefficient.toString();
        }
        
        return result;
    }
    
    //Algebra operations
    /*
     Does not check the VariableUnits for matching char values 
     (i.e. that they are the same variable). That task is left to higher
     calls.
     */
     
    //adds another VariableUnit to this one.
    public VariableUnit add(VariableUnit other) {
        double temp_coeff = coefficient + other.coefficient;
        VariableUnit result = new VariableUnit(temp_coeff, var.getVariable() );
        return result;
    }
    
    //subtracts another VariableUnit from this one.
    public VariableUnit subtract(VariableUnit other) {
        double temp_coeff = coefficient - other.coefficient;
        VariableUnit result = new VariableUnit(temp_coeff, var.getVariable() );
        return result;
    }
    //waiting on stable base
    /*
    public VariableUnit multiply(VariableUnit other) {
        double temp_coeff = coefficient * other.coefficient;
        int temp_exp = exponenet + other.exponent;
        VariableUnit result = new VariableUnit(temp_coeff, var.getVariable(), temp_exp );
        
        return result;
    }
    
    public VariableUnit divide(VariableUnit other) {
        double temp_coeff = coefficient / other.coefficient;
        int temp_exp = exponent - other.exponent;
        VariableUnit result = new VariableUnit(temp_coeff, var.getVariable(), temp_exp);
        return result;
    }
    */
    //helper class to handle the Variable directly
    private class Variable {
        private Double value;
        private char variable;
        
        public Variable(char new_var) {
            value = new Double(0.0);
            variable = new_var;
        }
        /*
        public Variable(Variable new_comp) {
            f_of_g = true;
            composition = composite;
        }
        */
        public double subValue() {
            return value;
            /*
            if (f_of_g) {
                return composition.subValue();
            }
            else {
                return value;
            }
            */
        }
        
        public char getVariable() { return variable; }

    }
    
    public static void main(String args[]) {
        VariableUnit v1, v2, v3, v4, y1, y2;
        v1 = new VariableUnit(1, 'x');
        v2 = new VariableUnit(2, 'x');
        v3 = new VariableUnit(3, 'x');
        v4 = new VariableUnit(4, 'x');
        y1 = v1.add(v2);
        y2 = v3.subtract(v4);
        
        VariableUnit[] array = {v1, v2, v3, v4, y1, y2};
        
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        System.out.println("----------------");
        System.out.print(y1 +" has same variable as "+ y2 +": ");
        System.out.println(VariableUnit.sameVariable(y1, y2));
        System.out.print(y1 + " is equal to " + y2 +": ");
        System.out.println(VariableUnit.equal(y1, y2));
        VariableUnit y3 = y1.add(y2);
        System.out.println("----------------");
        System.out.println( y3 );
        System.out.println("x = 16.0");
        y3.assignValue(16.0);
        System.out.println( y3 + " = " + y3.subValue() );
        
        System.out.println("----------------");
        System.out.println("x = 4");
        v2.assignValue(4.0);
        System.out.println(v2 + " = " + v2.subValue());
        
        System.out.println("----------------");
        VariableUnit novar = new VariableUnit(5.0);
        System.out.print("\'No variable\' printing test: ");
        System.out.println(novar);
        System.out.println("----------------");
        System.out.println("\'VariableUnit with mathematical operators\' test");
        System.out.println("\tPrinting out full equations:");
        VariableUnit op1 = new VariableUnit('+');
        VariableUnit op2 = new VariableUnit('-');
        VariableUnit op3 = new VariableUnit('=');
        LinkedList<VariableUnit> eqn = new LinkedList<VariableUnit>();
        eqn.add(v1); eqn.add(op1); eqn.add(v2); eqn.add(op3); eqn.add(y1);
        ListIterator<VariableUnit> iter = eqn.listIterator(0);
        while(iter.hasNext()) {
            System.out.print(iter.next());
        }
        System.out.println();
        
        eqn.clear();
        eqn.add(v3); eqn.add(op2); eqn.add(v4); eqn.add(op3); eqn.add(y2);
        iter = eqn.listIterator(0);
        while(iter.hasNext()) {
            System.out.print(iter.next());
        }
        System.out.println();

    }
}
