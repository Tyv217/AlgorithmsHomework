package uk.ac.cam.xty20.Algorithms.Tick2;

import uk.ac.cam.cl.tester.Algorithms.LCSFinder;

import java.util.Arrays;

public class LCSBottomUp extends LCSFinder {
    public LCSBottomUp(String s1, String s2) {
        super(s1, s2);
    }

    @Override
    public int getLCSLength() {
        if(mString1.length() == 0 || mString2.length() == 0){
            return 0;
        }
        int length1 = mString2.length();
        int length2 = mString1.length();
        mTable = new int[length2 + 1][length1 + 1];
        for(int x = 1; x < length1 + length2 + 2; x++){
            for(int y = 1; y <= x; y++){
                int z = x - y + 1;
                if(y <= length1 && z <= length2){
                    if(mString2.charAt(y - 1) == mString1.charAt(z - 1)){
                        mTable[z][y] = 1 + mTable[z-1][y-1];
                    }
                    else{
                        mTable[z][y] = Math.max(mTable[z-1][y],mTable[z][y-1]);
                    }
                }
            }
        }
        int[][] mTable1 = new int[length2][length1];
        for(int i = 0; i < length2; i++){
            mTable1[i] = Arrays.copyOfRange(mTable[i+1],1,length1 + 1);
        }
        mTable = mTable1;
        return mTable[length2 - 1][length1 - 1];
    }

    @Override
    public String getLCSString() {
        if(mString1.length() == 0 || mString2.length() == 0){
            return "";
        }
        StringBuilder result = new StringBuilder();
        int n = getLCSLength();
        int length1 = mString2.length() - 1;
        int length2 = mString1.length() - 1;
        for(int x = n; x > 0; x--){
            while((mTable[length2 - 1][length1] == x || mTable[length2][length1 - 1] == x)){
                if(length2 > 0){
                    if(mTable[length2 - 1][length1] == x){
                        length2--;
                    }
                }
                if(length1 > 0){
                    if(mTable[length2][length1-1] == x){
                        length1--;
                    }
                }
                if(length1 == 0 && length2 == 0){
                    break;
                }
                if(length2 == 0){
                    while(mTable[length2][length1 - 1] == x){
                        length1--;
                        if(length1 == 0){
                            break;
                        }
                    }
                    break;
                }
                if(length1 == 0){
                    while(mTable[length2 - 1][length1] == x){
                        length2--;
                        if(length2 == 0){
                            break;
                        }
                    }
                    break;
                }
            }
            result.insert(0,mString1.charAt(length2));
        }
        return result.toString();
    }
}
