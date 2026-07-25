// lc-1328. Break a Palindrome
var breakPalindrome = function(str) {
    let newStr;
    if(str.length==1)return '';
    for(let i=0;i<Math.floor(str.length / 2);i++){
        if(str[i]!=='a'){
            newstr=str.slice(0,i)+'a'+str.slice(i+1);
            return newstr;
        }
    }
    return str.slice(0,str.length-1)+'b';
};