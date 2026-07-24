package Design;

public class DesignBrowserHistory {
  // lc-1472. Design Browser History
  class BrowserHistory {
    class Node{
        String data;
        Node prev;
        Node next;
        Node(String val){
            data=val;
            prev=null;
            next=null;
        }
    }
    Node dl,cur,mover;
    int idx=0;
    public BrowserHistory(String homepage) {
        dl=new Node(homepage);
        idx=1;
        cur=dl;
        mover=cur;
    }
    
    public void visit(String url) {
        Node temp=new Node(url);
        temp.prev=mover;
        if(mover.next!=null)mover.next.prev=null;
        mover.next=temp;
        idx++;
        cur=temp;
        mover=temp;
    }
    
    public String back(int steps) {
        while(steps>0 && mover.prev!=null){
            mover=mover.prev;
            idx--;
            steps--;
        }
        return mover.data;
    }
    
    public String forward(int steps) {
        while(steps>0 && mover.next!=null){
            mover=mover.next;
            idx++;
            steps--;
        }
        return mover.data;
    }
}


}
