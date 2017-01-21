public class VariableUnit{
    /**
     * Class Variable 
     * Implements the smallest variable unit of an Equation.
     * Facilitates addition, subtraction, multiplication, and division of
     * `VariableUnit`s.
     *  
     **/
    private double coefficient;
    private Variable var;
    //private int exponent;
    //private Equation eqn;
    //private boolean f_of_g;
    
    //Constructors
    public VariableUnit (double dbl, char new_var) {
        coefficient = dbl;
        var = new Variable(new_var);
        //exponent = 1;
        //f_of_g = false;
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
        return ( coefficient * var.subValue() );
    }
    
    private char getChar() { return var.getChar(); }
    
    public static boolean equal(VariableUnit one, VariableUnit another) {
        return ( one.var.getChar() == another.var.getChar() );
    }
    
    public String toString() {
        Double temp = new Double(coefficient);
        String result = temp.toString() + getChar();
        return result;
    }
    
    //Algebra operations
    /*
     Does not check the VariableUnits for matching char values 
     (i.e. that they are the same variable). That task is left to higher
     calls.
     */
    public VariableUnit add(VariableUnit other) {
        double temp_coeff = coefficient + other.coefficient;
        VariableUnit result = new VariableUnit(temp_coeff, var.getChar() );
        return result;
    }
    public VariableUnit subtract(VariableUnit other) {
        double temp_coeff = coefficient - other.coefficient;
        VariableUnit result = new VariableUnit(temp_coeff, var.getChar() );
        return result;
    }
    //waiting on stable base
    /*
    public VariableUnit multiply(VariableUnit other) {
        double temp_coeff = coefficient * other.coefficient;
        int temp_exp = exponenet + other.exponent;
        VariableUnit result = new VariableUnit(temp_coeff, var.getChar(), temp_exp );
        
        return result;
    }
    
    public VariableUnit divide(VariableUnit other) {
        double temp_coeff = coefficient / other.coefficient;
        int temp_exp = exponent - other.exponent;
        VariableUnit result = new VariableUnit(temp_coeff, var.getChar(), temp_exp);
        return result;
    }
    */
    //helper class to handle the Variable directly
    private class Variable {
        private double value;
        private char var_char;
        
        public Variable(char new_var) {
            value = 0.0;
            var_char = new_var;
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
        
        public char getChar() { return var_char; }

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
        System.out.print("y1 is equal to y2: ");
        System.out.println(VariableUnit.equal(y1, y2));
        System.out.println(y1.add(y2));
    }
}
