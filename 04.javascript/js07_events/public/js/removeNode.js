const items = document.querySelectorAll('li');


/*for(let item of items) {
	item.addEventListener('click', function() {
		// this는 이벤트가 발생한 노드를 의미
		this.parentNode.removeChild(this);
		// or this.remove(this);
	})
}*/

// addEventListener에서 화살표함수를 사용하면 
// 화살표함수에서의 this는 window객체를 가리킨다.
// this를 사용하려면 화살표함수가 아니라 익명함수로
// 지정해야 한다. 따라서 아래로직은 에러가 발생하기
// 때문에 상기의 로직처럼 익명함수를 사용해야 한다.
for(let item of items) {
	item.addEventListener('click', () => {
		// this는 이벤트가 발생한 노드를 의미
		this.parentNode.removeChild(this);
		// or this.remove(this);
	})
}