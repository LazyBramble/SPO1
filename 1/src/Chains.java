import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class Chains
{
    private int[] Pointers; //ћассив указателей
    private int size;
    private ArrayList<ArrayList<String>> Values;//ƒвумерный список

    //—оздаем начальные массивы и заполн€ем массив указателей (-1)
    public Chains(int size)
    {
        this.size = 0;
        Pointers = new int[size];

        for (int i = 0; i< Pointers.length; i++)
        {
            Pointers[i] = -1;
        }

        Values = new ArrayList<>();
    }

    //«аполнение массивов указателей и двумерного списка слов
    public int insertChains (String word)
    {
        int hash = makeHash(word);
        int pointer = Pointers[hash];
        int count = 0;
        if (pointer == -1)
        {
            Pointers[hash] = Values.size();
            Values.add(new ArrayList<String>());
            int vldx = Values.size()-1;
            Values.get(vldx).add(word);
            this.size+=1;
        }
        else
        {
            count ++;
            if (Values.get(pointer).contains(word)){ return count;}
            else {Values.get(pointer).add(word); return count;}

        }
        return count;

    }

    private int makeHash(String str)
    {
        int hash = 0;

        for(int i = 0; i < str.length(); i++)
            hash = (31 * hash + str.charAt(i)) % Pointers.length;

        return hash;

    }

    public boolean checkChain (String word)
    {
        int hash = makeHash(word);
        if (Pointers[hash] == -1) {return false;}
        return (Values.get(Pointers[hash]).contains(word));
    }






}
