public class HashTable {

    //������ ��� �������� ���������
    private String [] table;

    //������ �������
    private int size;

    //�������� �����������, ������� ������� ��������� ������� ������� �������
    public HashTable(int size) {
        this.size = size;
        table = new String[size];
    }

    //������� ��������� ���� �����
    private int makehashUM(String word)
    {
        int hash = 0;

        for(int i = 0; i < word.length(); i++)
            hash = (31 * hash * word.charAt(i)) % size;

        return hash;
    }

    //������� ���������� ������� � �������� �������������
    public int insertSimpleRehash (String key)
        {
            int i = 0;
            while (table[i] != null) { i++;};
            table[i] = key;
            int count = 0;
            int hash = makehashUM(key);
            while(table[hash] != null)
        {
            hash = (hash + 31) % size;
            count++;
        }

        return count;
    }

   //����� �������
    public void print()
    {
        for(int i = 0; i < size; i++)
            if(table[i] != null)
                System.out.println(i + " " + table[i]);
    }

   //������� ����� � ���-�������
    public boolean checkUM (String word)
    {
        int hash = makehashUM(word);
        return table[hash].equals(word)== true;
    }



}
