package Day_6;
import java.util.ArrayList;
import java.util.Iterator;

public class Generic<T> {
    ArrayList<T> list;
    Generic(ArrayList<T> list){
        this.list = list;
    }
    public void display(){
        Iterator<?> itr= list.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
        
    }
}

    

