package edu.upc.data;
import org.apache.log4j.Logger;

public  class CuaImpl<T> implements Cua<T>
{
    int size;
    Node first;
    int contador;
    final static Logger logger= Logger.getLogger(CuaImpl.class);

    public CuaImpl(int len) {
        size = 0;
    }

    public int push(T t)
    {
       // this.push(t);
        if(this.size == 0) {
            Node nou = new Node<T>();
            nou.element = t;
            this.first = nou;
            size++;
            logger.info("afegit nou element: "+(T)first.element);
            return 0;

        }else{
            Node ultim = getUltim();
            Node nou = new Node<T>();
            nou.element = t;
            nou.next = null;
            ultim.next = nou;
            size++;
            logger.info("afegit nou element: "+(T)nou.element);
            return 0;
        }

    }

    public Node getUltim()
    {
        Node actual = this.first;
        while(actual.next != null)
        {
            actual = actual.next;
        }
        logger.info("l'últim es:"+actual.element);
        return actual;

    }
    public void buidarElement(Node node)
    {
     node.element = null;
    }
    public T pop() throws PilaBuidaException
    {

        if (this.size()==0) {
            throw new PilaBuidaException();
        }
        if (this.size()==1) {
            size--;
            logger.info("últim"+(T)first.element);
            logger.info("pop");
            return (T)first.element;
        }
        else {
            Node aux = first;
            first = first.next;
            size--;
            logger.info("últim"+(T)aux.element);
            logger.info("pop");
            return (T)aux.element;
        }

    }

    public int size()
    {
        logger.info("el tamany és:"+size);
        return size;
    }

}
