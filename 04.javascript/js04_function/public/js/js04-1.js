function showData(name, age) {
	alert(`제 이름 ${name}이고 나이는 ${age}살 입니다!!`)
}

function getData(콜백함수) {
	let name = prompt('이름을 입력하세요!', '홍길동');
	let age = prompt('나이를 입력하세요!', 1000);
	콜백함수(name, age);
}

getData(showData);