// lc-1578. Minimum Time to Make Rope Colorful

var minCost = function(colors, neededTime) {
    let i=0,j=1,min=0;
    while(j<colors.length){
        if(colors.charAt(i)==colors.charAt(j)){
            if(neededTime[i]>neededTime[j]){
                idx=j;
                min+=neededTime[j];
            }else{
                min+=neededTime[i];
                i=j;
            }
        }else{
            i=j;
        }  
        j++;
    }
    return min;
};