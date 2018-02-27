package battleship;



public class Battleship {
    
    private String element;          //will hold the element of whats occupying that space
    private boolean pc;              //boolean to determine whether user is human or pc
    private boolean called;          //boolean to determine whether element has already been called or not
    
    /**
     * Constructor sets pc = false, element to "_" and called = false
     */
    public Battleship() {
        
        pc = false;
        element = "_";
        called = false;
    }
    
    /**
     *
     * @param pc
     */
    public void setPc(boolean pc) {
        this.pc = pc;
    }
    
    public boolean getPc() {
        
        return pc;
    }
    
    public void setElement(String element) {
        this.element = element;
    }
    
    public String getElement() {
        //String element = Grid[row][col];
        
        return element;
    }
    
    /**
     * Returns true if the coordinates have already been used
     * @return called
     */
    public boolean getCalled() {
        
        return called;
    }
    
    /**
     * Set hit marker wheen coordinates are empty
     */
    public void setNothing() {
        
        element = "*";
    }
    
    public void setShip() {
        
        if(pc == true)
            element = "S";
        else
            element = "s";
        
        called = true;
    }
    
    public void setShip(boolean pc) {
        
        if(pc == true)
            element = "S";
        else
            element = "s";
        
        called = true;
    }
    
    
    public void setGrenade() {
        
        if(pc == true)
            element = "G";
        else
            element = "g";
        
        called = true;
    }
    
    public void setGrenade(boolean pc) {
        
        if(pc == true)
            element = "G";
        else
            element = "g";
        
        called = true;
    }
    
    public boolean isGrenade() {
        boolean isgrenade;
        
        if(element.equalsIgnoreCase("G"))
           return isgrenade = true;
        else
           return isgrenade = false;
    }
    
    public boolean isShip() {
        boolean isship;
        
        if(element.equalsIgnoreCase("S"))
            return isship = true;
        else
            return isship = false;
     
    }
    
    /**
     * Returns true if Coordinates are outside the grid
     * @param row
     * @param col
     * @return OutOfBounds
     */
    public boolean CoordinatesOutOfBounds(int row, int col) {
        
        boolean OutOfBounds;
        
        if (row < 0 || row > 7 || col < 0 || col > 7)
            OutOfBounds = true;
        else
            OutOfBounds = false;
        
        return OutOfBounds;
    }
    
    /**
     * Returns the String value of the desired coordinates
     * @param r
     * @param c
     * @return 
     */
    public String getCoordinatesString(int r, int c) {
        
        String coordinates = getRowString(r) + getColString(c);
        
        return coordinates;
     }
    
    /**
     * Returns the array value of row from the user input
     * @param input
     * @return row
     */
    public int getRowInt(String input) {
        //row is the first character of the string
        char char_row = input.charAt(0);
        int row;
        
        //assign numerical value to each letter of the grid for arrays equivalent
        if (char_row == 'a' || char_row == 'A')
            row = 0;
        else if (char_row == 'b' || char_row == 'B')
            row = 1;
        else if (char_row == 'c' || char_row == 'C')
            row = 2;
        else if (char_row == 'd' || char_row == 'D')
            row = 3;
        else if (char_row == 'e' || char_row == 'E')
            row = 4;
        else if (char_row == 'f' || char_row == 'F')
            row = 5;
        else if (char_row == 'g' || char_row == 'G')
            row = 6;
        else if (char_row == 'h' || char_row == 'H')
            row = 7;
        else
            row = -1; 
        
        return row;
    }
    
    /**
     * Returns the array value of col from the user input
     * @param input
     * @return col
     */
    public int getColInt(String input) {
        
        //col is the second character of the string
        char char_col = input.charAt(1);
        
        //transform char to int
        int int_col = Character.getNumericValue(char_col);
        
        //-1 for array
        int col = int_col - 1;
        
        return col;
    }
   
    
    public String getRowString(int r) {
        String row = "z";
        
        switch(r)  {
            case 0:
                row = "A";
                break;
            case 1:
                row = "B";
                break;
            case 2:
                row = "C";
                break;
            case 3:
                row = "D";
                break;
            case 4:
                row = "E";
                break;
            case 5:
                row = "F";
                break;
            case 6:
                row = "G";
                break;
            case 7:
                row = "H";
                break;
        }
        
        return row;
    }
    
    public String getColString(int c) {
        String col = "0";
        
        switch(c) {
            case 0:
                col = "1";
                break;
            case 1:
                col = "2";
                break;
            case 2:
                col = "3";
                break;
            case 3:
                col = "4";
                break;
            case 4:
                col = "5";
                break;
            case 5:
                col = "6";
                break;
            case 6:
                col = "7";
                break;
            case 7:
                col = "8";
                break;
        }
        
        return col;
    }
    
    /**
     *
     * @param grid
     */
    public void toString(Battleship grid[][]) {
        String output = "";
        
        for (int i = 0; i < grid.length; i++) 
        {
            
            for (int j = 0; j < grid[0].length; j++) {
                
               output += grid[i][j].getElement()+" ";
            }
            output += "\n";
        }
        
        System.out.println(""+output);
    }
    
}
