package sorting;


public class BubbleSort extends Sort {
    
  public static void main(String[] args) {
    print(sort(given));
    print(sort(expected));
  }
  
  public static int[] sort(int[] given) {
    int l = given.length - 1;
    int p1 = 0;
    int tl = given.length;
    int tt = 0;
    
    while(p1 < l){
      if(given[p1] > given[p1 + 1]) {
        int temp = given[p1];
        given[p1] = given[p1 + 1];
        given[p1+1] = temp;
      }
      p1++;
      if (p1 == l && tt < tl)  { p1 = 0; tt++;}; 
    }
    return given;
  }
}
