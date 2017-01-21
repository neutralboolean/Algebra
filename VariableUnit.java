public class VariableUnit implements Comparable<VariableUnit>{
    /**
     * Class Variable 
     * Implements the smallest variable unit of an Equation.
     * Facilitates addition, subtraction, multiplication, and division of
     * `VariableUnit`s.
     *  
     **/
    private float coefficient;
    private Variable var;
    //private int exponent;
    //private Equation eqn;
    //private boolean f_of_g;
    
    //Constructors
    public VariableUnit (float flt, char new_var) {
        coefficient = flt;
        var = new Variable(new_var);
        //exponent = 1;
        //f_of_g = false;
    }
    
    /*
    //waiting on stable base
    public VariableUnit (float flt, char new_var, int exp) {
        coefficient = flt;
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
    public void assignValue(float val) {
        var.value = val;
    }
    public float subValue() {
        return ( coefficient * var.subValue() );
    }
    
    private char getChar() { return var.getChar(); }
    
    public static boolean equals(VariableUnit one, VariableUnit another) {
        return ( one.var.getChar() == another.var.getChar() );
    }
    
    public String toString() {
        String result = coefficient + getChar();
        return result;
    }
    
    //Algebra operations
    /*
     Does not check the VariableUnits for matching char values 
     (i.e. that they are the same variable). That task is left to higher
     calls.
     */
    public VariableUnit add(VariableUnit other) {
        float temp_coeff = coefficient + other.coefficient;
        VariableUnit result = new VariableUnit(temp_coeff, var.getChar() );
        return result;
    }
    public VariableUnit subtract(VariableUnit other) {
        float temp_coeff = coefficient - other.coefficient;
        VariableUnit result = new VariableUnit(temp_coeff, var.getChar() );
        return result;
    }
    //waiting on stable base
    /*
    public VariableUnit multiply(VariableUnit other) {
        float temp_coeff = coefficient * other.coefficient;
        int temp_exp = exponenet + other.exponent;
        VariableUnit result = new VariableUnit(temp_coeff, var.getChar(), temp_exp );
        
        return result;
    }
    
    public VariableUnit divide(VariableUnit other) {
        float temp_coeff = coefficient / other.coefficient;
        int temp_exp = exponent - other.exponent;
        VariableUnit result = new VariableUnit(temp_coeff, var.getChar(), temp_exp);
        return result;
    }
    */
    //helper class to handle the Variable directly
    private class Variable {
        private float value;
        private char var_char;
        
        public Variable(char new_var) {
            value = 0.0;
            var_char = new_char;
        }
        /*
        public Variable(Variable new_comp) {
            f_of_g = true;
            composition = composite;
        }
        
        public float subValue() {
            if (f_of_g) {
                return composition.subValue();
            }
            else {
                return value;
            }
        }
        */
        public char getChar() { return var_char; }

    }
    
    public static void main() {
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
