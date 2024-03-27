/**
 * 
 */

 const title = document.querySelector('#title');
 const userName = document.querySelector('#desc p');
 const img = document.querySelector('#profile img');
 
 title.onclick = () => title.innerText = "나의 프로필";
 userName.onclick = () => userName.innerHTML = `이름 : <b>김민재</b>`
 img.onclick = () => img.src = "./images/pf2.png";