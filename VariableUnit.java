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
        //f_of_g = false;
    }
    //waiting in implementation of full Equation class
    /*
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
    
    //Algebra operations
    public VariableUnit add(VariableUnit other) {
        float temp_coeff = coefficient + other.coefficient;
        VariableUnit 
    }
    public VariableUnit subtract(VariableUnit other) {
        
    }
    public VariableUnit multiply(VariableUnit other) {
        
    }
    public VariableUnit divide(VariableUnit other) {
        
    }
    
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
        VariableUnit v1, v2
    }
}
