// lc-991. Broken Calculator
var brokenCalc = function(startValue, target) {
    let ops=0;
    while(target>startValue){
        ops++;
        if(target%2==0){
            target=target/2;
        }else{
            target++;
        }
    }
    return ops+startValue-target;
};