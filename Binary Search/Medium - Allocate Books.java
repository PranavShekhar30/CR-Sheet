TC: O(N logN);
SC: O(1);


public class Solution{
    public int books(int[] A, int B){
        if(B > A.length){
            return -1;
        }
        int high = 0; int low = 0; int ans = -1;
        for(int i=0; i<A.length; i++){
            high += A[i];
            low = Math.min(low, A[i]);
        }
        while(low <= high){
            int mid = low + (high - low)/2;
            if(allocationIsPossible(A, mid, B)){
                ans = mid;
                high = mid -1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
    boolean allocationIsPossible(int A, int barrier, int B){
        int allocated_student = 1;
        int pages = 0;

        for(int i=0; i<A.length; i++){
            if(A[i] > barrier){
                return false;
            }
            if(pages + A[i] > barrier){
                allocated_student += 1;
                pages += A[i];
            }
            else{
                pages += A[i];
            }
        } 
        if (allocated_student > B){
            return false;
        }
        return true;
    }
}
