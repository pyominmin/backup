const btn = document.querySelector("button");

/*
// 1. 선언함수
function dispaly() {
	alert("버튼을 클릭했습니다!!");
}

btn.addEventListener('click', dispaly);
*/
// 2. 화살표함수
btn.addEventListener("click", () => alert("버튼을 클릭했습니다!!"));