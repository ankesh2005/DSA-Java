class Heap{
  private int[] arr;
  private int idx=1;

  Heap(int capacity){
    arr=new int[capacity+1];
  }

  int peek(){
    if(idx==1){
      System.out.println("heap is empty");
      return -1;
    }
    return arr[1];
  }

  void add(int ele){
    if(arr.length==size()){
      System.out.println("heap is full");
    }
    arr[idx++]=ele;
    int root=idx-1;
    while(root!=1){
      int parent=root/2;
      if(arr[root]>=arr[parent])break;
      else{
        int temp=arr[root];
        arr[root]=arr[parent];
        arr[parent]=temp;
        root=parent;
      }
    }
  }
  int remove(){
    int min=arr[1];
    arr[1]=arr[idx-1];
    idx--;
    int root=1;
    while(root*2<=size()){
      int left=2*root, right=2*root+1;
      int lval=(left<=size())?arr[left]:Integer.MAX_VALUE;
      int rval=(right<=size())?arr[right]:Integer.MAX_VALUE;
      if(arr[root]<lval && arr[root]<rval)break;
      else{
        if(lval<rval){
          int temp=arr[root];
          arr[root]=arr[left];
          arr[left]=temp;
          root=left;
        }else{
          int temp=arr[root];
          arr[root]=arr[right];
          arr[right]=temp;
          root=right;
        }
      }
    }
    return min;
  }
  int size(){
    return idx-1;
  }
  void display(){
    for(int i=1;i<idx;i++){
      System.out.print(arr[i]+" ");
    }
  }

}

public class MinHeapIMplementation {
  public static void main(String[] args) {
    
  }
}
