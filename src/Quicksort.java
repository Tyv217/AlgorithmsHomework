import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Quicksort {
    public static void Quicksort_pivotFirstElement(Integer[] initialList, int iBegin, int iEnd){
        int size = iEnd - iBegin;
        if(size >= 2){
            int pivot = partition_firstElement(initialList, iBegin, iEnd);
            Quicksort_pivotFirstElement(initialList, iBegin, pivot);
            Quicksort_pivotFirstElement(initialList, pivot, iEnd);
        }
    }
    public static int partition_firstElement(Integer[] a, int iBegin, int iEnd){
        int iPivot = iBegin;
        int iLeft = iBegin;
        int iRight = iEnd;
        while(iLeft < iRight){
            while(iLeft < iRight && a[iLeft] <= a[iPivot]){
                iLeft++;
            }
            while(iLeft < iRight && a[iRight - 1] > a[iPivot]){
                iRight--;
            }
            if(iLeft < iRight && a[iLeft] > a[iPivot] && a[iRight - 1] <= a[iPivot]){
                int temp = a[iLeft];
                a[iLeft] = a[iRight - 1];
                a[iRight - 1] = temp;
                iLeft++;
                iRight--;
            }
        }
        int temp = a[iLeft - 1];
        a[iLeft - 1] = a[iPivot];
        a[iPivot] = temp;
        iPivot = iRight;
        return iPivot;
    }
    public static void Quicksort_pivotRandom(Integer[] initialList, int iBegin, int iEnd){
        int size = iEnd - iBegin;
        if(size >= 2){
            int pivot = partition_random(initialList, iBegin, iEnd);
            Quicksort_pivotRandom(initialList, iBegin, pivot);
            Quicksort_pivotRandom(initialList, pivot, iEnd);
        }
    }
    public static int partition_random(Integer[] a, int iBegin, int iEnd){
        Random random = new Random();
        int randomNumber = random.nextInt(iEnd - iBegin) + iBegin;
        int tmp = a[randomNumber];
        a[randomNumber] = a[iBegin];
        a[iBegin] = tmp;
        int iPivot = iBegin;
        int iLeft = iBegin;
        int iRight = iEnd;
        while(iLeft < iRight){
            while(iLeft < iRight && a[iLeft] <= a[iPivot]){
                iLeft++;
            }
            while(iLeft < iRight && a[iRight - 1] > a[iPivot]){
                iRight--;
            }
            if(iLeft < iRight && a[iLeft] > a[iPivot] && a[iRight - 1] <= a[iPivot]){
                int temp = a[iLeft];
                a[iLeft] = a[iRight - 1];
                a[iRight - 1] = temp;
                iLeft++;
                iRight--;
            }
        }
        int temp = a[iLeft - 1];
        a[iLeft - 1] = a[iPivot];
        a[iPivot] = temp;
        iPivot = iRight;
        return iPivot;
    }

    public static void main(String[] args) {
        Integer[] a = {1,2,3,4,5,6,7,8,9,10};
        List<Integer> aList = Arrays.asList(a);
        Collections.shuffle(aList);
        aList.toArray(a);
        Quicksort_pivotFirstElement(a,0,a.length);
        System.out.println(Arrays.toString(a));
        Integer[] b = {1,2,3,4,5,6,7,8,9,10};
        List<Integer> bList = Arrays.asList(a);
        Collections.shuffle(bList);
        bList.toArray(b);
        Quicksort_pivotRandom(b,0,b.length);
        System.out.println(Arrays.toString(b));
    }
}
