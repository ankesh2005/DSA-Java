// lc-2136. Earliest Possible Day of Full Bloom

var earliestFullBloom = function(plantTime, growTime) {
    let n=plantTime.length;
    let pg=new Array(n);
    for(let i=0;i<n;i++){
        pg[i]=new Array(2);
        pg[i][0]=plantTime[i];
        pg[i][1]=growTime[i];
    }
    pg.sort((a,b)=>b[1]-a[1]);
    let max=0;
    let prevPlantDays=0;
    for(let i=0;i<n;i++){
        prevPlantDays+=pg[i][0];
        max=Math.max(max,prevPlantDays+pg[i][1]);
    }
    return max;
};