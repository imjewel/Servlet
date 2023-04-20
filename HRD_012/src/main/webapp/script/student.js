/**
 * 
 */

function chkValue(){
	if(document.frm.studname.value==''){
		alert('학생 성명이 입력되지 않았습니다.');
		document.frm.studname.focus();
		return false;
	}
	if(document.frm.korean.value==''){
		alert('국어성적이 입력되지 않았습니다.');
		document.frm.korean.focus();
		return false;
	}
	if(document.frm.english.value==''){
		alert('영어성적이 입력되지 않았습니다.');
		document.frm.english.focus();
		return false;
	}
	if(document.frm.math.value==""){
		alert('수학성적이 입력되지 않았습니다.');
		document.frm.math.focus();
		return false;
	}
	if(document.frm.history.value==""){
		alert('역사성적이 입력되지 않았습니다.');
		document.frm.history.focus();
		return false;
	}
	
	return true;
}
