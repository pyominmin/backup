const orderInfo = document.querySelector('#orderInfo')
const orderButton = document.querySelector('#order')
const title = document.querySelector('#container > h2')

orderButton.addEventListener('click', () => {
	let ptag = document.createElement('p');
	let textNode = document.createTextNode(title.innerText);
	ptag.appendChild(textNode);
	
	ptag.style.fontSize = "0.8em";
	ptag.style.color = "red";
	
	orderInfo.appendChild(ptag);
	
}, {once : true}); // once옵션은 한번만 실행