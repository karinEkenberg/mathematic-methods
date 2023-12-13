/**
* The program performs severeal mathematical tasks
* 1. Area of the circle method (area(int radius))
* 2. Lateral surface area the cone (area(int radius, int height))
* 3. Pythagoras' theorem (pythagoras(int sideA, int sideB))
* 4. Volume method (volume(int radius, int height))
* 5. Printing the results of the above methods. 
* 6. Fractions method (fraction(int numerator, int denominator))
 *7. Reducing using gcd (gcd(int a, int b))
 *8. Printing method (printFraction(int[] parts))
 *9. Input method (input())
 *10. Printing the results of the fraction methods.
 * @author Karin Ekenberg , kareke-2
 */

/**
Pseudocode:
Step 1: Create area of the circle method
area(int radius){
calculate area;
}

Step 2: Creating Lateral surface area of the cone method
area(int radius, int height){
calculate area;
}

Step 3: Creating Pythagoras' theorem method
pythagoras(int sideA, int sideB){
calculate pythagoras;
}

Step 4: Creating Volume method
volume(int radius, int height){
calculate volume;
}

Step 5: Printing results of area and volume
System.out.println("area = 5, volume = 5.");

Step 6: Creating fractions method
fraction(int numerator, int denominator){
calculate fraction;
}

Step 7: Creating reducing using gcd method
gcd(int a, int b){
calculate gcd;
}

Step 8: Create printing method
printFraction(int[] parts){
take array of number and make it into fractions;
with some rules;
}

Step 9: Creating input method
input(){
check for valid input;
check for invalid input;
}

Step 10: Print out results of fraction methods
System.out.println("fractions are = 5");
*/

//importing the scanner class, helps reading user input
import java.util.Scanner;

class Main
{
//declare a static variable of type scanner, the variable will be used to read input
    static Scanner userInput;
  
//declare constants 
    static final double CONE_VOLUME_FACTOR = 3.0;
  
  /** 
 * return a posetive integer for valid values, else return -1 (if q is entered)
 * @param - none
 * @return - posetive integer, for valid values, -1 when user enters q
 */
  public static int input(){
    int number = 0;
    
    while(true){
      if(userInput.hasNextInt()){
        number = Math.abs(userInput.nextInt());
        if(number >= 0) {
          break;
        }
      }
      else if(userInput.hasNext()){
        String inString = userInput.next();
        if(inString.equalsIgnoreCase("q")){
          number = -1;
          break;
        }
        else{
          continue;
        }
      }
    }
    return number;
  }
 
/** 
 * calculates the area of a cirlce with the given radius
 * @param double radius - radius of the circle, must be positive 
 * @return - the area of the circle
 */
  public static double area(int radius){
    if(radius <= 0){
      throw new IllegalArgumentException("Radius must be posetive");
    }
    double pi = Math.PI;
    double baseArea = pi * Math.pow(radius, 2);

    return baseArea;
  }
  
/** 
 * calculates the area of a cone surface with the given radius and height
 * @param double radius - radius of the cone surface
 * @param double height - height of the cone surface
 * @return - the area of the cone surface
 */
public static double area(int radius, int height){
  if(radius < 0 || height < 0){
   return -1.0;
  }
  double slantHeight = Math.sqrt(Math.pow(radius, 2) + Math.pow(height, 2));
  double lateralSurfaceArea = Math.PI * radius * slantHeight;
  return lateralSurfaceArea;
}
  
/** 
 * calculates the volume of a cone by using radius and height
 * @param double radius - the radius of the base of the cone  
 * @param double height - the height of the cone
 * @return - the volume of the cone as a floating point number 
 * returns -1 if the radius or hight is negative 
 */
public static double pythagoras(double sideA, double sideB){
  if(sideA < 0 || sideB < 0){
    return -1.0;
  }
  double volume = (Math.PI * Math.pow(sideA, 2) * sideB) / CONE_VOLUME_FACTOR;
  return volume;
}
  
/** 
 * calculates the volume of the cone by using the radius and height
 * @param double radius - the radius
 * @param double height - the height
 * @return - the volume of the cone
 */
public static double volume(int radius, int height){
  if(radius < 0 || height < 0){
    return -1.0;
  }
  double volume = (Math.PI * Math.pow(radius, 2) * height) / CONE_VOLUME_FACTOR;
  return volume;
}
  
/** 
 * return a posetive integer for valid values, else return -1 (if q is entered)
 * @param - none
 * @return - posetive integer, for valid values, -1 when user enters q
 */
  public static int[] fraction(int nume, int denom){
    int integer = 0;
    int numerator = 0;
    int denominator = 0;
    
    if(denom == 0){
      return null;
    }
    else if(nume == 0){
      return new int[]{0, 0, 0};
    }

    integer = nume / denom;
    numerator = nume % denom;
    denominator = denom;

    int gcd = gcd(numerator, denominator);

    numerator = numerator / gcd;
    denominator = denominator / gcd;

    return new int[]{integer, numerator, denominator};
  }
  
  /** 
 * return the greatest common devisor of two integers (a and b)
 * @param - integer a and b
 * @return - greatest common devisor of a and b
 */
  public static int gcd(int a, int b){
    int c;
    if(a >= b){
      int temp = a;
      a = b;
      b = temp;
    }
     while(b != 0){
       c = a % b;
       a = b;
        b = c;
     }
    return a;
  }
  
/**
 * Print a mixed fraction in the form of an array of integers.
 * @param parts an array of three integers representing the mixed fraction (integer, numerator, denominator)
 * @return void
 */
  public static void printFraction(int[] parts){
    if(parts == null){
      System.out.print("Error!");
      return;
    }
    int numerator = parts[parts.length - 2];
    int denominator = parts[parts.length - 1];
    int integerPart = parts[0];
    if(integerPart == 0 && numerator == 0){
      System.out.print("0");
      return;
    }
     String fraction = numerator == 0 ? "" : numerator + "/" + denominator;
     String output = (integerPart == 0 ? "" : integerPart + " ") + (numerator == 0 ? "" : fraction );
    System.out.print(output);
      
  }
  
    public static void main(String[] args)
    {
//area and volume 
      System.out.println("----------------------------------");
      System.out.println("# Test of area and volume methods");
      System.out.println("----------------------------------");
//iniziating the userInput variable by creating a new Scanner object with the system.in parameter 
       userInput = new Scanner(System.in);
      
//declaring variables
      int r;
      int h;
      double circleArea;
      double coneArea;
      double coneVolume;
      
//Rounding the scale
        int noOfDecimals = 2; 
        double scale = 0; 
        scale = Math.pow (10, noOfDecimals); 
      
/*a while loop that runs until it breaks, within the loop the input() function is called
twice to obtain values for the variables r and h, if the value -1 is entered the loop breaks,
after values are obtained they are printed with printf and %d + %n to format the result and
make a new line*/
      while(true){
        r = input();
        if(r == -1){
          break;
        }
        h = input();
        if(h == -1){
          break;
        }
        circleArea = area(r);
        if(circleArea == -1){
          break;
        }
        coneArea = area(r, h);
        if(coneArea == -1){
          break;
        }
        coneVolume = pythagoras(r,h);
        if(coneVolume == -1){
          break;
        }

//using the rounding of scales 
        circleArea = Math.round (circleArea * scale) / scale;
        coneArea = Math.round (coneArea * scale) / scale;
        coneVolume = Math.round (coneVolume * scale) / scale;

//printing the results of area and volume 
      System.out.printf("r = %d h = %d%n", r, h);
      System.out.println("Circle area: " + circleArea);
      System.out.println("Cone area: " + coneArea);
      System.out.println("Cone volume: " + coneVolume);
      System.out.println("\n");
      }
      
//fractions    
      System.out.println("----------------------------------");
      System.out.println("# Test of the fractional methods");
      System.out.println("----------------------------------");

//decalring variables
      int nume = 0;
      int denom = 0;
      int greatDevi = 0;
      int rest = 0;
      
/*a while loop that runs until it breaks, within the loop the input() function is called
twice to obtain values for the variables nume and denom, if the value -1 is entered the loop breaks, after values are obtained they are printed with printf and %d + %n to format the result and make a new line*/
      while(true){
        nume = input();
        if(nume == -1){
          break;
        }
        denom = input();
        if(denom == -1){
          break;
        }
        greatDevi = gcd(nume, denom);
        if(greatDevi == -1){
          break;
        }
        
        rest = nume-(denom * greatDevi);
        int[] parts = {greatDevi, nume, denom};
        System.out.print(nume + "/" + denom + " = ");
        printFraction(fraction(nume, denom));
        System.out.println();
      }
      
//closing the scanner
      userInput.close();  
    }

}
