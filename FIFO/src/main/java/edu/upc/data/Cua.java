package edu.upc.data;

public interface Cua<T>
{
    public int push(T t);

    public T pop() throws PilaBuidaException;

    public int size();

}