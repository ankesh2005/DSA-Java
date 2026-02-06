public class DisarrangementOfBalls {
  // User function Template for Java
    static int countDer(int n) {
        // Base case
        if(n<=3) return n-1;
        return (n-1)*countDer(n-2)+(n-1)*countDer(n-1);
    }

}
