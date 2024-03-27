function calcSum(n) {
	let sum = 0;
	for(let i=1;i<=n;i++) {
		sum += i;
	}
	console.log(`1부터 ${n}까지의 합은 ${sum}입니다!!`);
}

calcSum(10);