// lc-2279. Maximum Bags With Full Capacity of Rocks
var maximumBags = function(cap, rocks, as) {
    let n=cap.length;
    let nt=[];
    for(let i=0;i<n;i++){
        let val=cap[i]-rocks[i];
        nt.push(val);
    }
    nt.sort((a,b)=>a-b);
    let count=0;
    for(let i=0;i<n;i++){
        as-=nt[i];
        if(as<0)break;
        count++;

    }
    return count;
};