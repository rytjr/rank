import java.util.*;
import java.io.*;

public class Main {

    static int count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int Num = Integer.parseInt(st.nextToken());
        int reposi = Integer.parseInt(st.nextToken());

        int list[] = new int[Num];
        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < Num; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(list, 0, Num - 1, reposi);
        if(count < reposi) {
            System.out.print(-1);
        }
    }

    public static void mergeSort(int list[], int left, int right, int reposi) {

        if(left < right) {
            int middle = (left + right) / 2;

            mergeSort(list, left, middle, reposi);
            mergeSort(list, middle + 1, right, reposi);
            merge(list, left, middle, right, reposi);
        }
    }

    public static void merge(int list[], int left, int middle, int right, int reposi) {

        int n1 = middle - left + 1;
        int n2 = right - middle;

        int arrleft[] = new int[n1];
        int arrright[] = new int[n2];

        for(int i = 0; i < n1; i++) {
            arrleft[i] = list[i + left];
        }

        for(int i = 0; i < n2; i++) {
            arrright[i] = list[middle + 1 + i];
        }

        int i = 0; int j = 0; int k = left;
        while(i < n1 && j < n2) {
            if(arrleft[i] <= arrright[j]) {
                list[k] = arrleft[i];

                count++;
                if(count == reposi) {
                    System.out.print(list[k]);
                }
                i++;
            }
            else {
                list[k] = arrright[j];
                count++;
                if(count == reposi) {
                    System.out.print(list[k]);
                }
                j++;
            }
            k++;

        }

        while(i < n1) {
            list[k] = arrleft[i];
            count++;
            if(count == reposi) {
                System.out.print(list[k]);
            }
            i++;
            k++;

        }
        while(j < n2) {
            list[k] = arrright[j];
            count++;
            if(count == reposi) {
                System.out.print(list[k]);
            }
            j++;
            k++;
        }

    }

}
