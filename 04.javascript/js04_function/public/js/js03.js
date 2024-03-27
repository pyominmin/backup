/*
	scope : 선언한 변수 or 함수의 적용범위를 말한다.
	
	1. var로 선언한 변수는 함수레벨범위
	2. let, const로 선언한 변수는 블록레벨범위
*/
let result = 0;
function sum(a, b) {
	result = a + b;
}
sum(10, 20);
document.write(result);
document.write('<hr>');


function addSum(n) {
	let sum = 0;
	for(let i=1;i<=n;i++) {
		sum += i;
	}
	return sum;
}
const num = 10;
document.write(`1부터 ${num}까지의 합은 ${addSum(num)}입니다. `)