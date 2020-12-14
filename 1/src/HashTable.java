public class HashTable {

    //массив для хранения элементов
    private String [] table;

    //размер таблицы
    private int size;

    //Вызываем конструктор, который создает начальную таблицу нужного размера
    public HashTable(int size) {
        this.size = size;
        table = new String[size];
    }

    //Функция получения хэша слова
    private int makehashUM(String word)
    {
        int hash = 0;

        for(int i = 0; i < word.length(); i++)
            hash = (31 * hash * word.charAt(i)) % size;

        return hash;
    }

    //Функция заполнения таблицы и простого рехэширования
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

   //Вывод массива
    public void print()
    {
        for(int i = 0; i < size; i++)
            if(table[i] != null)
                System.out.println(i + " " + table[i]);
    }

   //Наличие слова в хэш-таблице
    public boolean checkUM (String word)
    {
        int hash = makehashUM(word);
        return table[hash].equals(word)== true;
    }



}
