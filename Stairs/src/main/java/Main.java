package main.java;


class Main {
    private static int stairs(int n) {
        if(n == 1 || n == 2) {
            return n;
        }
        return stairs(n-1) + stairs(n-2);
    }
   public static void main(String[] args) {
      System.out.println(stairs(6));
   }
}