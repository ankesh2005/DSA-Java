// lc-881. Boats to Save People
var numRescueBoats = function(people, limit) {
    people.sort((a,b)=>a-b);
    let i=0,j=people.length-1;
    let count=0;
    while(i<=j){
        let cap=limit;
        if(cap>=people[j]){
            cap-=people[j];
            j--;
        }
        if(cap>=people[i]){
            i++;
        }
        count++;
    }
    return count;
};