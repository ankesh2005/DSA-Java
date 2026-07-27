// lc-1991 Maximum Alternating Subsequence Sum

var maxAlternatingSum = function(nums) {
    let dp={};
    let key=nums.length+" "+"1";
    dp[key]=0;
    key=nums.length+" "+"0";
    dp[key]=0;
    for(let i=nums.length-1;i>=0;i--){
        for(let plus=0;plus<2;plus++){
            let skip=dp[(i+1)+" "+plus];
            let take=0;
            if(plus==1){
                take=nums[i]+dp[i+1+" "+0];
            }else{
                take=-nums[i]+dp[i+1+" "+1];
            }
            dp[i+" "+plus]=Math.max(take,skip);
        }
    }
    return dp["0 1"];
};