/**
 * 
 */
$(document).on('ready',function(){
	console.log('header init start');
	initBtns_header();
});

function initBtns_header(){

	$('#header-logo').on('click',function(){
		location.href="/";
	});
	
	$('#btn-signin').on('click',function(){
		location.href="/user/signin";
	});

	$('#btn-signup').on('click',function(){
		location.href="/user/signup";
	});
}