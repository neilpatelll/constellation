public class Star {
   public static void main(String[] args) {

       // shape b
       for (int row = 0; row < 10; ++row) {
           for (int spaces = 0; spaces < 10 - row; ++spaces) {
               System.out.print(" ");
           }
           for (int stars = 0; stars < row; ++stars) {
               System.out.print("*");
           }
           // shape d
           for (int spaces = 0; spaces < 10 - row - 1; ++spaces) {
               System.out.print("");
           }
           for (int stars = 0; stars < row + 1; ++stars) {
               System.out.print("*");
           }
           System.out.println();
       }
       // shape c
       for (int row = 0; row < 10; ++row) {
           for (int spaces = 10; spaces > 10 - row - 1; --spaces) {
               System.out.print(" ");
           }
           for (int stars = 10; stars > row; --stars) {
               System.out.print("*");
           }
          
        //Only you have to add this for shape a
        for (int stars = 10-1; stars > row; --stars) {
               System.out.print("*");
           }
           System.out.println();
          
       }

      
   }

}