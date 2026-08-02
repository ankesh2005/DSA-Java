// lc-134. Gas Station
var canCompleteCircuit = function(gas, cost) {
    let tank=0,total=0,start=0;
    for(let i=0;i<gas.length;i++){
        let diff=gas[i]-cost[i];
        tank+=diff;
        total+=diff;
        if(tank<0){
            start=i+1;
            tank=0;
        }
    }
    return total>=0?start:-1;
};
