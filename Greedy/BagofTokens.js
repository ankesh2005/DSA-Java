// lc-948. Bag of Tokens
var bagOfTokensScore = function(tokens, power) {
    tokens.sort((a,b)=>a-b);
    let i=0,j=tokens.length-1;
    let max=0,count=0;
    while(i<=j){
        if(power>=tokens[i]){
            power-=tokens[i];
            count++;
            i++;
            max=Math.max(max,count);
        }else if(count>0){
            power+=tokens[j];
            count--;j--;
        }else break;
    }
    return max;
};