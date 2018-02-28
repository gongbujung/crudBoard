$(document).ready(function(){
	// 탭메뉴
	$('ul#aside_reply_nav li').click(function(){
	    var reply_tab_id = $(this).attr('data-tab');
	 
	    $('ul#aside_reply_nav li').removeClass('current');
	    $('.aside_reply_content').removeClass('current');
	 
	    $(this).addClass('current');
	    $("#"+reply_tab_id).addClass('current');
	  });

	$('ul#aside_comment_nav li').click(function(){
	    var comment_tab_id = $(this).attr('data-tab');
	 
	    $('ul#aside_comment_nav li').removeClass('current');
	    $('.aside_comment_content').removeClass('current');
	 
	    $(this).addClass('current');
	    $("#"+comment_tab_id).addClass('current');
	  });
 
});