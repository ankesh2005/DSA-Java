// lc-2131. Longest Palindrome by Concatenating Two Letter Words

var longestPalindrome = function(words) {
    let map={};
    for(let word of words){
        map[word]=(map[word]||0)+1;
    }
    let count=0;
    let usedmiddle=false;
    for(let word of words){
        let rev=word.split("").reverse().join("");
        if(rev!==word){
            if(map[word]>0 && map[rev]>0){
            count+=4;
            map[word]--;
            map[rev]--;
            }
        }else{
                if(map[word]>1){
                    count+=4;
                    map[word]-=2;
                }else if(map[word]==1 && usedmiddle==false){
                    usedmiddle=true;
                    map[word]--;
                    count+=2;
                }
        }
    }
        return count;
};