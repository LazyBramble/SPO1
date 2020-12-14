import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException
        {
            Scanner in = new Scanner(System.in);
        Chains chain = new Chains(300);
        String[] array = ReadText();
        HashTable HT = new HashTable(300);
        int counterUm = 0;
        int counterChain = 0;
        for (int i = 0; i < array.length; i++)
        {
            System.out.println(array[i]);
            counterUm = counterUm + HT.insertSimpleRehash(array[i]);
            counterChain = counterChain + chain.insertChains(array[i]);
        }
        HT.print();
        System.out.println("����������� �������� ��� ������������� � ������� ������������ = " + counterUm);
        System.out.println("����������� �������� ��� ������ ������� = " + counterChain);

        //1
            System.out.println("����� �������");
            System.out.println("������� ����� ��� ������ � ������ �������");
            String wrd = in.nextLine();
            long startTime = System.nanoTime();
            boolean CC = chain.checkChain(wrd);
            long endTime = System.nanoTime();
            long time = endTime - startTime;
            System.out.println("�������� ���������� ������ � ������ ������� = " + time);
            if (CC == true) {System.out.println("��������� ����� ���� � �������");}
            else {System.out.println("���������� ����� ��� � �������");}

        //2
            System.out.println("����� ������������� � ������� ������������");
            System.out.println("������� ����� ��� ������ � ������ � ������� ������������");
            wrd = in.nextLine();
            startTime = System.nanoTime();
            CC = HT.checkUM(wrd);
            endTime = System.nanoTime();
            time = endTime - startTime;
            System.out.println("�������� ���������� ������ � ������ ������������� � ������� ������������ = " + time);
            if (CC == true) {System.out.println("��������� ����� ���� � �������");}
            else {System.out.println("���������� ����� ��� � �������");}
        }


//������� ������ ���� �� ���������� �����
    private static String[] ReadText() throws IOException
    {
        FileReader fileReader = new FileReader("./t.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> lines = new ArrayList<String>();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }
        bufferedReader.close();
        return lines.toArray(new String[lines.size()]);
    }


}


