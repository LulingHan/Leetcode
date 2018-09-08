//
//  1-two-sum.c
//  use quick sort
//


#include <stdio.h>
#include <stdlib.h>
#define max(a,b) (a>b?a:b)
#define min(a,b) (a<b?a:b)

void* quicksort(int* nums,int* temp_array, int start, int end);
int* twoSum(int* nums, int numsSize, int target);

int main(int argc, const char * argv[]) {
    int nums[4] = {-3,4,3,90};
    int* out = malloc(2*sizeof(int));
    out = twoSum(nums,4,0);
    printf("%d",out[0]);
    printf("%d",out[1]);
}

void* quicksort(int* nums, int* temp_array, int start, int end){

    if(start >= end){
        return NULL;
    }

    int pivot = nums[(start + end) / 2];
    int i = start;
    int j = end;

    while(i <= j){
        while(nums[i] < pivot){
            i++;
        }
        while(nums[j] > pivot){
            j--;
        }
        if(i <= j){
            int temp1 = nums[i];
            int temp2 = temp_array[i];
            nums[i] = nums[j];
            nums[j] = temp1;
            temp_array[i] = temp_array[j];
            temp_array[j] = temp2;
            i++;
            j--;
        }
    }
    quicksort(nums,temp_array, start, j);
    quicksort(nums,temp_array, i, end);
    return NULL;
}

int* twoSum(int* nums, int numsSize, int target) {
    
    int* result = malloc(2 * sizeof(int));
    int * temp_array = malloc(numsSize * sizeof(int));
    
    for(int i=0;i<numsSize;i++){
        temp_array[i] = i;
    }
    // quick sort(increasing)
    quicksort(nums,temp_array, 0, numsSize - 1);
    
    for(int i=0; i<numsSize; i++){
        // can add "if break" here, cause the array has been sorted
        if(nums[i] > 0 && nums[i] > target){
            break;
        }
        for(int j=0; j<numsSize;j++){
            // do not add "if break" here, cause num[i] can < 0
            if(nums[j] == target - nums[i] && i != j){
                result[0] = min(temp_array[i],temp_array[j]);
                result[1] = max(temp_array[i],temp_array[j]);
                break;
            }
        }
    }
    return result;
}
