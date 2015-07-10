import java.util.LinkedList;

public class Demo<E> {

    private static final double LOAD_FACTOR_LIMIT = 0.7;

    private int size;
    private LinkedList<E>[] con;

    public Demo() {
        con  = (LinkedList<E>[])(new LinkedList[10]);
    }

public boolean add(E obj) {
        int oldSize = size;
        int index = Math.abs(obj.hashCode()) % con.length;
        if(con[index] == null)
            con[index] = new LinkedList<E>();
        if(!con[index].contains(obj)) {
            con[index].add(obj);
            size++;

        }
        if(1.0 * size / con.length > LOAD_FACTOR_LIMIT)
            resize();
        return oldSize != size;
    }

private void resize() {
        Demo<E> temp = new Demo<E>();
        temp.con = (LinkedList<E>[])(new LinkedList[con.length * 2 + 1]);
        for(int i = 0; i < con.length; i++){
            if(con[i] != null)
                for(E e : con[i])
                    temp.add(e);
        }
        con = temp.con;
    }

    public void sample(String s){
        System.out.println("Sample is "+s);
    }

    public int size() {
        System.out.println(size());
        return size;
    }
}