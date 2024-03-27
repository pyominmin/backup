/*
	ECMA2015이전까지는 기본적으로 서버에서 자료를 가져올 때
	XMLHttpRequest를 사용해서 사용했고 ECMA2015이후에는 fetch API를
	사용하고 있다.
	
	자바스크립트에서 네트워크통신을 할 때 서버와 비동기통신을 하는 방법
	AJAX(Asynchronous JavaScript and XML)방법으로 통신을 한다.
	즉, 비동기방식으로 서버와 통신을 하게 되는데 비동기란? 동시에 일어나지
	않는다는 뜻이다. 서버에 자료를 요청하고 수신이 완료될 때까지 기다리는 
	것이 아니라 자료를 나누어서 요청을 하고 요청한 자료가 수신되는 동안
	다른 작업을 수행할 수 있다는 것을 말한다.
	
	초창기에는 JavaScript으로 데이터를 송수신할 때 XML을 사용했지만 현재는
	JSON형태로 자료를 송수신한다.
	
	이때 비동기통신을 위한 기법(객체)이 XMLHttpRequst이다. 이 객체에서 지원하는
	기능(메서드)은 다음과 같다.
	
	A. XMLHttpRequest의 메서드
	1. open(방식, 자료주소, 비동기여부)
	   ... 방식은 HTTP요청방식을 의미, GET, POST, PUT중 하나이고 대문자로 정의
	   ... 자료주소 : 요청한 서버의 URL
	   ... 비동기여부: true, false, 기본값 true
	
	2. send(자료) - 서버로 사용자의 요청을 보내는 메서드
    3. 이외의 메서드
       a. setRequestHeader(header, value) : 요청할 때 특정값을 저장해서 요청하는 메서드
          반드시 open()메서드 바로 뒤에 작성해야 한다.
       b. getResponseHeader() : 서버의 응답중에서 HTTP헤더정보를 알고 싶을 때 사용하는 메서드
       c. getAllReponseHeaders() : HTTP요청에 대한 모든 응답정보를 반환	
       
    B. XMLHttpRequest의 속성
    
    1. readyState : XMLHttpRequest의 상태, 0->1->2->3->4->0 ...의 순서대로 반복
       0 : 아직 아무요청도 하지 않은 상태
       1 : 서버에 요청이 성공상태
       2 : 서버에 대한 요청의 응답이 도착한 상태
       3 : 서버에 자료가 로딩중인 상태
       4 : 자료처리가 완료가 되어 프로그램에서 사용할 수 있는 상태
     
     2. status, statusText
        status : HTTP의 상태코드
        ... 100: 처리중
        ... 200: 성공
        ... 300: 리다이렉트
        ... 400: 실패
        ... 500: 서버에러
        
        statusText : state에 대한 상세설명메시지
        
     3. responseText
        ... 요청에 대한 응답이 문자열 형태로 저장되는 속성
        
     C. XMLHttpRequest의 이벤트
     
     1. readystatechange
        ... readyState값이 변경될 때마다 발생되는 이벤트
*/
let xhr = new XMLHttpRequest();
xhr.open('GET', './student.json');
xhr.send();

xhr.onreadystatechange = () => {
	if(xhr.readyState === 4 && xhr.status === 200) {
		let students = JSON.parse(xhr.responseText);
		renderHTML(students);
	}
}

function renderHTML(students) {
	let output = "";
	// students.forEach(() => {})
	for(let student of students) {
		output += `
			<h2>${student.name}</h2>
			<ul>
				<li>전공 : ${student.major}</li>
				<li>학년 : ${student.grade}</li>
			</ul>
			<hr>
		`;
	}
	document.querySelector("#result").innerHTML = output;
}