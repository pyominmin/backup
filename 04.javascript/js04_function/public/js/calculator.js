'use strict'

const labelInput = document.querySelector('.input');
const keyClear = document.querySelector('.key--clear');
const keyDelete = document.querySelector('.key--delete');
const keyFunctions = document.querySelectorAll('.key--function');
const keyEquals = document.querySelector('.key--equals');
const keypads = document.querySelectorAll('.keypads');
const keyDot = document.querySelector('.key--dot');

(function() {
	// 1. 계산하기 위한 데이터
	let value = 0;
	let inputValue = '';
	let operatorPre = '';
	let operator = '';
	
	// 2. 계산을 수행하는 함수
	const operate = function(operator) {
		value = Number(value);
		inputValue = Number(inputValue);
		
		switch(operator) {
			case '+':
				value += inputValue;
				break;
			case '-':
				value -= inputValue;
				break;
			case '*':
				value *= inputValue;
				break;
			case '/':
				value /= inputValue;
				break;
		}
	
		// 출력값의 자리수를 제한
		if(value.toString().length > 12) {
			value = value.toString().slice(0, 13);
		}
		return value.toLocaleString();
	}
	
	
	// 3. equals, clear, 한개숫자만삭제, 소수점
	const equals = function() {
		value = labelInput.textContent = operate(operator);
		operator = '';
	}
	
	const deleteOne = function() {
		inputValue = inputValue.slice(0, -1);
		labelInput.textContent = inputValue || 0;
	}
	
	const clear = function() {
		value = 0;
		inputValue = '';
		operator = '';
		labelInput.textContent = value;		
	}
	const addDot = function() {
		inputValue += '.';
		labelInput.textContent = inputValue;
	}
	
	// 4. 입력숫자를 설정
	const setNumber = function(num) {
		if(!isNaN(num) && inputValue.length < 12) {
			inputValue += num;
			labelInput.textContent = inputValue;
		}
	}
	
	// 5. 사칙연산자
	const setOperator = function(key) {
		operatorPre = operator;
		operator = key; // +-*/...
		if(value && inputValue) {
			value = labelInput.textContent = operate(operatorPre);	
		}
		value = value || inputValue; // 123, + -> 123+1 = 124
		inputValue = '';
	}

	// 6. addEventListener - 숫자키패드의 클릭이벤트 처리
	keypads.forEach((key) => {
		key.addEventListener('click', (e) => {
			let num = e.target.textContent.trim();
			setNumber(num);
		})
	});
	
	// 7. addEventListener - 사칙연산자의 클릭이벤트 처리
	keyFunctions.forEach((key) => {
		key.addEventListener('click', (e) => {
			let key = e.target.textContent.trim();
			setOperator(key);
		})
	});
	
	// 8. addEventListener - equals, clear, 한개숫자삭제, 소수점
	keyEquals.addEventListener('click', () => {
		equals();	
	})
	
	keyClear.addEventListener('click', () => {
		clear();
	})
	
	keyDelete.addEventListener('click', () => {
		deleteOne();
	})
	
	keyDot.addEventListener('click', () => {
		addDot();
	})
	
	// 9. addEventListener - 키보드이벤트처리
	window.addEventListener('keydown', function(e) {
		let key = e.key; // A = 65, 0= 98....
		if(!isNaN(key)) setNumber(key);
		else if (key == 'Enter') equals();
		else if (key == 'Backspace') deleteOne();
		else if (key == 'Escape') clear();
		else if (key == '.') addDot();
	});
})();