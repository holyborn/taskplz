/**
 * 20171209 lcy
 * 메인화면 tab 기능
 *
 */

$(document).on('ready',function(){
	initBtns();
	selectTab('realtime');
});

function initBtns(){
	//Tab select btns
	$('#tabs input[type=radio]').on('click',function(){
		selectTab($(this).attr('id'));
	})
	
	//Service in preparing..
	$('#btn-qst,#btn-qstdir,.box-qst,.tag,.box-rank').on('click',function(){
		alert('서비스 준비중입니다..');
	});
}



function selectTab(tabName){
	hideAllTabs();
	switch(tabName){
	case 'realtime':
		$('#realtime-content').addClass('selected');
		break;
	case 'percent':
		$('#percent-content').addClass('selected');
		break;
	case 'reword':
		$('#reword-content').addClass('selected');
		break;
	case 'rank':
		$('#rank-content').addClass('selected');
		break;
	default:
		break;
	}
}

function hideAllTabs(){
	$('#realtime-content').removeClass('selected');
	$('#percent-content').removeClass('selected');
	$('#reword-content').removeClass('selected');
	$('#rank-content').removeClass('selected');
}